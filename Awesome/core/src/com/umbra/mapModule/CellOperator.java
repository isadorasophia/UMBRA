package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.impl.FabricaDeMonstro;
import com.umbra.puzzlesModule.IPuzzle;

/**
 * Created by laurocruz on 6/2/15.
 */
public class CellOperator {

    public Cell makeVazio() {
        return new Cell(null, null, false);
    }

    public void makePorta(ICell celula) {
        celula.setDoor(new Puzzle());
    }

    public void makeParede(ICell celula) {
        celula.setParede(true);
    }

    public void makeMonstro(ICell celula, int i, int j) {
        FabricaDeMonstro fabrica = new FabricaDeMonstro();

        celula.setMob(fabrica.create(j, new Position(i,j) ));
    }
}
