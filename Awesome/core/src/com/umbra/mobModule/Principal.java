package com.umbra.mobModule;

import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;
import com.umbra.mobModule.itemComponent.impl.ItemManager;
import com.umbra.mobModule.itemComponent.inter.IItemBattle;
import com.umbra.mobModule.itemComponent.inter.IItemManager;
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
        	espada.addModAtt("Força", 10);
        	player.setAtt("Força", 5);
        	player.putItem(espada);
            System.out.println(player.toString());
            player.equipItem("Espada");
        	System.out.println(player.toString());
        	player.unequipAll();
        	System.out.println(player.toString());
        } catch (Exception e) {
        	e.printStackTrace();
        }

        System.out.println("Terminado");
        System.exit(1);
    }
}
