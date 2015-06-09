package com.umbra.mobModule.mobComponent.impl;

import anima.context.exception.ContextException;
import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;
import anima.factory.exception.FactoryException;
import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.impl.AttCreator;
import com.umbra.mobModule.attComponent.inter.IAttManager;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.enums.Type;
import com.umbra.mobModule.exceptions.FullInventoryException;
import com.umbra.mobModule.exceptions.SameItemException;
import com.umbra.mobModule.itemComponent.impl.ItemManager;
import com.umbra.mobModule.itemComponent.inter.IItem;
import com.umbra.mobModule.itemComponent.inter.IItemManager;
import com.umbra.mobModule.itemComponent.inter.IItemPuzzle;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

import java.util.List;
import java.util.Vector;

/**
 * Classe que implementa o player que será usado no jogo,
 * e que implementa o design pattern Singleton
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class Player extends PlayerGeneric implements IPlayer{

    public static double MAXHP = 100;

    private static Player instance;

    /**
     * Construtor privado do player, faz o player começar com uma lanterna;
     * @param name : nome do player
     * @param description : descrição do player
     * @param position : posição
     * @param invSize : tamanho do inventário
     */
    private Player(String name, String description, IPosition position, int invSize) {
        super(name, description, position, invSize);
        try {
            IGlobalFactory factory = null;
            factory = ComponentContextFactory.createGlobalFactory();
            factory.registerPrototype(ItemManager.class);
            IItemManager itemmanager = factory.createInstance(
                    "<http://purl.org/NET/dcc/com.umbra.mobModule.itemComponent.impl.ItemManager>");
            IItemPuzzle lantern = itemmanager.instantiateItemPuzzle("LANTERN", null);
            super.putItem(lantern);
        } catch (ContextException e) {
            e.printStackTrace();
        } catch (FactoryException e) {
            e.printStackTrace();
        } catch (FullInventoryException e) {
            e.printStackTrace();
        } catch (SameItemException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método que retorna a instância do player, que é única de acordo com o Singleton
     * @param name : nome do player
     * @param description : descrição do player
     * @param position : posição
     * @param invSize : tamanho do inventário
     * @return Única instância do Singleton player
     */
    public static Player getInstance(String name, String description, IPosition position, int invSize){
        if (instance == null) {
            instance = new Player(name, description, position, invSize);
        }
        return instance;
    }

    public double getXp() {
        if (!(hasAtt("xp")) ) {
            return 0;
        } else {
            return getAtt("xp").getValue();
        }
    }

    public void setXp(double xp) {
        if (!(hasAtt("xp"))) {
        	try {
        		IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
            	factory.registerPrototype(AttCreator.class);
            	IAttManager attmanager = factory.createInstance(
            							 "<http://purl.org/NET/dcc/com.umbra.mobModule.attComponent.impl.AttCreator>");
            	IAttribute novo = attmanager.create(0.0, "xp", xp);
            	atts.put("xp", novo);
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
            
        } else {
            atts.get("xp").setValue(xp);
        }
    }

    public int addXP(double xp){
        int nivel = getNivel();
        setXp(getXp() + xp);
        return getNivel() - nivel;

    }

    public int getNivel(){
        if (!(hasAtt("xp"))) {
            return 1;
        } else {
            return getAtt("xp").getValue() > 1 ? (int) Math.floor(Math.log10(getAtt("xp").getValue())) + 1 : 1;
        }
    }

    public double getHealth() {
        return getAtt("hp").getValue();
    }

    public Vector<String> itemsForBattle() {
        List<IItem> items = inventory.getAllItems();
        Vector<String> resp = new Vector<String>(items.size(), 1);

        for (IItem item : items) {
        	if (item.getType() == Type.ITEM_BATTLE) {
        		resp.add(item.getName());
        	}
        }
        
        return resp;
    }
    
    public Vector<String> itemsIlumination() {
        List<IItem> items = inventory.getAllItems();
        Vector<String> resp = new Vector<String>(items.size(), 1);

        for (IItem item : items) {
        	if (item.getType() == Type.ITEM_ILUMINATION) {
        		resp.add(item.getName());
        	}
        }
        
        return resp;
    }
    
    public Vector<String> itemsPuzzle() {
        List<IItem> items = inventory.getAllItems();
        Vector<String> resp = new Vector<String>(items.size(), 1);

        for (IItem item : items) {
        	if (item.getType() == Type.ITEM_PUZZLE) {
        		resp.add(item.getName());
        	}
        }
        
        return resp;
    }
    
}
