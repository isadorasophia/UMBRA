package com.umbra.mobModule.mobComponent.impl;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.mobComponent.inter.IMonstro;

import java.util.Hashtable;
import java.util.List;

/**
 * Classe que é a implementação de um monstro que será usado no jogo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class Monstro extends MonstroGeneric implements IMonstro{

	/**
	 * Construtor padrão do monstro
	 * @param name
	 * @param description
	 * @param position
	 * @param id
	 */
    public Monstro(String name, String description, IPosition position, int id) {
        super(name, description, position, id);
    }

    /**
     * Construtor que recebe uma List de atributos
     * @param name
     * @param description
     * @param position
     * @param atts
     * @param id
     */
    public Monstro(String name, String description, IPosition position, List<IAttribute> atts, int id) {
        super(name, description, position, atts, id);
    }

    /**
     * Construtor que recebe uma Hashtable com os atributos
     * @param name
     * @param description
     * @param position
     * @param atts
     * @param id
     */
    public Monstro(String name, String description, IPosition position, Hashtable<String, IAttribute> atts, int id) {
        super(name, description, position, atts, id);
    }

}
