package com.umbra.mobModule.mobComponent;

import com.umbra.bdModule.mobAux.*;
import com.umbra.mapModule.IPosition;

public class FabricaDeMonstro {
    private int id;

    /* Incompleto*/
    public IMonstro instantiate(int nivel, IPosition position){

        return new Monstro("Monstro", "Monstro Cruel", position, atts, id);
    }
}
