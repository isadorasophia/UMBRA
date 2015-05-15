package com.umbra.mobModule.mobComponent;


import com.umbra.mapModule.IPosition;

public abstract class MobFactory {

    public abstract IPlayer create(String name, String description,  IPosition position);
    public abstract IMonstro create(int nivel, IPosition position);

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
