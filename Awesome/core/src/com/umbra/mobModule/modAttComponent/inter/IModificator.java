package com.umbra.mobModule.modAttComponent.inter;

import com.umbra.mobModule.attComponent.inter.IAttribute;

/**
 * Interface para as operações que modificam os atributos nos modificadores
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IModificator {
	
	/**
	 * Modifica um atributo com os parâmetros que foram passados
	 * @param src
	 * @param parameters
	 * @return
	 */
    public IAttribute modify(IAttribute src, double ... parameters);
    
    /**
     * Desmodifica um atributo com os parâmetros que foram passados
     * @param src
     * @param parameters
     * @return
     */
    public IAttribute unmodify(IAttribute src, double ... parameters);
}
