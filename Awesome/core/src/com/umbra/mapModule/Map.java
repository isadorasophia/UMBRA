package com.umbra.mapModule;

public class Map extends IMap{

    private ICell[][] corredor;

    {
        corredor = new ICell[5][20];
    }

    @Override
    public void initialPosition() {

    }
}
