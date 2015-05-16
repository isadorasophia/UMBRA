package com.umbra.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.umbra.vultoModule.IVulto;
import com.umbra.vultoModule.VultoSingleton;

public class Selector implements ISelector{
    private IMode mode;
    private ModesInstantiator instantiator;
    private VultoSingleton vultoSingleton;
    private IVulto vulto;

    public Selector(){
        instantiator = new ModesInstantiator();
        vultoSingleton = new VultoSingleton();
        vulto = vultoSingleton.instance();
        setMode(Modes.MAZE);
    }

    public void setMode(Modes state){
        switch (state){
            case BATLLE:
                mode = instantiator.battleModeInstance();
                break;
            case MAZE:
                mode = instantiator.mazeModeInstance();
                break;
            case PUZZLE:
                mode = instantiator.puzzleModeInstance();
                break;
            case VULTO:
                mode = instantiator.vultoModeInstance();
                instantiator.vultoModeReset();
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
