package com.umbra.mobModule.itemComponent.impl;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.enums.Att;
import com.umbra.mobModule.itemComponent.inter.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component(
		id = "<http://purl.org/NET/dcc/com.umbra.mobModule.itemComponent.impl.ItemManager>",
		provides = {"<http://purl.org/NET/dcc/com.umbra.mobModule.itemComponent.impl.IItemManager>"}
)

public class ItemManager extends ComponentBase implements IItemManager {

    private static void addModAtt(IItemBattle item, double rarity, Att att, Random r){
        double randRarity = r.nextDouble()/2 + 1/2;
        double paramether = rarity * randRarity * att.getIncrement();
        //paramether = Math.floor(paramether);
        item.addModAtt(att.getName(), paramether);
    }
    public IItemBattle instantiateItemBattle(String name, String description, double findProb, IPosition pos){
        IItemBattle resp = new ItemBattle(name, description, findProb, pos);
        if(findProb != 0){
            double rarity = 1/findProb;
            Random r = new Random();
            Att[] allowedToModify = {Att.ATTACK, Att.DEXTERITY, Att.DEFENSE};
            boolean hasSome = false;
            for(int j = 0; j < allowedToModify.length; j++){
                if(r.nextBoolean()){
                    addModAtt(resp, rarity, allowedToModify[j], r);
                    hasSome = true;
                }
            }
            if(!hasSome){
                Att a =allowedToModify[r.nextInt(allowedToModify.length)];
                addModAtt(resp, rarity, a, r);
            }
        }
        return resp;
    }
    
    public IItemPuzzle instantiateItemPuzzle(String name, String description, double findProb, IPosition pos){
        return new ItemPuzzle(name, description, findProb, pos);
    }
    
    public IItemIlumination instantiateItemIlumination(String name, String description, double findProb, IPosition pos, double ilumination){
        return new ItemIlumination(name, description, findProb, pos, ilumination);
    }
    
}