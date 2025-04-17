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
