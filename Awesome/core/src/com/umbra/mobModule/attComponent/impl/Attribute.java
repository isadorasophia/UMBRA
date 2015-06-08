package com.umbra.mobModule.attComponent.impl;

import com.umbra.mobModule.Margin;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.exceptions.NoMaxMinException;

/**
 * Classe cujos objetos representam atributos dos mobs
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class Attribute implements IAttribute  {
    private String name;
    private double value;
    private Double min = null;
    private Double max = null;

    public static final double MIN = 0;

    /**
     * Constroi um Attribute setando os parametros:
     * @param name : o nome do atributo a ser criado
     * @param value : o valor inicial do atributo a ser criado
     */
    public Attribute(String name, double value){
        this(null, name, value,  null);
    }

    /**
     * Constroi um Attribute setando os parametros:
     * @param name : o nome do atributo a ser criado
     * @param value : o valor inicial do atributo a ser criado
     * @param max : o valor máximo do atributo a ser criado
     */
    public Attribute(String name, double value, double max){
        this(null, name, value,  new Double(max));
    }

    /**
     * Constroi um Attribute setando os parametros:
     * @param min : o valor mínimo do atributo a ser criado
     * @param name : o nome do atributo a ser criado
     * @param value : o valor inicial do atributo a ser criado
     */
    public Attribute(double min, String name, double value){
        this(new Double(min), name, value, null);
    }

    /**
     * É muito semelhante ao construtor principal de Attribute, mas recebe parâmetros double e não Double,
     * para fascilitar a passagem de parâmetros por parte do usuário.
     * @param min : o valor mínimo do atributo a ser criado
     * @param name : o nome do atributo a ser criado
     * @param value : o valor inicial do atributo a ser criado
     * @param max : o valor máximo do atributo a ser criado
     */
    public Attribute(double min, String name, double value, double max){
        this(new Double(min), name, value, new Double(max));
    }

    /**
     * Representa o construtor principal de Attribute, pois é o mais geral, todos os outros o chamam direta ou
     * indiretamente passando os parâmetros que recebem e marcando com null os que não recebem.
     * @param min : o valor mínimo do atributo a ser criado
     * @param name : o nome do atributo a ser criado
     * @param value : o valor inicial do atributo a ser criado
     * @param max : o valor máximo do atributo a ser criado
     * @return : retorna o atributo construído com os parâmetros passados
     */
    public Attribute(Double min, String name, double value, Double max){
        this.name = name;
        this.value = value;
        this.min = min;
        this.max = max;
    }

    public String getName() {
        return name;
    }
    
    public double getValue() {
        return value;
    }
    
    public void setValue(double value) {
        boolean set = true;
        if (min != null && value < min) {
        	this.value = min;
            set = false;
        }
        if (max != null && value > max) {
        	this.value = max;
            set = false;
        }
        if (set) {
            this.value = value;
        }
    }

    @Override
    public Double getMax() {
        return max;
    }

    @Override
    public Double getMin() {
        return min;
    }

    @Override
    public void setToMax() throws NoMaxMinException {
    	if (max == null) {
    		throw new NoMaxMinException("Max value doesn't exist");
    	}
        value = max;
    }

    @Override
    public void setToMin() throws NoMaxMinException {
    	if (min == null) {
    		throw new NoMaxMinException("Min value doesn't exist");
    	}
        value = min;
    }

    @Override
    public String toString(Margin m){
        String resp = "";
        resp += String.format("%s = %f", name, value);
        if(min != null){
            resp += String.format(", min = %.1f", min);
        }
        if(max != null){
            resp += String.format(", max = %.1f", max);
        }
        return m.ident(resp);
    }
    public String toString(){
        return toString(Margin.first());
    }

    public void setMax(double max){
        this.max = max;
        if (this.value > max) {
        	this.value = max;
        }
    }

    public void setMin(double min){
        this.min = min;
        if (this.value < min) {
        	this.value = min;
        }
    }

    public IAttribute clone() {
        return new Attribute(min, name, value, max);
    }
}
