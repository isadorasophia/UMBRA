package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.IMob;
import java.util.Random;

public class Map implements IMap{
    private ICell[][] corredor;

    corredor = new ICell[25][5];

    @Override
    public void initialPosition(IMob player) {
        int cont = 0;

        for(int i = 0;i < 25; i++) {
            for(int j = 0; j < 5; j++) {

            }
        }
    }

    @Override
    public void getPosition(IPosition posicao) {
        return;
    }

    @Override
    public void move(IPosition destino) {

    }
}
