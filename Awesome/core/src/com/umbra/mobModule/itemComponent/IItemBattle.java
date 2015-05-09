package com.umbra.mobModule.itemComponent;

import com.umbra.mobModule.attComponent.*;
import com.umbra.mobModule.mobComponent.*;

import java.util.List;


public interface IItemBattle extends IItemGeneric {
    public IMobGeneric updateMob(IMobGeneric src);
    public void newModAtt(IModAtt modAtt);
    public List<IModAtt> getModAtts();
}
