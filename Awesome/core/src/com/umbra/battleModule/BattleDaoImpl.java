package com.umbra.battleModule;

import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

/**
 * Classe que armazena os dados do Jogador e seu Inimigo e 
 * provê ao BattleManager
 * 
 * @author Matheus Mortatti Diamantino 156740
 * @author Isadora Sophia Garcia Rodopoulos 158018
 *
 */
class BattleDaoImpl extends BattleDao {
	// Mob components
	private IMonstro monster = null;	
	private IPlayer player = null;
	
	/**
	 * Getter para o monstro
	 * 
	 * @return IMonstro - objeto que implementa a interface IMonstro
	 */
	@Override
	IMonstro getMonster () { return this.monster; }
	
	/**
	 * Setter para o monstro
	 * 
	 * @param monster - Monstro que será usado na batalha
	 */
	private void setMonster (IMonstro monster) { this.monster = monster; }
	
	/**
	 * Getter para o Player
	 * 
	 * @return IPlayer - objeto que implementa a interface IPlayer
	 */
	@Override
	IPlayer getPlayer () { return this.player; }
	
	/**
	 * Setter para o player
	 * 
	 * @param player - Player que será usado na batalha
	 */
	private void setPlayer (IPlayer player) { this.player = player; }
	
	/**
	 * Construtor
	 * 
	 * @param player - Player que será usado na batalha
	 * @param monster - Monstro que será usado na batalha
	 */
	BattleDaoImpl (IPlayer player, IMonstro monster) {
		setPlayer(player);
		setMonster(monster);
	}
}