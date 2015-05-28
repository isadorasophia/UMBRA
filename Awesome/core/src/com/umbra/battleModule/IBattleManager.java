package com.umbra.battleModule;

import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;
import anima.annotation.ComponentInterface;
import anima.component.ISupports;

@ComponentInterface (
		value = "<http://purl.org/NET/dcc/com.umbra.battleModule.BattleManager>"
)

public interface IBattleManager extends ISupports{
	// function which initializes the class for further use
	public void initialize (IPlayer player, IMonstro monster);
	
	// function called by the main module, updates the output
	public void processInput (String input);
	
	// in order to keep in track with the battle status
	public boolean getDone ();
	public String getStatus ();
}