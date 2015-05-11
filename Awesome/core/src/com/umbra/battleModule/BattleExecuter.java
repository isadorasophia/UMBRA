package com.umbra.battleModule;

import com.umbra.mobModule.mobComponent.*;

// Static class, which manages the battle AI
final class BattleExecuter {
	// Prevents to instantiate the class, since it's supposed to be static
	private BattleExecuter () { }
	
	// Tries to escape!
	static boolean escape (IMobGeneric player, IMobGeneric enemy) {
		return false;
	}
	
	static String attack (IMobGeneric attacker, IMobGeneric victim) {
		return null;
	}
	
	static String defend (IMobGeneric attacker, IMobGeneric victim) {
		return null;
	}
	
	// Monsters turn
	static String monsterAI (IMobGeneric monster, IMobGeneric victim) {
		return null;
	}
	
	// Returns if the battle has ended
	static boolean isItOver (IMobGeneric monster, IMobGeneric victim) {
		return false;
	}
}