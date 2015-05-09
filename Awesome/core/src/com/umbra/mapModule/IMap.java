package com.umbra.mapModule;

public interface IMap {
    public void initialPosition();
    public void getPosition(IPosition posicao);
    public void move(IPosition destino);
}
