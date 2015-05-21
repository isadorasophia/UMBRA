package com.umbra.mobModule.mobComponent;


import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.Exceptions.BadConstructorException;

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
