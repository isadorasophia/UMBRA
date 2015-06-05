package com.umbra.mobModule.mobComponent.inter;

import java.util.Vector;

public interface IPlayer extends IPlayerGeneric {
    /*
    funções: 
        boolean addXP () > retorna true se upou de nivel, false otherwise
        boolean decreaseHP () > retorna true se ainda esta vivo, falso otherwise
        boolean equip () > retorna se conseguiu equipar ou nao
        unequip () > desequipa tudo
    */
    public double getXp();
    public void setXp(double xp);
    /* Retorna true se  o player 'upou' o nivel, false caso contrario*/
    public boolean addXP(double xp);
    public int getNivel();
    public double getHealth();
    
    public Vector<String> itemsForBattle();
    public Vector<String> itemsIlumination();
    public Vector<String> itemsPuzzle();
}
