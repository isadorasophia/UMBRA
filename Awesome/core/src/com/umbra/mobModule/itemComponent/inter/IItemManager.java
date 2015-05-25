package com.umbra.mobModule.itemComponent.inter;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;

import com.umbra.mapModule.IPosition;

/**
 * Interface para o criador de itens que
 * sera exportado para o resto do jogo
 * 
 * @author luizfrf
 *
 */

@ComponentInterface(
		"<http://purl.org/NET/dcc/com.umbra.mobModule.itemComponent.inter.IItemManager>")

public interface IItemManager extends ISupports {
	public IItemBattle instantiateItemBattle(String name, String description, double findProb, IPosition pos);
    public IItemPuzzle instantiateItemPuzzle(String name, String description, double findProb, IPosition pos);
    public IItemIlumination instantiateItemIlumination(String name, String description, double findProb, IPosition pos, double ilumination);
}
