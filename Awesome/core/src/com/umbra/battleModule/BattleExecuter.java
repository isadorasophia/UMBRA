package com.umbra.battleModule;

import java.util.Random;
import com.umbra.mobModule.mobComponent.inter.IMob;

// Static class, which manages the battle AI
class BattleExecuter {	
	// Prevents to instantiate the class, since it's supposed to be static
	BattleExecuter () { 
		status = new String ();
		this.limbs = new BodyPart("Limbs", 1.2f, 0.7f);
		this.brain = new BodyPart("Brain", 1.8f, 0.2f);
		this.vitalOrgans = new BodyPart("Vital Organs", 1.6f, 0.3f);
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
				damage = calcDamage(attacker, victim, false);
				setStatus(attacker.getName() + " attacks and inflicted a damage of " + (int) damage + "on " + victim.getName() + "!\n");
				
				if (victim.decreaseHP(damage)) {
					setStatus (attacker.getName() + " just killed " + victim.getName() + "...\n");
					return true;
				}
				
			case critical:
				damage = calcDamage(attacker, victim, true);
				setStatus(attacker.getName() + " attacks and inflicted a CRITICAL damage of " + (int) damage + "on " + victim.getName() + "!\n");
				
				if (victim.decreaseHP(damage)) {
					setStatus (attacker.getName() + " just killed " + victim.getName() + "...\n");
					return true;
				}
				
			case counter:
				setStatus ("Counter attack!\n");
				return attack (victim, attacker, BP, true);
				
			case missed:
				setStatus(attacker.getName() + " tried to attack " + victim.getName() + ", but missed!\n");
		}
		
		return false;
	}
	
	private AttackState stateOfAttack (IMob attacker, IMob victim, float chance) {
		Random random = new Random();
		double attackerRate = attacker.getAtt("dexterity").getValue() + attacker.getAtt("luck").getValue();
		double enemyRate = victim.getAtt("evasiveness").getValue() + victim.getAtt("luck").getValue();
		
		// chance to add up to 50% more to their stats
		attackerRate *= random.nextFloat() * 0.5 + 0.1;
		enemyRate *= random.nextFloat() * 0.5 + 0.1;
		
		if (attackerRate >= enemyRate) {
			if (attackerRate >= enemyRate * 3)
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
		if (input.equalsIgnoreCase("L"))
			return this.limbs;
		else if (input.equalsIgnoreCase("B")) 
			return this.brain;
		else if (input.equalsIgnoreCase("V"))
			return this.vitalOrgans;
		
		return null;
	}
	
	private double calcDamage (IMob attacker, IMob victim, boolean critical) {
		Random random = new Random ();
		
		double defense = (victim.getAtt("defense").getValue() * 2) * (random.nextFloat() + 0.5);
		double attack = 7 + (attacker.getAtt("attack").getValue() * 2) * (random.nextFloat() + 0.5);
		
		if (critical) {
			attack += attacker.getAtt("attack").getValue();
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
	
	// Monsters turn
	boolean monsterAI (IMob monster, IMob victim) {
		// wait for body parts.
		return true;
	}
}