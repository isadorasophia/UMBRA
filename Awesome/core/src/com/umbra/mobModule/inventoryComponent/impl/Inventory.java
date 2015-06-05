package com.umbra.mobModule.inventoryComponent.impl;
import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.mobModule.exceptions.FullInventoryException;
import com.umbra.mobModule.inventoryComponent.inter.IInventory;
import com.umbra.mobModule.itemComponent.inter.IItem;

import java.util.*;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.mobModule.inventoryComponent.impl.Inventory>",
		provides={"<http://purl.org/NET/dcc/com.umbra.mobModule.inventoryComponent.inter.IInventory>"}
)

public class Inventory extends ComponentBase implements IInventory {
    private Integer size = null;
    private Hashtable<String,IItem> items = new Hashtable<String,IItem>();

    public IItem dropItem(String witch){
        IItem resp = items.get(witch);
        items.remove(witch);
        return resp;
    }
    
    public IItem getItem(String name){
	   IItem resp;
	   if (items.containsKey(name)) {
		   resp = items.get(name);
	   } else {
		   resp = null;
	   }
   		return resp;  
    }

    public boolean hasItem(String name) {
        return items.containsKey(name);
    }

    public void adItem(IItem item) throws FullInventoryException {
        if(size == null || items.size() < size) {
            items.put(item.getName(), item);
        }else{
            throw new FullInventoryException("This Item was not added to the inventory");
        }
    }
    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        int resp;
        if(size == null){
            resp = -1;
        }else{
            resp = size;
        }
        return resp;
    }

    public List<IItem> getAllItems() {
        List<IItem> resp = new ArrayList<IItem>();
        Enumeration<IItem> e = items.elements();
        while(e.hasMoreElements()){
            resp.add(e.nextElement());
        }
        return resp;
    }

}
