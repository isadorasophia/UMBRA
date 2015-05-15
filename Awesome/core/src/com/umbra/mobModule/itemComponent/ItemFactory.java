package com.umbra.mobModule.itemComponent;

import com.umbra.mapModule.IPosition;


public class ItemFactory{

    public static IItemBattle instantiate(String name, String description, double findProb, IPosition pos){
        return new ItemBattle(name, description, findProb, pos);
    }
    public static IItemPuzzle instantiateP(String name, String description, double findProb, IPosition pos){
        return new ItemPuzzle(name, description, findProb, pos);
    }
    public static IItemIlumination instantiate(String name, String description, double findProb, IPosition pos, double ilumination){
        return new ItemIlumination(name, description, findProb, pos, ilumination);
    }
}