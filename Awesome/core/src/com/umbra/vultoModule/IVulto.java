package com.umbra.vultoModule;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;
import com.umbra.vultoModule.Exceptions.InputException;

@ComponentInterface("<http://purl.org/NET/dcc/com.umbra.com.umbra.vultoModule.IVulto>")
public interface IVulto extends ISupports {
    public boolean checkVulto();
    public void lightInterference(double light);
    public boolean chooseAction(String action, StringBuilder result, double luck) throws InputException;
}
