package com.umbra.mobModule.attComponent.inter;

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
     */
    public void setToMax();
    /**
     * Volta o valor do atributo para seu mínimo
     */
    public void setToMin();

    /**
     * Permite editar o valor máximo do atributo
     * @param max
     */
    public void setMax(double max);
    /**
     * Permite editar o valor mínimo do atributo
     * @param min
     */
    public void setMin(double min);
}

