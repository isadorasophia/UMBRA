package com.umbra.mobModule.interGenerics;


import com.umbra.mapModule.IPosition;

public interface IPositionable {
    /**
     * Permite ler a posição de um objeto que implemente a interface IPositionable
     * @return Um Objeto que implemente a interface IPosition
     */
    public IPosition getPosition();
    public void setPosition(IPosition position);
}
