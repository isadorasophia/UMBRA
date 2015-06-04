package com.umbra.mobModule.modAttComponent.impl;

import com.umbra.mobModule.Margin;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.modAttComponent.inter.IModAtt;
import com.umbra.mobModule.modAttComponent.inter.IModificator;

public class ModAtt implements IModAtt {
    private String attName;
    private IModificator operation;
    private double[] parameters;

    public ModAtt(String attName, IModificator operation, double ... parameter){
        this.attName = attName;
        this.operation = operation;
        parameters = parameter;
    }
    public IAttribute modify(IAttribute src) {

        IAttribute resp;
        IAttribute clone = src.clone();
        resp = operation.modify(clone, this.parameters);
        return resp;

    }
    public IAttribute unmodify(IAttribute src) {
        IAttribute clone = src.clone();
        IAttribute resp = operation.unmodify(clone, this.parameters);
        return resp;
    }

    public String getName() {
        return attName;
    }

    public String toString(Margin m) {
        String resp = "", partial = "";
        partial += String.format("Modifica %s usando %f", attName, parameters[0]);
        for(int i = 1 ; i < parameters.length - 1; i++){
            partial += String.format(", %f", parameters[i]);
        }
        if (parameters.length == 1) {
            partial += " como parametro";
        } else {
            partial += String.format(" e %f como parametros", parameters[parameters.length - 1]);
        }
        resp += m.ident(partial);
        return resp;
    }
    public String toString() {
        return toString(Margin.first());}
}
