package com.umbra.mobModule.mobComponent.impl;

import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
import com.umbra.mobModule.itemComponent.inter.IItem;
import com.umbra.mobModule.itemComponent.inter.IItemBattle;
import com.umbra.mobModule.interenum.Type;
import com.umbra.mobModule.inventoryComponent.impl.Inventory;
import com.umbra.mobModule.inventoryComponent.inter.IInventory;
import com.umbra.mobModule.mobComponent.inter.IPlayerGeneric;

import java.util.*;


public class PlayerGeneric extends Mob implements IPlayerGeneric {
    private IInventory inventory = null;
    private Stack<IItemBattle> equiped = null;

    public PlayerGeneric(String name, String description, IPosition position, int inventorySize){
        super(name, description, position);
        try {
        	IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
        	factory.registerPrototype(Inventory.class);
        	Inventory inventory = factory.createInstance(
        				"<http://purl.org/NET/dcc/com.umbra.mobModule.inventoryComponent.impl.Inventory>");
        	this.inventory = inventory;
        	this.inventory.setSize(inventorySize);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
    }

    public Type getType() {
        Type resp = Type.PLAYER;
        resp.setChar('@');
        System.out.println(equiped.pop().getName());
        return resp;
    }

    public void putItem(IItem ...neoItem){
        for (IItem neo : neoItem) {
            inventory.adItem(neo);
        }
    }

    public IItem dropItem(String name) {
        IItem resp = inventory.dropItem(name);
        if (equiped != null && equiped.contains(resp)) {
            equiped.remove(resp);
        }
        return resp;
    }
    public List<IItem> dropItems(String ... names){
        List<IItem> resp = new ArrayList<IItem>(names.length);
        for(String name : names) {
            resp.add(dropItem(name));
        }
        return resp;
    }


    public boolean equipItem(String itemName) {
        boolean resp = true;
        if (inventory.hasItem(itemName)) {
            if (equiped == null) {
                equiped = new Stack<IItemBattle>();
            }
            IItemBattle item = (IItemBattle) inventory.dropItem(itemName);

            if (item == null) {
                resp = false;
            } else {
                try {
                    equiped.push(item);
                    item.updateMob(this);
                } catch (CannotDoubleModifyAttributeException e) {
                    e.printStackTrace();
                }
            }
        } else {
            resp = false;
        }

        return resp;
    }
    public List<Boolean> equipItems(String... itemNames){
        List<Boolean> resp = new ArrayList<Boolean>(itemNames.length);
        for (String itemName : itemNames) {
            resp.add(equipItem(itemName)) ;
        }
        return resp;
    }

    public void unequipAll() {
        while (!equiped.empty()) {
            IItemBattle item = equiped.pop(); 
        	try {
            	item.unupdateMob(this);
            } catch (CannotUnmodifyWhatHasNotBeenModifiedException e) {
                e.printStackTrace();
            }
        	inventory.adItem(item);
        }
    }

    public Vector<String> itemsForBattle() {
        Vector<IItem> items = inventory.getAllItems();
        Vector<String> resp = new Vector<String>(items.size(), 1);

        for (IItem item : items) {
            resp.add(item.getName());
        }
        
        return resp;
    }
}
