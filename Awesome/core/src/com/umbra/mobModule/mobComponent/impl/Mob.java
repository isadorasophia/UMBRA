package com.umbra.mobModule.mobComponent.impl;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.enums.Type;
import com.umbra.mobModule.mobComponent.inter.IMob;

import java.util.Hashtable;
import java.util.List;

/**
 * Classe Abstrata que representa um mob que será usado no jogo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public abstract class Mob extends MobGeneric implements IMob {

	/**
	 * Construtor padrão
	 * @param name : nome do mob
	 * @param description : descrição do mob
	 * @param position : posição
	 */
    protected Mob(String name, String description, IPosition position) {
        super(name, description, position);
    }

    /**
     * Construtor que recebe uma Hashtable com os atributos
     * @param name : nome do mob
     * @param description : descrição do mob
     * @param position : posição
     * @param atts : Hashtable com os atributos
     */
    protected Mob(String name, String description, IPosition position, Hashtable<String, IAttribute> atts) {
        super(name, description, position, atts);
    }

    /**
     * Construtor que recebe uma List com os atributos
     * @param name : nome do mob
     * @param description : descrição do mob
     * @param position : posição
     * @param atts : lista com os atributos
     */
    protected Mob(String name, String description, IPosition position, List<IAttribute> atts) {
        super(name, description, position, atts);
    }

    public boolean dead() {
        return this.getAtt("hp").getValue() <= 0.5;
    }

    public abstract Type getType();

    public char getChar(){
        return getType().getChar();
    }
    
    public boolean decreaseHP(double hp) {
        IAttribute att = getAtt("hp");
        double value = att.getValue() - hp;
        att.setValue(value);

        return value > 0;
    }

}
