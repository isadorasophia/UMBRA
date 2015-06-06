package com.umbra.mobModule.enums;

/**
 * Tipo enumerado que representa os atributos que serão usados no jogo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public enum Att {
    HP("hp"),
    DEFENSE("defense"),
    ATTACK("atack"),
    DEXTERITY("dexterity"),
    EVASIVENESS("evasiveness"),
    LUCK("luck"), SANITY("sanity"),
    XP("xp");

    private String name;

    private Att(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
