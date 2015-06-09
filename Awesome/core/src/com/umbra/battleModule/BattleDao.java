package com.umbra.battleModule;

import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

/**
 * Classe abstrata para a obtenção de dados do player e do monster
 * 
 * @author Matheus Mortatti Diamantino 156740
 * @author Isadora Sophia Garcia Rodopoulos 158018
 *
 */
abstract class BattleDao {
	/**
	 * Getter para o monstro
	 * 
	 * @return IMonstro - objeto que implementa a interface IMonstro
	 */
	abstract IMonstro getMonster ();
	
	/**
	 * Getter para o Player
	 * 
	 * @return IPlayer - objeto que implementa a interface IPlayer
	 */
	abstract IPlayer getPlayer ();
}