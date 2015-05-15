package com.umbra.battleModule;

import java.util.Vector;
import com.umbra.mobModule.mobComponent.*;

public class BattleManager {
	// Mob components
	private IMonstro monster = null;	
	private IPlayer player = null;
	
	// Flags
	private boolean isBattleSet = false;
	private boolean playerTurn = true;
	private boolean enemyTurn = false;
	private boolean done = false;
	
	// Main string, which is passed to the main class
	private String status = "";
	
	private IMonstro getMonster () { return this.monster; }
	private void setMonster (IMonstro monster) { this.monster = monster; }
	
	private IPlayer getPlayer () { return this.player; }
	private void setPlayer (IPlayer player) { this.player = player; }
	
	public boolean getDone () { return this.done; }
	private void setDone (boolean state) { this.done = state; }
	
	public String getStatus () { return this.status; }
	private void setStatus (String status) { 
		if (status == null)
			this.status = "";
		else
			this.status += status; 
	}
	
	// Function which initializes the class for further use
	public void initialize (IPlayer player, IMonstro monster) {
		setPlayer(player);
		setMonster(monster);
		
		this.playerTurn = true;
		this.enemyTurn = false;
		
		setDone(false);
		
		setStatus(null);

		beReady();
	}
	
	// Set first things first
	private void beReady () {
		setStatus(getMonster().getDescription() + "\n You must choose your items:\n");

		// TODO: define monster item function
		Vector <String> items = getPlayer().itemsForBattle();

		if (items.isEmpty()) {
			this.isBattleSet = true;
		}
		else {
			boolean first = true;
			
			for (String item : items) {
				if (!first) {
					setStatus(item);
					first = false;
				} else {
					setStatus(" or " + item);
				}
			}
			
			setStatus(".");
		}
	}
	
	// Function called by the main module, updates the output
	public void processInput (String input) {
		setStatus(null);
		
		// If the battle isn't set yet
		if (!this.isBattleSet) {
			// TODO: define monster equip function, which returns true if has successfully equipped the player
			if (this.monster.equip(input)) {
				isBattleSet = true;
			} else {
				setStatus("You must choose a valid item.");
				
				return;
			}
		}
		
		if (this.playerTurn) {
			// Process the input and make it gets realz
		} else if (this.enemyTurn) {
			// Make the enemy super duper AI
		}
		
		if (BattleExecuter.isItOver(getMonster(), getPlayer())) {
			// TODO: function that returns if the player is dead
			if (player.dead())
				lostBattle();
			else
				wonBattle();
			
			reset();
		}
	}
	
	private void wonBattle () {
		// Win xp!! Yay!
	}
	
	private void lostBattle() {
		// Player loses XP ):
	}
	
	private void reset() {
		setDone(true);
		
		// Battle ended, reset class configurations
	}
}
