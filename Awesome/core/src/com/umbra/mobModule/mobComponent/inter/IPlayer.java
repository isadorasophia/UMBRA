package com.umbra.mobModule.mobComponent.inter;

import java.util.Vector;

public interface IPlayer extends IPlayerGeneric {
    public double getXp();
    public void setXp(double xp);
    public int getNivel();
    public Vector<String> itemsForBattle();
    public Vector<String> itemsIlumination();
    public Vector<String> itemsPuzzle();
}
