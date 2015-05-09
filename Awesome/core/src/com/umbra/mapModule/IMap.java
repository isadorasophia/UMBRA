package com.umbra.mapModule;

/**
 * Created by laurocruz on 5/8/15.
 */
public interface IMap {
    public void initialPosition();
    public void getPosition(IPosition posicao);
    public void move(IPosition destino);
}
