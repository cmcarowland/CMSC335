package com.project3;

public interface IState {
    public void onEnter();
    public void onTick();
    public void onExit();
    public String getStateName();
}
