package com.umbra.mobModule.mobComponent.impl;


import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.enums.Att;
import com.umbra.mobModule.exceptions.BadConstructorException;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

/* VEEM MONXSTRO */
public class FabricaDeMonstro extends MobFactory {
    private static int id = 0;

    /* Incompleto, usar bd*/
    private static List monster(int id, int nivel){
        List resp = new ArrayList(3);

        String name = "Monstro";
        String description = "Cruel";
        Hashtable<String,IAttribute> atts = new Hashtable<String, IAttribute>();

        resp.add(0, name);
        resp.add(1, description);
        resp.add(2, atts);

        return resp;

    }
    public double randomExpAtt(Random r, int nivel, double coef , double dev, int rounding, Att att){
        double resp = coef * Math.exp(nivel) + r.nextDouble() * dev - dev/2;
        double tens = Math.floor(Math.pow(10, rounding));
        resp = Math.floor(resp/tens)*tens;
        resp = Math.abs(resp);
        return resp;
    }
    public double randomLinearAtt(Random r, int nivel, double coef , double dev, int rounding, Att att){
        double resp = coef*nivel + r.nextDouble() * dev - dev/2;
        double tens = Math.floor(Math.pow(10, rounding));
        resp = Math.floor(resp/tens)*tens;
        resp = Math.abs(resp);
        return resp;
    }
    public IMonstro create(int nivel, IPosition position){
        List monster = monster(id, nivel);

        String name = (String) monster.get(0);
        String description = (String) monster.get(1);
        Hashtable<String,IAttribute> atts = (Hashtable<String,IAttribute>) monster.get(2);

        IMonstro resp = new Monstro(name, description, position, atts, id);

        Random r = new Random(id*nivel);

        double maxHp = randomExpAtt(r, nivel, 42,nivel/42, 2, Att.HP);
        resp.setAtt(0, Att.HP.getName(), maxHp, maxHp);

        double xp = randomExpAtt(r, nivel, 34,nivel/34, 1, Att.XP);
        resp.setAtt(Att.XP.getName(), xp);

        double defense = randomLinearAtt(r, nivel, 42,nivel/34, 0, Att.DEFENSE);
        resp.setAtt(Att.DEFENSE.getName(), defense);

        double attack = randomLinearAtt(r, nivel, 42, nivel / 34, 0, Att.ATTACK);
        resp.setAtt(Att.ATTACK.getName(), attack);

        double dexterity = randomLinearAtt(r, nivel, 34, nivel / 42, 0, Att.DEXTERITY);
        resp.setAtt(Att.DEXTERITY.getName(), dexterity);

        double dexterity = randomLinearAtt(r, nivel, 34, nivel / 42, 0, Att.DEXTERITY);
        resp.setAtt(Att.DEXTERITY.getName(), dexterity);





        id++;

        return resp;
    }

    /*Throws exception BadConstructor*/
    public IPlayer instantiate(String name, String description, IPosition position) throws BadConstructorException {
        throw new BadConstructorException();
    }



}
