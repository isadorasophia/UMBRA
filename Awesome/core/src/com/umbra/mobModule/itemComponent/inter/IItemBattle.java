package com.umbra.mobModule.itemComponent.inter;

import com.umbra.mobModule.exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
import com.umbra.mobModule.mobComponent.inter.IMob;


public interface IItemBattle extends IItem {
    public void addModAtt(String attName, double parameter, char type);
    public void addModAtt(String attName, double parameter);
    public void updateMob(IMob src) throws CannotDoubleModifyAttributeException;
    public void unupdateMob(IMob src) throws CannotUnmodifyWhatHasNotBeenModifiedException;
}
