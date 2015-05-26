package com.umbra.mobModule.mobComponent.impl;


import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.exceptions.BadConstructorException;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

public class PlayerInstantiator extends MobFactory {
    
    /*
    atributos:
        nivel = 1
        maxHP
        currentHP
        currentXP
        defense
        attack
        dexterity
        evasiveness
        speed
        luck
        sanity = 0.0 a 1.0
    */

    public static final Integer INITIAL_SIZE = 10;

    public IPlayer instantiate(String name, String description,  IPosition position){

        IPlayer resp = Player.getInstance(name, description, position, INITIAL_SIZE);

        return resp;


    }

    public IMonstro create(int nivel, IPosition position) throws BadConstructorException {
        throw new BadConstructorException();
    }
}
