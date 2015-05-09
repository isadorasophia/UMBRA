package com.umbra.mobModule.mobComponent;

import com.umbra.mobModule.attComponent.IAttribute;
import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.itemComponent.*;

import java.util.*;


public class PlayerGeneric extends Mob implements IPlayerGeneric {
    private IInventory inventory = null;
    private Stack<IItemBattle> equiped = null;
    private int inventorySize;

    public PlayerGeneric(String name, IPosition position){
        super(name, position);
    }
    public PlayerGeneric(String name, String description, IPosition position){
        super(name, description, position);
    }
    public PlayerGeneric(String name, String description, IPosition position, List<IAttribute> atts){
        super(name, description, position, atts);
    }
    public PlayerGeneric(String name, String description, IPosition position,
                         Hashtable<String, IAttribute> atts){
        super(name, description, position, atts);
    }
    public PlayerGeneric(String name, String description, IPosition position, Hashtable<String, IAttribute> atts,
                         List<IItem> items, int size){
        super(name, description, position, atts);
        this.createInventory(size);
        for(IItem item : items){
            inventory.adItem(item);
        }
    }
    public PlayerGeneric(String name, String description, IPosition position, List<IAttribute> atts,
                         List<IItem> items, int size){
        super(name, description, position, atts);
        this.createInventory(size);
        for(IItem item : items){
            inventory.adItem(item);
        }
    }

    public PlayerGeneric(String name, String description, IPosition position,
                         Hashtable<String, IAttribute> atts, IInventory inventory) {
        super(name, description, position, atts);
        this.inventory = inventory;
    }

    public char getChar(){
        return '@';
    }
    public IInventory getInventory() {
        return inventory;
    }


    public boolean equipItem(String itemName) {
        IInventory inv = getInventory();
        boolean resp = true;
        if(inv.hasItem(itemName)){
            if(equiped == null){
                equiped = new Stack<IItemBattle>();
            }
            equiped.push((IItemBattle)inv.dropItem(itemName));
            ((IItemBattle)inv.getItem(itemName)).updateMob(this);
        }else{
            resp = false;
        }

        return resp;
    }


    public void unequipAll() {
        while(!equiped.empty()){
            equiped.pop().unupdateMob(this);
        }
    }

    public void createInventory(int size) {
        this.inventory = new Inventory(size);
    }
    
    public IMobGeneric clone(){
        IMobGeneric clone = new PlayerGeneric(name, description, position, atts, inventory);
        return clone;
    }
}
