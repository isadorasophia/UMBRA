package com.umbra.mobModule.itemComponent;

import com.umbra.mobModule.modAttComponent.IModificator;
import com.umbra.mobModule.mobComponent.IMob;


public interface IItemBattle extends IItemGeneric {
    public void addModAtt(String attName, IModificator operation, double ... parameter);
    public void addModAtt(String attName, double parameter);
    public void updateMob(IMob src);
    public void unupdateMob(IMob src);
}
