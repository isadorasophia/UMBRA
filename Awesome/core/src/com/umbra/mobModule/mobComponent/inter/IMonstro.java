package com.umbra.mobModule.mobComponent.inter;

/**
 * Interface de marcação para o monstro que será usado no jogo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IMonstro extends IMonstroGeneric {
	/**
	 * Pega a descrição de vitória do monstro
	 * @return
	 */
	public String getWinDescription();
	
	/**
	 * Seta a descrição de vitória do monstro 
	 * @param win
	 */
	public void setWinDescription(String win);
	
	/**
	 * Pega a descrição de morte do monstro
	 * @return
	 */
	public String getDeathDescription();
	
	/**
	 * Seta a descrição de morte do monstro
	 * @param death
	 */
	public void setDeathDescription(String death);
}
