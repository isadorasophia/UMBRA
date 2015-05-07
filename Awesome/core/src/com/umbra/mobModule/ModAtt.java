package com.umbra.mobModule;


public class ModAtt implements IModAtt {
    private String attName;
    private double operation;

    public ModAtt(String attName, double operation){
        this.attName = attName;
        this.operation = operation;
    }

    public IAttribute modify(IAttribute src) {
        IAttribute returnValue = src.clone();
        returnValue.setValue(src.getValue() + operation);
        return returnValue;

    }

    public String getName() {
        return attName;
    }
}
