package com.umbra.vultoModule;

public class Vulto implements IVulto {
    private int distance;
    private double lightProtection;

    public Vulto(){
        distance = 100;
        lightProtection = 0;
    }
    public boolean checkVulto(){
        return distance == 0;
    }
    public void lightInterference(double light){}
    public boolean chooseAction(int Action) {
        return false;
    }
}
