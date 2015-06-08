package com.umbra.mobModule;

import java.util.List;

import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;

import com.umbra.mapModule.Position;
import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.impl.Attribute;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.enums.Att;
import com.umbra.mobModule.enums.Operation;
import com.umbra.mobModule.inventoryComponent.impl.Inventory;
import com.umbra.mobModule.inventoryComponent.inter.IInventory;
import com.umbra.mobModule.itemComponent.impl.ItemManager;
import com.umbra.mobModule.itemComponent.inter.IItem;
import com.umbra.mobModule.itemComponent.inter.IItemBattle;
import com.umbra.mobModule.itemComponent.inter.IItemIlumination;
import com.umbra.mobModule.itemComponent.inter.IItemManager;
import com.umbra.mobModule.itemComponent.inter.IItemPuzzle;
import com.umbra.mobModule.mobComponent.impl.MobManager;
import com.umbra.mobModule.mobComponent.inter.IMobManager;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;
import com.umbra.mobModule.modAttComponent.impl.ModAtt;
import com.umbra.mobModule.modAttComponent.inter.IModAtt;

public class Principal {
	public static void main(String[] args) {

        try {
        	IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
        	factory.registerPrototype(MobManager.class);
        	factory.registerPrototype(ItemManager.class);
        	IMobManager mobmanager = factory.createInstance(
        			"<http://purl.org/NET/dcc/com.umbra.mobModule.mobComponent.impl.MobManager>");
        	IItemManager itemmanager = factory.createInstance(
        			"<http://purl.org/NET/dcc/com.umbra.mobModule.itemComponent.impl.ItemManager>");
        	IPlayer player = mobmanager.createPlayer("Player", "Teste", null);
        	
        	IItemBattle longSword = itemmanager.instantiateItemBattle("longSword", null);
        	IItemPuzzle key = itemmanager.instantiateItemPuzzle("key", null);
        	IItemIlumination lantern = itemmanager.instantiateItemIlumination("lantern", null);
        	IMonstro monstro = mobmanager.createMonstro(5, null);
        	
        } catch (Exception e) {
        	e.printStackTrace();
        }

        System.out.println("Terminado");
        System.exit(1);
    }
}
