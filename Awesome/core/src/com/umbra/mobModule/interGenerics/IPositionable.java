package com.umbra.mobModule.interGenerics;

import com.umbra.mapModule.IPosition;

/**
 * Interface que generaliza os objetos que guardam a posição no mapa
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IPositionable {
    /**
     * Permite ler a posição de um objeto que implemente a interface IPositionable
     * @return Um Objeto que implemente a interface IPosition
     */
    public IPosition getPosition();
    public void setPosition(IPosition position);
}
