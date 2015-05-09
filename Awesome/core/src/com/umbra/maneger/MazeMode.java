package com.umbra.maneger;

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
    private boolean beginning;
    private String initialText;
    private FileReader reader;
    private static String dir = MazeMode.class.getResource(".").getPath() + "/";
    private float conter;
    private BitmapFont font;
    private SpriteBatch batch;
    private boolean eof;

    @Override
    public void init() {
        try {
            reader = new FileReader("Textos/initialText.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        batch = new SpriteBatch();
        beginning = true;
        eof = true;
        conter = 0;
        font = new BitmapFont();
        font.setColor(Color.BLUE);
    }

    @Override
    public void update(float dt) {
        if(beginning){
            conter++;
            if(conter == 100*dt) {
                if(!eof) beginning = false;
                else {
                    conter = 0;
                    try {
                        int a = reader.read();
                        if (a != -1) initialText += reader.read();
                        else{
                            eof = false;
                            reader.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{
        }
    }

    @Override
    public void draw() {
        batch.begin();
        if(beginning){
            if(initialText != null) font.draw(batch,initialText,0, 0);
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
