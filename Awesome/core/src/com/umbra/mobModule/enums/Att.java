package com.umbra.mobModule.enums;

/**
 * Tipo enumerado que representa os atributos que serão usados no jogo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public enum Att {
    HP("hp", 100, 10),
    XP("xp", 200, 13),
    DEFENSE("defense", 10, 3),
    ATTACK("atack", 10, 2),
    DEXTERITY("dexterity", 12, 3),
    EVASIVENESS("evasiveness", 10, 1),
    LUCK("luck", 5, 1),
    SANITY("sanity", 100, -1);


    private String name;
    private double base;
    private double increment;

    private Att(String name, double base, double increment){
        this.name = name;
        this.base = base;
        this.increment = increment;
    }

    public String getName(){
        return name;
    }
    public double getBase(){
        return base;
    }
    public double getIncrement(){
        return increment;
    }
}
