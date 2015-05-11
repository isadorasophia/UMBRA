package com.umbra.battleModule;

import java.util.Vector;
import com.umbra.mobModule.mobComponent.*;

public class BattleManager {
	private IMonstro monster = null;
	private IPlayer player = null;

	private BattleExecuter battleExecuter = null;
	
	private boolean isBattleSet = false;
	

	private boolean battleIsSet = false;

	private String status = null;
	//private String

	private IMonstro getMonster () {
		return this.monster;
	}

	private void setMonster (IMonstro monster) {
		this.monster = monster;
	}

	private IPlayer getPlayer () {
		return this.player;
	}

	private void setPlayer (IPlayer player) {
		this.player = player;
	}

	public String initialize (IPlayer player, IMonstro monster) {
		setPlayer(player);
		setMonster(monster);

		getReady();

		return this.status;
	}

	// TODO: define monster functions
	private void getReady () {
		this.status = this.monster.getDescription() + "\n You must choose your items:\n";

		Vector <String> items = this.monster.itemsForBattle();

		if (items.isEmpty()) {
			this.isBattleSet = true;
		}
		else {
			for (int i = 0; i < items.size(); i++) {
				this.status += items[i];

				if (i + 1 < items.size())
					this.status += " or ";
			}
		}
	}
	
	public String processInput (String input) {
		if (!this.isBattleSet) {
			this.monster.equip(input);
			
			isBattleSet = true;
		}
		
		if (this.playerTurn) {
			// Make the player input gets realz
		} else if (this.enemyTurn) {
			// Make the enemy super duper AI
		}
	}
	
	public String wonBattle () {
		// Win xp!! Yay!
	}
	
	public String lostBattle() {
		// Player loses XP ):

	public void processInput (String input) {

	}
}
