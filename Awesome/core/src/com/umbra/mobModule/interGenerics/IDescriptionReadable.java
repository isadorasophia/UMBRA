package com.umbra.mobModule.interGenerics;

/**
 * Interface que generaliza a leitura de descrições de objetos
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IDescriptionReadable {
    /**
     * Permite ler a descrição de um objeto que implemente esta interface IDescriptionReadable
     * @return String contendo a descição
     */
    public String getDescription();
}
