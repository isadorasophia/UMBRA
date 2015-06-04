package com.umbra.mobModule.modAttComponent.impl;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.mobModule.enums.Operation;
import com.umbra.mobModule.exceptions.BadArgumentException;
import com.umbra.mobModule.modAttComponent.inter.IModAtt;
import com.umbra.mobModule.modAttComponent.inter.IModAttManager;
import com.umbra.mobModule.modAttComponent.inter.IModificator;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.mobModule.modAttComponent.impl.ModAttCreator>",
		provides={"<http://purl.org/NET/dcc/com.umbra.mobModule.modAttComponent.inter.IModAttManager>"}
)

public class ModAttCreator extends ComponentBase implements IModAttManager {
    private IModAtt create(String attName, IModificator operation, double ... parameter) {
        IModAtt resp = new ModAtt(attName, operation, parameter);
        return resp;
    }
    
    public IModAtt create(String attName, double parameter) {
        IModAtt resp;
        IModificator operation = null;
        
        try {
	        if (parameter >= 0) {
	        	operation = ModificatorFactory.operationCreator(Operation.ADICAO, parameter);
	        } else if (parameter < 0) {
	        	parameter = Math.abs(parameter);
	        	operation = ModificatorFactory.operationCreator(Operation.SUBTRACAO, parameter);
	        }
        } catch (BadArgumentException e) {
        	System.out.println(e.getMessage());
        }
        
        resp = create(attName, operation, parameter);
        return resp;

    }
    
    public IModAtt create(String attName, double parameter, Operation type) throws BadArgumentException {
        IModificator operation = null;
        IModAtt resp;
        parameter = Math.abs(parameter);
        
        try {
        	operation = ModificatorFactory.operationCreator(type, parameter);
        } catch (BadArgumentException e) {
        	System.out.println(e.getMessage());
        }
        
        resp = create(attName, operation, parameter);
        return resp;
    }
}
