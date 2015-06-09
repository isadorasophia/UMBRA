package com.umbra.battleModule;

import java.util.Random;
import java.util.Vector;

import com.umbra.mobModule.exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.exceptions.FullInventoryException;
import com.umbra.mobModule.exceptions.NoMaxMinException;
import com.umbra.mobModule.exceptions.SameItemException;
//import com.umbra.mobModule.itemComponent.impl.ItemManager;
//import com.umbra.mobModule.itemComponent.inter.IItemBattle;
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
	
	// Data components
	private BattleDao battleDao = null;
	
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
	 * Checa se o player mudou de nível, em que a batalha entra em estado de distribuição de 
	 * pontos em seus atributos
	 * 
	 * @return boolean - Retorna se mudou de nível
	 */
	public boolean getHasLeveledUp () { return this.hasLeveledUp; }
	
	/**
	 * Inicialização das variáveis de batalha
	 * 
	 * @param player - Jogador da batalha
	 * @param monster - Monstro da batalha
	 */
	public void initialize (IPlayer player, IMonstro monster) {
		/*ItemManager itemManager = new ItemManager();
		IItemBattle item = itemManager.instantiateItemBattle("LONG SWORD", null);
		try {
			getPlayer().putItem(item);
		} catch (FullInventoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SameItemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		/*// For testing sake
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
		
		this.battleExecuter = new BattleExecuter();
		this.battleDao = new BattleDaoImpl(player, monster);
		
		// information regarding turns
		this.playerTurn = true;
		this.turnsPassed = 0;
		
		// battle status
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
		Vector <String> items = battleDao.getPlayer().itemsForBattle();
		
		setStatus(battleDao.getMonster().getDescription() + "\n");
		
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
		// restart settings
		String oldStatus = getStatus();
		setStatus(null);
		
		// in order to identify the input, set a pattern
		input = input.toUpperCase();
		
		// if the battle was already over
		if (this.isBattleOver && this.hasLeveledUp) {			
			levelUp(input);
				
			return;
		}
		
		// if the battle isn't set yet
		if (!this.isBattleSet) {
			// auxiliar boolean
			boolean b = false;
			
			try {
				b = battleDao.getPlayer().equipItem(input);
			} catch (CannotDoubleModifyAttributeException e) {
				e.printStackTrace();
			}
			
			// if it was successfully equipped
			if (b) {
				isBattleSet = true;
				
				setStatus("Your item was equipped.\n" + battleDao.getMonster().getName() + " approaches slowly into your direction."
						+ " You must make a choice.\n[A]ttack, [D]efend or [R]un. Time is clocking.\n");
				
				return;
			} else {
				Vector <String> items = battleDao.getPlayer().itemsForBattle();
				
				setStatus("You must choose a valid item:\n" + listItems(items));
				
				randomStatus();
				
				return;
			}
		}
		
		// if it is the player turn
		if (this.playerTurn) {
			// reset defense status, if that is the case
			if (this.playerDefending && this.turnsPassed == 2) {
				this.battleExecuter.defend(battleDao.getPlayer(), true);
				this.playerDefending = false;
				
			} else { // player can keep on defending, just count as a passed turn
				if (this.turnsPassed != 2 && this.playerDefending) {
					this.turnsPassed += 1;
				}
			}
			
			// execute player move
			if (input.contains("D")) {
				// player increases his defense in the next 2 turns
				if (!this.playerDefending) {
					this.battleExecuter.defend(battleDao.getPlayer(), false);
				} else { // manually defends, since it was already defending
					this.turnsPassed = 0;
					setStatus("You chose to defend, for once.\nPress return to procede.\n");
				
					// get ready for next move
					this.playerTurn = false;
					
					return;
				}
				
				this.turnsPassed = 0;
				this.playerDefending = true;
				
			} else if (input.contains("R")) { // run!
				setDone(this.battleExecuter.escape(battleDao.getPlayer(), battleDao.getMonster()));
				
			} else if (input.contains("A")) { // proceed 
				setStatus ("An attack is attempted. You can attack towards the creature's...\n"
						+ "[L]imbs [ 1.15 | 50% ],\n"
						+ "[B]rain [ 1.35 | 30% ] or\n"
						+ "[V]ital organs [ 1.25 | 40% ]\n");
				
				return;
				
			} else if (input.contains("L") || input.contains("B") || input.contains("V")) { //attack!
				isBattleOver = this.battleExecuter.attack(battleDao.getPlayer(), battleDao.getMonster(), input);
				
			} else { // invalid input
				String retry = "You must choose a valid action.\n\n";
				
				// if it contains the initial description, get rid of it
				if (oldStatus.contains(battleDao.getMonster().getDescription())) {
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
				this.battleExecuter.defend(battleDao.getMonster(), true);
				this.enemyDefending = false;
			}
			
			// decides the next movement
			String monsterInput = this.battleExecuter.monsterAI(battleDao.getMonster(), battleDao.getPlayer());
			
			if (monsterInput.contains("D")) {
				this.battleExecuter.defend(battleDao.getMonster(), false);
				
				this.enemyDefending = true;
			} else {
				 this.isBattleOver = this.battleExecuter.attack(battleDao.getMonster(), battleDao.getPlayer(), monsterInput);
			}
			
			// get battle status
			setStatus(battleExecuter.getStatus());
			
			if (!this.isBattleOver) {
				setStatus("You may procede to your turn - you can either [A]ttack, [D]efend or [R]un. Decide.\n\n"
						+ battleDao.getMonster().getName() + "'s Health: " + (int)battleDao.getMonster().getAtt("hp").getValue() + " / "
						+ battleDao.getMonster().getAtt("hp").getMax().intValue() + "\n");
			}
			
			// get ready for next move
			this.playerTurn = true;
		}
		
		
		// if the battle was lost...
		if (this.isBattleOver && !this.hasLeveledUp) {
			// Unequip all items
			try {
				battleDao.getPlayer().unequipAll();
			} catch (FullInventoryException e) {
				e.printStackTrace();
			} catch (SameItemException e) {
				e.printStackTrace();
			}
			
			if (battleDao.getPlayer().dead()) {
				lostBattle();
			} else {
				wonBattle();
			}
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
		double gainedXP = battleDao.getMonster().getAtt("xp").getValue();
		
		setStatus(this.battleDao.getMonster().getWinDescription());
		setStatus("You win this battle, for once. The creature is now dead, you may " +
				"move on to your hopeless journey.\n");
		setStatus("You win " + (int)battleDao.getMonster().getAtt("xp").getValue() + " XP as you leave the battle.");
		
		// Reset Player's Health
		try {
			battleDao.getPlayer().getAtt("hp").setToMax();
		} catch (NoMaxMinException e) {
			e.printStackTrace();
		}
		
		// increase gained XP and checks if player has leveled up
		int levelGained;
		levelGained = battleDao.getPlayer().addXP(gainedXP);
		
		if (levelGained > 0) {
			this.hasLeveledUp = true;
			this.attsSelected *= levelGained;
		}
		else {
			setDone(true);
			
			reset();
		}
	}
	
	/**
	 * Caso o jogador tenha perdido a batalha, realiza os processos necessários
	 */
	private void lostBattle() {
		setStatus(battleDao.getMonster().getDeathDescription());
		
		setDone(true);
		reset();
	}
	
	/**
	 * Realiza o procedimento de Level Up do jogador
	 * 
	 * @param answer  - Onde o jogador quer usar seu SkillPoint
	 */
	private void levelUp (String answer) {
		setStatus(null);
		
		if (this.attsSelected != 0 && !answer.isEmpty()) {
			// Level Up the stats selected!
			if (answer.contains("1")) {
				battleDao.getPlayer().getAtt("hp").setMax(battleDao.getPlayer().getAtt("hp").getMax() + 10);
				
				try {
					battleDao.getPlayer().getAtt("hp").setToMax();
				} catch (NoMaxMinException e) {
					e.printStackTrace();
				}
				
				this.attsSelected--;
				
			} else if (answer.contains("2")) {
				battleDao.getPlayer().getAtt("attack").setValue(battleDao.getPlayer().getAtt("attack").getValue() + 1);
				this.attsSelected--;
				
			} else if (answer.contains("3")) {
				battleDao.getPlayer().getAtt("defense").setValue(battleDao.getPlayer().getAtt("defense").getValue() + 1);
				this.attsSelected--;
				
			} else if (answer.contains("4")) {
				battleDao.getPlayer().getAtt("dexterity").setValue(battleDao.getPlayer().getAtt("dexterity").getValue() + 1);
				this.attsSelected--;
				
			} else if (answer.contains("5")) {
				battleDao.getPlayer().getAtt("evasiveness").setValue(battleDao.getPlayer().getAtt("evasiveness").getValue() + 1);
				this.attsSelected--;
				
			} else if (answer.contains("6")) {
				battleDao.getPlayer().getAtt("luck").setValue(battleDao.getPlayer().getAtt("luck").getValue() + 1);
				this.attsSelected--;
				
			} else {
				setStatus("You must choose a valid attribute.\n\n");
			}
		}
		
		// if all the atts have been chosen
		if (this.attsSelected == 0) {
			setDone(true);
			reset();
		} else {
			setStatus("You got to Level " + (int)battleDao.getPlayer().getNivel() + "!\n"
					+ "You have " + this.attsSelected + " Skill Points to spend. " + "Choose where you want to level up:\n" 
					+ "[1] Health = " + battleDao.getPlayer().getAtt("hp").getMax() + "\n"
					+ "[2] Attack = " + (int)battleDao.getPlayer().getAtt("attack").getValue() + "\n"
					+ "[3] Defense = " + (int)battleDao.getPlayer().getAtt("defense").getValue() + "\n"
					+ "[4] Dexterity = " + (int)battleDao.getPlayer().getAtt("dexterity").getValue() + "\n"
					+ "[5] Evasiveness = " + (int)battleDao.getPlayer().getAtt("evasiveness").getValue() + "\n"
					+ "[6] Luck = " + (int)battleDao.getPlayer().getAtt("luck").getValue() + "\n");
		}
	}
	
	/**
	 * Reseta as configurações de batalha
	 */
	private void reset() {		
		// Battle ended, reset class configurations
		this.battleExecuter = null;
		this.battleDao = null;
	}
}
