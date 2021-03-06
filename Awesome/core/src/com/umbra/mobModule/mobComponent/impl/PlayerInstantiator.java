package com.umbra.mobModule.mobComponent.impl;

import com.umbra.mapModule.inter.IPosition;
import com.umbra.mobModule.enums.Att;
import com.umbra.mobModule.exceptions.BadConstructorException;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

/**
 * Classe que representa um instanciador de player que extende a fábrica abstrata, 
 * mas na verdade só pega a instancia do ítem
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class PlayerInstantiator extends MobFactory {

    public static final Integer INITIAL_SIZE = 10;

    public IPlayer instantiate(String name, String description,  IPosition position) {

        IPlayer resp = Player.getInstance(name, description, position, INITIAL_SIZE);
        resp.setAtt(0, Att.HP.getName(), Player.MAXHP, Player.MAXHP);
        resp.setAtt(0, Att.XP.getName(), 0);
        resp.setAtt(0,Att.ATTACK.getName(), 15);
        resp.setAtt(0,Att.DEFENSE.getName(), 14);
        resp.setAtt(0,Att.DEXTERITY.getName(), 13);
        resp.setAtt(0, Att.EVASIVENESS.getName(), 10);
        resp.setAtt(0, Att.LUCK.getName(), 9);
        resp.setAtt(0, Att.SANITY.getName(), 0.5, 1);
        resp.setAtt(0, Att.SPEED.getName(), 12);

        return resp;


    }

    public IMonstro create(int nivel, IPosition position) throws BadConstructorException {
        throw new BadConstructorException();
    }
}
