package com.umbra.mobModule.mobComponent;

public interface IPlayerGeneric extends IMobGeneric {
	public void createInventory(int size);
    public IInventory getInventory();
    
    public boolean equipItem(String itemName);
    public void unequipAll();

}
