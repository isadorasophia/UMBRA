package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.impl.FabricaDeMonstro;
import com.umbra.puzzlesModule.PuzzleFactory;

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

    public void makeMonstro(ICell celula, int i, int j) {
        celula.setMob(fabricaMonstro.create(j, new Position(i,j) ));
    }
}
