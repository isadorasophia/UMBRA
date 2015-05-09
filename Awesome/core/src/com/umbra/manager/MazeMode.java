package com.umbra.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MazeMode implements IMode{
    private static String dir = MazeMode.class.getResource(".").getPath() + "/";
    // Flags
    private boolean beginning;
    private boolean eof;

    private String initialText;
    private FileReader reader;
    private BitmapFont font;
    private SpriteBatch batch;

    private float counter;

    @Override
    public void init() {
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        try {
            reader = new FileReader("Textos/initialText.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        batch = new SpriteBatch();
        beginning = true;
        eof = false;
        counter = 0;
        font = new BitmapFont(Gdx.files.internal("Fonts/courier.fnt"));
        font.setColor(1,1,1,1);
    }

    @Override
    public void update(float dt) {
        if(beginning){
            counter++;
            if(counter == 10) {
                if(eof) beginning = false;
                else {
                    counter = 0;
                    int a = -1;
                    try {
                        a = reader.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (a != -1) {
                        initialText += (char)a;
                    }else{
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
        }else{
        }
    }

    @Override
    public void draw() {
        batch.begin();
        if(beginning){
            if(initialText != null){
                font.draw(batch,initialText,100,Gdx.graphics.getHeight() - 50,600f,-5,true);
            }
        } else {

        }
        batch.end();
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void dispose() {

    }
}
