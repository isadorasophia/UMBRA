package com.umbra.mobModule.itemComponent.impl;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.dbModule.DBFactory;
import com.umbra.dbModule.enums.TypeDB;
import com.umbra.dbModule.exceptions.NoMethod;
import com.umbra.dbModule.interfaces.iDB;
import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.enums.Att;
import com.umbra.mobModule.itemComponent.inter.*;

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
    
	/**
	 * Pega o item com o nome passado do DB
	 * @param fileName : nome do item
	 * @param pathadd : tipo do item
	 * @return Lista com as Strings lidas do DB
	 */
    private static List<String> item(String fileName, String pathadd){
    	//Instanciando um db do tipo CSV
        DBFactory factory = new DBFactory("item");
        iDB dbItems = factory.getDB(TypeDB.CSV);

        //Recuperando dados do monstroX do DB
        String[] fields = null;
        try {
            fields = dbItems.getFromDB(fileName);
        } catch (NoMethod e) {
            e.printStackTrace();
        }
        
        List<String> resp = new ArrayList<String>(5);
        
        resp.add(0, fields[1]);
        resp.add(1, fields[2]);
        resp.add(2, "");
        
        if (pathadd.equalsIgnoreCase("dbItemBattle")) {
        	String[] modatts = fields[3].split(",");
        	resp.add(3, modatts[0]);
        	resp.add(4, modatts[1]);
        	resp.add(5, modatts[2]);
        } else if (pathadd.equals("dbItemIlumination")) {
        	resp.add(3, fields[3]);
        } else if (pathadd.equals("dbItemPuzzle")) {
        	resp.add(3, fields[3]);
        }
        
        String description = "";

        for(int i = 4; i < fields.length; i++){
            description += fields[i] + '\n';
        }

        resp.set(2, description);
        
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