package com.umbra.mobModule.modAttComponent;

import com.umbra.mobModule.Exceptions.BadArgumentException;

public class ModAttCreator {
    public static IModAtt create(String attName, IModificator operation, double ... parameter){
        IModAtt resp = new ModAtt(attName, operation, parameter);
        return resp;
    }
    public static IModAtt create(String attName, double parameter){
        IModAtt resp;
        resp = create(attName, new Addicionator(), parameter);
        return resp;

    }
    public static IModAtt create(String attName, double parameter, char type) throws BadArgumentException {
        IModificator operation = null;
        IModAtt resp;
        switch (type) {
            case '-':
                parameter = - parameter;
            case '+':
                operation = new Addicionator();
                break;
            case '/':
                if(parameter == 0){
                    throw new BadArgumentException("You've tried to create an ByZeroDivider");
                }
                parameter = 1/parameter;
            case '*':
                operation = new Multiplicator();
                break;

        }
        resp = create(attName, operation, parameter);
        return resp;
    }
}
