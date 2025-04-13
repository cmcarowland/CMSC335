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
    private boolean toRight = true;
    private Circle circle;
    private Car nextCar;
    private PhysicsState state = PhysicsState.MOVING;

    static private int idCounter = 0;
    static private Random random = new Random();
    static private float random(float min, float max) {
        return random.nextFloat(max - min) + min;
    }
    static private int random(int min, int max) {
        return random.nextInt(max - min) + min;
    }
    
    public Car() {
        this.id = idCounter++;
        this.maxSpeed = random(15.6f, 24.6f);
        this.currentSpeed = maxSpeed;
        if(random(0f, 1.0f) > 0.5) {
            this.toRight = false;
            x = 9725;
        } else {
            x = -175;
        }

        circle = new Circle();
        circle.setRadius(10);
        circle.setTranslateX(x / 10000 * App.mainLayout.getWidth());
        Color c = Color.rgb(random(128, 255),random(128, 255),random(128, 255));
        circle.setFill(c);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is being garbage collected: " + this);
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

    @Override
    public void onPhysicsTicked() {
        if (toRight) {
            x += currentSpeed;// * Physics.getTimeDelta();
        } else {
            x -= currentSpeed;// * Physics.getTimeDelta();
        }

        if (nextCar != null && nextCar.state == PhysicsState.MOVING) {
            float distance = Math.abs(nextCar.getX() - x);
            // System.out.println("Car " + id + " distance to next car " + nextCar.getId() + " is " + distance);
            if (distance < 350) {
                currentSpeed = nextCar.getCurrentSpeed();
                // System.out.println("Car " + id + " slowed down to " + currentSpeed);
            }
        } else {
            currentSpeed = maxSpeed;
        }
        // System.out.println("Car " + id + " Physics Tick " + x);

        Platform.runLater(() -> {
            circle.setTranslateX(x / 10000 * App.mainLayout.getWidth());
        });

        if (x > 10000 || x < -350) {
            state = PhysicsState.COMPLETE;
            Physics.removeListener(this);
            // System.out.println("Car " + id + " removed from physics " + App.mainLayout.getChildren().size());
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
}
