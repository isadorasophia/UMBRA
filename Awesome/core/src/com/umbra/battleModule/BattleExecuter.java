package com.umbra.battleModule;

import java.util.Random;
import com.umbra.mobModule.mobComponent.inter.IMob;

/**
 * Classe que realiza os procedimentos de ataque e defesa durante a batalha
 * 
 * @author Matheus Mortatti Diamantino 156740
 * @author Isadora Sophia Garcia Rodopoulos 158018
 *
 */
// Manages battle mechanics in general
class BattleExecuter {
	/**
	 * Construtor
	 */
	BattleExecuter () { 
		status = new String ();
		this.limbs = new BodyPart("limbs", 1.15f, 0.5f);
		this.brain = new BodyPart("brain", 1.35f, 0.3f);
		this.vitalOrgans = new BodyPart("vital organs", 1.25f, 0.4f);
	}
	
	private enum AttackState { normal, critical, counter, missed }
	
	BodyPart limbs, brain, vitalOrgans;
	private String status;
	
	/**
	 * Getter para a variável Status
	 * 
	 * @return String - Estado que será adicionado ao output 
	 */
	String getStatus () { return this.status; }
	
	/**
	 * Setter para a variável Status
	 * 
	 * @param status - Estado a ser setado
	 */
	private void setStatus (String status) { 
		if (status == null)
			this.status = "";
		else
			this.status += status; 
	}
	
	/**
	 * Limpa o status da battle
	 */
	void cleanStatus() { setStatus(null); }
	
	/**
	 * Retorna a string com a primeira letra capitalizada
	 * 
	 * @param Uma string arbitrária
	 * @return String - a string recebida no parâmetro com a primeira letra maiúscula
	 */
	private String capitalize (String input) {
		return input.substring(0, 1).toUpperCase() + input.substring(1);
	}
	
	/**
	 * Provê a referencia à parte do corpo a ser atacada
	 * 
	 * @param input
	 * @return BodyPart - Parte do corpo a ser atacada
	 */
	private BodyPart returnBodyPart (String input) {
		if (input.contains("L"))
			return this.limbs;
		else if (input.contains("B")) 
			return this.brain;
		else if (input.contains("V"))
			return this.vitalOrgans;
		
		return null;
	}
	
	/**
	 * Realiza cálculos que determinam se o player conseguiu fugir da batalha
	 * 
	 * @param player
	 * @param enemy
	 * @return boolean - Se o player conseguiu escapar
	 */
	boolean escape (IMob player, IMob enemy) {
		cleanStatus();
		
		Random random = new Random ();
		
		double escapeRate = (player.getAtt("luck").getValue() * 2 * ((player.getAtt("sanity").getValue()) + 1)) + player.getAtt("evasiveness").getValue();
		double enemyRate = (player.getAtt("luck").getValue() * 2 * ((random.nextFloat() * 0.5) + 1)) + player.getAtt("dexterity").getValue();
		
		String playerName = player.getName();
		playerName = playerName.substring(0, 1).toUpperCase() + playerName.substring(1);
		
		if (escapeRate >= enemyRate) {
			setStatus(capitalize(player.getName()) + " was able to escape the battle and ran for his pitiful life...\n");
			return true;
		} else {
			setStatus(capitalize(player.getName()) + " tried to escape the battle, but failed.\n");
			return false;
		}
	}
	
	/**
	 * Realiza comparações e calcula as consequências do ataque realizado
	 * 
	 * @param attacker
	 * @param victim
	 * @param BP
	 * @param counter
	 * @return - boolean Se o monstro ou o player morreu
	 */
	boolean attack (IMob attacker, IMob victim, String BP) {		
		int damage;
		BodyPart bodyPart = returnBodyPart(BP);
		
		cleanStatus();
		
		if (bodyPart == null) {
			setStatus("That was an invalid move.\n");
			
			return false;
		}
		
		AttackState attackState = stateOfAttack (attacker, victim, bodyPart.getHitChance());
		
		switch (attackState) {
			case normal:
				damage = (int)calcDamage(attacker, victim, false, bodyPart.getAttFactor());
				setStatus(capitalize(attacker.getName()) + " attacked towards the " + bodyPart.getBodyPart() + " and inflicted a damage of " + (int) damage + " on " + victim.getName() + "!\n");
					
				victim.decreaseHP(damage); 
						
				if (victim.dead()) {
					return true;
				}
				
				break;
			case critical:
				damage = (int)calcDamage(attacker, victim, true, bodyPart.getAttFactor());
				setStatus(capitalize(attacker.getName()) + " attacked towards the " + bodyPart.getBodyPart() + " and inflicted a CRITICAL damage of " + (int) damage + " on " + victim.getName() + "!\n");
					
				victim.decreaseHP(damage);
				
				if (victim.dead()) {
					return true;
				}
				
				break;
			case counter:
				setStatus("Counter!\n");
				
				damage = (int)calcDamage(victim, attacker, false, bodyPart.getAttFactor());
				setStatus(capitalize(victim.getName()) + " attacked towards the " + bodyPart.getBodyPart() + " and inflicted a damage of " + (int)damage + " on " + attacker.getName() + "!\n");
				
				attacker.decreaseHP(damage);
				
				if (attacker.dead()) {
					return true;
				}
				
				break;
			case missed:
				setStatus(capitalize(attacker.getName()) + " tried to attack " + victim.getName() + ", but missed!\n");
				
				break;
		}
 
		
		return false;
	}
	
	/**
	 * Determina o estado do ataque realizado (critical, normal, counter ou missed)
	 * 
	 * @param attacker
	 * @param victim
	 * @param chance - chance de CriticalHit
	 * @return AttackState - Enum representativo do estado do ataque
	 */
	private AttackState stateOfAttack (IMob attacker, IMob victim, float chance) {
		Random random = new Random();
		double attackerRate = attacker.getAtt("dexterity").getValue() + attacker.getAtt("luck").getValue();
		double enemyRate = victim.getAtt("evasiveness").getValue() + victim.getAtt("luck").getValue();
		
		// chance to add up to 50% more to their stats
		attackerRate *= (random.nextFloat() + 1);
		enemyRate *= (random.nextFloat() * 0.4 + 1);
		
		if (attackerRate >= enemyRate * (chance/10 + 1)) {
			if (random.nextFloat() < chance)
				return AttackState.critical;
			else
				return AttackState.normal;
		}
		else {
			if (enemyRate > attackerRate * 2 * (chance/2 + 1))
				return AttackState.counter;
			else
				return AttackState.missed;
		}
	}
	
	/**
	 * Calcula o valor do dano causado pelo ataque
	 * 
	 * @param attacker
	 * @param victim
	 * @param critical
	 * @param attackFactor
	 * @return double - Valor do ataque realizado
	 */
	private double calcDamage (IMob attacker, IMob victim, boolean critical, float attackFactor) {
		Random random = new Random ();
		
		//double defense = (victim.getAtt("defense").getValue() * 2) * (random.nextFloat() + 0.5);
		//double attack = 3 + (attacker.getAtt("attack").getValue() * 2) * (random.nextFloat() + 0.5);
		double defense = victim.getAtt("defense").getValue();
		double attack = attacker.getAtt("attack").getValue() * (random.nextFloat() * 0.5 + 1.25);
		
		if (critical) {
			attack *= attackFactor;
		}
		
		if (attack - defense < 1) {
			return 1;
		}
		
		return attack - defense;
	}
	
	/**
	 * Realiza o procedimento de defesa
	 * 
	 * @param target - quem está defendendo
	 * @param over - Se o periodo de defesa acabou
	 */
	void defend (IMob target, boolean over) {
		cleanStatus();
		
		double defense = target.getAtt("defense").getValue();
		
		if (over) {
			// decrease
			target.setAtt("defense", defense / 	1.8);
			
			setStatus(capitalize(target.getName()) + " lost the defense move.\n");
		} else {
			// increase
			target.setAtt("defense", defense * 1.8);
			
			setStatus(capitalize(target.getName()) + " chose to defend.\n");
		}
	}
	
	/**
	 * Inteligência artificial do monstro
	 * 
	 * @param monster
	 * @param victim
	 * @return String - Parte do corpo que o monstro quer atacar
	 */
	String monsterAI (IMob monster, IMob victim) {
		Random random = new Random();
		double hpProportion = monster.getAtt("hp").getValue()/monster.getAtt("hp").getMax();
		double attackChance = (monster.getAtt("attack").getValue() * 2) * (random.nextFloat()/2);
		
		if (hpProportion < .25) {
			if (attackChance >= victim.getAtt("hp").getValue()) {
				// higher chance to hit enemy
				return "L";
			}
			// bets on higher chance of attack
			else if (random.nextFloat() <= 0.6)
				return "B";
			else
				return "D";
		} else {
			if (monster.getAtt("attack").getValue() * limbs.getAttFactor() * (random.nextFloat() * .25) >= 
					monster.getAtt("dexterity").getValue() * (1 + limbs.getHitChance()) * (random.nextFloat() * .25)) {
				return "L";
				
			} else if (monster.getAtt("dexterity").getValue() * vitalOrgans.getAttFactor() * (.3 + random.nextFloat() * .5) > 
			monster.getAtt("attack").getValue() * (1 + vitalOrgans.getHitChance()) * (.25 + random.nextFloat() * .25)) {
				return "V";
			
			} else { 
				return "B";
				
			}
		}
	}
}