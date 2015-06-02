package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.inter.IMob;

public class Position implements IPosition{
    private int posX;
    private int posY;

    public Position (int Yi, int Xi) {
        this.posX = Xi;
        this.posY = Yi;
    }

    public IMob moveNorth(ICell norte, ICell atual) {
        if (norte.getMob() != null)
            return norte.setMob();
        else if (!norte.getParede()) {
            norte.setMob(atual.removeMob());
            this.posY++;
        }
        return null;
    }

    public IMob moveSouth(ICell sul, ICell atual) {
        if (sul.getMob() != null)
            return sul.setMob();
        else if (!sul.getParede()) {
            sul.setMob(atual.removeMob());
            this.posY--;
        }
        return null;
    }

    public IMob moveWest(ICell oeste, ICell atual) {
        if (oeste.getMob() != null)
            return oeste.setMob();
        else if (!oeste.getParede()) {
            oeste.setMob(atual.removeMob());
            this.posX--;
        }
        return null;
    }

    public IMob moveEast(ICell leste, ICell atual) {
        if (leste.getMob() != null)
            return leste.setMob();
        else if (!leste.getParede()) {
            leste.setMob(atual.removeMob());
            this.posX++;
        }
        return null;
    }

    public int getX() {
        return this.posX;
    }

    public int getY() {
        return this.posY;
    }


}
