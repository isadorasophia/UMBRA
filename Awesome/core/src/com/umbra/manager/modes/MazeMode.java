package com.umbra.manager.modes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.umbra.manager.IComunicator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MazeMode implements IMode{
    IComunicator comunicator;

    // Flags
    private boolean beginning;
    private boolean eof;

    private String initialText = "";
    private FileReader reader;

    @Override
    public void init(IComunicator comunicator) {
        beginning = true;
        eof = false;

        try {
            reader = new FileReader("Textos/initialText.txt");
        } catch (FileNotFoundException e) {
            beginning = false;
        }
        int a = -1;
        try {
            do{
                a = reader.read();
                initialText += (char)a;
            }while(a != -1);    // a == -1 at eof
            reader.close();
        } catch (IOException e) {
            beginning = false;
        }

        this.comunicator = comunicator;
        this.comunicator.setText(initialText);
    }

    @Override
    public void update(float dt) {

        // First Text update
        if(beginning) {
            if(!comunicator.update(dt)) eof = true;
        }

        // Maze update
        else{
        }

    }

    @Override
    public void draw() {

        // First text draw
        if(beginning){
            comunicator.draw();
        }

        // Maze draw
        else {
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        }

    }

    @Override
    public void handleInput() {

        // wait press enter to exit first text
        if(beginning && eof && Gdx.input.isKeyPressed(Input.Keys.ENTER)) beginning = false;

    }

    @Override
    public void dispose() {
        comunicator.dispose();
    }
}
