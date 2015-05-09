package com.umbra.mobModule.mobComponent;

import com.umbra.mobModule.itemComponent.IItem;

public interface IInventory {
    public IItem dropItem(String witch);
    public void adItem(IItem item);
    /*Adicionado o método getItem*/
    public IItem getItem(String name);
    public boolean hasItem(String name);
    public void setSize(int size);
    public int getSize();
}
