package com.project3;

import javafx.scene.Node;

public class Intersection {
    static int idCounter = 1;

    private int id;
    private int x;
    private final int width = 10;
    private LightState lightState = LightState.OFF;
    Node ui = null;
    private IntersectionController intersectionData = null;

    public Intersection(int x, Node t) {
        this.id = idCounter++;
        this.x = x * 1000;
        Thread thread = new Thread(() -> lightThread());
        thread.setDaemon(true);
        thread.start();
        ui = t;
    }

    public void setIntersectionData(IntersectionController intersectionData) {
        this.intersectionData = intersectionData;
    }

    public LightState getState() {
        return lightState;
    }

    private void lightThread() {
        while(App.currentState != null) {
            if(lightState == LightState.OFF) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    if(lightState == LightState.OFF) {
                        continue;
                    }
                    lightState = LightState.GREEN;
                    intersectionData.setGreenLightVisible(true);
                    intersectionData.setRedLightVisible(false);
                    // System.out.println("Light is green");
                    Thread.sleep(5000);
                    if(lightState == LightState.OFF) {
                        continue;
                    }
                    lightState = LightState.YELLOW;
                    intersectionData.setGreenLightVisible(false);
                    intersectionData.setYellowLightVisible(true);
                    // System.out.println("Light is yellow");
                    Thread.sleep(2000);
                    if(lightState == LightState.OFF) {
                        continue;
                    }
                    lightState = LightState.RED;
                    intersectionData.setYellowLightVisible(false);
                    intersectionData.setRedLightVisible(true);
                    // System.out.println("Light is red");
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void enable() {
        lightState = LightState.GREEN;
        ui.setVisible(true);
    }
    
    public void disable() {
        lightState = LightState.OFF;
        ui.setVisible(false);
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getWidth() {
        return width;
    }    
}
