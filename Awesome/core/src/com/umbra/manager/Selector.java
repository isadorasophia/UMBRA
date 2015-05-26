package com.umbra.manager;

import anima.annotation.Component;
import anima.context.exception.ContextException;
import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;
import anima.factory.exception.FactoryException;

import com.sun.jndi.toolkit.ctx.ComponentContext;
import com.umbra.manager.Singletons.MobManagerSingleton;
import com.umbra.manager.Singletons.VultoSingleton;
import com.umbra.manager.modes.IMode;
import com.umbra.manager.modes.Modes;
import com.umbra.manager.modes.ModesInstantiator;
import com.umbra.mobModule.mobComponent.inter.IMobManager;
import com.umbra.mobModule.mobComponent.inter.IPlayer;
import com.umbra.vultoModule.IVulto;

public class Selector implements ISelector{
    private IMode mode;
    private IVulto vulto;
    private IPlayer player;
    private IMobManager mobManeger;

    public void init(){
    	mobManeger = MobManagerSingleton.instance();
        vulto = VultoSingleton.instance();
        player = mobManeger.createPlayer();
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
