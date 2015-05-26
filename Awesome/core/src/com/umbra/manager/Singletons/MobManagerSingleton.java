package com.umbra.manager.Singletons;

import anima.context.exception.ContextException;
import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;
import anima.factory.exception.FactoryException;

import com.umbra.mobModule.mobComponent.inter.IMobManager;


public class MobManagerSingleton {
    private static IMobManager uniqueInstance = null;
    public static IMobManager instance(){
        if(uniqueInstance == null){
        	try {
				IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
				uniqueInstance = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.mobModule.mobComponent.impl.MobManager>");
			} catch (ContextException e) {
				e.printStackTrace();
			} catch (FactoryException e) {
				e.printStackTrace();
			}
        }
        return uniqueInstance;
    }
}