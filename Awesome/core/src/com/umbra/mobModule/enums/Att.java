package com.umbra.mobModule.enums;

/**
 * Tipo enumerado que representa os atributos que serão usados no jogo,
 * com valores base e valores de incremento para modificação
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public enum Att {
    HP("hp", 100, 10),
    XP("xp", 100, 200),
    DEFENSE("defense", 7, 2),
    ATTACK("attack", 12, 2),
    DEXTERITY("dexterity", 10, 2),
    EVASIVENESS("evasiveness", 8, 1),
    LUCK("luck", 7, 1),
    SANITY("sanity", 1, -0.01),
    SPEED("speed", 10, 1);


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
