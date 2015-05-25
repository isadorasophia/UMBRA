package com.umbra.mobModule.itemComponent.inter;

import com.umbra.mobModule.exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
import com.umbra.mobModule.modAttComponent.inter.IModificator;
import com.umbra.mobModule.mobComponent.inter.IMob;


public interface IItemBattle extends IItem {
    public void addModAtt(String attName, IModificator operation, double ... parameter);
    public void addModAtt(String attName, double parameter);
    public void updateMob(IMob src) throws CannotDoubleModifyAttributeException;
    public void unupdateMob(IMob src) throws CannotUnmodifyWhatHasNotBeenModifiedException;
}
