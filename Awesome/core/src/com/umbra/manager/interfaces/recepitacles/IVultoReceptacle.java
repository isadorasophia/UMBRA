package com.umbra.manager.interfaces.recepitacles;

import anima.annotation.ComponentInterface;
import anima.component.IReceptacle;
import com.umbra.vultoModule.IVulto;

@ComponentInterface("<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.recepitacle.IVultoReceptacle>")
public interface IVultoReceptacle extends IReceptacle{
    public void connect(IVulto vulto);
}
