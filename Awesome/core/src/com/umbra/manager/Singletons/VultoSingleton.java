package com.umbra.manager.Singletons;

import anima.context.exception.ContextException;
import anima.factory.IGlobalFactory;
import anima.factory.context.componentContext.ComponentContextFactory;
import anima.factory.exception.FactoryException;

import com.umbra.vultoModule.IVulto;
import com.umbra.vultoModule.Vulto;


public class VultoSingleton {
    private static IVulto uniqueInstance = null;
    public static IVulto instance(){
        if(uniqueInstance == null){
        	try {
				IGlobalFactory factory = ComponentContextFactory.createGlobalFactory();
				uniqueInstance = factory.createInstance("<http://purl.org/NET/dcc/com.umbra.vultoModule.Vulto>");
			} catch (ContextException e) {
				e.printStackTrace();
			} catch (FactoryException e) {
				e.printStackTrace();
			}
        }
        return uniqueInstance;
    }
}
