package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.IMob;
import com.umbra.puzzlesModule.IPuzzle;

public interface ICell {
    public IMob remove();
    public Boolean receive(IMob entidade);
    public IMob getEntety();
    public IPuzzle getDoor();
    public String getDescription();
}
