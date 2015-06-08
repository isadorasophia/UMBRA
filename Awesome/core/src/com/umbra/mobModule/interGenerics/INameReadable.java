package com.umbra.mobModule.interGenerics;

/**
 * Interface que generaliza os objetos que tem um nome
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface INameReadable {
    /**
     * Permite ler o nome de um objeto que implemente a interface INameReadable
     * @return String contendo o nome
     */
    String getName();
}
