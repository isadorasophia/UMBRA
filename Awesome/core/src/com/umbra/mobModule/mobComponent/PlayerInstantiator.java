package com.umbra.mobModule.mobComponent;


import com.umbra.mapModule.IPosition;

public class PlayerInstantiator extends MobFactory {
        /*Player Manager*/

    public static final Integer INITIAL_SIZE = 10;

    public IPlayer create(String name, String description,  IPosition position){

        IPlayer resp = new Player(name, description, position, INITIAL_SIZE);

        return resp;


    }

    public IMonstro create(int nivel, IPosition position) {
        /*throw new BadConstructorException();*/
        return null;
    }
}
