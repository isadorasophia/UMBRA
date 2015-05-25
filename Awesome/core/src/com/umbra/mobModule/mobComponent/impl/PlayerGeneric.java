package com.umbra.mobModule.mobComponent.impl;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
import com.umbra.mobModule.itemComponent.inter.IItem;
import com.umbra.mobModule.itemComponent.inter.IItemBattle;
import com.umbra.mobModule.interenum.Type;
import com.umbra.mobModule.inventoryComponent.impl.InvCreator;
import com.umbra.mobModule.inventoryComponent.inter.IInventory;
import com.umbra.mobModule.mobComponent.inter.IPlayerGeneric;

import java.util.*;


public class PlayerGeneric extends Mob implements IPlayerGeneric {
    private IInventory inventory = null;
    private Stack<IItemBattle> equiped = null;
    private int inventorySize;

    public PlayerGeneric(String name, String description, IPosition position, int inventorySize){
        super(name, description, position);
        this.inventory = InvCreator.create(inventorySize);
    }

    public Type getType() {
        Type resp = Type.PLAYER;
        resp.setChar('@');
        return resp;
    }
    public IInventory getInventory() {
        return inventory;
    }

    public void putItem(IItem ...neoItem){
        if (this.inventory == null) {
            this.inventory = InvCreator.create(inventorySize);
        }
        for (IItem neo : neoItem) {
            inventory.adItem(neo);
        }
    }

    public IItem dropItem(String name) {
        IItem resp = inventory.dropItem(name);
        if (equiped.contains(resp)) {
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
        IInventory inv = getInventory();
        boolean resp = true;
        if (inv.hasItem(itemName)) {
            if (equiped == null) {
                equiped = new Stack<IItemBattle>();
            }
            IItemBattle item = (IItemBattle) inv.dropItem(itemName);

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
            try {
                equiped.pop().unupdateMob(this);
            } catch (CannotUnmodifyWhatHasNotBeenModifiedException e) {
                e.printStackTrace();
            }
        }
    }

    public Vector<String> itemsForBattle() {

        IInventory inv = getInventory();
        Vector<IItem> items = inv.getAllItems();
        Vector<String> resp = new Vector<String>(items.size(), 1);

        for (IItem item : items) {
            resp.add(item.getName());
        }
        
        return resp;
    }
}
