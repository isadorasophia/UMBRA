package com.umbra.mapModule;

public class Position implements IPosition{
    public int posX;
    public int posY;

    public Boolean moveNorth(){
        if(ValidMove("north"))
            this.posY--;
        return true;
        return false;
    }

    public Boolean moveSouth(){
        if(ValidMove("south"))
            this.posY++;
        return true;
        return false;
    }

    public Boolean moveWest(){
        if(ValidMove("west"))
            this.posX--;
        return true;
        return false;
    }

    public Boolean moveEast(){
        if(ValidMove("east"))
            this.posX++;
        return true;
        return false;
    }
}
