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
	 * @return Se o mob está vivo ou morto
	 */
    public boolean dead();
    
    /**
     * Retorna o caracter do enumerado de identificação do mob
     * @return Caractere de identificação
     */
    public char getChar();
    
    /**
     * Decrementa o hp e retorna se morreu ou não
     * @param hp : vida do mob
     * @return Checa se morreu ou não
     */
    public boolean decreaseHP(double hp);
    
}
