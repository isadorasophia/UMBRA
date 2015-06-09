package com.umbra.mobModule.itemComponent.inter;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;

import com.umbra.mapModule.IPosition;

@ComponentInterface(
		"<http://purl.org/NET/dcc/com.umbra.mobModule.itemComponent.inter.IItemManager>")

/**
 * Interface para o criador de itens que
 * sera exportado para o resto do jogo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IItemManager extends ISupports {
    /**
     * Cria um item do tipo de batalha
     * @param name : nome do item
     * @param pos : posição
     * @return Item de batalha criado
     */
    public IItemBattle instantiateItemBattle(String name, IPosition pos);
    
    /**
     * Cria um item do tipo de puzzle
     * @param name : nome do item
     * @param pos : posição
     * @return Item de puzzle criado
     */
    public IItemPuzzle instantiateItemPuzzle(String name, IPosition pos);
    
    /**
     * Cria um item do tipo de iluminação
     * @param name : nome do item
     * @param pos : posição
     * @return Item de iluminação criado
     */
    public IItemIlumination instantiateItemIlumination(String name, IPosition pos);
}
