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
import com.umbra.mobModule.itemComponent.impl.ItemManager;
import com.umbra.mobModule.itemComponent.inter.IItem;
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
        	
        	IItemBattle longSword = itemmanager.instantiateItemBattle("longsword", null);
        	player.putItem(longSword);
        	IAttribute att = new Attribute("hp", 20);
        	System.out.println(att.getMin());
        	
        } catch (Exception e) {
        	e.printStackTrace();
        }

        System.out.println("Terminado");
        System.exit(1);
    }
}
