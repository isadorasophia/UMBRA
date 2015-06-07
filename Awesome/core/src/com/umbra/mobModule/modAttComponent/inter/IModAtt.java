package com.umbra.mobModule.modAttComponent.inter;

import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
import com.umbra.mobModule.interGenerics.INameReadable;
import com.umbra.mobModule.interGenerics.Stringlizable;

/**
 * Interface para um modificador de um atributo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IModAtt extends
        INameReadable,
        Stringlizable
{
	
	/**
	 * Modifica um atributo passado com o valor já armazenado no objeto
	 * @param src
	 * @return
	 * @throws CannotDoubleModifyAttributeException
	 */
    public IAttribute modify(IAttribute src) throws CannotDoubleModifyAttributeException;
    
    /**
     * Desmodifica um atributo passado com o valor armazenado no objeto
     * @param src
     * @return
     * @throws CannotUnmodifyWhatHasNotBeenModifiedException
     */
    public IAttribute unmodify(IAttribute src) throws CannotUnmodifyWhatHasNotBeenModifiedException;
    
}
