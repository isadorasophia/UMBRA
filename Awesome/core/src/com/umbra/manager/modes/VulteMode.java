package com.umbra.manager.modes;

import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.interfaces.IMode;
import com.umbra.vultoModule.IVulto;
import com.umbra.vultoModule.UnknownInputException;

public class VulteMode implements IMode {
    IComunicator comunicator;
    IVulto vulto;
    StringBuilder result = new StringBuilder(); 
    String text = "The mysterious figure is about to find you. What you do... [F]ace the figure, [H]ide or [R]un.";
    boolean isAlive;
    
    @Override
    public void init(IComunicator comunicator, Characters characters) {
        this.comunicator = comunicator;
        this.vulto = characters.getVulto();
        comunicator.newText(text);
        isAlive = true;
    }

    @Override
    public void update(float dt) {
        if(comunicator.update(dt)) {
            String input = comunicator.getInput();
            if (input != null) {
                try {
                	result.delete(0, result.length());
                    isAlive = vulto.chooseAction(input,result);
                    comunicator.newText(result.toString());
                } catch (UnknownInputException e) {
                    comunicator.newText(" I don't understand this command :");
                }
            }
        }
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
