package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.impl.FabricaDeMonstro;
import com.umbra.mobModule.mobComponent.inter.IMob;
import com.umbra.puzzlesModule.PuzzleFactory;

import java.util.ArrayList;

/**
 * Created by laurocruz on 6/2/15.
 */
public class CellOperator {
    private FabricaDeMonstro fabricaMonstro = new FabricaDeMonstro();
    private PuzzleFactory fabricaPuzzle = new PuzzleFactory();


    public Cell makeVazio() {
        return new Cell();
    }

    public void makePorta(ICell celula) {
        celula.setDoor(fabricaPuzzle.getPuzzle());
    }

    public void makeParede(ICell celula) {
        celula.setParede(true);
    }

    public void makeMonstro(ICell celula, int i, int j,int nivel, ArrayList<IMob> monstrosPos) {
        IMob monstro = fabricaMonstro.create(nivel, new Position(i,j) );
        monstrosPos.add(monstro);
        celula.setMob(monstro);
    }
}
