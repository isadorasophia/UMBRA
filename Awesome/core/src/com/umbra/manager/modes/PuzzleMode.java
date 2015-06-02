package com.umbra.manager.modes;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.battleModule.IBattleManager;
import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.interfaces.IMode;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;


@Component(
        id="<http://purl.org/NET/dcc/com.umbra.manager.modes.PuzzleMode>",
        provides="<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IMode>"
)
public class PuzzleMode extends ComponentBase implements IMode {
	IComunicator comunicator;
    Characters characters;
    IPlayer player;

    // Flags
    boolean isAlive;
    boolean modeOn; // Continue in the mode
    boolean end; // Actions ere over
    boolean done; // Last text already written
	
    @Override
    public void init(IComunicator comunicator, Characters characters) {
    	this.comunicator = comunicator;
        player = characters.getPlayer();
        comunicator.newText("");
        isAlive = true;
        modeOn = true;
        end = false;
        done = false;
    }

    @Override
    public Modes update(float dt) {
        return Modes.PUZZLE;
    }

    @Override
    public void draw() {

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {

    }
}
