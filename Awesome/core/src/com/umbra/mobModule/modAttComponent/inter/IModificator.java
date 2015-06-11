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
	 * @param src : atributo que será modificado
	 * @param parameters : lista de parâmetros que modificam o atributo
	 * @return Novo atributo modificado
	 */
	public IAttribute modify(IAttribute src, double ... parameters);
    
	/**
	* Desmodifica um atributo com os parâmetros que foram passados
	* @param src : atributo que será desmodificado
	* @return Novo atributo desmodificado
	*/
	public IAttribute unmodify(IAttribute src);
}
