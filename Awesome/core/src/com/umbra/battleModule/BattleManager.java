package com.umbra.battleModule;

import java.util.Random;
import java.util.Vector;

import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;
import anima.annotation.Component;
import anima.component.base.ComponentBase;

@Component(
		id = "<http://purl.org/NET/dcc/com.umbra.battleModule.BattleManager>",
		provides = {"<http://purl.org/NET/dcc/com.umbra.battleModule.iBattleManager>"}
)

public class BattleManager extends ComponentBase implements IBattleManager{
	// Handler
	private BattleExecuter battleExecuter = null;
	
	// Mob components
	private IMonstro monster = null;	
	private IPlayer player = null;
	
	// Flags
	private boolean isBattleSet = false;
	private boolean playerTurn = true;
	private boolean done = false;
	private boolean isBattleOver = false;

	// regarding defense move
	private boolean playerDefending = false;
	private boolean enemyDefending = false;
	
	// level up variables
	private int attsSelected = 3;
	
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
		
		// For testing sake
		this.player.setAtt("attack", 10);
		this.player.setAtt("defense", 8);
		this.player.setAtt("dexterity", 10);
		this.player.setAtt("evasiveness", 15);
		this.player.setAtt("luck", 8);
		this.player.setAtt("sanity", 5);
		player.setAtt("hp", 20);
        
		
		this.monster.setAtt("attack", 12);
		this.monster.setAtt("defense", 10);
		this.monster.setAtt("dexterity", 15);
		this.monster.setAtt("evasiveness", 12);
		this.monster.setAtt("luck", 7);
		this.monster.setAtt("sanity", 2);
		this.monster.setAtt("hp", 25);
		
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
				if (first) {
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
		
		// if the battle was already over
		if (isBattleOver)
			levelUp(input);
		
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
				this.battleExecuter.defend(player, false);
				
				this.playerDefending = true;
			} else if (input.contains("R")) {
				setDone(this.battleExecuter.escape(player, monster));
				
			} else if (input.contains("A")) {
				setStatus ("An attack is attempted. You can attack towards the creature's\n"
						+ "[L]imbs [ 1.2 | 70% ],\n"
						+ "[B]rain [ 1.8 | 20% ] or\n"
						+ "[V]ital organs [ 1.6 | 30% ]\n");
				
				return;
				
			} else if (input.contains("L") || input.contains("B") || input.contains("V")) {
				isBattleOver = this.battleExecuter.attack(getPlayer(), getMonster(), input);
				
			} else {
				setStatus("You must choose a valid action.\n" + oldStatus);
				
				System.out.println(input);
				
				randomStatus();
				
				return;
			}
			
			// get battle status
			setStatus(battleExecuter.getStatus());
			if (!this.isBattleOver)
				setStatus("Press return to procede.\n");
			
			// get ready for next move
			this.playerTurn = false;
		} else {
			// reset defense status, if that is the case
			if (this.enemyDefending) {
				this.battleExecuter.defend(getMonster(), true);
				this.enemyDefending = false;
			}
			
			String monsterInput = this.battleExecuter.monsterAI(monster, player);
			
			if (monsterInput.contains("D")) {
				this.battleExecuter.defend(monster, false);
				
				this.enemyDefending = true;
			} else {
				 isBattleOver = this.battleExecuter.attack(getMonster(), getPlayer(), monsterInput);
			}
			
			// get battle status
			setStatus(battleExecuter.getStatus());
			
			if (!isBattleOver)
				setStatus("You may procede to your turn - you can either [A]ttack, [D]efend or [R]un. Decide.\n");
			
			// get ready for next move
			this.playerTurn = true;
		}
		
		
		
		// if the battle was lost...
		if (isBattleOver) {
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
			setStatus("\nSome whispers come to you as if they were lost in the silence of emptiness...\n");
		}
		else if (randomFactor % 7 == 0) {
			setStatus("\nTic. Tac. Tic...\n");
		}
	}
	
	private void wonBattle () {
		double gainedXP = getMonster().getAtt("XP").getValue();
		
		setStatus("You win this battle, for once. The creature is now dead, you may " +
				"move on to your hopeless journey.\n");
		setStatus("You win " + (int)monster.getAtt("xp").getValue() + " XP as you leave the battle.");
		
		// increase gained XP and checks if player has leveled up
		if (getPlayer().addXP(gainedXP)) {
			// leveled up!
			// set map of atts to player choose which will he increase.
			// then move on...
		}
		// Just for testing sake
		setDone(true);
	}
	
	private void lostBattle() {
		setStatus("Suddenly, everything becomes darker... Your limbs are tembling... Everything is fading. Long gone. "
				+ "No hopes, no chance of escape. You are dead.\n");
		
		setDone(true);
		
		// lower XP?
	}
	
	private void levelUp (String answer) {
		if (this.attsSelected == 0)
			setDone(true);
	}
	
	private void reset() {		
		// Battle ended, reset class configurations
		this.battleExecuter = null;
	}
}
