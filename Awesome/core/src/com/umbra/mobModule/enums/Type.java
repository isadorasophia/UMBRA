package com.umbra.mobModule.enums;

public enum Type {
    MONSTRO('M', "Monsto"),
    PLAYER('@', "Player"),
    ITEM('i', "Item"),
    ITEM_BATTLE("ib", "Item Battle"),
    ITEM_ILUMINATION("il", "Item Ilumination"),
    ITEM_PUZZLE("ip", "Item Puzzle");
    private final String id;
    private char anotherId;
    String description;
    Type(char id, String description){
        this.id = ""+id;
        this.anotherId = id;
        this.description = description;
    }
    Type(String id, String description){
        this.id = id;
        this.anotherId = id.charAt(1);
        this.description = description;

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
    public String getDescription(){
        return description;
    }

}
