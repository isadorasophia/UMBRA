package com.umbra.mobModule.mobComponent.impl;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.mapModule.inter.IPosition;
import com.umbra.mobModule.exceptions.BadConstructorException;
import com.umbra.mobModule.mobComponent.inter.IMobManager;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.mobModule.mobComponent.impl.MobManager>",
		provides={"<http://purl.org/NET/dcc/com.umbra.mobModule.mobComponent.inter.IMobManager>"}
)

/**
 * Classe que representa o componente que instancia o player e os monstros
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class MobManager extends ComponentBase implements IMobManager {
	
	public IPlayer createPlayer(String name, String description, IPosition position) {
		MobFactory factory = MobFactory.createFactory("Player");
		IPlayer player = null;
		
		try {
			player = factory.instantiate(name, description, position);
		} catch (BadConstructorException e) {
			player = null;
		}
		
		return player;
	}
	
	public IMonstro createMonstro(int nivel, IPosition position) {
		MobFactory factory = MobFactory.createFactory("Monstro");
		IMonstro monstro = null;
		
		try {
			monstro = factory.create(nivel, position);
		} catch (BadConstructorException e) {
			monstro = null;
		}
		
		return monstro;
	}
}
