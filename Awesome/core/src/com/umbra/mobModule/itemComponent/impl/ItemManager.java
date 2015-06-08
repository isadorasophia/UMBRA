package com.umbra.mobModule.itemComponent.impl;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.dbMobModule.dbItem.BDItem;
import com.umbra.mobModule.enums.Att;
import com.umbra.mobModule.itemComponent.inter.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component(
		id = "<http://purl.org/NET/dcc/com.umbra.mobModule.itemComponent.impl.ItemManager>",
		provides = {"<http://purl.org/NET/dcc/com.umbra.mobModule.itemComponent.impl.IItemManager>"}
)

/**
 * Classe que representa o componente que é uma fábrica de itens
 * de três tipos: BATTLE, PUZZLE, ILUMINATION
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class ItemManager extends ComponentBase implements IItemManager {
    
    private static List<String> item(String fileName, String pathadd){
        List<String> resp = new ArrayList<String>();
        String name;
        String path = BDItem.class.getResource(".").getPath() + pathadd + "/" + fileName;

        String findprob = null;
        String description = "";
        try {
        	BufferedReader br = new BufferedReader(new FileReader(path + ".txt"));
            name = br.readLine();
            findprob = br.readLine();
            resp.add(1, findprob);
            resp.add(2, "");
            
            if (pathadd.equalsIgnoreCase("dbItemBattle")) {
            	String modatt = br.readLine();
            	resp.add(3, modatt);
            	modatt = br.readLine();
            	resp.add(4, modatt);
            	modatt = br.readLine();
            	resp.add(5, modatt);
            } else if (pathadd.equals("dbItemIlumination")) {
            	String ilumination = br.readLine();
            	resp.add(3, ilumination);
            } else if (pathadd.equals("dbItemPuzzle")) {
            	String adjectives = br.readLine();
            	resp.add(3, adjectives);
            }
            
            for(String line = br.readLine(); line != null; line = br.readLine()){
                description += line + "\n";
            }
            resp.set(2, description);
            
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return resp;

    }
    
    public IItemBattle instantiateItemBattle(String fileName, IPosition pos){
    	List<String> item = item(fileName, "dbItemBattle");
    	double findProb = Double.parseDouble(item.get(1));
    	String description = item.get(2);
        String name = item.get(0);
    	
        IItemBattle resp = new ItemBattle(name, description, findProb, pos);
        if (findProb != 0) {
        	Att[] allowedToModify = {Att.ATTACK, Att.DEXTERITY, Att.DEFENSE};
        	double parameter;
        	for(int j = 0; j < allowedToModify.length; j++) {
        		parameter = Double.parseDouble(item.get(j + 3));
        		resp.addModAtt(allowedToModify[j].getName(), parameter);
        	}
        }
        
        return resp;
    }
    
    public IItemPuzzle instantiateItemPuzzle(String fileName, IPosition pos){
    	List<String> item = item(fileName, "dbItemPuzzle");
    	double findProb = Double.parseDouble(item.get(1));
    	String description = item.get(2);
        String name = item.get(0);

    	IItemPuzzle resp = new ItemPuzzle(name, description, findProb, pos);
    	String[] lista = item.get(3).split(",");
    	for (String adj : lista) {
    		resp.newAdjective(adj);
    	}
        return resp;
    }
    
    public IItemIlumination instantiateItemIlumination(String fileName, IPosition pos){
    	List<String> item = item(fileName, "dbItemIlumination");
    	double findProb = Double.parseDouble(item.get(1)),
    		   ilumination = Double.parseDouble(item.get(3));
    	String description = item.get(2);
        String name = item.get(0);

    	IItemIlumination resp = new ItemIlumination(name, description, findProb, pos, ilumination);
        return resp;
    }
    
}