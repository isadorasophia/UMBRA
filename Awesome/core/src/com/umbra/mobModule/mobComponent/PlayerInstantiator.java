package com.umbra.mobModule.mobComponent;


import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.Exceptions.BadConstructorException;

public class PlayerInstantiator extends MobFactory {

    public static final Integer INITIAL_SIZE = 10;

    public IPlayer getInstance(String name, String description,  IPosition position){

        IPlayer resp = Player.getInstance(name, description, position, INITIAL_SIZE);

        return resp;


    }

    public IMonstro create(int nivel, IPosition position) throws BadConstructorException {
        throw new BadConstructorException();
    }
}
