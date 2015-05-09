package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.IMob;

public interface IMap {
    public void initialPosition(IMob player);
    public void getPosition(IPosition posicao);
    public void move(IPosition destino);
}
