package com.umbra.mobModule.mobComponent;

import mobModule.itemComponent.IInventory;

public interface IPlayer extends IMob {
	public void createInventory(int size);
    public IInventory getInventory();
}
