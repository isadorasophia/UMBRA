package com.umbra.mobModule.modAttComponent.impl;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.mobModule.enums.Operation;
import com.umbra.mobModule.modAttComponent.inter.IModAtt;
import com.umbra.mobModule.modAttComponent.inter.IModAttManager;
import com.umbra.mobModule.modAttComponent.inter.IModificator;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.mobModule.modAttComponent.impl.ModAttCreator>",
		provides={"<http://purl.org/NET/dcc/com.umbra.mobModule.modAttComponent.inter.IModAttManager>"}
)

/**
 * Classe que representa o componente que cria os modificadores de atributo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class ModAttCreator extends ComponentBase implements IModAttManager {

	/**
	 * Criador privado para criar o modificador de atributo
	 * com uma operação e os parâmetros passados
	 * @param attName : nome do atributo modificado
	 * @param operation : operação que modifica o atributo
	 * @param parameter : lista de parâmetros de modificação
	 * @return Modificador de atributo criado
	 */
    private IModAtt create(String attName, IModificator operation, double ... parameter) {
        IModAtt resp = new ModAtt(attName, operation, parameter);
        return resp;
    }
    
    public IModAtt create(String attName, double parameter) {
        IModAtt resp = null;
        IModificator operation = null;

        try {
        	if (parameter >= 0) {
	            operation = ModificatorFactory.operationCreator(Operation.ADICAO, parameter);
	        } else if (parameter < 0) {
	            parameter = -parameter;
	            operation = ModificatorFactory.operationCreator(Operation.SUBTRACAO, parameter);
	        }
        	
            resp = create(attName, operation, parameter);
        } catch (ArithmeticException e) {
            resp = null;
        }
        
        return resp;
    }
    
    public IModAtt create(String attName, Operation type, double ... parameter) throws ArithmeticException {
        IModificator operation;
        IModAtt resp;
        operation = ModificatorFactory.operationCreator(type, parameter);
        resp = create(attName, operation, parameter);
        return resp;
    }
}
