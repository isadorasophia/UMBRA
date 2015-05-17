package com.umbra.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class Comunicator {
    // Define constants
    static final int textSpeed = 5;

    // Flags
    private boolean cursor;

    private BitmapFont font;
    private SpriteBatch batch;
    private String text = "_";
    private String fullText;
    private int index;
    // counter of updates
    private float counter;

    public Comunicator(String fullText){

        this.fullText = fullText;
        counter = 0;
        index = 0;

        batch = new SpriteBatch();
        cursor = true;

        // initialize font
        try {
            font = new BitmapFont(Gdx.files.internal("Fonts/courier.fnt"));
        }catch (GdxRuntimeException e){
            font = new BitmapFont();
        }
        font.setColor(1,1,1,1);
    }

    public boolean addChar(float dt){
        // no more characters to add
        if(fullText.length()+1 == text.length()) return false;

        // Control of text speed
        counter += dt;
        if (counter > textSpeed * dt) {
            text = text.substring(0, text.length() - 1);
            text += fullText.charAt(index);
            text += '_';
            index++;
            counter = 0;
        }
        return true;
    }

    public void blink(float dt) {
        // blinking cursor
        counter += dt;
        if (counter > textSpeed  * dt) {
            if (cursor) text = text.substring(0, text.length() - 1);
            else text += '_';
            cursor ^= true;
            counter = 0;
        }
    }

    public void draw(){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if(text != null){
            font.draw(batch,text,100,Gdx.graphics.getHeight() - 50,600f,-5,true);
        }
        batch.end();
    }

    public void dispose(){
        batch.dispose();
        font.dispose();
    }
}
