package com.umbra.manager.modes;

import anima.annotation.Component;
import anima.component.base.ComponentBase;
import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.interfaces.IMode;


@Component(
        id="<http://purl.org/NET/dcc/com.umbra.manager.modes.PuzzleMode>",
        provides="<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IMode>"
)
public class PuzzleMode extends ComponentBase implements IMode {

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
