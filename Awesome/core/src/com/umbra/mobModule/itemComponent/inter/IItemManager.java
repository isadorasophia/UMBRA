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
     * Cria um item do tipo de batalha com seus parâmetros nome,
     * descrição, probabilidade de ser encontrado e posição
     * @param name
     * @param description
     * @param findProb
     * @param pos
     * @return IItemBattle
     */
    public IItemBattle instantiateItemBattle(String name, String description, double findProb, IPosition pos);
    
    /**
     * Cria um item do tipo de puzzle com seus parâmetros nome,
     * descrição, probabilidade de ser achado e posição
     * @param name
     * @param description
     * @param findProb
     * @param pos
     * @return IItemPuzzle
     */
    public IItemPuzzle instantiateItemPuzzle(String name, String description, double findProb, IPosition pos);
    
    /**
     * Cria um item do tipo de iluminção com nome, descrição,
     * probabilidade de ser achado, posição e iluminação
     * @param name
     * @param description
     * @param findProb
     * @param pos
     * @param ilumination
     * @return IItemIlumination
     */
    public IItemIlumination instantiateItemIlumination(String name, String description, double findProb, IPosition pos, double ilumination);
}
