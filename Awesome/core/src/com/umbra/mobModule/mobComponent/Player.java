package com.umbra.mobModule.mobComponent;

import mapModule.IPosition;
import mobModule.*;
import mobModule.itemComponent.*;

import java.util.Hashtable;
import java.util.List;


public class Player extends Mob implements IPlayer {
    IInventory inventory = null;
    public Player(String name, IPosition position, List<IAttribute> atts){
        super(name, position, atts);
    }

    public Player(String name, IPosition position, List<IAttribute> atts, List<IItem> items, int size){
        super(name, position, atts);
        this.createInventory(size);
        for(IItem item : items){
            inventory.adItem(item);
        }
    }

    public Player(String name, IPosition position, Hashtable<String, IAttribute> atts, IInventory inventory) {
        super(name, position, atts);
        this.inventory = inventory;
    }

    public IInventory getInventory() {
        return inventory;
    }
    
    public void createInventory(int size) {
    	this.inventory = new Inventory(size);
    }
    
    public IMob clone(){
        IMob clone = new Player(name, position, atts, inventory);
        return clone;
    }
}
