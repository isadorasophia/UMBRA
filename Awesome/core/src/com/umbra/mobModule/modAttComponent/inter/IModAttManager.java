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
	public IModAtt create(String attName, double parameter);
    public IModAtt create(String attName, double parameter, Operation type) throws BadArgumentException;
}
