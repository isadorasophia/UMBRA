package com.umbra.mobModule.itemComponent;

import com.umbra.mobModule.*;
import com.umbra.mobModule.mobComponent.*;

import java.util.List;


public interface IItemBattle extends IItem {
    public IMob updateMob(IMob src);
    public void newModAtt(IModAtt modAtt);
    public List<IModAtt> getModAtts();
}
