package com.umbra.mobModule.attComponent;


import java.util.*;

public class ModAtt implements IModAtt {
    private String attName;
    private Modificator operation;
    private List<Double> parameters;

    public ModAtt(String attName, Modificator operation){
        this.attName = attName;
        this.operation = operation;
    }
    public ModAtt(String attName, double parameter){
        this.attName = attName;
        this.operation = new AddAtt();
        if(this.parameters == null){
            parameters = new LinkedList<Double>();
        }
        this.parameters.set(0, parameter);
    }
    public ModAtt(String attName, double parameter1, double parameter2){
        this.attName = attName;
        this.operation = new AddAtt();
        if(this.parameters == null){
            parameters = new LinkedList<Double>();
        }
        this.parameters.set(0, parameter1);
        this.parameters.set(1, parameter2);
    }
    public ModAtt(String attName, List<Double> parameters){
        this.attName = attName;
        this.operation = new AddAtt();
        this.parameters = parameters;
    }

    public IAttribute modify(IAttribute src) {
        IAttribute returnValue, clone = src.clone();
        returnValue = operation.modify(clone, parameters);
        return returnValue;

    }

    public String getName() {
        return attName;
    }
}
