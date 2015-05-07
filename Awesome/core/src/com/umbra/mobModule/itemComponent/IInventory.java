package com.umbra.mobModule.itemComponent;

public interface IInventory {
    public IItem dropItem(String witch);
    public void adItem(IItem item);
    /*Adicionado o método getItem*/
    public IItem getItem(String name);
    public void setSize(int size);
    public int getSize();
}
