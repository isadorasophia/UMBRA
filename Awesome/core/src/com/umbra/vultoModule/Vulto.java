package com.umbra.vultoModule;

public class Vulto implements IVulto {
    private int distance;
    private int lightProtection;

    public boolean checkVulto(){
        return distance == 0;
    }
    public void lightInterference(double light){}
    public boolean chooseAction(int Action) {
        return false;
    }
}
