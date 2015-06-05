package com.umbra.mobModule.itemComponent.inter;

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
