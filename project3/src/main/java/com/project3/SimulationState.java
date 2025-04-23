/**
 * CMSC 335
 * SimulationState
 * DATE: 22 APR 25
 * AUTHOR: Raymond Rowland
 * 
 * This enum represents the various states of a simulation, 
 * providing a structured way to manage and track the simulation's progress.
 */
package com.project3;

public enum SimulationState {
    RUNNING("Running"),
    STOPPED("Stopped"),
    PAUSED("Paused"),
    CONTINUED("Continued");

    private final String stateName;

    SimulationState(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }
}
