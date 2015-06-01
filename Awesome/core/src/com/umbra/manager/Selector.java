package com.umbra.manager;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.manager.interfaces.*;
import com.umbra.manager.modes.Modes;
import com.umbra.manager.modes.ModesInstantiator;
import com.umbra.mobModule.itemComponent.inter.IItem;
import com.umbra.mobModule.itemComponent.inter.IItemIlumination;
import com.umbra.mobModule.mobComponent.inter.IMobManager;
import com.umbra.vultoModule.IVulto;

import java.util.Vector;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.manager.Selector>",
		requires={"<http://purl.org/NET/dcc/com.umbra.mobModule.mobComponent.inter.IMobManager>",
        "<http://purl.org/NET/dcc/com.umbra.vultoModule.Vulto>"}
)
public class Selector extends ComponentBase implements ISelectorComponent {
    private Characters characters = new Characters();
    private IMode mode;
    private IMobManager mobManager;
    Modes state;

    public void init() {
        ModesInstantiator.init();
        characters.setPlayer(mobManager.createPlayer());
        characters.setMonstro(mobManager.createMonstro());
        setMode(Modes.BATLLE);
    }

    public void setMode(Modes state){
        this.state = state;
        switch (state){
            case BATLLE:
                mode = ModesInstantiator.battleModeInstance(characters);
                ModesInstantiator.battleModeReset(characters);
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
            case GAMEOVER:
                mode = ModesInstantiator.gameOverModeInstance(characters);
                ModesInstantiator.gameOverModeReset(characters);
        }
    }
    public void update(float dt){
        Modes next;

        // Consider light influence on vulto
        double light = 0;
        Vector<String> lightItems = characters.getPlayer().itemsIlumination();
        for(String s : lightItems){
            IItemIlumination item = (IItemIlumination) characters.getPlayer().dropItem(s);
            light += item.getIlumination();
        }
        characters.getVulto().lightInterference(light);
        if(this.state != Modes.BATLLE && this.state != Modes.VULTO && characters.getVulto().checkVulto()) {
            setMode(Modes.VULTO);
        }
        mode.handleInput();
        next = mode.update(dt);
        if(next != state) setMode(next);
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
