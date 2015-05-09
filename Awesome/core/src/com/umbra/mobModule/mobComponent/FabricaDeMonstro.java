package com.umbra.mobModule.mobComponent;

import com.umbra.mapModule.IPosition;

public class FabricaDeMonstro {
    private int id;

    public IMonstro instantiate(int nivel, IPosition position){
        return new Monstro()
    }
}
