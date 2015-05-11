package com.umbra.battleModule;

import com.umbra.mobModule.mobComponent.IMonstro;
import com.umbra.mobModule.mobComponent.IPlayer;

public interface IBattleManager {
	// Function which initializes the class for further use
	public void initialize (IPlayer player, IMonstro monster);
	
	// Function called by the main module, updates the output
	public void processInput (String input);
}