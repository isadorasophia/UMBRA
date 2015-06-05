package com.umbra.mobModule.enums;

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
