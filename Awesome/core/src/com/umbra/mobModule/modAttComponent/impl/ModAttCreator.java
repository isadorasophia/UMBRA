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
        IModAtt resp = null;
        Operation operation = null;

        if (parameter >= 0) {
            operation = Operation.ADICAO;
        } else if (parameter < 0) {
            parameter = -parameter;
            operation = Operation.SUBTRACAO;
        }

        try {
            resp = create(attName, operation, parameter);
        } catch (BadArgumentException e) {
            System.err.println("That is ridiculously impossible");
        }
        return resp;

    }
    
    public IModAtt create(String attName, Operation type, double ... parameter) throws BadArgumentException {
        IModificator operation;
        IModAtt resp;
        operation = ModificatorFactory.operationCreator(type, parameter[0]);
        resp = create(attName, operation, parameter);
        return resp;
    }
}
