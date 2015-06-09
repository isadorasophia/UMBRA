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
	 * @return Descrição de vitória
	 */
	public String getWinDescription();
	
	/**
	 * Seta a descrição de vitória do monstro 
	 * @param win : nova descrição de vitória
	 */
	public void setWinDescription(String win);
	
	/**
	 * Pega a descrição de morte do monstro
	 * @return Descrição de morte
	 */
	public String getDeathDescription();
	
	/**
	 * Seta a descrição de morte do monstro
	 * @param death : nova descrição de morte
	 */
	public void setDeathDescription(String death);
}
