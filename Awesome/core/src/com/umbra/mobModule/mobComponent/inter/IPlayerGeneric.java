package com.umbra.mobModule.mobComponent.inter;

import com.umbra.mobModule.itemComponent.inter.IItem;

import java.util.List;

/**
 * Interface com os métodos de um player genérico
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IPlayerGeneric extends IMob {
	
	/**
	 * Coloca um item no inventário do player
	 * @param novo
	 */
    public void putItem(IItem ... novo);
    
    /**
     * Retira um item do inventário do player
     * @param itemName
     * @return
     */
    public IItem dropItem(String itemName);
    
    /**
     * Retira vários itens do inventário do player
     * @param names
     * @return
     */
    public List<IItem> dropItems(String ... names);
    
    /**
     * Equipa um item no player, e retorna se foi possível equipar
     * @param itemName
     * @return
     */
    public boolean equipItem(String itemName);
    
    /**
     * Equipa vários itens e retorna uma lista de quais foi possível equipar
     * @param itemName
     * @return
     */
    public List<Boolean> equipItems(String ... itemName);
    
    /**
     * Desequipa todos os itens que foram equipados
     */
    public void unequipAll();
    
    /**
     * Retorna uma lista com todos os itens do player
     * @return
     */
    public List<IItem> getAllItems();
}
