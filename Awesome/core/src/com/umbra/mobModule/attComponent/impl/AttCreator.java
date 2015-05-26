package com.umbra.mobModule.attComponent.impl;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.mobModule.attComponent.inter.IAttManager;
import com.umbra.mobModule.attComponent.inter.IAttribute;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.mobModule.attComponent.impl.AttCreator>",
		provides={"<http://purl.org/NET/dcc/com.umbra.mobModule.attComponent.inter.IAttManager>"}
)

public class AttCreator extends ComponentBase implements IAttManager {
	
    public IAttribute create(String name, double value){
        IAttribute resp;
        resp = new Attribute(name, value);
        return resp;
    }
    public IAttribute create(String name, double value, Double max){
        IAttribute resp;
        resp = new Attribute(name, value, max);
        return resp;
    }
    public IAttribute create(Double min, String name, double value){
        IAttribute resp;
        resp = new Attribute(min, name, value);
        return resp;
    }
    public IAttribute create(Double min, String name, double value, Double max){
        IAttribute resp;
        resp = new Attribute(min, name, value,  max);
        return resp;
    }

}
