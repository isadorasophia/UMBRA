package com.umbra.mobModule.mobComponent.impl;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.exceptions.BadConstructorException;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

/**
 * Classe abstrata que representa uma fábrica abstrata do design
 * pattern Abstract Factory, que cria player e monstros
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public abstract class MobFactory {

	/**
	 * Retorna um player criado ou uma exceção se for na fábrica de monstro
	 * @param name
	 * @param description
	 * @param position
	 * @return
	 * @throws BadConstructorException
	 */
    public abstract IPlayer instantiate(String name, String description,  IPosition position) throws BadConstructorException;
    
    /**
     * Retorna um monstro criado ou uma exceção caso seja na fábrica de player
     * @param nivel
     * @param position
     * @return
     * @throws BadConstructorException
     */
    public abstract IMonstro create(int nivel, IPosition position) throws BadConstructorException;

    /**
     * Cria uma fábrica do tipo especificado, player ou monstro
     * @param id
     * @return
     */
    public static MobFactory createFactory(String id) {
        MobFactory factory = null;
        if (id.equalsIgnoreCase("Monstro"))
            factory = new FabricaDeMonstro();
        else if (id.equalsIgnoreCase("Player"))
            factory = new PlayerInstantiator();

        return factory;
    }
}
