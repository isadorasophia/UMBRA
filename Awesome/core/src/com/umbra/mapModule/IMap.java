package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.IMob;

public interface IMap {
    public void initialPosition(IMob player);
    public void getPosition(IPosition posicao);
    public boolean move(IMob entidade, char direction);
}
