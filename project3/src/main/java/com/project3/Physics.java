package com.project3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Physics {
    private static List<PhysicsTickListener> listeners;
    private static List<PhysicsTickListener> addingListeners;
    private static List<PhysicsTickListener> removingListeners;
    private static Lock lock = new ReentrantLock();

    static {
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
                Thread.sleep(16);
                notifyListeners();
                processWaitingListeners();
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
            System.out.println("Removing listener: " + listener);
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
}
