package com.umbra.manager;

import anima.annotation.Component;
import anima.component.IRequires;
import anima.component.base.ComponentBase;

import com.umbra.manager.interfaces.*;
import com.umbra.manager.modes.Modes;
import com.umbra.manager.modes.ModesInstantiator;
import com.umbra.mobModule.mobComponent.inter.IMobManager;
import com.umbra.mobModule.mobComponent.inter.IPlayer;
import com.umbra.vultoModule.IVulto;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.manager.Selector>",
		requires={"<http://purl.org/NET/dcc/com.umbra.mobModule.mobComponent.inter.IMobManager>",
        "<http://purl.org/NET/dcc/com.umbra.vultoModule.Vulto>"}
)
public class Selector extends ComponentBase implements ISelectorComponent {
    private Characters characters = new Characters();
    private IMode mode;
    private IMobManager mobManager;

    public void init() {
        characters.setPlayer(mobManager.createPlayer());
        characters.setMonstro(mobManager.createMonstro());
        setMode(Modes.BATLLE);
    }

    public void setMode(Modes state){
        switch (state){
            case BATLLE:
                mode = ModesInstantiator.battleModeInstance(characters);
                break;
            case MAZE:
                mode = ModesInstantiator.mazeModeInstance(characters);
                break;
            case PUZZLE:
                mode = ModesInstantiator.puzzleModeInstance(characters);
                break;
            case VULTO:
                mode = ModesInstantiator.vultoModeInstance(characters);
                ModesInstantiator.vultoModeReset(characters);
                break;
        }
    }
    public void update(float dt){
        if(characters.getVulto().checkVulto()){
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

    @Override
    public void connect(IVulto vulto) {
        characters.setVulto(vulto);
    }

    @Override
    public void connect(IMobManager mobManager) {
        this.mobManager = mobManager;
    }
}
