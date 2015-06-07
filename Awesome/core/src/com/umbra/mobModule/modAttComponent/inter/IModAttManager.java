package com.umbra.mobModule.modAttComponent.inter;

import com.umbra.mobModule.enums.Operation;
import com.umbra.mobModule.exceptions.BadArgumentException;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;

/**
 * Interface para a criação de modificadores de
 * atributo para os items de batalha
 * 
 * @author Luiz Fernando Rodrigues da Fonseca
 * @author Lucas Alves Racoci
 *
 */

@ComponentInterface(
		"<http://purl.org/NET/dcc/com.umbra.mobModule.modAttComponent.inter.IModAttManager>")

public interface IModAttManager extends ISupports {
	
	/**
	 * Criador de um modificador de atributo sem uma operação específica,
	 * portanto ele só soma um subtrai o valor de um atributo
	 * @param attName
	 * @param parameter
	 * @return
	 */
	public IModAtt create(String attName, double parameter);
	
	/**
	 * Criador de um modificador de atributo com alguma operação especificada
	 * @param attName
	 * @param type
	 * @param parameter
	 * @return
	 * @throws BadArgumentException
	 */
    public IModAtt create(String attName, Operation type, double ... parameter) throws BadArgumentException;
    
}
