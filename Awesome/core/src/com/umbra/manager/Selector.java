package com.umbra.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.umbra.vultoModule.IVulto;
import com.umbra.vultoModule.VultoSingleton;

public class Selector implements ISelector{
    private IMode mode;
    private IVulto vulto;

    public void init(){
        vulto = VultoSingleton.instance();
        setMode(Modes.MAZE);
    }

    public void setMode(Modes state){
        switch (state){
            case BATLLE:
                mode = ModesInstantiator.battleModeInstance();
                break;
            case MAZE:
                mode = ModesInstantiator.mazeModeInstance();
                break;
            case PUZZLE:
                mode = ModesInstantiator.puzzleModeInstance();
                break;
            case VULTO:
                mode = ModesInstantiator.vultoModeInstance();
                ModesInstantiator.vultoModeReset();
                break;
        }
    }
    public void update(float dt){
        if(vulto.checkVulto()){
            setMode(Modes.VULTO);
        }
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
