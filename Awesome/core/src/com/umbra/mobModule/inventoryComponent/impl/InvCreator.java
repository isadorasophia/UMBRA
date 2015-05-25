package com.umbra.mobModule.inventoryComponent.impl;

import com.umbra.mobModule.inventoryComponent.inter.IInventory;

public class InvCreator {
    public static IInventory create(int size){
        IInventory resp;
        resp = new Inventory(size);
        return resp;
    }
}

