package com.umbra.battleModule;

import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;
import anima.annotation.ComponentInterface;
import anima.component.ISupports;

@ComponentInterface (
		value = "<http://purl.org/NET/dcc/com.umbra.battleModule.IBattleManager>"
)

/**
 * Interface provida para os utilitários do componente
 * 
 * @author Matheus Mortatti Diamantino 156740
 * @author Isadora Sophia Garcia Rodopoulos 158018
 *
 */
public interface IBattleManager extends ISupports{
	
	/**
	 * Inicializa o componente
	 * 
	 * @param player
	 * @param monster
	 */
	public void initialize (IPlayer player, IMonstro monster);
	
	/**
	 * Realiza o processamento do input do jogador
	 * 
	 * @param input
	 */
	public void processInput (String input);
	
	/**
	 * Getter para a variável Done (se a batalha terminou ou não)
	 * 
	 * @return boolean - Se a batalha acabou ou não
	 */
	public boolean getDone ();
	
	/**
	 * Getter para o output a ser impresso ao jogador
	 * 
	 * @return String - Output da batalha
	 */
	public String getStatus ();
}