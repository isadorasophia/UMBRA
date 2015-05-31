package com.umbra.manager.modes;

import anima.annotation.Component;
import anima.component.base.ComponentBase;
import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.interfaces.IMode;
import com.umbra.mobModule.mobComponent.inter.IPlayer;
import com.umbra.vultoModule.IVulto;
import com.umbra.vultoModule.UnknownInputException;
import com.umbra.vultoModule.Vulto;


@Component(
        id="<http://purl.org/NET/dcc/com.umbra.manager.modes.VulteMode>",
        provides="<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IMode>"
)
public class VulteMode extends ComponentBase implements IMode {
    IComunicator comunicator;
    IVulto vulto;
    IPlayer player;
    StringBuilder result = new StringBuilder(); 
    String text = "The mysterious figure is about to find you. What you do... [F]ace the figure, [H]ide or [R]un.";
    boolean isAlive;
    boolean modeOn;
    
    @Override
    public void init(IComunicator comunicator, Characters characters) {
        this.comunicator = comunicator;
        this.vulto = characters.getVulto();
        this.player = characters.getPlayer();
        comunicator.newText(text);
        isAlive = true;
        modeOn = true;
    }

    @Override
    public Modes update(float dt) {
        Modes next_mode = Modes.VULTO;
        if (comunicator.update(dt)) {
            if (modeOn) {
                String input = comunicator.getInput();
                if (input != null) {
                    try {
                        result.delete(0, result.length());
                        isAlive = vulto.chooseAction(input, result, player.getAtt("luck").getValue());
                        modeOn = false;
                        comunicator.newText(result.toString());
                    } catch (UnknownInputException e) {
                        comunicator.newText(" I don't understand this command :");
                    }
                }
            } else {
                if (isAlive) next_mode = Modes.MAZE;
                else next_mode = Modes.GAMEOVER;
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

    }

    @Override
    public void dispose() {

    }
}
