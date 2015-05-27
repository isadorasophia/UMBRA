package com.umbra.manager.interfaces;

import anima.annotation.ComponentInterface;
import anima.component.IReceptacle;
import com.umbra.mobModule.mobComponent.inter.IMobManager;

@ComponentInterface("<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IMobManagerRecepitacle>")
public interface IMobManagerRecepitacle extends IReceptacle {
    public void connect(IMobManager mobManager);
}
