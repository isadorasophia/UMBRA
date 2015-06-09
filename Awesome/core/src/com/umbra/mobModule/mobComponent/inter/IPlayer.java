package com.umbra.mobModule.mobComponent.inter;

import java.util.Vector;

/**
 * Interface que possui os métodos do player que será utilizado no jogo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IPlayer extends IPlayerGeneric {
    
	/**
	 * Pega o xp do player
	 * @return Xp do player
	 */
    public double getXp();
    
    /**
     * Muda o xp do player
     * @param xp : novo xp do player
     */
    public void setXp(double xp);
    
    /**
     * Adiciona xp no player
     * @param xp : xp que será adicionado
     * @return número de níveis que o player subiu
     */
    public int addXP(double xp);
    
    /**
     * Pega o nivel do player
     * @return Nível do player
     */
    public int getNivel();
    
    /**
     * Pega a vida do player
     * @return Vida do player
     */
    public double getHealth();
    
    /**
     * Retorna uma lista com os nomes dos items de batalha do player
     * @return Nomes dos itens de batalha
     */
    public Vector<String> itemsForBattle();
    
    /**
     * Retorna uma lista com os nomes dos items de iluminação do player
     * @return Nomes dos itens de iluminação
     */
    public Vector<String> itemsIlumination();
    
    /**
     * Retorna uma lista com os nomes dos items de puzzle do player
     * @return Nomes dos itens de puzzle
     */
    public Vector<String> itemsPuzzle();
}
