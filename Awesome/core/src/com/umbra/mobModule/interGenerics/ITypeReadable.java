package com.umbra.mobModule.interGenerics;

import com.umbra.mobModule.enums.Type;

/**
 * Interface que generaliza os objetos que tem o enumerado
 * identificador Type, para retornar os tipo do objeto
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface ITypeReadable {
    /**
     * Permite Ler o Tipo de um objeto, que é um objeto enumétavel do tipo Type
     * @return um objeto enumétavel do tipo Type
     */
    public Type getType();
}
