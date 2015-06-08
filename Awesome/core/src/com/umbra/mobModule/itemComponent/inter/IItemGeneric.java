package com.umbra.mobModule.itemComponent.inter;

import com.umbra.mobModule.interGenerics.*;

/**
 * Interface para um item genérico que pode ser extendido
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IItemGeneric extends
        IPositionable,
        IDescriptionReadable,
        INameReadable,
        ITypeReadable,
        Stringlizable
{
    /**
     * Permite leitura da probabilidade de se achar um ítem no jogo
     * @return Retorna a probabilidade de achar o item no jogo
     */
    public double getFindProb();
}
