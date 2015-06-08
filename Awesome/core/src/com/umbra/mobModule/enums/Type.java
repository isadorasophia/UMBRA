package com.umbra.mobModule.enums;

/**
 * Tipo enumerado usado para identificar os tipos de mobs
 * e os tipos de itens usados no programa
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

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
    private Type(char id, String description){
        this.id = ""+id;
        this.anotherId = id;
        this.description = description;
    }
    private Type(String id, String description){
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
