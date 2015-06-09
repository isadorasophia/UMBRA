package com.umbra.manager.modes;

import anima.annotation.Component;
import anima.component.base.ComponentBase;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.interfaces.IMode;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.manager.modes.InicialMode>",
        provides="<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IMode>"
)
public class InitialMode extends ComponentBase implements IMode {

    IComunicator comunicator;

    // Flags
    private boolean beginning;
    private boolean eof;
    private boolean modeon;

    private String initialText = "";
    private FileReader reader;

    @Override
    public void init(IComunicator comunicator, Characters characters) {
        beginning = true;
        eof = false;
        modeon = true;

        try {
            reader = new FileReader("Textos/initialText.txta");
            int a = -1;
            do {
                a = reader.read();
                initialText += (char) a;
            } while (a != -1);    // a == -1 at eof
            reader.close();
        } catch (FileNotFoundException e) {
            initialText = "";
        } catch (IOException e) {
            initialText = "";
        }

        this.comunicator = comunicator;
        this.comunicator.newText("Umbra", Gdx.graphics.getWidth()/2 - 50, Gdx.graphics.getHeight()/2 + 50, Gdx.graphics.getWidth() - 200, true);
    }

    @Override
    public Modes update(float dt) {
        Modes newMode = Modes.INITIAL;

        // First Text update
        if(comunicator.update(dt)) eof = true;
        if(!modeon) return Modes.MAZE;
        return newMode;
    }

    @Override
    public void draw() {
        comunicator.draw();
    }

    @Override
    public void handleInput() {

        // wait press enter to exit first text
        if(modeon && eof && Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            if(beginning){
                beginning = false;
                comunicator.newText(initialText, 100, Gdx.graphics.getHeight() - 50, Gdx.graphics.getWidth() - 200f, true);
                eof = false;
            }else modeon = false;
        }
    }

    @Override
    public void dispose() {
        comunicator.dispose();
    }

}
