package com.umbra.mobModule.modAttComponent.impl;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.mobModule.exceptions.BadArgumentException;
import com.umbra.mobModule.modAttComponent.inter.IModAtt;
import com.umbra.mobModule.modAttComponent.inter.IModAttManager;
import com.umbra.mobModule.modAttComponent.inter.IModificator;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.mobModule.modAttComponent.impl.ModAttCreator>",
		provides={"<http://purl.org/NET/dcc/com.umbra.mobModule.modAttComponent.inter.IModAttManager>"}
)

public class ModAttCreator extends ComponentBase implements IModAttManager {
    public IModAtt create(String attName, IModificator operation, double ... parameter) {
        IModAtt resp = new ModAtt(attName, operation, parameter);
        return resp;
    }
    
    public IModAtt create(String attName, double parameter) {
        IModAtt resp;
        resp = create(attName, new Addicionator(), parameter);
        return resp;

    }
    
    public IModAtt create(String attName, double parameter, char type) throws BadArgumentException {
        IModificator operation = null;
        IModAtt resp;
        switch (type) {
            case '-':
                parameter = -parameter;
                break;
            case '+':
                operation = new Addicionator();
                break;
            case '/':
                if (parameter == 0) {
                    throw new BadArgumentException("You've tried to create an ByZeroDivider");
                }
                parameter = 1/parameter;
                break;
            case '*':
                operation = new Multiplicator();
                break;

        }
        resp = create(attName, operation, parameter);
        return resp;
    }
}
