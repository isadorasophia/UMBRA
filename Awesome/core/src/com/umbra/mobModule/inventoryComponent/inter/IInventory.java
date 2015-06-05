package com.umbra.mobModule.inventoryComponent.inter;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;
import com.umbra.mobModule.exceptions.FullInventoryException;
import com.umbra.mobModule.itemComponent.inter.IItem;

import java.util.List;

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
    /**
     * Retira um item do inventario e retorná-o
     * @param name Nome do item a ser retirado do inventário
     * @return Retorna o item retirado do inventário
     */
    public IItem dropItem(String name);

    /**
     *  Adiciona o item passado como parâmetro e joga uma excessão caso o item não caiba
     * @param item Objeto que implementa a interface IItem, a ser adicionado ao inventário, se possível
     * @throws FullInventoryException Excessão lançada caso o ítem não caiba no inventário
     */
    public void adItem(IItem item) throws FullInventoryException;

    /**
     * Permite recuperar um objeto do tipo IItem do inventário a partir de seu nome
     * @param name Nome do objeto a ser retornado
     * @return Retorna um objeto do tipo IItem que esteja no inventário e tenha um nome conforme passado por parâmetro
     */
    public IItem getItem(String name);

    /**
     * Verifica se há no inventário um objeto a partir de seu nome
     * @param name Nome do objeto, o qual pretende-se saber se está no inventário
     * @return Retorna uma booleana indicando true caso o objeto esteja na lista e false caso contrário
     */
    public boolean hasItem(String name);

    /**
     * Modifica o tamanho máximo do inventário em número de ítens. Se nunca for usado supõe-se um tamnho infinito
     * @param size Novo tamanho do inventário
     */
    public void setSize(int size);

    /**
     * Permite saber o tamnaho do inventário
     * @return Retorna o tamanho atual do inventário ou -1 caso o inventário seja infinito
     */
    public int getSize();

    /**
     * Permite saber todos os ítens do inventário
     * @return Retorna uma lista contendo todos os ítens
     */
    public List<IItem> getAllItems();
}
