package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.IMob;

public class Position implements IPosition{
    private int posX;
    private int posY;

    public Position (int Xi, int Yi) {
        this.posX = Xi;
        this.posY = Yi;
    }

    public Boolean moveNorth(ICell norte, ICell atual) {
        if (norte.getMob() == null) {
            norte.setMob(atual.remove());
            this.posY++;
            return true;
        }
        return false;
    }

    public Boolean moveSouth(ICell sul, ICell atual) {
        if (sul.getMob() == null) {
            sul.setMob(atual.remove());
            this.posY--;
            return true;
        }
        return false;
    }

    public Boolean moveWest(ICell oeste, ICell atual) {
        if (oeste.getMob() == null) {
            oeste.setMob(atual.remove());
            this.posX--;
            return true;
        }
        return false;
    }

    public Boolean moveEast(ICell leste, ICell atual) {
        if (leste.getMob() == null) {
            leste.setMob(atual.remove());
            this.posX++;
            return true;
        }
        return false;
    }

    public int getX() {
        return this.posX;
    }

    public int getY() {
        return this.posY;
    }

    /*
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

    */
}
