package com.umbra.manager;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.umbra.manager.interfaces.*;
import com.umbra.manager.modes.Modes;
import com.umbra.manager.modes.ModesInstantiator;
import com.umbra.mapModule.impl.Position;
import com.umbra.mobModule.itemComponent.inter.IItemIlumination;
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

    private Sprite ret;
    private SpriteBatch batch;
    private Characters characters = new Characters();
    private IMode mode;
    private IMobManager mobManager;
    private Modes state;
    private IComunicator comunicator;

    public void init() {
        ModesInstantiator.init();
        characters.setPlayer(mobManager.createPlayer("you","",new Position(0,0)));
        characters.setMonstro(mobManager.createMonstro(1, new Position(3, 3)));
        setMode(Modes.INITIAL);
        comunicator = new TextComunicator();
        batch = new SpriteBatch();
        ret = new Sprite(new Texture(Gdx.graphics.getWidth()*10,30, Pixmap.Format.RGB565));
        ret.setColor(0, 0, 0, 1);
        ret.setPosition(Gdx.graphics.getWidth() - ret.getWidth(),Gdx.graphics.getHeight() - ret.getHeight());
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

    public boolean update(float dt){
        Modes next;
        String playerInfo;
        boolean reset = false;

        // set player info
        playerInfo = "HP: " + (int)characters.getPlayer().getHealth() +  "/" + characters.getPlayer().getAtt("hp").getMax() + "  | XP: " + (int)characters.getPlayer().getXp() +
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
        mode.handleInput();
        next = mode.update(dt);
        if(next == Modes.RESET) reset = true;
        else if(next != state) setMode(next);
        return reset;
    }

    public void draw(){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mode.draw();
        if(state != Modes.INITIAL && state != Modes.GAMEOVER) comunicator.draw();
        batch.begin();
        ret.draw(batch);
        batch.end();
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

