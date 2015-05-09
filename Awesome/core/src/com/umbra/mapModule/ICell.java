package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.IMob;
import com.umbra.puzzlesModule.IPuzzle;

public interface ICell {
    public IMob removeMob();
    public Boolean setMob(IMob entidade);
    public IMob getMob();
    public IPuzzle getDoor();
    public String getDescription();
}
