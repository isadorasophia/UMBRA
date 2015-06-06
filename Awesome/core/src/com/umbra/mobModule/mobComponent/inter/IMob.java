package com.umbra.mobModule.mobComponent.inter;

/**
 * Interface que contém os métodos de um Mob
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IMob extends IMobGeneric {
	
	/**
	 * Retorna se o mob está vivo ou morto
	 * @return
	 */
    public boolean dead();
    
    /**
     * Retorna o enumerado de identificação do mob
     * @return
     */
    public char getChar();
    
    /**
     * Decrementa o hp e retorna se morreu ou não
     * @param hp
     * @return
     */
    public boolean decreaseHP(double hp);
    
}
