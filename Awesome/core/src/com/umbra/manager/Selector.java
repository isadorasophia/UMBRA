package com.umbra.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Selector implements ISelector{
    private IMode mode;

    public Selector(){
        setMode(Modes.MAZE);
    }

    public void setMode(Modes state){
        if(mode != null) mode.dispose();
        switch (state){
            case BATLLE:
                mode = new BattleMode();
                break;
            case MAZE:
                mode = new MazeMode();
                break;
            case PUZZLE:
                mode = new PuzzleMode();
                break;
            case VULTO:
                mode = new VulteMode();
                break;
        }
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mode.init();
    }
    public void update(float dt){
        mode.handleInput();
        mode.update(dt);
    }
    public void draw(){
        mode.draw();
    }
    public void dispose(){
        mode.dispose();
    }
}
