package com.umbra.manager.modes;

import anima.annotation.Component;
import anima.component.base.ComponentBase;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.brashmonkey.spriter.Player;
import com.umbra.battleModule.BattleManager;
import com.umbra.battleModule.IBattleManager;
import com.umbra.manager.Characters;
import com.umbra.manager.TextComunicator;
import com.umbra.manager.interfaces.IBattleModeComponent;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.interfaces.IMode;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;
import com.umbra.vultoModule.UnknownInputException;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.manager.modes.BattleMode>",
        provides="<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IMode>",
		requires="<http://purl.org/NET/dcc/com.umbra.battleModule.BattleManager>"
)
public class BattleMode extends ComponentBase implements IBattleModeComponent {
	IComunicator comunicator;
    Characters characters;
    IPlayer player;
    IMonstro monstro;
    IBattleManager battlemanager;
    boolean modeOn;

    @Override
    public void init(IComunicator comunicator, Characters characters) {
        this.comunicator = comunicator;
        player = characters.getPlayer();
        monstro = characters.getMonstro();
        battlemanager.initialize(player,monstro);
        comunicator.newText(battlemanager.getStatus());
        modeOn = true;
    }

    @Override
    public Modes update(float dt) {
        Modes next_mode = Modes.BATLLE;
        if(comunicator.update(dt)) {
            if(modeOn) {
                String input = comunicator.getInput();
                if (input != null) {
                    battlemanager.processInput(input);
                    comunicator.newText(battlemanager.getStatus());
                    modeOn = !battlemanager.getDone();
                }
            }else{
                if(player.getHealth() == 0) next_mode = Modes.GAMEOVER;
                else next_mode = Modes.MAZE;
            }
        }
        return next_mode;
    }

    @Override
    public void draw() {
        comunicator.draw();
    }

    @Override
    public void handleInput() {
        Gdx.input.isKeyPressed(Keys.ANY_KEY);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void connect(IBattleManager battlemanager) {
        this.battlemanager = battlemanager;
    }
}
