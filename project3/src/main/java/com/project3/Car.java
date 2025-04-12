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

    static private int idCounter = 0;
    static private Random random = new Random();
    static private float random(float min, float max) {
        return random.nextFloat(max - min) + min;
    }
    
    public Car() {
        this.id = idCounter++;
        this.maxSpeed = random(15.6f, 24.6f);
        this.currentSpeed = maxSpeed;
        if(random(0, 1) > 0.5) {
            this.toRight = false;
            x = 10000;
        }

        circle = new Circle();
        circle.setRadius(10);
        circle.setTranslateX(x / 10000 * App.mainLayout.getWidth());
        Color c = Color.rgb((int)Math.floor(random(0, 255)),(int)Math.floor(random(0, 255)),(int)Math.floor(random(0, 255)));
        circle.setFill(c);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is being garbage collected: " + this);
    }

    public int getId() {
        return id;
    }

    public float getMaxSpeed() {
        return maxSpeed;
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
        // System.out.println("Car " + id + " Physics Tick " + x);
        if (toRight) {
            x += currentSpeed;
        } else {
            x -= currentSpeed;
        }

        Platform.runLater(() -> {
            circle.setTranslateX(x / 10000 * App.mainLayout.getWidth());
        });

        if (x > 10000 || x < -200) {
            Physics.removeListener(this);
            System.out.println("Car " + id + " removed from physics " + App.mainLayout.getChildren().size());
            ObservableList<Node> circles = App.mainLayout.getChildren();
            for (Node circle : circles) {
                if (circle == this.circle) {
                    System.out.println("Car " + circle.hashCode() + " removed from layout " + this.circle.hashCode());
                    Platform.runLater(() -> {
                        App.mainLayout.getChildren().remove(circle);
                    });
                    break;
                }
            }
            
        }
    } 
}
