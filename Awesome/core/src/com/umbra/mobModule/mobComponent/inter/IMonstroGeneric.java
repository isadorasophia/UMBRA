package com.umbra.mobModule.mobComponent.inter;

/**
 * Interface que generaliza os métodos de um monstro genérico
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IMonstroGeneric extends IMob {
	
	/**
	 * Muda o identificador do monstro
	 * @param id
	 */
    public void setId(int id);
    
    /**
     * Pega o identificador do monstro
     * @return
     */
    public int getId();
}
