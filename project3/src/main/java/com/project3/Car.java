/**
 * CMSC 335
 * Car.java
 * DATE: 22 Apr 2025
 * AUTHOR: Raymond Rowland
 * 
 * A class representing a car, which is part of the project3 package.
 * This class is designed to encapsulate the properties and behaviors
 * of a car within the context of the application.
 * 
 * The Car class implements the PhysicsTickListener interface, which
 * allows it to respond to physics ticks in the simulation. It contains
 * properties such as the car's ID, maximum speed, current speed, and
 * position (x-coordinate).
 */
package com.project3;

import java.util.Random;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;

public class Car implements PhysicsTickListener {
    private int id;
    private float maxSpeed;
    private float currentSpeed;
    private float x;
    private boolean toRight = true;
    private Circle circle;
    private Car nextCar;
    private Label label;
    private PhysicsState state = PhysicsState.MOVING;
    private Intersection nextIntersection = null;

    private final static int SAFETY_DISTANCE = 100;
    private final static float MPS_TO_MPH = 2.23694f;
    private final static short ROAD_END = 10000;

    static private int idCounter = 0;
    static private Random random = new Random();
    static private float random(float min, float max) {
        return random.nextFloat(max - min) + min;
    }
    static private int random(int min, int max) {
        return random.nextInt(max - min) + min;
    }
    
    public Car(boolean isToRight, Label label) {
        this.id = idCounter++;
        this.maxSpeed = random(15.6f, 24.6f);
        this.currentSpeed = maxSpeed;
        this.toRight = isToRight;
        if(isToRight) {
            x = 50;
        } else {
            x = 9900;
        }

        circle = new Circle();
        circle.setRadius(3);
        circle.setTranslateX(x / ROAD_END * App.mainLayout.getWidth());
        Color c = Color.rgb(random(128, 255),random(128, 255),random(128, 255));
        circle.setFill(c);
        this.label = label;
        label.setText(toString());
    }

    @Override
    protected void finalize() throws Throwable {
        // System.out.println("Object is being garbage collected: " + this);
    }

    @Override
    public String toString() {
        return "Car " + id + " at X: " + String.format("%.0f", x) + " at " + String.format("%.0f", currentSpeed * MPS_TO_MPH) + " MPH";
    }

    public static void resetCounter() {
        idCounter = 0;
    }

    public int getId() {
        return id;
    }

    public Car getNextCar() {
        return nextCar;
    }

    public void setNextCar(Car nextCar) {
        this.nextCar = nextCar;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }
    
    public void setMaxSpeed(float ms) {
        maxSpeed = ms;
        currentSpeed = maxSpeed;
    }

    public float getCurrentSpeed() {
        return currentSpeed;
    }

    public float getX() {
        return x;
    }

    public Circle getCircle() {
        return circle;
    } 

    public Label getLabel() {
        return label;
    } 

    public boolean isToRight() {
        return toRight;
    }

    private float getDistance(Intersection i) {
        return Math.abs(i.getX() - x);
    }

    private float getDistance() {
        if(nextCar == null) {
            return ROAD_END;
        }

        return Math.abs(nextCar.getX() - x);
    }

    @Override
    public void onPhysicsTicked() {
        nextIntersection = App.findNextIntersection(this);
        if (nextIntersection != null) {
            float distance = getDistance(nextIntersection);
            if (nextIntersection.getState() == LightState.RED && distance > SAFETY_DISTANCE / 2.0f && distance < SAFETY_DISTANCE) {
                currentSpeed = 0;
                state = PhysicsState.STOPPED;
                // System.out.println("Car " + id + " stopped at intersection " + nexIntersection.getId());
            } else if (nextIntersection.getState() == LightState.GREEN || distance > SAFETY_DISTANCE) {
                currentSpeed = maxSpeed;
                state = PhysicsState.MOVING;
                // System.out.println("Car " + id + " passed intersection " + nexIntersection.getId());
            }
        }
        if (state == PhysicsState.STOPPED) 
            return;
            
        if (nextCar != null && nextCar.state != PhysicsState.COMPLETE) {
            float distance = getDistance();
            // System.out.println("Car " + id + " distance to next car " + nextCar.getId() + " is " + distance);
            if (distance < SAFETY_DISTANCE) {
                currentSpeed = nextCar.getCurrentSpeed();
                // System.out.println("Car " + id + " slowed down to " + currentSpeed);
            }
        } else {
            currentSpeed = maxSpeed;
        }

        if (toRight) {
            x += currentSpeed * Physics.getDeltaTime();
        } else {
            x -= currentSpeed * Physics.getDeltaTime();
        }

        // System.out.println("Car " + id + " Physics Tick " + x);
        Platform.runLater(() -> {
            circle.setTranslateX(x / ROAD_END * App.mainLayout.getWidth());
            label.setText(toString());
        });

        if (x > ROAD_END || x < -100) {
            state = PhysicsState.COMPLETE;
            Physics.removeListener(this);
            cleanUp();
        }
    }

    public void cleanUp() {
        Platform.runLater(() -> {
            App.primaryController.removeCar(this);
        });
    }
}
