package com.umbra.manager;

import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;
import com.umbra.puzzlesModule.IPuzzle;
import com.umbra.vultoModule.IVulto;

public class Characters {

    private IPlayer player;
    private IMonstro monstro;
    private IVulto vulto;
    private IPuzzle puzzle;

    public void setPlayer(IPlayer player){
        this.player = player;
    }

    public IPlayer getPlayer(){
        return player;
    }

    public void setMonstro(IMonstro monstro){
        this.monstro = monstro;
    }

    public IMonstro getMonstro(){
        return monstro;
    }

    public void setVulto(IVulto vulto){
        this.vulto = vulto;
    }

    public IVulto getVulto(){
        return vulto;
    }

    public void setPuzzle(IPuzzle puzzle){ this.puzzle = puzzle;}

    public IPuzzle getPuzzle() { return puzzle; }
}
