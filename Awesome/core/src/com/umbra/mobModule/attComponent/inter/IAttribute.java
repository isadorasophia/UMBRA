package com.umbra.mobModule.attComponent.inter;

import com.umbra.mobModule.exceptions.NoMaxMinException;
import com.umbra.mobModule.interGenerics.IClonable;
import com.umbra.mobModule.interGenerics.INameReadable;
import com.umbra.mobModule.interGenerics.Stringlizable;

/**
 * Interface com os metodos dos atributos
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IAttribute extends
        INameReadable,
        IClonable<IAttribute>,
        Stringlizable
{
    /**
     * Da permição de leitura do valor do atributo aos outros componentes
     * @return Retorna o valor do atributo
     */
    public double getValue();

    /**
     * Da permição de escrita do valor do atributo aos outros componentes
     * @param value Recebe o valor a ser setado no atributo
     */
    public void setValue(double value);

    /**
     * Permite a leitura do valor máximo
     * @return retorna o valor máximo
     */
    public Double getMax();

    /**
     * Permite a leitura do valor mínimo
     * @return retorna o valor mínimo
     */
    public Double getMin();
    /**
     * Volta o valor do atributo para seu máximo
     * @throws NoMaxMinException Exceção lançada quando não há o valor máximo
     */
    public void setToMax() throws NoMaxMinException;
    /**
     * Volta o valor do atributo para seu mínimo
     * @throws NoMaxMinException Exceção lançada quando não há o valor mínimo
     */
    public void setToMin() throws NoMaxMinException;

    /**
     * Permite editar o valor máximo do atributo
     * @param max : seta o máximo
     */
    public void setMax(double max);
    /**
     * Permite editar o valor mínimo do atributo
     * @param min : seta o mínimo
     */
    public void setMin(double min);
}

