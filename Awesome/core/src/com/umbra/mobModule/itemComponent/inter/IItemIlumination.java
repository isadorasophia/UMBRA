package com.umbra.mobModule.itemComponent.inter;

/**
 * Interface que contém métodos de um item de iluminação que será usado no jogo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IItemIlumination extends IItem {
    /**
     * Permite leitura do valor da itensidade luminosa de um item do tipo IItemIlumination
     * @return Retorna o valor da itensidade luminosa do item
     */
    public double getIlumination();

    /**
     * Permite modificar o valor da itensidade luminosa de um item do tipo IItemIlumination
     * @param ilumination Novo valor para a itensidade luminosa do item
     */
    public void setIlumination(double ilumination);
}
