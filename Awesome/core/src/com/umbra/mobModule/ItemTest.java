package com.umbra.mobModule;

import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;

import com.umbra.mobModule.itemComponent.impl.ItemManager;
import com.umbra.mobModule.itemComponent.inter.IItemBattle;
import com.umbra.mobModule.itemComponent.inter.IItemManager;
import com.umbra.mobModule.mobComponent.impl.MobManager;
import com.umbra.mobModule.mobComponent.inter.IMobManager;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

/**
 * Uma das aplicações para testar o módulo internamente
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class ItemTest {
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
        	
        	IItemBattle longSword = itemmanager.instantiateItemBattle("Long Sword", null);

        	player.putItem(longSword);
        	player.equipItem("Long Sword");
        	player.unequipAll();
        	System.out.println(player);
        	
        } catch (Exception e) {
        	e.printStackTrace();
        }

        System.out.println("Terminado");
        System.exit(1);
    }
}
