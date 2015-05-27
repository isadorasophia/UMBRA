package com.umbra.manager.interfaces;

import anima.annotation.ComponentInterface;
import anima.component.IReceptacle;
import com.umbra.vultoModule.IVulto;

@ComponentInterface("<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IVultoReceptacle>")
public interface IVultoReceptacle extends IReceptacle{
    public void connect(IVulto vulto);
}
