/**
 * CMSC 335
 * TimeTickedListener.java
 * DATE: 22 APR 25
 * AUTHOR: Raymond Rowland
 * 
 * This interface defines a listener for time-ticked events, allowing 
 * implementing classes to respond to periodic updates or ticks.
 */
package com.project3;

public interface TimeTickedListener {
    void onTimeTicked(String time);
}
