package com.umbra.mobModule.attComponent;


public class ModAtt implements IModAtt {
    private String attName;
    private Modificator operation;
    private double[] parameters;

    public ModAtt(String attName, Modificator operation, double ... parameter){
        this.attName = attName;
        this.operation = operation;
        parameters = parameter;
    }


    public IAttribute modify(IAttribute src) {
        IAttribute returnValue, clone = src.clone();
        returnValue = operation.modify(clone, parameters);
        return returnValue;

    }
    public IAttribute unmodify(IAttribute src) {
        IAttribute returnValue, clone = src.clone();
        returnValue = operation.unmodify(clone, parameters);
        return returnValue;
    }

    public String getName() {
        return attName;
    }
}
