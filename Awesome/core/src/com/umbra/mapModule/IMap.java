package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.IMob;

public interface IMap {
    public ICell getCell(IPosition posicao);
    public ICell[][] getCell(IPosition posicao,int range);
    public boolean move(IMob entidade, char direction);
}
