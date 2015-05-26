package com.umbra.vultoModule;

import anima.annotation.ComponentInterface;

@ComponentInterface("<http://purl.org/NET/dcc/com.umbra.com.umbra.vultoModule.IVulto>")
public interface IVulto {
    public boolean checkVulto();
    public void lightInterference(double light);
    public boolean chooseAction(String action) throws UnknownInputException;
}
