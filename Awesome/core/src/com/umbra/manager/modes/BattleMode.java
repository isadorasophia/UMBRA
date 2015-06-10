package com.umbra.manager.modes;

import anima.annotation.Component;
import anima.component.base.ComponentBase;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.umbra.battleModule.IBattleManager;
import com.umbra.manager.Characters;
import com.umbra.manager.TextComunicator;
import com.umbra.manager.interfaces.IBattleModeComponent;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.manager.modes.BattleMode>",
        provides="<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IMode>",
		requires="<http://purl.org/NET/dcc/com.umbra.battleModule.BattleManager>"
)
public class BattleMode extends ComponentBase implements IBattleModeComponent {

    IComunicator comunicator, battleComunicator;
    Characters characters;
    IPlayer player;
    IMonstro monstro;
    IBattleManager battlemanager;

    // Flags
    boolean isAlive;
    boolean modeOn; // Continue in the mode
    boolean end; // Actions ere over
    boolean done; // Last text already written
    boolean closeToUp,levelup;

    @Override
    public void init(IComunicator comunicator, Characters characters) {
        this.comunicator = comunicator;
        battleComunicator = new TextComunicator();
        player = characters.getPlayer();
        monstro = characters.getMonstro();
        battlemanager.initialize(player,monstro);
        comunicator.newText(battlemanager.getStatus(), 100, Gdx.graphics.getHeight() - 50, Gdx.graphics.getWidth() - 200f, true);
        isAlive = true;
        modeOn = true;
        end = false;
        done = false;
        levelup = false;
        closeToUp = false;
    }

    @Override
    public Modes update(float dt) {
        Modes next_mode = Modes.BATLLE;

        if(comunicator.update(dt)) {
           if((!levelup) || battleComunicator.update(dt)) {
                if (!end) {
                    String input;
                    if (levelup) {
                        input = battleComunicator.getInput();
                        if (input != null) {
                            battlemanager.processInput(input);
                            String status = battlemanager.getStatus();
                            comunicator.newText(status, 100, Gdx.graphics.getHeight() - 50,
                                    Gdx.graphics.getWidth() - 200f, true, false);
                            comunicator.newText(status, 100, Gdx.graphics.getHeight() - 50,
                                    Gdx.graphics.getWidth() - 200f, true, false);
                        }
                        if(closeToUp) levelup = true;
                        if(battlemanager.getHasLeveledUp()) closeToUp = true;
                    } else {
                        input = comunicator.getInput();
                        if (input != null) {
                            battlemanager.processInput(input);
                            comunicator.newText(battlemanager.getStatus(), 100, Gdx.graphics.getHeight() - 50,
                                    Gdx.graphics.getWidth() - 200f, true, false);
                            end = battlemanager.getDone();
                        }
                        if(!battlemanager.getHasLeveledUp()) {
                            levelup = false;
                            closeToUp = false;
                        }
                    }
                } else {
                    done = true;
                    if (!modeOn) {
                        if (player.dead()) next_mode = Modes.GAMEOVER;
                        else next_mode = Modes.MAZE;
                    }
                }
            }
        }
        return next_mode;
    }

    @Override
    public void draw() {
        comunicator.draw();
        battleComunicator.draw();
    }

    @Override
    public void handleInput() {
        // wait press enter to exit Mode
        if(done && Gdx.input.isKeyPressed(Input.Keys.ENTER)) modeOn = false;
    }

    @Override
    public void dispose() {
    }

    @Override
    public void connect(IBattleManager battlemanager) {
        this.battlemanager = battlemanager;
    }
}
