package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.IMob;
import com.umbra.puzzlesModule.IPuzzle;

public interface iCell {
    public void remove(IMob entidade);
    public void receive(IMob entidade);
    public IMob getEntety();
    public IPuzzle getDoor();
    public String getDescription();
}
