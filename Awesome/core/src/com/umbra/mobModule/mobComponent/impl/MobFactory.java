package com.umbra.mobModule.mobComponent.impl;


import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.exceptions.BadConstructorException;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

public abstract class MobFactory {

    public abstract IPlayer getInstance(String name, String description,  IPosition position) throws BadConstructorException;
    public abstract IMonstro create(int nivel, IPosition position) throws BadConstructorException;

    public static MobFactory createFactory(String id)

    {
        MobFactory factory = null;
        if (id.equalsIgnoreCase("Monstro"))
            factory = new FabricaDeMonstro();
        else if (id.equalsIgnoreCase("Player"))
            factory = new PlayerInstantiator();

        return factory;
    }
}
