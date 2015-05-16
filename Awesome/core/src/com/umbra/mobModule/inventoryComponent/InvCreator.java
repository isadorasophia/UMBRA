package com.umbra.mobModule.inventoryComponent;

public class InvCreator {
    public static IInventory create(int size){
        IInventory resp;
        resp = new Inventory(size);
        return resp;
    }
}

