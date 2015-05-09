package com.umbra.mobModule.mobComponent;

import com.umbra.mobModule.IFactory;
import com.umbra.mobModule.itemComponent.ItemFactory;

public class Creator {
    public static IFactory create(String type_name) {
        switch (type_name){
            case "Mob":
                return new MobFactory ();
            case "Item":
                return new ItemFactory ();

        }
        return null;
    }
}
