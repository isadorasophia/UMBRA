package com.umbra.mobModule.interGenerics;

/**
 * Interface que viabiliza o uso do pattern
 * Prototype para clonagem de objetos
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 * @param <T> objeto genérico que pode ser clonado
 */

public interface IClonable<T> {
    /**
     * Permite clonar um objeto do tipo clonável, isto é que implemente a interface IClonable
     * @return retorna um clone do objeto
     */
    public T clone();
}
