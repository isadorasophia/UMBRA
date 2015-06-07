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
            List<IMonstro> monstros = new ArrayList<IMonstro>();

            System.out.print("Digite o número de monstros a serem criados:");
            int n = s.nextInt();
            int i = 1;
            while(n-- > 0){
                System.out.printf("Nivel : %d\n", i);
                IMonstro novo = mobmanager.createMonstro(i++, null);
                System.out.println(novo.toString());
                monstros.add(novo);
            }
            /*System.out.print("Digite o número de itens a serem criados:");

            List<IItemBattle> itens = new ArrayList<IItemBattle>();
            int n2 = s.nextInt();
            Random r = new Random();
            for(int j = 1; j <= n2; j++){
                double findProb = r.nextDouble();
                String name = String.format("Item "+ j);
                String description = String.format("Item com findProb: %f",findProb);
                IItemBattle itembattle = itemmanager.instantiateItemBattle(name, description,findProb, null);
                System.out.println(itembattle);
                itens.add(itembattle);
            }

            //IItemBattle espada = itemmanager.instantiateItemBattle("Espada", "Fuderosa", 0.2, null);

            for(IItemBattle i : itens){
                System.out.println("Player: ...");
                System.out.println(player);
                System.out.println("... ser modificado por ...");
                System.out.println(i);
                i.updateMob(player);
                System.out.println("... tem como resultado: ");
                System.out.println(player);

            }*/

            /*
            espada.addModAtt("Força", 10);
            espada.addModAtt("Defesa", -30);
            player.putItem(espada);
            player.equipItem("Espada");
            System.out.println(player.toString());
            player.setAtt(0, "hp", 100);
            System.out.println(player.getAtt("hp"));
            player.setAtt("hp", 20);
            System.out.println(player.getAtt("hp"));
            player.decreaseHP(21);
            System.out.println(player.getAtt("hp"));
            System.out.println(player.dead());
            */
            //System.out.println(player.getAtt("Força").getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
        s.close();
        System.out.println("Terminado");
        System.exit(1);
    }
}
