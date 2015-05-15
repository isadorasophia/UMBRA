package com.umbra.mobModule.itemComponent;

import com.umbra.mobModule.Exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.Exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
import com.umbra.mobModule.modAttComponent.IModificator;
import com.umbra.mobModule.mobComponent.IMob;


public interface IItemBattle extends IItem {
    public void addModAtt(String attName, IModificator operation, double ... parameter);
    public void addModAtt(String attName, double parameter);
    public void updateMob(IMob src) throws CannotDoubleModifyAttributeException;
    public void unupdateMob(IMob src) throws CannotUnmodifyWhatHasNotBeenModifiedException;
}
