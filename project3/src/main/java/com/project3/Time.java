/**
 * CMSC 335
 * Time.java
 * DATE: 22 APR 25
 * AUTHOR: Raymond Rowland
 * 
 * This class represents a utility for handling time-related operations.
 * It provides methods and functionality to work with time values.
 * It includes a listener mechanism to notify other components
 * when the time has ticked, allowing for real-time updates and synchronization.
 * The time is represented in hours, minutes, and seconds format.
 */
package com.project3;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Time {
    private static List<TimeTickedListener> listeners = new ArrayList<>();
    private static LocalTime currentTime = LocalTime.of(0, 0, 0);
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void tick() {
        while(App.currentState != SimulationState.STOPPED) {
            try {
                if(App.currentState == SimulationState.RUNNING) {
                    currentTime = currentTime.plusSeconds(1);
                    notifyListeners();
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void resetTimer() {
        currentTime = LocalTime.of(0, 0, 0);
        notifyListeners();
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
