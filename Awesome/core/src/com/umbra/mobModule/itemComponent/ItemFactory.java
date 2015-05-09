package com.umbra.mobModule.itemComponent;

import com.umbra.mobModule.IFactory;


public class ItemFactory implements IFactory {


    public IItem instantiate(String subtype, String name) {
        switch(subtype){
            case "Battle":
                return new ItemBattle(name);
            case "Puzzle":
                return new ItemPuzzle(name);
            case "Ilumination":
                return new ItemIlumination(name);

        }
        return null;
    }

    public IItem instantiate(String subtype) {
        return instantiate(subtype, "noName");
    }
}