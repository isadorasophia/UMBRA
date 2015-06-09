package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.inter.IMob;

public class Position implements IPosition{
    private int posX;
    private int posY;

    public Position (int Yi, int Xi) {
        this.posX = Xi;
        this.posY = Yi;
    }

    // Funções de movimento
    // Retorna "ocupado" se houver um mob ou uma porta na célula de destino
    // Retorna "desocupado" se não houver nada ou apenas uma parede na célula de destino

    public String moveNorth(ICell norte, ICell atual) {
        if (norte.getMob() != null || norte.getDoor() != null)
            return "ocupado";
        else if (!norte.getParede()) {
            norte.setMob(atual.removeMob());
            this.posY--;
        }
        return "desocupado";
    }

    public String moveSouth(ICell sul, ICell atual) {
        if (sul.getMob() != null || sul.getDoor() != null)
            return "ocupado";
        else if (!sul.getParede()) {
            sul.setMob(atual.removeMob());
            this.posY++;
        }
        return "desocupado";
    }

    public String moveWest(ICell oeste, ICell atual) {
        if (oeste.getMob() != null || oeste.getDoor() != null)
            return "ocupado";
        else if (!oeste.getParede()) {
            oeste.setMob(atual.removeMob());
            this.posX--;
        }
        return "desocupado";
    }

    public String moveEast(ICell leste, ICell atual) {
        if (leste.getMob() != null || leste.getDoor() != null)
            return "ocupado";
        else if (!leste.getParede()) {
            leste.setMob(atual.removeMob());
            this.posX++;
        }
        return "desocupado";
    }

    public int getX() {
        return this.posX;
    }

    public int getY() {
        return this.posY;
    }


}
