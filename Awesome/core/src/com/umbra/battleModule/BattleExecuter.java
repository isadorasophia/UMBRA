package com.umbra.battleModule;

import java.util.Random;
import com.umbra.mobModule.mobComponent.inter.IMob;

// Manages battle mechanics in general
class BattleExecuter {
	BattleExecuter () { 
		status = new String ();
		this.limbs = new BodyPart("Limbs", 1.3f, 0.7f);
		this.brain = new BodyPart("Brain", 1.8f, 0.3f);
		this.vitalOrgans = new BodyPart("Vital Organs", 1.6f, 0.4f);
	}
	
	private static enum AttackState { normal, critical, counter, missed }
	
	BodyPart limbs, brain, vitalOrgans;
	private String status = "";
	
	String getStatus () { return this.status; }
	private void setStatus (String status) { 
		if (status == null)
			this.status = "";
		else
			this.status += status; 
	}
	
	// Tries to escape!
	boolean escape (IMob player, IMob enemy) {
		setStatus(null);
		
		Random random = new Random ();
		// TODO: sanity attribute
		double escapeRate = (player.getAtt("luck").getValue() * 2 * ((random.nextFloat() * player.getAtt("sanity").getValue()) + 1)) + player.getAtt("evasiveness").getValue();
		double enemyRate = (player.getAtt("luck").getValue() * 2 * ((random.nextFloat() * 0.5) + 1)) + player.getAtt("dexterity").getValue();
		
		if (escapeRate >= enemyRate) {
			setStatus(player.getName() + " was able to escape the battle and ran for his pitiful life...\n");
			return true;
		} else
			setStatus(player.getName() + " tried to escape the battle, but failed.\n");
			return false;
	}
	
	boolean attack (IMob attacker, IMob victim, String input) {
		return attack (attacker, victim, input, false);
	}
	
	// returns true if the battle is over, false otherwise
	private boolean attack (IMob attacker, IMob victim, String BP, boolean counter) {
		double damage;
		BodyPart bodyPart = returnBodyPart(BP);
		
		if (bodyPart == null) {
			setStatus("That was an invalid move.\n");
			
			return false;
		}
		
		AttackState attackState = stateOfAttack (attacker, victim, bodyPart.getHitChance());
		
		// If it isn't a counter move, clean up the string
		if (!counter) 
			setStatus(null);
		
		switch (attackState) {
			case normal:
				damage = calcDamage(attacker, victim, false, bodyPart.getAttFactor());
				setStatus(attacker.getName() + " attacks and inflicted a damage of " + (int) damage + " on " + victim.getName() + "!\n");
					
				victim.decreaseHP(damage); 
						
				if (victim.dead()) {
					setStatus (attacker.getName() + " just killed " + victim.getName() + "...\n");
					return true;
				}
				break;
			case critical:
				damage = calcDamage(attacker, victim, true, bodyPart.getAttFactor());
				setStatus(attacker.getName() + " attacks and inflicted a CRITICAL damage of " + (int) damage + " on " + victim.getName() + "!\n");
					
				victim.decreaseHP(damage);
				if (victim.dead()) {
					setStatus (attacker.getName() + " just killed " + victim.getName() + "...\n");
					return true;
				}
				break;
			case counter:
				setStatus("Counter!\n");
				damage = calcDamage(victim, attacker, false, bodyPart.getAttFactor());
				setStatus(victim.getName() + " attacks and inflicted a damage of " + (int)damage + " on " + attacker.getName() + "!\n");
				
				attacker.decreaseHP(damage);
				if (attacker.dead()) {
					setStatus (victim.getName() + " just killed " + attacker.getName() + "...\n");
					return true;
				}
				break;
			case missed:
				setStatus(attacker.getName() + " tried to attack " + victim.getName() + ", but missed!\n");
				break;
		}
 
		
		return false;
	}
	
	private AttackState stateOfAttack (IMob attacker, IMob victim, float chance) {
		Random random = new Random();
		double attackerRate = attacker.getAtt("dexterity").getValue() + attacker.getAtt("luck").getValue();
		double enemyRate = victim.getAtt("evasiveness").getValue() + victim.getAtt("luck").getValue();
		
		// chance to add up to 50% more to their stats
		attackerRate *= (random.nextFloat() + 1);
		enemyRate *= (random.nextFloat() * 0.3 + 1);
		
		if (attackerRate >= enemyRate) {
			if (random.nextFloat() < chance)
				return AttackState.critical;
			else
				return AttackState.normal;
		}
		else {
			if (enemyRate > attackerRate * 2)
				return AttackState.counter;
			else
				return AttackState.missed;
		}
	}
	
	private BodyPart returnBodyPart (String input) {
		if (input.contains("L"))
			return this.limbs;
		else if (input.contains("B")) 
			return this.brain;
		else if (input.contains("V"))
			return this.vitalOrgans;
		
		return null;
	}
	
	private double calcDamage (IMob attacker, IMob victim, boolean critical, float attackFactor) {
		Random random = new Random ();
		
		//double defense = (victim.getAtt("defense").getValue() * 2) * (random.nextFloat() + 0.5);
		//double attack = 3 + (attacker.getAtt("attack").getValue() * 2) * (random.nextFloat() + 0.5);
		double defense = victim.getAtt("defense").getValue();
		double attack = attacker.getAtt("attack").getValue() * (random.nextFloat() * 0.6 + 1);
		
		if (critical) {
			attack *= attackFactor;
		}
		
		if (attack - defense < 1) {
			return 1;
		}
		
		return attack - defense;
	}
	
	void defend (IMob target, boolean over) {
		double defense = target.getAtt("defense").getValue();
		setStatus(null);
		
		if (over) {
			// decrease
			target.setAtt("defense", defense / 1.5);
			
			setStatus(target.getName() + " defense move is now done.\n");
		} else {
			// increase
			target.setAtt("defense", defense * 1.5);
			
			setStatus(target.getName() + " chooses to defend itself.\n");
		}
	}
	
	// Monster turn
	String monsterAI (IMob monster, IMob victim) {
		Random random = new Random();
		double hpProportion = monster.getAtt("hp").getValue()/monster.getAtt("maxHP").getValue();
		double attackChance = (monster.getAtt("attack").getValue() * 2) * (1 + random.nextFloat()/2);
		
		if (hpProportion < 0.2) {
			if (attackChance >= victim.getAtt("hp").getValue()) {
				// higher chance to hit enemy
				return "L";
			}
			// bets on higher chance of attack
			else if (random.nextFloat() <= 0.3)
				return "B";
			else
				return "D";
		} else {
			if (monster.getAtt("attack").getValue() * (1 - random.nextFloat() * 0.25) >= monster.getAtt("dexterity").getValue() * (1 - random.nextFloat() * 0.25)) {
				return "L";
			} else if (monster.getAtt("dexterity").getValue() * (1 - random.nextFloat() * 0.25) > monster.getAtt("attack").getValue() * 0.5) {
				return "V";
			} else
				return "B";
		}
	}
}