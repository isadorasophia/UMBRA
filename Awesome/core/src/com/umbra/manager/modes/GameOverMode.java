package com.umbra.manager.modes;

import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.interfaces.IMode;

public class GameOverMode implements IMode {
    private IComunicator comunicator;

    @Override
    public void init(IComunicator comunicator, Characters characters) {
        this.comunicator = comunicator;
        comunicator.newText("GAME OVER");
    }

    @Override
    public Modes update(float dt) {
        Modes next_mode = Modes.GAMEOVER;
        if(comunicator.update(dt)) next_mode = Modes.MAZE;
        return next_mode;
    }

    @Override
    public void draw() {
        comunicator.draw();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {

    }
}
