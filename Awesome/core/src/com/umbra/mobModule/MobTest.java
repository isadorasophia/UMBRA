package com.umbra.mobModule;

import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;
import com.umbra.mobModule.itemComponent.impl.ItemManager;
import com.umbra.mobModule.itemComponent.inter.IItemBattle;
import com.umbra.mobModule.itemComponent.inter.IItemManager;
import com.umbra.mobModule.mobComponent.impl.MobManager;
import com.umbra.mobModule.mobComponent.inter.IMobManager;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

import java.util.ArrayList;
import java.util.List;
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


            IPlayer player = mobmanager.createPlayer();
            List<IMonstro> monstros = new ArrayList<IMonstro>();

            System.out.print("Digite o número de monstros a serem criados:");
            int n = s.nextInt();

            while(n-- > 0){
                IMonstro novo = mobmanager.createMonstro();
                monstros.add(novo);
            }
            /*for(IMonstro m : monstros){
                m.setAtt("força", (new Random(m.getId())).nextInt(100));
                System.out.println(m.toString());
            }*/
            IItemBattle espada = itemmanager.instantiateItemBattle("Espada", "Fuderosa", 0.2, null);

            espada.addModAtt("Força", 10);
            player.putItem(espada);
            player.equipItem("Espada");
            System.out.println(player.toString());
            //System.out.println(player.getAtt("Força").getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        s.close();
        System.out.println("Terminado");
        System.exit(1);
    }
}
