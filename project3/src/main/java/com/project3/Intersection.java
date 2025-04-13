package com.project3;

public class Intersection {
    static int idCounter = 0;

    private int id;
    private int x;
    private int width;
    private LightState lightState = LightState.OFF;

    public Intersection(int x, int width) {
        this.id = idCounter++;
        this.x = x;
        this.width = width;
        Thread thread = new Thread(() -> lightThread());
        thread.setDaemon(true);
        thread.start();
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
                    System.out.println("Light is green");
                    Thread.sleep(5000);
                    if(lightState == LightState.OFF) {
                        continue;
                    }
                    lightState = LightState.YELLOW;
                    System.out.println("Light is yellow");
                    Thread.sleep(2000);
                    if(lightState == LightState.OFF) {
                        continue;
                    }
                    lightState = LightState.RED;
                    System.out.println("Light is red");
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void enable() {
        lightState = LightState.GREEN;
    }
    
    public void disable() {
        lightState = LightState.OFF;
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
