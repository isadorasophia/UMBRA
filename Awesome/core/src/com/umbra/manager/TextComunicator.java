package com.umbra.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.umbra.manager.interfaces.IComunicator;

public class TextComunicator implements IComunicator, InputProcessor {
    // Define constants
    static final int textSpeed = 1;

    // Flags
    private boolean cursor;
    boolean end; // true when the text is written entirely
    boolean inputReady;
    boolean readInput;
    
    private float hight;
    private BitmapFont font;
    private SpriteBatch batch;
    private String text;
    private String fullText;
    private int index;
    StringBuilder input;
    // counter of updates
    private float counter;

    public TextComunicator(){
        batch = new SpriteBatch();

        // initialize font
        try {
            font = new BitmapFont(Gdx.files.internal("Fonts/proggy.fnt"));
        }catch (GdxRuntimeException e){
        	font = new BitmapFont();
        }
        font.setColor(1,1,1,1);

        newText("");
        Gdx.input.setInputProcessor(this);
    }

    public void newText(String fullText){
        this.fullText = fullText;
        counter = 0;
        index = 0;
        text = "_";
        cursor = true;
        inputReady = false;
        readInput = false;
        end = false;
        input = new StringBuilder();
        hight = Gdx.graphics.getHeight() - 50;
    }
    
    public String getInput(){
    	readInput = true;
    	if(inputReady){
    		return input.substring(0,input.length() - 1);
    	}else{
    		return null;
    	}
    }

    public boolean update(float dt){
        end = end || (fullText.length() + 1 == text.length());
        // Control of text speed
        counter += dt;
        if (counter > textSpeed * dt) {
            if (!end) {
                nextChar(dt);
            } else {
                // no more characters to add start blink cursor
                blink(dt);
            }
            counter = 0;
        }
        return end;
    }

    public void addChar(char c){
    	if(end){
    		text = text.substring(0, text.length() - 1);
            text += c;
            text += '_';
    	}
    }
    
    private void nextChar(float dt){
        text = text.substring(0, text.length() - 1);
        text += fullText.charAt(index);
        text += '_';
        index++;
    }

    private void blink(float dt) {
        text = text.substring(0, text.length() - 1);
        if (cursor) text += ' ';
        else text += '_';
        cursor ^= true;
    }

    public void draw(){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if(text != null){
        	if(hight - 100 - ((font.getCapHeight()*text.length())/(Gdx.graphics.getWidth() - 300))*font.getCapHeight() < 0) hight += font.getCapHeight();
        	font.draw(batch,text,100,hight,Gdx.graphics.getWidth() - 200,-5,true);
        }
        batch.end();
    }

    public void dispose(){
        batch.dispose();
        font.dispose();
    }
    
    @Override
	public boolean keyTyped(char character) {
		if(readInput){ 
			input.append(character);
			addChar(character);
		}
		return false;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(readInput){
            if(keycode == Input.Keys.ENTER) inputReady = true;
            if(keycode == Input.Keys.BACKSPACE){
                input = new StringBuilder();
                text = fullText + ( (cursor) ? "_" : " ");
            }
		}
		return false;
	}

	/* unused methods of InputProcessor */
	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
