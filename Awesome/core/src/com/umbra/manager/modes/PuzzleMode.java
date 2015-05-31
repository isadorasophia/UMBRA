package com.umbra.manager.modes;

import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.interfaces.IMode;

public class PuzzleMode implements IMode {

    @Override
    public void init(IComunicator comunicator, Characters characters) {

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
