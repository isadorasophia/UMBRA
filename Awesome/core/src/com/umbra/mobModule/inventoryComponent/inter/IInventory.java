package com.umbra.mobModule.inventoryComponent.inter;

import com.umbra.mobModule.itemComponent.inter.IItem;

import java.util.Vector;

public interface IInventory {
    public IItem dropItem(String witch);
    public void adItem(IItem item);
    /*Adicionado o método getItem*/
    public IItem getItem(String name);
    public boolean hasItem(String name);
    public void setSize(int size);
    public int getSize();
    public Vector<IItem> getAllItems();
}
