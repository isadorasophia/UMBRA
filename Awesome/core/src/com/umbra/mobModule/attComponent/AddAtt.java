package com.umbra.mobModule.attComponent;


public class AddAtt implements Modificator {
    public IAttribute modify(IAttribute src, double... parameter) {
        IAttribute returnValue = src.clone();
        returnValue.setValue(src.getValue() + parameter[0]);
        return returnValue;
    }

    public IAttribute unmodify(IAttribute src, double... parameter) {
        IAttribute returnValue = src.clone();
        returnValue.setValue(src.getValue() - parameter[0]);
        return returnValue;
    }
}
