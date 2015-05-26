package com.umbra.mobModule.itemComponent.impl;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.itemComponent.inter.IItemBattle;
import com.umbra.mobModule.itemComponent.inter.IItemIlumination;
import com.umbra.mobModule.itemComponent.inter.IItemManager;
import com.umbra.mobModule.itemComponent.inter.IItemPuzzle;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.mobModule.itemComponent.impl.ItemManager>",
		provides={"<http://purl.org/NET/dcc/com.umbra.mobModule.itemComponent.impl.IItemManager>"}
)

public class ItemManager extends ComponentBase implements IItemManager {

    public IItemBattle instantiateItemBattle(String name, String description, double findProb, IPosition pos){
        return new ItemBattle(name, description, findProb, pos);
    }
    
    public IItemPuzzle instantiateItemPuzzle(String name, String description, double findProb, IPosition pos){
        return new ItemPuzzle(name, description, findProb, pos);
    }
    
    public IItemIlumination instantiateItemIlumination(String name, String description, double findProb, IPosition pos, double ilumination){
        return new ItemIlumination(name, description, findProb, pos, ilumination);
    }
    
}