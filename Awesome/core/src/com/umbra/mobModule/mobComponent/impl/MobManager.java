package com.umbra.mobModule.mobComponent.impl;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.mobModule.exceptions.BadConstructorException;
import com.umbra.mobModule.mobComponent.inter.IMobManager;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.mobModule.mobComponent.impl.MobManager>",
		provides={"<http://purl.org/NET/dcc/com.umbra.mobModule.mobComponent.inter.IMobManager>"}
)

public class MobManager extends ComponentBase implements IMobManager {
	
	public IPlayer createPlayer() {
		MobFactory factory = MobFactory.createFactory("Player");
		IPlayer player = null;
		
		try {
			player = factory.getInstance("Player", "Jogador teste", null);
		} catch (BadConstructorException e) {
			e.printStackTrace();
		}
		
		return player;
	}
	
	public IMonstro createMonstro() {
		MobFactory factory = MobFactory.createFactory("Monstro");
		IMonstro monstro = null;
		
		try {
			monstro = factory.create(1, null);
		} catch (BadConstructorException e) {
			e.printStackTrace();
		}
		
		return monstro;
	}
}
