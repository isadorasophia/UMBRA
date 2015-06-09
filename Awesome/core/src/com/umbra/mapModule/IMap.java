package com.umbra.mapModule;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;
import com.umbra.Exceptions.UnknownInputException;
import com.umbra.mobModule.mobComponent.inter.IMob;

@ComponentInterface("<http://purl.org/NET/dcc/com.umbra.com.umbra.mapModule.IMap>")
public interface IMap extends ISupports {
    public ICell getCell(IPosition posicao);
    public ICell[][] getCell(IPosition posicao,int range);
    public ICell move(IMob entidade, String direction) throws UnknownInputException;
    public void kill(IMob monstro);
    public Map getInstance(IMob personagem);
}
