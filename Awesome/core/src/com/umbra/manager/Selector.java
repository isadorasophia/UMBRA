package com.umbra.manager;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.umbra.manager.interfaces.*;
import com.umbra.manager.modes.InitialMode;
import com.umbra.manager.modes.Modes;
import com.umbra.manager.modes.ModesInstantiator;
import com.umbra.mapModule.IMap;
import com.umbra.mapModule.Position;
import com.umbra.mobModule.itemComponent.inter.IItem;
import com.umbra.mobModule.itemComponent.inter.IItemIlumination;
import com.umbra.mobModule.mobComponent.impl.Player;
import com.umbra.mobModule.mobComponent.impl.PlayerInstantiator;
import com.umbra.mobModule.mobComponent.inter.IMobManager;
import com.umbra.puzzlesModule.PuzzleFactory;
import com.umbra.vultoModule.IVulto;

import java.util.Vector;

@Component(
		id = "<http://purl.org/NET/dcc/com.umbra.manager.Selector>",
        provides = "<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.ISelector>",
		requires = {
                "<http://purl.org/NET/dcc/com.umbra.mobModule.mobComponent.inter.IMobManager>",
                "<http://purl.org/NET/dcc/com.umbra.vultoModule.Vulto>",
                "<http://purl.org/NET/dcc/com.umbra.com.umbra.vultoModule.IVulto>"
        }
)
public class Selector extends ComponentBase implements ISelectorComponent {

    static final int HPMAX = 100;

    private Characters characters = new Characters();
    private IMode mode;
    private IMobManager mobManager;
    private Modes state;
    private IComunicator comunicator;

    public void init() {
        ModesInstantiator.init();
        characters.setPlayer(mobManager.createPlayer("Player","",new Position(0,0)));
        characters.setMonstro(mobManager.createMonstro(1, new Position(3, 3)));
        characters.setPuzzle(new PuzzleFactory().getPuzzle());
        setMode(Modes.PUZZLE);
        comunicator = new TextComunicator();
    }

    public void setMode(Modes state){
        this.state = state;
        switch (state){
            case INITIAL:
                mode = ModesInstantiator.inicialModeInstance(characters);
                break;
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
        String playerInfo;

        // set player info
        playerInfo = "HP: " + (int)characters.getPlayer().getHealth() +  "/" + HPMAX + "  | XP: " + (int)characters.getPlayer().getXp() +
                "  | Level: " + characters.getPlayer().getNivel();
        comunicator.newText(playerInfo, 100, 50, Gdx.graphics.getWidth() - 200f, false);
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
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mode.draw();
        if(state != Modes.INITIAL && state != Modes.GAMEOVER) comunicator.draw();
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

