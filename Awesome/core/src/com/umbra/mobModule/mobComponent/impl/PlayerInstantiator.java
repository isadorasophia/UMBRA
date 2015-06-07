package com.umbra.mobModule.mobComponent.impl;


import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.enums.Att;
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
        resp.setAtt(0, Att.HP.getName(), Player.MAXHP, Player.MAXHP);
        resp.setAtt(0, Att.XP.getName(), 0);
        resp.setAtt(0, Att.SANITY.getName(), 1, 1);
        resp.setAtt(Att.ATTACK.getName(), 0);
        resp.setAtt(Att.DEFENSE.getName(), 0);
        resp.setAtt(Att.DEXTERITY.getName(), 0);
        resp.setAtt(Att.EVASIVENESS.getName(), 0);
        resp.setAtt(0, Att.LUCK.getName(), 0.5, 1);

        return resp;


    }

    public IMonstro create(int nivel, IPosition position) throws BadConstructorException {
        throw new BadConstructorException();
    }
}
