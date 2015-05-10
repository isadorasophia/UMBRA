package com.umbra.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.xml.soap.Text;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MazeMode implements IMode{
    // Define constants
    static final int textSpeed = 10;

    // Flags
    private boolean beginning;
    private boolean eof;
    private boolean cursor;

    private String initialText = "_";
    private FileReader reader;
    private BitmapFont font;
    private SpriteBatch batch;
    // counter of updates
    private float counter;

    @Override
    public void init() {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch = new SpriteBatch();

        try {
            reader = new FileReader("Textos/initialText.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // initialize font
        font = new BitmapFont(Gdx.files.internal("Fonts/courier.fnt"));
        font.setColor(1,1,1,1);

        beginning = true;
        eof = false;
        cursor = true;

        counter = 0;
    }

    @Override
    public void update(float dt) {

        // First Text update
        if(beginning) {
            counter += dt;
            if (counter > textSpeed*dt) {

                // blinking cursor
                if (eof) {
                    if (cursor) initialText = initialText.substring(0, initialText.length() - 1);
                    if (!cursor) initialText += '_';
                    cursor ^= true;
                }

                // add one letter
                else {
                    int a = -1;
                    try {
                        a = reader.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // a == -1 at eof
                    if (a != -1) {
                        initialText = initialText.substring(0, initialText.length() - 1);
                        initialText += (char) a;
                        initialText += '_';
                    } else {
                        eof = true;
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                counter = 0;
            }
        }

        // Maze update
        else{}

    }

    @Override
    public void draw() {
        batch.begin();

        // First text draw
        if(beginning){
            if(initialText != null){
                font.draw(batch,initialText,100,Gdx.graphics.getHeight() - 50,600f,-5,true);
            }
        }

        // Maze draw
        else {}

        batch.end();
    }

    @Override
    public void handleInput() {

        // wait press enter to exit first text
        if(beginning && eof && Gdx.input.isKeyPressed(Input.Keys.ENTER)) beginning = false;

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
