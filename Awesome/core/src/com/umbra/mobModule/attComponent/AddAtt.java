package com.umbra.mobModule.attComponent;


import java.util.*;

public class AddAtt implements Modificator {
    public IAttribute modify(IAttribute src, List<Double> parameters) {
        IAttribute returnValue = src.clone();
        returnValue.setValue(src.getValue() + parameters.get(0));
        return returnValue;
    }
}
