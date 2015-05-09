package com.umbra.mobModule.itemComponent;

import com.umbra.mobModule.attComponent.*;
import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.mobComponent.*;

import java.util.ArrayList;
import java.util.List;


public class ItemBattle extends Item implements IItemBattle  {
    List<IModAtt> modatts;

    public ItemBattle(String name){
        super(name);
    }

    public ItemBattle(String name, String description,
                      double findProb, IPosition pos){
        super(name, description, findProb, pos);
        this.modatts = new ArrayList<IModAtt>();
    }

    public IMobGeneric updateMob(IMobGeneric src) {
        IMobGeneric returnValue;
        returnValue = src.clone();
        for(IModAtt modatt : modatts){
            if(src.hasAtt(modatt.getName())){
                IAttribute update = modatt.modify(src.getAtt(modatt.getName()));
                src.setAtt(modatt.getName(), update.getValue());
            }
        }
        return returnValue;
    }

    public void newModAtt(IModAtt modAtt ) {
        modatts.add(modatts.size(), modAtt);
    }

    public List<IModAtt> getModAtts() {
        return modatts;
    }
}
