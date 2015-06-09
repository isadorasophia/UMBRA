package com.umbra.manager.modes;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.umbra.Exceptions.InputException;
import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.interfaces.IMode;
import com.umbra.mobModule.mobComponent.inter.IPlayer;
import com.umbra.vultoModule.IVulto;


@Component(
        id="<http://purl.org/NET/dcc/com.umbra.manager.modes.VulteMode>",
        provides="<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IMode>"
)
public class VulteMode extends ComponentBase implements IMode {

    IComunicator comunicator;
    IVulto vulto;
    IPlayer player;
    StringBuilder result = new StringBuilder(); 
    String text = "Everything becomes, suddenly, colder. A presence comes to you, the breathing thing. " +
            "It does not appear to be friendly - although you can’t see it, it seems to be hostile and terrifying. " +
            "You must do something. Quick. What you do... [F]ace the figure, [H]ide or [R]un.";

    // Flags
    boolean isAlive;
    boolean modeOn; // Continue in the mode
    boolean end; // Actions ere over
    boolean done; // Last text already written

    @Override
    public void init(IComunicator comunicator, Characters characters) {
        this.comunicator = comunicator;
        this.vulto = characters.getVulto();
        this.player = characters.getPlayer();
        comunicator.newText(text, 100, Gdx.graphics.getHeight() - 50, Gdx.graphics.getWidth() - 200f, true);
        isAlive = true;
        modeOn = true;
        end = false;
    }

    @Override
    public Modes update(float dt) {
        Modes next_mode = Modes.VULTO;
        if (comunicator.update(dt)) {
            if (!end) {
                String input = comunicator.getInput();
                if (input != null) {
                    try {
                        result.delete(0, result.length());
                        isAlive = vulto.chooseAction(input, result, player.getAtt("luck").getValue());
                        end = true;
                        comunicator.newText(result.toString(), 100, Gdx.graphics.getHeight() - 50, Gdx.graphics.getWidth() - 200f, true);
                    } catch (InputException e) {
                        comunicator.newText(e.getMessage(), 100, Gdx.graphics.getHeight() - 50, Gdx.graphics.getWidth() - 200f, true);
                    }
                }
            } else {
                done = true;
                if(!modeOn) {
                    if (isAlive) next_mode = Modes.MAZE;
                    else next_mode = Modes.GAMEOVER;
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
