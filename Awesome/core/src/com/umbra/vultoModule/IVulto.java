package com.umbra.vultoModule;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;

@ComponentInterface("<http://purl.org/NET/dcc/com.umbra.com.umbra.vultoModule.IVulto>")
public interface IVulto extends ISupports {
    public boolean checkVulto();
    public void lightInterference(double light);
    public boolean chooseAction(String action, StringBuilder result) throws UnknownInputException;
}
