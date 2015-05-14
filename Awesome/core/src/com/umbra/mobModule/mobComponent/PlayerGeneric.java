package com.umbra.mobModule.mobComponent;

import com.umbra.mobModule.attComponent.IAttribute;
import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.itemComponent.*;

import java.util.*;


public class PlayerGeneric extends Mob implements IPlayerGeneric {
    private IInventory inventory = null;
    private Stack<IItemBattle> equiped = null;
    private int inventorySize;

    public PlayerGeneric(String name, String description, IPosition position, int inventarySize){
        super(name, description, position);
        this.inventory = new Inventory(inventarySize);
    }

    public PlayerGeneric(String name, String description, IPosition position,
                         Hashtable<String, IAttribute> atts, IInventory inventory) {
        super(name, description, position, atts);
        this.inventory = inventory;
        this.inventorySize = inventory.getSize();
    }

    public char getChar(){
        return '@';
    }
    public IInventory getInventory() {
        return inventory;
    }

    public void putItem(IItem neoItem){
        if(this.inventory == null){
            this.inventory = new Inventory(inventorySize);

        }
    }


    public boolean equipItem(String itemName) {
        IInventory inv = getInventory();
        boolean resp = true;
        if(inv.hasItem(itemName)){
            if(equiped == null){
                equiped = new Stack<>();
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

    public Vector <String> itemsForBattle(){

        IInventory inv = getInventory();
        Vector<IItem> items = inv.getAllItems();
        Vector<String> resp = new Vector<>(items.size(), 1);

        for(IItem item : items){
            resp.add(item.getName());
        }
        return resp;
    }
    
    public IMobGeneric clone(){
        IMobGeneric clone = new PlayerGeneric(name, description, position, atts, inventory);
        return clone;
    }
}
