package com.umbra.mobModule.mobComponent;

import java.util.Vector;

public interface IPlayerGeneric extends IMobGeneric {
    public boolean equipItem(String itemName);
    public void unequipAll();
    public Vector<String> itemsForBattle();

}
