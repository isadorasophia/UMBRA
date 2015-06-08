package com.umbra.mobModule.itemComponent.inter;
import java.util.List;

/**
 * Interface que contém os métodos de um item do tipo puzzle que será usado no jogo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IItemPuzzle extends IItem {

	/**
	 * Pega os adjetivos que o item possui
	 * @return List<String>
	 */
    public List<String> getAdjectives();
    
    /**
     * Adiciona um novo adjetivo ao item
     * @param newAdj
     */
    public void newAdjective(String newAdj);
    
    /**
     * Modifica um adjetivo ja existente
     * @param src
     * @param newAdj
     */
    public void modAdj(String src, String newAdj);
}
