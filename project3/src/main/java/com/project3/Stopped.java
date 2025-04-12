package com.project3;

public class Stopped implements IState {
    Physics physics;
    String stateName = "Stopped";

    @Override
    public void onEnter() {
        
    }

    @Override
    public void onTick() {
        
    }

    @Override
    public void onExit() {
        
    }

    @Override
    public String getStateName() {
        return stateName;
    }
    
}
