package com.umbra.mobModule.attComponent;


public class AttCreator {
    public static IAttribute create(String name, double value){
        IAttribute resp;
        resp = new Attribute(name, value);
        return resp;
    }
    public static IAttribute create(String name, double value, double max){
        IAttribute resp;
        resp = new Attribute(name, value, max);
        return resp;
    }
    public static IAttribute create(double min, String name, double value){
        IAttribute resp;
        resp = new Attribute(min, name, value);
        return resp;
    }
    public static IAttribute create(double min, String name, double value, double max){
        IAttribute resp;
        resp = new Attribute(min, name, value,  max);
        return resp;
    }

}
