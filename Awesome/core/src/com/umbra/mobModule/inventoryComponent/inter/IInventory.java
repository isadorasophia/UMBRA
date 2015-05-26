package com.umbra.mobModule.inventoryComponent.inter;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;

import com.umbra.mobModule.itemComponent.inter.IItem;

import java.util.Vector;

/**
 * Interface para o inventario do player
 * 
 * @author Luiz Fernando Rodrigues da Fonseca
 * @author Lucas Alves Racoci
 *
 */

@ComponentInterface(
		"<http://purl.org/NET/dcc/com.umbra.mobModule.inventoryComponent.inter.IInventory>")

public interface IInventory extends ISupports {
    public IItem dropItem(String witch);
    public void adItem(IItem item);
    /*Adicionado o método getItem*/
    public IItem getItem(String name);
    public boolean hasItem(String name);
    public void setSize(int size);
    public int getSize();
    public Vector<IItem> getAllItems();
}
