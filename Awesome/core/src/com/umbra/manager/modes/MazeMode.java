package com.umbra.manager.modes;

import anima.annotation.Component;
import anima.component.base.ComponentBase;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.*;
import com.umbra.manager.Characters;
import com.umbra.manager.TextComunicator;
import com.umbra.manager.interfaces.IMapModeComponent;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.mapModule.ICell;
import com.umbra.mapModule.IMap;
import com.umbra.mapModule.Map;
import com.umbra.mapModule.Position;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

import java.lang.StringBuilder;

@Component(
		id = "<http://purl.org/NET/dcc/com.umbra.manager.modes.MazeMode>",
        provides = "<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IMode>",
        requires = "<http://purl.org/NET/dcc/com.umbra.com.umbra.mapModule.IMap>"
)
public class MazeMode extends ComponentBase implements IMapModeComponent {

    private int range = 2;
    private IComunicator comunicatorMap, comunicatorComand;
    private IPlayer player;
    private IMap map;
    private ICell cells[][];
    StringBuilder mapString;

    // Flags
    boolean modeOn; // Continue in the mode
    boolean end; // Actions ere over
    boolean done; // Last text already written

    @Override
    public void init(IComunicator comunicator, Characters characters) {
        this.comunicatorMap = comunicator;
        this.comunicatorComand = new TextComunicator();
        comunicatorComand.newText("Where you go: ", 100, 200, Gdx.graphics.getWidth() - 200f, true);
        player = characters.getPlayer();
        map = Map.getInstance(player);
        modeOn = true;
        end = false;
        done = false;
    }

    @Override
    public Modes update(float dt) {
        Modes next_mode = Modes.MAZE;

        // Update Map
        //cells = map.getCell(new Position(5,2), range);
        //for(ICell[] cellRow : cells)
        //    for(ICell cell : cellRow){
        //        mapString.append(cell.getDescription());
        //    }
        //comunicator.newText(mapString.toString(), Gdx.graphics.getWidth()/2 - 300, Gdx.graphics.getHeight()/2 - 300,
        //        range, false);

        // Manager Text Output and Input


        if(comunicatorComand.update(dt)) {
            if(!end) {
                String input = comunicatorComand.getInput();
                if (input != null) {
                    //map.move(player,input);
                    comunicatorComand.newText("Where you go: ", 100, 200, Gdx.graphics.getWidth() - 200f, true);
                }
            }else{
                done = true;
                if(!modeOn) {
                    if (player.dead()) next_mode = Modes.GAMEOVER;
                    else next_mode = Modes.MAZE;
                }
            }
        }
        return next_mode;
    }

    @Override
    public void draw() {
        //comunicatorMap.draw();
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

    }

}
