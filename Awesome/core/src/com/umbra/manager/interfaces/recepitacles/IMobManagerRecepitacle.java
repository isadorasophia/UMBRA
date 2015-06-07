package com.umbra.manager.interfaces.recepitacles;

import anima.annotation.ComponentInterface;
import anima.component.IReceptacle;
import com.umbra.mobModule.mobComponent.inter.IMobManager;

@ComponentInterface("<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.recepitacle.IMobManagerRecepitacle>")
public interface IMobManagerRecepitacle extends IReceptacle {
    public void connect(IMobManager mobManager);
}
