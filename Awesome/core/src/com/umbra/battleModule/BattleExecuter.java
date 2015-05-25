package com.umbra.battleModule;

import java.util.Random;

import com.umbra.mobModule.mobComponent.*;

// Static class, which manages the battle AI
class BattleExecuter {	
	private static enum AttackState { normal, critical, counter, missed }
	
	// BodyPart arm, leg, belly, head;
	
	// Prevents to instantiate the class, since it's supposed to be static
	private BattleExecuter () { }
	private static BattleExecuter instance = null;
	
	public static BattleExecuter getInstance() {
		if (instance == null) {
			instance = new BattleExecuter();
		}
		
		return instance;
	}
	
	// Tries to escape!
	boolean escape (IMob player, IMob enemy) {
		return false;
	}
	
	String attack (IMob attacker, IMob victim) {
		float damage;
		AttackState attackState = stateOfAttack (attacker, victim);
		
		switch (attackState) {
			case normal:
				
			case critical:
				
			case counter:
				return "Counter attack!\n" + attack (victim, attacker);
			case missed:
				// TODO: name for IMob
				return attacker.getName() + "tried to attack" + victim.getName() + "but missed!\n";
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
	
	String defend (IMob attacker, IMob victim) {
		return null;
	}
	
	// Monsters turn
	String monsterAI (IMob monster, IMob victim) {
		return null;
	}
	
	// Returns if the battle has ended
	static boolean isItOver (IMob monster, IMob victim) {
		return false;
	}
}