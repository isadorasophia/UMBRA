package com.umbra.mobModule.mobComponent;

import com.umbra.mobModule.itemComponent.IInventory;

public interface IPlayer extends IMobGeneric {
	public void createInventory(int size);
    public IInventory getInventory();
}
