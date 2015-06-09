package com.umbra.mapModule.inter;

import com.umbra.mobModule.mobComponent.inter.IMob;
import com.umbra.puzzlesModule.IPuzzle;

public interface ICell {
    public IMob removeMob();
    public Boolean setMob(IMob entidade);
    public IMob getMob();
    public void setDoor(IPuzzle porta);
    public IPuzzle getDoor();
    public void setParede(boolean p);
    public boolean getParede();
    public char getDescription();
}
