package com.umbra.mobModule.mobComponent.inter;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;

/**
 * Interface para o componente que retorna instancias
 * de Player e Monstros para o jogo principal
 * 
 * @author Luiz Fernando Rodrigues da Fonseca
 * @author Lucas Alves Racoci
 *
 */

@ComponentInterface(
		"<http://purl.org/NET/dcc/com.umbra.mobModule.mobComponent.inter.IMobManager>")

public interface IMobManager extends ISupports {
	
	/**
	 * Cria um player com os atributos já pré definidos
	 * @return
	 */
	public IPlayer createPlayer();
	
	/**
	 * Cria um monstro e seus atributos aleatoriamente de acordo com seu nível
	 * @param nivel
	 * @return
	 */
	public IMonstro createMonstro(int nivel);
}
