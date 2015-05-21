package com.umbra.mobModule;

import com.umbra.mobModule.Exceptions.BadConstructorException;
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


        IPlayer p = null;
        try {
            p = MobFactory.createFactory("player").getInstance("Teste", "descrição do Teste", null);
        } catch (BadConstructorException e) {
            e.printStackTrace();
        }

        p.putItem(faca, escudo);

        p.equipItem("Escudo");

        p.attsPrint();

        p.equipItem("Braçadera");

        p.attsPrint();

        p.equipItem("Faca");

        p.attsPrint();

        p.dropItem("Escudo");

        p.attsPrint();


        System.out.println("Terminado");
    }
}
