package com.umbra.battleModule;

import java.util.Random;
import java.util.Vector;

import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

public class BattleManager {
	// Handler
	private BattleExecuter battleExecuter = null;
	
	// Mob components
	private IMonstro monster = null;	
	private IPlayer player = null;
	
	// Flags
	private boolean isBattleSet = false;
	private boolean playerTurn = true;
	private boolean done = false;

	// regarding defense move
	private boolean playerDefending = false;
	private boolean enemyDefending = false;
	
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
		
		this.battleExecuter = new BattleExecuter();
		
		this.playerTurn = true;
		
		this.isBattleSet = false;
		this.playerDefending = false;
		this.enemyDefending = false;
		setDone(false);
		
		setStatus(null);

		beReady();
	}
	
	// Set first things first
	private void beReady () {
		Vector <String> items = getPlayer().itemsForBattle();
		
		setStatus(monster.getDescription());

		if (items.isEmpty()) {
			setStatus("\nIt seems that you don't have any item.\n"
					+ "You use your hope as an exhausted fuel of not giving up. Quick, make a choice...\n"
					+ "[A]ttack, [D]efend or [R]un.\n");
					
			this.isBattleSet = true;
		}
		else {
			setStatus(getMonster().getDescription() + "\n You must choose your items:\n");
			
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
		String oldStatus = getStatus();
		setStatus(null);
		
		// If the battle isn't set yet
		if (!this.isBattleSet) {
			// If it was successfully equipped
			if (getPlayer().equipItem(input)) {
				isBattleSet = true;
				
				setStatus("Your item was equipped.\n" + getMonster().getName() + " approaches slowly into your direction."
						+ " You must make a choice.\n [A]ttack, [D]efend or [R]un. Time is clocking.\n");
				
				return;
			} else {
				setStatus("You must choose a valid item.\n");
				
				randomStatus();
				
				return;
			}
		}
		
		if (this.playerTurn) {
			// reset defense status, if that is the case
			if (this.playerDefending) {
				this.battleExecuter.defend(getPlayer(), true);
				this.playerDefending = false;
			}
			
			// execute player move
			if (input.contains("D")) {
				
			} else if (input.contains("R")) {
				battleExecuter.escape(player, monster);
				
			} else if (input.contains("A")) {
				setStatus ("An attack is attempted. You can attack towards the [L]imbs, [B]rain or [V]ital organs"
						+ " of the creature.\n");
				
				return;
				
			} else if (input.contains("L") || input.contains("B") || input.contains("V")) {
				setDone(this.battleExecuter.attack(getPlayer(), getMonster(), input));
				
			} else {
				setStatus("You must choose a valid action.\n" + oldStatus);
				
				System.out.println(input);
				
				randomStatus();
				
				return;
			}
			
			// get battle status
			setStatus(battleExecuter.getStatus());
			if (!getDone())
				setStatus("Press return to procede.\n");
			
			// get ready for next move
			this.playerTurn = false;
		} else {
			// reset defense status, if that is the case
			if (this.enemyDefending) {
				this.battleExecuter.defend(getMonster(), true);
				this.enemyDefending = false;
			}
			
			// execute monster move
			setDone(battleExecuter.monsterAI(monster, player));
			
			// get battle status
			setStatus(battleExecuter.getStatus());
			if (!getDone())
				setStatus("You may procede to your turn - you can either [A]ttack, [D]efend or [R]un. Decide.\n");
			
			// get ready for next move
			this.playerTurn = true;
		}
		
		// if the battle was lost...
		if (getDone()) {
			if (getPlayer().dead()) {
				lostBattle();
			} else {
				wonBattle();
			}
			
			reset ();
		}
	}
	
	private void randomStatus () {
		Random random = new Random ();
		int randomFactor = random.nextInt(24);
		
		if (randomFactor % 8 == 0) {
			setStatus("Some whispers come to you as if they were lost in the silence of emptiness...\n");
		}
		else if (randomFactor % 7 == 0) {
			setStatus("Tic. Tac. Tic...\n");
		}
	}
	
	private void wonBattle () {
		double gainedXP = getMonster().getAtt("XP").getValue();
		
		if (getPlayer().addXP(gainedXP)) {
			// level up
		} else {
			// ok
		}
	}
	
	private void lostBattle() {
		// Player loses XP ):
		// lower XP
	}
	
	private void reset() {
		setDone(true);
		
		// Battle ended, reset class configurations
		this.battleExecuter = null;
		
	}
}
