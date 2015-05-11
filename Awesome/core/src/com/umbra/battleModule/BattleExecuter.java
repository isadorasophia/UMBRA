package com.umbra.battleModule;

import com.umbra.mobModule.mobComponent.*;

// Static class, which manages the battle AI
final class BattleExecuter {
	// Prevents to instantiate the class, since it's supposed to be static
	private BattleExecuter () { }
	
	// Tries to escape!
	public static boolean escape () {
		return false;
	}
	
	public static String attack (IMobGeneric attacker, IMobGeneric victim) {
		return null;
	}
	
	public static String defend (IMobGeneric attacker, IMobGeneric victim) {
		return null;
	}
	
	// Monsters turn
	public static String monsterAI (IMobGeneric monster, IMobGeneric victim) {
		return null;
	}
	
	// Returns if the battle has ended
	public static boolean isItOver (IMobGeneric monster, IMobGeneric victim) {
		return false;
	}
}