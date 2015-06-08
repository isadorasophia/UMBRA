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
     * @param name
     * @param pos
     * @return IItemBattle
     */
    public IItemBattle instantiateItemBattle(String name, IPosition pos);
    
    /**
     * Cria um item do tipo de puzzle
     * @param name
     * @param pos
     * @return IItemPuzzle
     */
    public IItemPuzzle instantiateItemPuzzle(String name, IPosition pos);
    
    /**
     * Cria um item do tipo de iluminação
     * @param name
     * @param pos
     * @return IItemIlumination
     */
    public IItemIlumination instantiateItemIlumination(String name, IPosition pos);
}
