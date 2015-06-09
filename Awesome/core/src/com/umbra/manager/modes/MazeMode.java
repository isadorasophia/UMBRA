package com.umbra.manager.modes;

import anima.annotation.Component;
import anima.component.base.ComponentBase;
import com.badlogic.gdx.Gdx;
import com.umbra.manager.Characters;
import com.umbra.manager.TextComunicator;
import com.umbra.manager.interfaces.IMapModeComponent;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.mapModule.ICell;
import com.umbra.mapModule.IMap;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

import java.lang.StringBuilder;

@Component(
		id = "<http://purl.org/NET/dcc/com.umbra.manager.modes.MazeMode>",
        provides = "<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IMode>",
        requires = "<http://purl.org/NET/dcc/com.umbra.com.umbra.mapModule.IMap>"
)
public class MazeMode extends ComponentBase implements IMapModeComponent {

    private int range = 3;
    private IComunicator comunicatorMap, comunicatorComand;
    private Characters characters;
    private IMap map;
    private ICell cells[][];
    StringBuilder mapString = new StringBuilder();

    @Override
    public void init(IComunicator comunicator, Characters characters) {
        this.comunicatorMap = comunicator;
        this.comunicatorComand = new TextComunicator();
        comunicatorComand.newText("You are limited to move [W] up, [S] down, [A] left and [D] right. Where you go: ", 100, 150, Gdx.graphics.getWidth() - 200f, true);
        this.characters = characters;
        map.init(characters.getPlayer());
    }

    @Override
    public Modes update(float dt) {
        IPlayer player = characters.getPlayer();
        Modes next_mode = Modes.MAZE;

        // Update Map
        mapString.delete(0, mapString.length());
        cells = map.getCell(player.getPosition() ,range);
        for(ICell[] cellRow : cells)
            for(ICell cell : cellRow){
                if(cell == null) mapString.append("#");
                else mapString.append(cell.getDescription());
            }
        comunicatorMap.newText(mapString.toString(), Gdx.graphics.getWidth()/2 - 150, Gdx.graphics.getHeight()/2 + 150,
                range, false);

        // Manager Text Output and Input
        String new_text = "You are limited to move [W] up, [S] down, [A] left and [D] right. Where you go: ";
        if(comunicatorComand.update(dt)) {
            String input = comunicatorComand.getInput();
            if(characters.getVulto().checkVulto()) next_mode = Modes.VULTO;
            if (input != null) {
                ICell cell = map.move(player,input);
                if(cell == null) new_text = "aaYou can't go there: ";
                else switch (cell.getDescription()){
                    case '#':
                        new_text = "You can't go there. You are limited to move [W] up, [S] down, [A] left and [D] right: ";
                        break;
                    case '[':
                        characters.setPuzzle(cell.getDoor());
                        next_mode = Modes.PUZZLE;
                        break;
                    case '.':
                        break;
                    default:
                        characters.setMonstro((IMonstro)cell.getMob());
                        next_mode = Modes.BATLLE;
                }
                if(next_mode == Modes.MAZE) comunicatorComand.newText(new_text, 150, 100, Gdx.graphics.getWidth() - 200f, true);
            }
        }
        return next_mode;
    }

    @Override
    public void draw() {
        comunicatorMap.draw();
        comunicatorComand.draw();
    }

    @Override
    public void handleInput() {
    }

    @Override
    public void dispose() {
        comunicatorMap.dispose();
        comunicatorComand.dispose();
    }

    @Override
    public void connect(IMap map) {
        this.map = map;
    }

}
