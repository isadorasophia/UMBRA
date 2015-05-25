package com.umbra.battleModule;

import java.util.Random;

import com.umbra.mobModule.mobComponent.*;

// Static class, which manages the battle AI
class BattleExecuter {	
	private static BattleExecuter instance = null;
	static BattleExecuter getInstance() {
		if (instance == null) {
			instance = new BattleExecuter();
		}
		
		return instance;
	}
	
	private static enum AttackState { normal, critical, counter, missed }
	
	// BodyPart arm, leg, belly, head;
	private String status = "";
	
	// Prevents to instantiate the class, since it's supposed to be static
	private BattleExecuter () { status = new String (); }
	String getStatus () { return this.status; }
	private void setStatus (String status) { 
		if (status == null)
			this.status = "";
		else
			this.status += status; 
	}
	
	// Tries to escape!
	boolean escape (IMob player, IMob enemy) {
		return false;
	}
	
	boolean attack (IMob attacker, IMob victim) {
		return attack (attacker, victim, false);
	}
	
	private boolean attack (IMob attacker, IMob victim, boolean counter) {
		double damage;
		AttackState attackState = stateOfAttack (attacker, victim);
		
		if (!counter)
			setStatus(null);
		
		switch (attackState) {
			case normal:
				damage = calcDamage(attacker, victim, false);
				// TODO: decrease HP function
				victim.decreaseHP(damage);
				return attacker.getName() + " attacks and inflicted a damage of " + (int) damage + "on " + victim.getName() + "!\n";
			case critical:
				damage = calcDamage(attacker, victim, true);
				if (victim.decreaseHP(damage)) {
					return attacker.getName() + " attacks and inflicted a CRITICAL damage of " + (int) damage + "on " + victim.getName() + "!\n";
				} else
					return attacker.getName() + " just killed " + victim.getName() 
			case counter:
				return "Counter attack!\n" + attack (victim, attacker);
			case missed:
				// TODO: name for IMob
				return attacker.getName() + " tried to attack " + victim.getName() + "but missed!\n";
		}
		
		return null;
	}
	
	private AttackState stateOfAttack (IMob attacker, IMob victim) {
		Random random = new Random();
		double attackerRate = attacker.getAtt("speed").getValue() + attacker.getAtt("dexterity").getValue() + attacker.getAtt("luck").getValue();
		double enemyRate = victim.getAtt("evasiveness").getValue() + victim.getAtt("dexterity").getValue() + victim.getAtt("luck").getValue();
		
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
	
	boolean defend (IMob attacker, IMob victim) {
		return true;
	}
	
	// Monsters turn
	boolean monsterAI (IMob monster, IMob victim) {
		return true;
	}
}