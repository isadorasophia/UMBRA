package com.umbra.mobModule.mobComponent;

import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.IFactory;

public class MobFactory implements IFactory<IMobGeneric> {


    public IMobGeneric instantiate(String subtype, String name, IPosition position) {
        switch(subtype){
            case "Monstro":
                return (IMonstroGeneric) new MonstroGeneric(name, position);
            case "Player":
                return (IPlayerGeneric) new PlayerGeneric(name, position);

        }
        return null;
    }

    public IMobGeneric instantiate(String subtype, Object... parameter) {
        return instantiate(subtype, (String) parameter[0], (IPosition) parameter[1]);
    }
}
