package com.umbra.mobModule;

import java.util.Vector;

import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;

import com.umbra.mobModule.itemComponent.impl.ItemManager;
import com.umbra.mobModule.itemComponent.inter.IItemBattle;
import com.umbra.mobModule.itemComponent.inter.IItemIlumination;
import com.umbra.mobModule.itemComponent.inter.IItemManager;
import com.umbra.mobModule.itemComponent.inter.IItemPuzzle;
import com.umbra.mobModule.mobComponent.impl.MobManager;
import com.umbra.mobModule.mobComponent.inter.IMobManager;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

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
        	IPlayer player = mobmanager.createPlayer();
        	IItemBattle espada = itemmanager.instantiateItemBattle("Espada", "Fuderosa", 0.2, null);
        	player.putItem(espada);
        	player.setAtt("Forca", 0);
        	espada.addModAtt("Forca", 3);
        	player.equipItem("Espada");
        	System.out.println(player.getAtt("Forca").getValue());
        } catch (Exception e) {
        	e.printStackTrace();
        }

        System.out.println("Terminado");
    }
}
