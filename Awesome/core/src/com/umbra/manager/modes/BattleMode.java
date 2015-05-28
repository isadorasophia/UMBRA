package com.umbra.manager.modes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.brashmonkey.spriter.Player;
import com.umbra.battleModule.BattleManager;
import com.umbra.manager.Characters;
import com.umbra.manager.TextComunicator;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.interfaces.IMode;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;
import com.umbra.vultoModule.UnknownInputException;

public class BattleMode implements IMode {
	IComunicator comunicator;
    Characters characters;
    IPlayer player;
    IMonstro monstro;
    BattleManager battlemanager;

    @Override
    public void init(IComunicator comunicator, Characters characters) {
        this.comunicator = comunicator;
        player = characters.getPlayer();
        monstro = characters.getMonstro();
        battlemanager = new BattleManager();
        battlemanager.initialize(player,monstro);
        comunicator.newText(battlemanager.getStatus());
    }

    @Override
    public void update(float dt) {
        if(comunicator.update(dt)) {
            String input = comunicator.getInput();
            if (input != null) {
                battlemanager.processInput(input);
                comunicator.newText(battlemanager.getStatus());
            }
        }
    }

    @Override
    public void draw() {
        comunicator.draw();
    }

    @Override
    public void handleInput() {
        Gdx.input.isKeyPressed(Keys.ANY_KEY);
    }

    @Override
    public void dispose() {

    }
}
