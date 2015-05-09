package com.umbra.mobModule.mobComponent;


import com.umbra.mobModule.IFactory;

public class MobFactoryFactory implements IFactory<IFactory> {
    public IFactory instantiate(String subtype, Object... parameter) {
        switch (subtype){
            case "Monstro":
                return new FabricaDeMonstro();
            case "Player":
                return new PlayerInstantiatior();
        }
        return null;
    }
}
