package com.umbra.mobModule.mobComponent.impl;

import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.Margin;
import com.umbra.mobModule.enums.Type;
import com.umbra.mobModule.exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
import com.umbra.mobModule.exceptions.FullInventoryException;
import com.umbra.mobModule.inventoryComponent.impl.Inventory;
import com.umbra.mobModule.inventoryComponent.inter.IInventory;
import com.umbra.mobModule.itemComponent.inter.IItem;
import com.umbra.mobModule.itemComponent.inter.IItemBattle;
import com.umbra.mobModule.mobComponent.inter.IPlayerGeneric;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Classe que representa um player genérico que pode ser extendido
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class PlayerGeneric extends Mob implements IPlayerGeneric {
    protected IInventory inventory = null;
    protected Stack<IItemBattle> equiped = null;

    /**
     * Construtor padrão do player genérico, que recebe
     * nome, descrição, posição e tamanho do inventário
     * @param name
     * @param description
     * @param position
     * @param inventorySize
     */
    public PlayerGeneric(String name, String description, IPosition position, int inventorySize){
        super(name, description, position);
        try {
        	IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
        	factory.registerPrototype(Inventory.class);
        	Inventory inventory = factory.createInstance(
        				"<http://purl.org/NET/dcc/com.umbra.mobModule.inventoryComponent.impl.Inventory>");
        	this.inventory = inventory;
        	this.inventory.setSize(inventorySize);
            this.equiped = new Stack<IItemBattle>();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
    }

    public Type getType() {
        return Type.PLAYER;
    }

    public void putItem(IItem ...neoItem) throws FullInventoryException {
    	int addItens = 0;
        for (IItem neo : neoItem) {
        	try {
        		inventory.adItem(neo);
        	} catch (FullInventoryException e) {
        		e.setAddItens(addItens);
        		throw e;
        	}
			addItens++;
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
            IItemBattle item = null;
            
            if (inventory.getItem(itemName).getType() == Type.ITEM_BATTLE) {
            	item = (IItemBattle) inventory.dropItem(itemName);
            }
            
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
        	try {
				inventory.adItem(item);
			} catch (FullInventoryException e) {
				e.printStackTrace();
			}
        }
    }
    public List<IItem> getAllItems(){
        List<IItem> resp = new ArrayList<IItem>();
        List<IItem> items = inventory.getAllItems();

        for (IItem item : items) {
            resp.add(item);
        }
        for (IItem item : equiped){
            resp.add(item);
        }
        return resp;
    }
    public String toString(Margin m){
        String resp = super.toString(m);
        resp += m.ident("#Itens:");
        for(IItem i : getAllItems()){
            resp += i.toString(m.next());
        }
        return resp;
    }
    
}
