package com.umbra.mobModule.interGenerics;

import com.umbra.mapModule.inter.IPosition;

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
    
    /**
     * Permite setar a posição do objeto que implemente IPositionable
     * @param position : nova posição
     */
    public void setPosition(IPosition position);
}
