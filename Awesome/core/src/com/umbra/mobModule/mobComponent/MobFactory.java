package com.umbra.mobModule.mobComponent;

import com.umbra.mobModule.IFactory;

public class MobFactory implements IFactory {


    public IMobGeneric instantiate(String subtype, String name) {
        switch(subtype){
            case "Monstro":
                return (IMonstro) new Monstro(name);
            case "Player":
                return (IPlayer) new Player(name);

        }
        return null;
    }

    public IMobGeneric instantiate(String subtype) {
        return instantiate(subtype, "noName");
    }
}
