package com.umbra.manager;

public class Selector implements ISelector{
    private IMode mode;

    public Selector(){
        setMode(Modes.Maze);
    }

    public void setMode(Modes state){
        if(mode != null) mode.dispose();
        switch (state){
            case Batlle:
                mode = new BattleMode();
                break;
            case Maze:
                mode = new MazeMode();
                break;
            case Puzzle:
                mode = new PuzzleMode();
                break;
            case Vulte:
                mode = new VulteMode();
                break;
        }
        mode.init();
    }
    public void update(float dt){
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
