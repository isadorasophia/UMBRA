package com.umbra.mobModule.mobComponent.inter;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;
import com.umbra.mapModule.inter.IPosition;

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
	 * @param name : nome do player
	 * @param description : descrição do player
	 * @param position : posição
	 * @return Player criado
	 */
	public IPlayer createPlayer(String name, String description, IPosition position);
	
	/**
	 * Cria um monstro e seus atributos aleatoriamente de acordo com seu nível
	 * @param nivel : nível que se deseja criar o monstro
	 * @param position : posição
	 * @return Monstro criado
	 */
	public IMonstro createMonstro(int nivel, IPosition position);
}
