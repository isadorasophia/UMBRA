package com.umbra.mobModule.mobComponent.inter;

import com.umbra.mobModule.exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.exceptions.FullInventoryException;
import com.umbra.mobModule.exceptions.SameItemException;
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
	 * @throws FullInventoryException Retorna a exceção caso o inventário esteja cheio
	 * @throws SameItemException Exceção lançada quando o item já está no inventário
	 */
    public void putItem(IItem ... novo) throws FullInventoryException, SameItemException;
    
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
     * @throws CannotDoubleModifyAttributeException Exceção disparada quando se tenta modificar
     * 												duas vezes um atributo com o mesmo modificador
     */
    public boolean equipItem(String itemName) throws CannotDoubleModifyAttributeException;
    
    /**
     * Equipa vários itens e retorna uma lista de quais foi possível equipar
     * @param itemName
     * @return
     * @throws CannotDoubleModifyAttributeException Exceção disparada quando se tenta modificar
     * 												duas vezes um atributo com o mesmo modificador
     */
    public List<Boolean> equipItems(String ... itemName) throws CannotDoubleModifyAttributeException;
    
    /**
     * Desequipa todos os itens que foram equipados
     * @throws SameItemException Tentativa de desequipar o mesmo item duas vezes
     * @throws FullInventoryException Tentativa de adicionar o item ao inventário, mas ele está cheio
     */
    public void unequipAll() throws FullInventoryException, SameItemException;
    
    /**
     * Retorna uma lista com todos os itens do player
     * @return
     */
    public List<IItem> getAllItems();
}
