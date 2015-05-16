package com.umbra.mobModule.inventoryComponent;
import com.umbra.mobModule.itemComponent.IItem;

import java.util.*;


public class Inventory implements IInventory {
    private int size;
    private Hashtable<String, IItem> items;
    
    public Inventory(int size) {
    	this.size = size;
    	this.items = new Hashtable<String, IItem>();
    }

    public IItem dropItem(String witch){
        IItem resp = items.get(witch);
        items.remove(witch);
        return resp;
    }
   public IItem getItem(String name){
	   IItem resp;
	   if(items.containsKey(name)){
		   resp = items.get(name);
	   }else{
		   resp = null;
	   }
   		return resp;  
   }

    public boolean hasItem(String name) {
        return items.containsKey(name);
    }

    public void adItem(IItem item){
        items.put(item.getName(), item);
    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return size;
    }


    public Vector<IItem> getAllItems() {
        Vector<IItem> resp = new Vector<>(items.size(), 1);
        Enumeration e = items.elements();
        while(e.hasMoreElements()){
            resp.add((IItem) e.nextElement());
        }
        return resp;
    }

}
