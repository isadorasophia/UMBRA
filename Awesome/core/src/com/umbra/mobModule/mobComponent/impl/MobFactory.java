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
	 * Retorna um player criado com os atributos padrões
     * @param name : nome do player
     * @param description : descrição do player
     * @param position : posição
	 * @return Player criado
	 * @throws BadConstructorException Tentativa de instanciar o player na fábrica de monstro
	 */
    public abstract IPlayer instantiate(String name, String description,  IPosition position) throws BadConstructorException;
    
    /**
     * Retorna um monstro criado acessado do DB
     * @param nivel : nível do monstro
     * @param position : posição
     * @return Monstro criado
     * @throws BadConstructorException Tentativa de instanciar o monstro no instanciador de player
     */
    public abstract IMonstro create(int nivel, IPosition position) throws BadConstructorException;

    /**
     * Cria uma fábrica do tipo especificado, player ou monstro
     * @param id : tipo da fábrica que se deseja ser instanciada
     * @return Fábrica concreta criada
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
