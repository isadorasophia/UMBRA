package com.umbra.mobModule.mobComponent.inter;

/**
 * Interface de marcação para o monstro que será usado no jogo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IMonstro extends IMonstroGeneric {
	public String getWinDescription();
	public void setWinDescription(String win);
	public String getDeathDescription();
	public void setDeathDescription(String death);
}
