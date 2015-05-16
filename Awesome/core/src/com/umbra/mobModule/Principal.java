package com.umbra.mobModule;

import com.umbra.mobModule.itemComponent.IItemBattle;
import com.umbra.mobModule.itemComponent.ItemFactory;
import com.umbra.mobModule.mobComponent.IPlayer;
import com.umbra.mobModule.mobComponent.MobFactory;

public class Principal {
	public static void main(String[] args) {

        IItemBattle faca = ItemFactory.instantiate("Faca", "Afiada", 0.33, null);
        faca.addModAtt("Força",  +2);
        faca.addModAtt("Força",  +3);
        faca.addModAtt("Força",  -2);
        faca.addModAtt("Defesa", -5);
        faca.addModAtt("Defesa", +5);

        IItemBattle escudo = ItemFactory.instantiate("Escudo","Pesado",0.01,null);

        escudo.addModAtt("Defesa", +45);
        escudo.addModAtt("Defesa", -10);
        escudo.addModAtt("Força",  -15);


        IPlayer p = MobFactory.createFactory("player").create("Teste", "descrição do Teste", null);

        p.putItem(faca, escudo);

        p.equipItem("Escudo");
        p.equipItem("Braçadera");
        p.equipItem("Faca");

        p.dropItem("Escudo");

        System.out.println("Terminado");
    }
}
