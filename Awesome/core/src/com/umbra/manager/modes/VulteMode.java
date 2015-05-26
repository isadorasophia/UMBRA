package com.umbra.manager.modes;

import com.umbra.manager.IComunicator;
import com.umbra.manager.Singletons.VultoSingleton;
import com.umbra.vultoModule.IVulto;
import com.umbra.vultoModule.UnknownInputException;

public class VulteMode implements IMode{
    IComunicator comunicator;
    IVulto vulto;
    String text = "vulto command :";

    @Override
    public void init(IComunicator comunicator) {
        this.comunicator = comunicator;
        vulto = VultoSingleton.instance();
        comunicator.setText(text);
    }

    @Override
    public void update(float dt) {
        if(comunicator.update(dt)) {
            String input = comunicator.getInput();
            if (input != null) {
                try {
                    vulto.chooseAction(input);
                } catch (UnknownInputException e) {
                    comunicator.setText(" I don't understand this command :");
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
