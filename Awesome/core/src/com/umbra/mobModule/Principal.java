package com.umbra.mobModule;

import com.umbra.mobModule.itemComponent.IItemBattle;
import com.umbra.mobModule.itemComponent.ItemFactory;
import com.umbra.mobModule.mobComponent.*;

public class Principal {
	public static void main(String[] args) {

        IPlayer p = MobFactory.createFactory("monstro").create("Teste", "descrição do Teste", null);

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

        p.putItem(faca, escudo);

        p.equipItem("Escudo");
        p.equipItem("Braçadera");
        p.equipItem("Faca");

        p.dropItem("Escudo");

        System.out.println("Terminado");
    }
}
