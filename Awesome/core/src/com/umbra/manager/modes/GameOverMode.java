package com.umbra.manager.modes;

import anima.annotation.Component;
import anima.component.base.ComponentBase;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.interfaces.IMode;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.manager.modes.GameOverMode>",
        provides="<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IMode>"
)
public class GameOverMode extends ComponentBase implements IMode {
    private IComunicator comunicator;

    // Flags
    boolean modeOn; // Continue in the mode
    boolean done; // Last text already written

    @Override
    public void init(IComunicator comunicator, Characters characters) {
        this.comunicator = comunicator;
        comunicator.newText("GAME OVER");
        done = false;
        modeOn = true;
    }

    @Override
    public Modes update(float dt) {
        Modes next_mode = Modes.GAMEOVER;

        if(comunicator.update(dt)) done = true;
        if(!modeOn) next_mode = Modes.MAZE;
        return next_mode;
    }

    @Override
    public void draw() {
        comunicator.draw();
    }

    @Override
    public void handleInput() {
        // wait press enter to exit Mode
        if(done && Gdx.input.isKeyPressed(Input.Keys.ENTER)) modeOn = false;
    }

    @Override
    public void dispose() {

    }
}
