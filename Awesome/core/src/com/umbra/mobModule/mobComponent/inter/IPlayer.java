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
	 * @return
	 */
    public double getXp();
    
    /**
     * Muda o xp do player
     * @param xp
     */
    public void setXp(double xp);
    
    /**
     * Adiciona xp no player
     * @param xp
     * @return
     */
    public boolean addXP(double xp);
    
    /**
     * Pega o nivel do player
     * @return
     */
    public int getNivel();
    
    /**
     * Pega a vida do player
     * @return
     */
    public double getHealth();
    
    /**
     * Retorna uma lista com os nomes dos items de batalha do player
     * @return
     */
    public Vector<String> itemsForBattle();
    
    /**
     * Retorna uma lista com os nomes dos items de iluminação do player
     * @return
     */
    public Vector<String> itemsIlumination();
    
    /**
     * Retorna uma lista com os nomes dos items de puzzle do player
     * @return
     */
    public Vector<String> itemsPuzzle();
}
