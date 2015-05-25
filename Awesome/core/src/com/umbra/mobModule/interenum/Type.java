package com.umbra.mobModule.interenum;

public enum Type {
    MONSTRO('M'), PLAYER('@'),ITEM('i'), ITEM_BATTLE("ib"), ITEM_ILUMINATION("il"), ITEM_PUZZLE("ip");
    private final String id;
    private char anotherId;
    String description;
    Type(char id){
        this.id = ""+id;
        this.anotherId = id;
    }
    Type(String id){
        this.id = id;
        this.anotherId = id.charAt(0);

    }

    public String getId(){
        return id;
    }
    public char getChar(){
        return anotherId;
    }
    public void setChar(char anotherId){
        this.anotherId = anotherId;
    }

}
