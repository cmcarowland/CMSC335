package com.project3;

import javafx.scene.Node;

public class Intersection {
    static int idCounter = 1;

    private int id;
    private int x;
    private final int width = 10;
    private LightState lightState = LightState.OFF;
    Node ui = null;
    private LightController lightController = null;

    public Intersection(int x, LightController lc) {
        this.id = idCounter++;
        this.x = x * 1000;
        Thread thread = new Thread(() -> lightThread());
        thread.setDaemon(true);
        thread.start();
        this.lightController = lc;
    }
    
    public void setLightController(LightController lc) {
        System.out.println("Set: " + lc);
        this.lightController = lc;
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
                    lightController.setGreenLightVisible(true);
                    lightController.setRedLightVisible(false);
                    // System.out.println("Light is green");
                    Thread.sleep(5000);
                    if(lightState == LightState.OFF) {
                        continue;
                    }
                    lightState = LightState.YELLOW;
                    lightController.setGreenLightVisible(false);
                    lightController.setYellowLightVisible(true);
                    // System.out.println("Light is yellow");
                    Thread.sleep(2000);
                    if(lightState == LightState.OFF) {
                        continue;
                    }
                    lightState = LightState.RED;
                    lightController.setYellowLightVisible(false);
                    lightController.setRedLightVisible(true);
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
        lightController.setVisible(true);
    }
    
    public void disable() {
        lightState = LightState.OFF;
        lightController.setVisible(false);
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
