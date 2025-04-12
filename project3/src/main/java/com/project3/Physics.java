package com.project3;

import java.util.ArrayList;
import java.util.List;

class Physics {
    private static List<PhysicsTickListener> listeners;

    static {
        listeners = new ArrayList<>();
        Thread thread = new Thread(Physics::tick);
        thread.setDaemon(true);
        thread.start();
    }

    private static void tick() {
        while(App.currentState != null) {
            try {
                Thread.sleep(16);
                // System.out.println("Physics Tick");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void addListener(PhysicsTickListener listener) {
        listeners.add(listener);
    }

    public static void removeListener(PhysicsTickListener listener) {
        listeners.remove(listener);
    }
    
    static void notifyListeners() {
        for (PhysicsTickListener listener : listeners) {
            try {
                
            } catch (Exception e) {
                removeListener(listener);
            }
        }
    }
}
