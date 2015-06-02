package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.inter.IMob;

public interface IMap {
    public ICell getCell(IPosition posicao);
    public ICell[][] getCell(IPosition posicao,int range);
    public boolean move(IMob entidade, String direction);
}
