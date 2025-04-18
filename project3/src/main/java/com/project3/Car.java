package com.project3;

import java.util.Random;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Car implements PhysicsTickListener {
    private int id;
    private float maxSpeed;
    private float currentSpeed;
    private float x;
    private short y;
    private boolean toRight = true;
    private Circle circle;
    private Car nextCar;
    private PhysicsState state = PhysicsState.MOVING;
    private Intersection nexIntersection = null;

    private final static int SAFETY_DISTANCE = 100;
    private final static float MPS_TO_MPH = 2.23694f;

    static private int idCounter = 0;
    static private Random random = new Random();
    static private float random(float min, float max) {
        return random.nextFloat(max - min) + min;
    }
    static private int random(int min, int max) {
        return random.nextInt(max - min) + min;
    }
    
    public Car(boolean isToRight) {
        this.id = idCounter++;
        this.maxSpeed = random(15.6f, 24.6f);
        this.currentSpeed = maxSpeed;
        this.toRight = isToRight;
        if(isToRight) {
            x = 50;
            y = 10;
        } else {
            y = -10;
            x = 9900;
        }

        circle = new Circle();
        circle.setRadius(3);
        circle.setTranslateX(x / 10000 * App.mainLayout.getWidth());
        Color c = Color.rgb(random(128, 255),random(128, 255),random(128, 255));
        circle.setFill(c);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is being garbage collected: " + this);
    }

    @Override
    public String toString() {
        return "Car " + id + " at X: " + String.format("%.0f", x) + " Y: " + y + " at " + String.format("%.0f", currentSpeed * MPS_TO_MPH) + " MPH";
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

    public boolean isToRight() {
        return toRight;
    }

    private float getDistance(Intersection i) {
        return Math.abs(i.getX() - x);
    }

    private float getDistance() {
        if(nextCar == null) {
            return 10000;
        }

        return Math.abs(nextCar.getX() - x);
    }

    @Override
    public void onPhysicsTicked() {
        nexIntersection = App.findNextIntersection(this);
        if (nexIntersection != null) {
            float distance = getDistance(nexIntersection);
            if (nexIntersection.getState() == LightState.RED && distance > SAFETY_DISTANCE / 2.0f && distance < SAFETY_DISTANCE) {
                currentSpeed = 0;
                state = PhysicsState.STOPPED;
                // System.out.println("Car " + id + " stopped at intersection " + nexIntersection.getId());
            } else if (nexIntersection.getState() == LightState.GREEN) {
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
            circle.setTranslateX(x / 10000 * App.mainLayout.getWidth());
        });

        if (x > 10000 || x < -100) {
            state = PhysicsState.COMPLETE;
            Physics.removeListener(this);
            cleanUp();
        }
    }

    public void cleanUp() {
        ObservableList<Node> circles = App.mainLayout.getChildren();
        for (Node circle : circles) {
            if (circle == this.circle) {
                // System.out.println("Car " + circle.hashCode() + " removed from layout " + this.circle.hashCode());
                Platform.runLater(() -> {
                    App.mainLayout.getChildren().remove(circle);
                });
                break;
            }
        }
    }
}
