package com.umbra.manager.modes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.umbra.manager.IComunicator;

public class BattleMode implements IMode {
	IComunicator comunicator;
	
    @Override
    public void init(IComunicator comunicator) {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void draw() {

    }

    @Override
    public void handleInput() {
        Gdx.input.isKeyPressed(Keys.ANY_KEY);
    }

    @Override
    public void dispose() {

    }
}