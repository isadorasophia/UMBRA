package com.umbra.mobModule;

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
        	IPlayer player = mobmanager.createPlayer("Player", "Teste", null);
        	IItemBattle espada = itemmanager.instantiateItemBattle("espada", null);
        	IItemPuzzle chave = itemmanager.instantiateItemPuzzle("chave", null);
        	IItemIlumination lanterna = itemmanager.instantiateItemIlumination("lanterna", null);
        	System.out.println(espada);
        	System.out.println(chave);
        	System.out.println(lanterna);
        } catch (Exception e) {
        	e.printStackTrace();
        }

        System.out.println("Terminado");
        System.exit(1);
    }
}
