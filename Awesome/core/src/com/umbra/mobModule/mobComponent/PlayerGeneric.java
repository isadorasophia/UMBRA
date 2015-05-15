package com.umbra.mobModule.mobComponent;

import com.umbra.mobModule.Exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.Exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
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

    public void putItem(IItem ... neoItem){
        if(this.inventory == null){
            this.inventory = new Inventory(inventorySize);
        }
        for(IItem neo : neoItem){
            inventory.adItem(neo);
        }
    }

    public IItem dropItem(String name) {
        IItem resp = inventory.dropItem(name);
        if(equiped.contains(resp)){
            equiped.remove(resp);
        }
        return resp;
    }
    public List<IItem> dropItems(String ... names){
        List<IItem> resp = new ArrayList<>(names.length);
        for(String name : names){
            resp.add(dropItem(name));
        }
        return resp;
    }


    public boolean equipItem(String itemName) {
        IInventory inv = getInventory();
        boolean resp = true;
        if(inv.hasItem(itemName)){
            if(equiped == null){
                equiped = new Stack<>();
            }
            equiped.push((IItemBattle)inv.dropItem(itemName));
            try {
                ((IItemBattle)inv.getItem(itemName)).updateMob(this);
            } catch (CannotDoubleModifyAttributeException e) {
                e.printStackTrace();
            }
        }else{
            resp = false;
        }

        return resp;
    }
    public List<Boolean> equipItems(String... itemNames){
        List<Boolean> resp = new ArrayList<>(itemNames.length);
        for(String itemName : itemNames){
            resp.add(equipItem(itemName)) ;
        }
        return resp;
    }

    public void unequipAll() {
        while(!equiped.empty()){
            try {
                equiped.pop().unupdateMob(this);
            } catch (CannotUnmodifyWhatHasNotBeenModifiedException e) {
                e.printStackTrace();
            }
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
