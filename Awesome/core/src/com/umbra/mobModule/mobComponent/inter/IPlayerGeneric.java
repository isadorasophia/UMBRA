package com.umbra.mobModule.mobComponent.inter;

import com.umbra.mobModule.itemComponent.inter.IItem;

import java.util.List;
import java.util.Vector;

public interface IPlayerGeneric extends IMob {
    public void putItem(IItem ... novo);
    public IItem dropItem(String itemName);
    public List<IItem> dropItems(String ... names);
    public boolean equipItem(String itemName);
    public List<Boolean> equipItems(String ... itemName);
    public void unequipAll();
    public Vector<String> itemsForBattle();

}
