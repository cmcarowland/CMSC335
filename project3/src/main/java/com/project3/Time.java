package com.project3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Time {
    private static List<TimeTickedListener> listeners = new ArrayList<>();
    private static LocalTime currentTime = LocalTime.of(0, 0, 0);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    static {
        Thread thread = new Thread(Time::tick);
        thread.setDaemon(true);
        thread.start();
        System.out.println("Time thread started");
    }

    private static void tick() {
        while(App.currentState != null) {
            try {
                if(App.currentState == SimulationState.RUNNING) {
                    currentTime = currentTime.plusSeconds(1);
                    notifyListeners();
                } else if (App.currentState == SimulationState.STOPPED && currentTime.compareTo(LocalTime.of(0, 0, 0)) > 0) {
                    currentTime = LocalTime.of(0, 0, 0);
                    notifyListeners();
                } 

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addListener(TimeTickedListener listener) {
        listeners.add(listener);
    }

    public static void removeListener(TimeTickedListener listener) {
        listeners.remove(listener);
    }
    
    static void notifyListeners() {
        for (TimeTickedListener listener : listeners) {
            try {
                listener.onTimeTicked(formatter.format(currentTime));
            } catch (Exception e) {
                removeListener(listener);
            }
        }
    }
}
