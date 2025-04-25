/**
 * CMSC 335
 * Physics.java
 * DATE: 22 APR 25
 * AUTHOR: Raymond Rowland
 * 
 * This class provides functionality related to physics calculations and operations.
 * It manages a list of listeners that are notified on each physics tick.
 * It also handles the addition and removal of listeners in a thread-safe manner.
 * The class runs a separate thread that simulates the physics ticks at a fixed interval.
 * The delta time between ticks is calculated and can be accessed by listeners.
 */
package com.project3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javafx.application.Platform;

import java.time.Duration;
import java.time.LocalTime;

class Physics {
    private static List<PhysicsTickListener> listeners;
    private static List<PhysicsTickListener> addingListeners;
    private static List<PhysicsTickListener> removingListeners;
    private static Lock lock = new ReentrantLock();
    private static final int tickTime = 16; // 16ms
    private static double deltaTime = 0;
    private static LocalTime time = null;
    private static double[] fps = {60, 60, 60, 60, 60, 60, 60, 60, 60, 60};
    private static int fpsIndex = 0;

    static {
        time = LocalTime.now();
        listeners = new ArrayList<>();
        addingListeners = new ArrayList<>();
        removingListeners = new ArrayList<>();
        Thread thread = new Thread(Physics::tick);
        thread.setDaemon(true);
        thread.start();
    }

    private static void tick() {
        while(App.currentState != null) {
            try {
                Thread.sleep(tickTime);
                if(App.currentState == SimulationState.RUNNING) {
                    deltaTime = Duration.between(time, LocalTime.now()).toNanos() / 1000000000.0;
                    fps[fpsIndex++] = deltaTime;
                    if (fpsIndex >= fps.length) {
                        fpsIndex = 0;
                    }
                    // System.out.println("Delta time: " + deltaTime);
                    notifyListeners();
                    processWaitingListeners();
                    Platform.runLater(() -> {
                        App.primaryController.updateFPSLabel();
                    });
                }else {
                    deltaTime = 0;
                }

                time = LocalTime.now();
                // System.out.println("Physics Tick");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void addListener(PhysicsTickListener listener) {
        lock.lock();
        try{
            addingListeners.add(listener);
        } finally {
            lock.unlock();
        }
    }

    public static void removeListener(PhysicsTickListener listener) {
        lock.lock();
        try {
            // System.out.println("Removing listener: " + listener);
            removingListeners.add(listener);
        } finally {
            lock.unlock();
        }
    }

    static void processWaitingListeners() {
        lock.lock();
        try {
            for (PhysicsTickListener listener : addingListeners) {
                if (!listeners.contains(listener)) {
                    listeners.add(listener);
                }
            }
            addingListeners.clear();
            
            for (PhysicsTickListener listener : removingListeners) {
                if (listeners.contains(listener)) {
                    listeners.remove(listener);
                }
            }
            removingListeners.clear();
        } finally {
            lock.unlock();
        }
    }
    
    static void notifyListeners() {
        for (PhysicsTickListener listener : listeners) {
            try {
                listener.onPhysicsTicked();
            } catch (Exception e) {
                removeListener(listener);
            }
        }
    }

    public static double getDeltaTime() {
        return deltaTime;
    }

    public static int getFPS() {
        double sum = 0;
        for (double d : fps) {
            sum += d;
        }
     
        return (int)(1 / (sum / fps.length));
    }

    public static void getCarsGoingX(Car c) {
        Car closestCar = null;
        float distance = 10000;
        
        for (PhysicsTickListener listener : listeners) {
            if (listener instanceof Car) {
                Car car = (Car) listener;
                if (car.getId() != c.getId()) {
                    if (car.isToRight() == c.isToRight()) {
                        // System.out.println("Car " + c.getId() + " is going in the same direction as car " + car.getId());
                        float d = Math.abs(car.getX() - c.getX());
                        if (d < distance) {
                            distance = d;
                            closestCar = car;
                        }
                    }
                }
            }
        }

        c.setNextCar(closestCar);
    }

    public static void reset() {
        lock.lock();
        try {
            for (PhysicsTickListener listener : listeners) {
                if (listener instanceof Car) {
                    removingListeners.add(listener);
                    ((Car) listener).cleanUp();
                }
            }
        } finally {
            lock.unlock();
        }

        time = LocalTime.now();
    }
}
