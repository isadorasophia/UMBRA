package com.umbra.manager.modes;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.umbra.battleModule.IBattleManager;
import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.interfaces.IMode;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;
import com.umbra.puzzlesModule.IPuzzle;


@Component(
        id="<http://purl.org/NET/dcc/com.umbra.manager.modes.PuzzleMode>",
        provides="<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IMode>"
)
public class PuzzleMode extends ComponentBase implements IMode {

    IComunicator comunicator;
    Characters characters;
    IPuzzle puzzle;

    // Flags
    boolean modeOn; // Continue in the mode
    boolean end; // Actions ere over
    boolean done; // Last text already written


    @Override
    public void init(IComunicator comunicator, Characters characters) {
    	this.comunicator = comunicator;
        modeOn = true;
        end = false;
        done = false;
        puzzle = characters.getPuzzle();
        comunicator.newText(puzzle.init(characters.getPlayer()),100, Gdx.graphics.getHeight() - 50, Gdx.graphics.getWidth() - 200f, true);
    }

    @Override
    public Modes update(float dt) {
        Modes next_mode = Modes.PUZZLE;
        String new_text;

        if(comunicator.update(dt)) {
            if(!end) {
                String input = comunicator.getInput();
                if (input != null) {
                    new_text = puzzle.inputMsg(input);
                    if(new_text == "This puzzle is over!") end = true;
                    else comunicator.newText(new_text, 100, Gdx.graphics.getHeight() - 50, Gdx.graphics.getWidth() - 200f, true);
                }
            }else{
                done = true;
                if(!modeOn) {
                    next_mode = Modes.MAZE;
                }
            }
        }
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
