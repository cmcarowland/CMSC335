package com.project3;

import javafx.scene.Node;

public class Intersection implements PhysicsTickListener {
    private int id;
    private int x;
    private final int width = 10;
    private LightState lightState = LightState.OFF;
    Node ui = null;
    private LightController lightController = null;
    private double currentTime = 0;
    private float greenLightTime = 37;
    private float yellowLightTime = 4.5f;
    private float redLightTime = 48.5f;

    public Intersection(int x, LightController lc) {
        this.id = 5;
        this.x = x * 1000;
        this.lightController = lc;
        Physics.addListener(this);
    }
    
    public void setLightController(LightController lc) {
        // System.out.println("Set: " + lc);
        this.lightController = lc;
    }

    public LightState getState() {
        return lightState;
    }

    public void enable() {
        currentTime = 0;
        lightState = LightState.STARTING;
        lightController.setVisible(true);
    }
    
    public void disable() {
        lightState = LightState.OFF;
        lightController.setVisible(false);
        lightController.setGreenLightVisible(false);
        lightController.setYellowLightVisible(false);
        lightController.setRedLightVisible(false);
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

    @Override
    public void onPhysicsTicked() {
        if(lightState == LightState.OFF) {
            return;
        }

        currentTime += Physics.getDeltaTime();
        if(currentTime < greenLightTime && lightState != LightState.GREEN) {
            lightState = LightState.GREEN;
            lightController.setGreenLightVisible(true);
            lightController.setRedLightVisible(false);
        } else if(currentTime > greenLightTime && lightState == LightState.GREEN) {
            lightState = LightState.YELLOW;
            lightController.setGreenLightVisible(false);
            lightController.setYellowLightVisible(true);
        } else if(currentTime > greenLightTime + yellowLightTime && lightState == LightState.YELLOW) {
            lightState = LightState.RED;
            lightController.setYellowLightVisible(false);
            lightController.setRedLightVisible(true);
        }
        if(currentTime > greenLightTime + yellowLightTime + redLightTime) {
            currentTime = 0;
        }
    }

    public float getGreenLightTime() {
        return greenLightTime;
    }

    public void setGreenLightTime(float greenLightTime) {
        this.greenLightTime = greenLightTime;
    }

    public float getYellowLightTime() {
        return yellowLightTime;
    }

    public void setYellowLightTime(float yellowLightTime) {
        this.yellowLightTime = yellowLightTime;
    }

    public float getRedLightTime() {
        return redLightTime;
    }

    public void setRedLightTime(float redLightTime) {
        this.redLightTime = redLightTime;
    }
}
