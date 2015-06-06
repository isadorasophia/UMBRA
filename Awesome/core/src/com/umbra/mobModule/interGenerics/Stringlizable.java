package com.umbra.mobModule.interGenerics;

import com.umbra.mobModule.Margin;

/**
 * Interface com métodos para debugar o código internamente,
 * com métodos que imprimem os objetos formatados na tela
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface Stringlizable {
    /**
     * Permite retornar uma string identada por um objeto do tipo Margin que é passado como parâmetro
     * @param m Objeto do tipo Margin, contendo métodos para identar Strings automaticamente
     * @return String identada descrevendo o objeto e, possivelmente, sub-objetos
     */
    public String toString(Margin m);

    /**
     * Permite retornar uma string que descreva o objeto
     * @return String identada descrevendo o objeto e, possivelmente, sub-objetos
     */
    public String toString();
}
