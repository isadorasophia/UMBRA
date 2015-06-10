package com.umbra.manager.interfaces.recepitacles;

import anima.annotation.ComponentInterface;
import anima.component.IReceptacle;
import com.umbra.mapModule.inter.IMap;

@ComponentInterface("<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.recepitacle.MapRecepitacle>")
public interface IMapRecepitacle extends IReceptacle {
    public void connect(IMap map);
}
