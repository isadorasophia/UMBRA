package com.umbra.mobModule.modAttComponent.impl;

import com.umbra.mobModule.Margin;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
import com.umbra.mobModule.modAttComponent.inter.IModAtt;
import com.umbra.mobModule.modAttComponent.inter.IModificator;

/**
 * Classe que implementa um modificador de um atributo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class ModAtt implements IModAtt {
    private String attName;
    private IModificator operation;
    private double[] parameters;
    private IAttribute src;

    /**
     * Constrói um modificador de atributo com uma operação passada
     * e vários valores que ele pode alterar
     * @param attName
     * @param operation
     * @param parameter
     */
    public ModAtt(String attName, IModificator operation, double ... parameter){
        this.attName = attName;
        this.operation = operation;
        parameters = parameter;
    }
    
    /* Throws CannotDoubleModifyAttributeException if(this.src != null)*/
    public IAttribute modify(IAttribute src) throws CannotDoubleModifyAttributeException {
        if (this.src != null) {
            throw new CannotDoubleModifyAttributeException();
        }
        IAttribute resp;
        IAttribute clone = src.clone();
        this.src = src;
        resp = operation.modify(clone, this.parameters);
        return resp;

    }
    
    /* Throws CannotUnmodifyWhatHasNoBeenModifiedException if(src == null)  */
    public IAttribute unmodify(IAttribute src) throws CannotUnmodifyWhatHasNotBeenModifiedException {
        if (this.src == null) {
            throw new CannotUnmodifyWhatHasNotBeenModifiedException();
        }
        IAttribute clone = src.clone();
        IAttribute resp = operation.unmodify(clone, this.parameters);
        IAttribute returnValue = this.src.clone();
        if(resp != returnValue){
            System.err.println("Erro, modAtt com src errado");
        }
        this.src = null;
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
        return toString(Margin.first());
    }
}
