package com.umbra.mapModule;

public class Position implements IPosition{
    private int posX;
    private int posY;

    public Position (int Yi, int Xi) {
        this.posX = Xi;
        this.posY = Yi;
    }

    public Boolean moveNorth(ICell norte, ICell atual) {
        if (norte.getMob() == null) {
            norte.setMob(atual.removeMob());
            this.posY++;
            return true;
        }
        return false;
    }

    public Boolean moveSouth(ICell sul, ICell atual) {
        if (sul.getMob() == null) {
            sul.setMob(atual.removeMob());
            this.posY--;
            return true;
        }
        return false;
    }

    public Boolean moveWest(ICell oeste, ICell atual) {
        if (oeste.getMob() == null) {
            oeste.setMob(atual.removeMob());
            this.posX--;
            return true;
        }
        return false;
    }

    public Boolean moveEast(ICell leste, ICell atual) {
        if (leste.getMob() == null) {
            leste.setMob(atual.removeMob());
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


}
