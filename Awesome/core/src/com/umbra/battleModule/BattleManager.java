package com.umbra.battleModule;

import java.util.Random;
import java.util.Vector;

import com.umbra.mobModule.exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.exceptions.FullInventoryException;
import com.umbra.mobModule.exceptions.NoMaxMinException;
import com.umbra.mobModule.exceptions.SameItemException;
import com.umbra.mobModule.itemComponent.impl.ItemManager;
import com.umbra.mobModule.itemComponent.inter.IItemBattle;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

@Component(
		id = "<http://purl.org/NET/dcc/com.umbra.battleModule.BattleManager>",
		provides = {"<http://purl.org/NET/dcc/com.umbra.battleModule.IBattleManager>"}
)

/**
 * Classe principale que implementa a interface provida ao Game Manager
 * Sua função é lidar com o input do jogador processando-o e retornando uma resposta à ele
 * 
 * @author Matheus Mortatti Diamantino 156740
 * @author Isadora Sophia Garcia Rodopoulos 158018
 *
 */

public class BattleManager extends ComponentBase implements IBattleManager{
	// Handler
	private BattleExecuter battleExecuter = null;
	
	// Mob components
	private IMonstro monster = null;	
	private IPlayer player = null;
	
	// Flags
	private boolean hasLeveledUp = false;
	private boolean isBattleSet = false;
	private boolean playerTurn = true;
	private boolean done = false;
	private boolean isBattleOver = false;
	
	// Keeps track of how many turns has passed
	private int turnsPassed;

	// regarding defense move
	private boolean playerDefending = false;
	private boolean enemyDefending = false;
	
	// level up variables
	private int attsSelected = 5;
	
	// Main string, which is passed to the main class
	private String status = "";
	
	/**
	 * Getter para o monstro
	 * 
	 * @return IMonstro - objeto que implementa a interface IMonstro
	 */
	private IMonstro getMonster () { return this.monster; }
	
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
	private IPlayer getPlayer () { return this.player; }
	/**
	 * Setter para o player
	 * 
	 * @param player - Player que será usado na batalha
	 */
	private void setPlayer (IPlayer player) { this.player = player; }
	
	/**
	 * Getter para a variavel Done
	 * 
	 * @return boolean - Se o processo da batalha está terminado ou não
	 */
	public boolean getDone () { return this.done; }
	
	/**
	 * Setter para a variável Done
	 * 
	 * @param state - Estado da batalha (Terminado ou não)
	 */
	private void setDone (boolean state) { this.done = state; }
	
	/**
	 * Getter para a variavel Status
	 * 
	 * @return String - Texto represantativo do estado da batalha passado ao jogador
	 */
	public String getStatus () { return this.status; }
	
	/**
	 * Setter para a variável Status
	 * 
	 * @param status - Estado a ser adicionado ao que será passado ao jogador
	 */
	private void setStatus (String status) { 
		if (status == null)
			this.status = "";
		else
			this.status += status; 
	}
	
	/**
	 * Inicialização das variáveis de batalha
	 * 
	 * @param player - Jogador da batalha
	 * @param monster - Monstro da batalha
	 */
	public void initialize (IPlayer player, IMonstro monster) {
		setPlayer(player);
		setMonster(monster);
		
		/*ItemManager itemManager = new ItemManager();
		IItemBattle item = itemManager.instantiateItemBattle("Long Sword", null);
		
			try {
				getPlayer().putItem(item);
			} catch (FullInventoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SameItemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		// For testing sake
		 this.player.setAtt("attack", 15);
		this.player.setAtt("defense", 14);
		this.player.setAtt("dexterity", 13);
		this.player.setAtt("evasiveness", 10);
		this.player.setAtt("luck", 9);
		
		this.player.setAtt("hp", 10);
        
		
		this.monster.setAtt("attack", 15);
		this.monster.setAtt("defense", 13);
		this.monster.setAtt("dexterity", 8);
		this.monster.setAtt("evasiveness", 6);
		this.monster.setAtt("luck", 7);
		this.monster.setAtt("sanity", 2);
		this.monster.setAtt("hp", 10); */
		this.player.setAtt("sanity", 0.7);
		
		this.battleExecuter = new BattleExecuter();
		
		this.playerTurn = true;
		
		this.hasLeveledUp = false;
		this.isBattleSet = false;
		setDone(false);
		
		this.playerDefending = false;
		this.enemyDefending = false;
		
		setStatus(null);

		beReady();
	}
	
	/**
	 * Pede ao jogador que escolha um item a ser equipado e usado durante a batalha
	 * 
	 */
	private void beReady () {
		Vector <String> items = getPlayer().itemsForBattle();
		
		setStatus(monster.getDescription() + "\n");
		
		if (items.isEmpty()) {
			setStatus("It seems that you don't have any item.\n"
					+ "You use your hope as an exhausted fuel of not giving up. Quick, make a choice...\n"
					+ "[A]ttack, [D]efend or [R]un.\n");
					
			this.isBattleSet = true;
		}
		else {
			setStatus("You must choose a item by typing its name:\n" + listItems(items));
		}
	}
	
	/**
	 * Provê a lista de itens que podem ser esuipados antes da batalha
	 * 
	 * @param items - Lista de itens do jogador
	 * @return String - Nome dos itens
	 */
	private String listItems(Vector <String> items) {
		boolean first = true;
		
		String itemsToChoose = new String();
		
		for (String item : items) {
			if (first) {
				itemsToChoose += item;
				first = false;
			} else {
				itemsToChoose += "; " + item;
			}
		}
		
		itemsToChoose += ".\n";
		
		return itemsToChoose;
	}
	
	/**
	 * Função chamada pelo Game Manager que realiza o update do output
	 * fornecido ao jogador através de seu Input
	 * 
	 * @param input - Input do jogador
	 */
	public void processInput (String input) {
		String oldStatus = getStatus();
		setStatus(null);
		
		// in order to identify the input, set a pattern
		input = input.toUpperCase();
		
		// if the battle was already over
		if (this.isBattleOver && this.hasLeveledUp) {
			levelUp(input);
			return;
		}
		
		// If the battle isn't set yet
		if (!this.isBattleSet) {
			// If it was successfully equipped
			boolean b = false;
			try {
				b = getPlayer().equipItem(input);
			} catch (CannotDoubleModifyAttributeException e) {
				e.printStackTrace();
			}
			if (b) {
				isBattleSet = true;
				
				setStatus("Your item was equipped.\n" + getMonster().getName() + " approaches slowly into your direction."
						+ " You must make a choice.\n [A]ttack, [D]efend or [R]un. Time is clocking.\n");
				
				return;
			} else {
				Vector <String> items = getPlayer().itemsForBattle();
				
				setStatus("You must choose a valid item:\n" + listItems(items));
				
				randomStatus();
				
				return;
			}
		}
		
		// if it is the player turn
		if (this.playerTurn) {
			// reset defense status, if that is the case
			if (this.playerDefending && this.turnsPassed == 2) {
				this.battleExecuter.defend(getPlayer(), true);
				this.playerDefending = false;
			} else { // player can keep on defending, just count as a passed turn
				if (this.turnsPassed != 2 && this.playerDefending) {
					this.turnsPassed += 1;
				}
			}
			
			// execute player move
			if (input.contains("D")) {
				// The player increases his defense in the next 2 turns
				this.battleExecuter.defend(getPlayer(), false);
				this.turnsPassed = 0;
				this.playerDefending = true;
			} else if (input.contains("R")) {
				setDone(this.battleExecuter.escape(getPlayer(), getMonster()));
				
			} else if (input.contains("A")) {
				setStatus ("An attack is attempted. You can attack towards the creature's...\n"
						+ "[L]imbs [ 1.2 | 60% ],\n"
						+ "[B]rain [ 1.7 | 30% ] or\n"
						+ "[V]ital organs [ 1.5 | 40% ]\n");
				
				return;
				
			} else if (input.contains("L") || input.contains("B") || input.contains("V")) {
				isBattleOver = this.battleExecuter.attack(getPlayer(), getMonster(), input);
				
			} else {
				String retry = "You must choose a valid action.\n \n";
				
				// if it contains the initial description, get rid of it
				if (oldStatus.contains(monster.getDescription())) {
					oldStatus = "[A]ttack, [D]efend or [R]un. Time is clocking.\n";
				}
				
				// avoid repeating the same message
				if (!oldStatus.contains(retry)) {
					setStatus(retry + oldStatus);
				} else {
					setStatus(oldStatus);
				}
				
				randomStatus();
				
				return;
			}
			
			// get battle status
			setStatus(battleExecuter.getStatus());
			
			if (!this.isBattleOver)
				setStatus("Press return to procede.\n");
			
			// get ready for next move
			this.playerTurn = false;
		} else { // if it is the monster turn
			// reset defense status, if that is the case
			if (this.enemyDefending) {
				this.battleExecuter.defend(getMonster(), true);
				this.enemyDefending = false;
			}
			
			String monsterInput = this.battleExecuter.monsterAI(monster, player);
			
			if (monsterInput.contains("D")) {
				this.battleExecuter.defend(getMonster(), false);
				
				this.enemyDefending = true;
			} else {
				 isBattleOver = this.battleExecuter.attack(getMonster(), getPlayer(), monsterInput);
			}
			
			// get battle status
			setStatus(battleExecuter.getStatus());
			
			if (!isBattleOver) {
				setStatus("You may procede to your turn - you can either [A]ttack, [D]efend or [R]un. Decide.\n\n"
						+ getMonster().getName() + "'s Health: " + (int)getMonster().getAtt("hp").getValue() + " / "
						+ getMonster().getAtt("hp").getMax().intValue() + "\n");
			}
			
			// get ready for next move
			this.playerTurn = true;
		}
		
		
		// if the battle was lost...
		if (this.isBattleOver && !this.hasLeveledUp) {
			if (getPlayer().dead()) {
				lostBattle();
			} else {
				wonBattle();
			}
			
			reset ();
		}
	}
	
	/**
	 * Provê um Estado a mais a ser incluido ao output,
	 * apenas com função estética
	 */
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
	
	/**
	 * Caso o jogador tenha ganhado a batalha, realiza os processos necessários
	 */
	private void wonBattle () {
		double gainedXP = getMonster().getAtt("xp").getValue();
		
		setStatus(this.monster.getWinDescription());
		setStatus("You win this battle, for once. The creature is now dead, you may " +
				"move on to your hopeless journey.\n");
		setStatus("You win " + (int)monster.getAtt("xp").getValue() + " XP as you leave the battle.");
		
		// Reset Player's Health
		try {
			getPlayer().getAtt("hp").setToMax();
		} catch (NoMaxMinException e) {
			e.printStackTrace();
		}
		
		// increase gained XP and checks if player has leveled up
		int levelGained;
		levelGained = getPlayer().addXP(gainedXP);
		
		if (levelGained > 0) {
			this.hasLeveledUp = true;
			this.attsSelected *= levelGained;
		}
		else {
			setDone(true);
		}
	}
	
	/**
	 * Caso o jogador tenha perdido a batalha, realiza os processos necessários
	 */
	private void lostBattle() {
		setStatus(this.monster.getDeathDescription());
		setStatus("Suddenly, everything becomes darker... Your limbs are tembling... Everything is fading. Long gone. "
				+ "No hopes, no chance of escape. You are dead.\n");
		
		setDone(true);
		
		// lower XP?
	}
	
	/**
	 * Realiza o procedimento de Level Up do jogador
	 * 
	 * @param answer  - Onde o jogador quer usar seu SkillPoint
	 */
	private void levelUp (String answer) {
		setStatus(null);
		if(this.attsSelected != 0) {
			
			// Level Up the stats selected!
			if(answer.contains("1")) {
				
				getPlayer().getAtt("hp").setMax(getPlayer().getAtt("hp").getMax() + 10);
				
				try {
					getPlayer().getAtt("hp").setToMax();
				} catch (NoMaxMinException e) {
					e.printStackTrace();
				}
				
				this.attsSelected--;
				
			} else if(answer.contains("2")) {
				
				getPlayer().getAtt("attack").setValue(getPlayer().getAtt("attack").getValue() + 1);
				this.attsSelected--;
				
			} else if(answer.contains("3")) {
				
				getPlayer().getAtt("defense").setValue(getPlayer().getAtt("defense").getValue() + 1);
				this.attsSelected--;
				
			} else if(answer.contains("4")) {
				
				getPlayer().getAtt("dexterity").setValue(getPlayer().getAtt("dexterity").getValue() + 1);
				this.attsSelected--;
				
			} else if(answer.contains("5")) {
				
				getPlayer().getAtt("evasiveness").setValue(getPlayer().getAtt("evasiveness").getValue() + 1);
				this.attsSelected--;
				
			} else if(answer.contains("6")) {
				
				getPlayer().getAtt("luck").setValue(getPlayer().getAtt("luck").getValue() + 1);
				this.attsSelected--;
				
			} else
				setStatus("You must choose a valid action.\n");
			
			setStatus("You got to Level " + (int)getPlayer().getNivel() + "!\n"
					+ "You have " + this.attsSelected + " Skill Points to spend. " + "Choose where you want to level up:\n" 
					+ "[1] Health = " + getPlayer().getAtt("hp").getMax() + "\n"
					+ "[2] Attack = " + (int)getPlayer().getAtt("attack").getValue() + "\n"
					+ "[3] Defense = " + (int)getPlayer().getAtt("defense").getValue() + "\n"
					+ "[4] Dexterity = " + (int)getPlayer().getAtt("dexterity").getValue() + "\n"
					+ "[5] Evasiveness = " + (int)getPlayer().getAtt("evasiveness").getValue() + "\n"
					+ "[6] Luck = " + (int)getPlayer().getAtt("luck").getValue() + "\n");
		}
		
		// if all the atts have been chosen
		if (this.attsSelected == 0)
			setDone(true);
	}
	
	/**
	 * Reseta as configurações de batalha
	 */
	private void reset() {		
		// Battle ended, reset class configurations
		this.battleExecuter = null;
	}
}
