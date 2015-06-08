package com.umbra.mobModule;

import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;
import com.umbra.mobModule.itemComponent.impl.ItemManager;
import com.umbra.mobModule.itemComponent.inter.IItemBattle;
import com.umbra.mobModule.itemComponent.inter.IItemManager;
import com.umbra.mobModule.itemComponent.inter.IItemPuzzle;
import com.umbra.mobModule.mobComponent.impl.MobManager;
import com.umbra.mobModule.mobComponent.inter.IMobManager;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MobTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
            factory.registerPrototype(MobManager.class);
            factory.registerPrototype(ItemManager.class);
            IMobManager mobmanager = factory.createInstance(
                    "<http://purl.org/NET/dcc/com.umbra.mobModule.mobComponent.impl.MobManager>");
            IItemManager itemmanager = factory.createInstance(
                    "<http://purl.org/NET/dcc/com.umbra.mobModule.itemComponent.impl.ItemManager>");


            IPlayer player = mobmanager.createPlayer("Player", "Teste", null);
            IItemPuzzle key = itemmanager.instantiateItemPuzzle("Key", null);
            System.out.println(key);

        } catch (Exception e) {
            e.printStackTrace();
        }
        s.close();
        System.out.println("Terminado");
        System.exit(1);
    }
}
