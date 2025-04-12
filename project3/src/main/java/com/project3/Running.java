package com.project3;

public class Running implements IState{
    Thread thread;
    String stateName = "Running";

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
