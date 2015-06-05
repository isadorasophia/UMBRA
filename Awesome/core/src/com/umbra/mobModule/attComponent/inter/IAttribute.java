package com.umbra.mobModule.attComponent.inter;

import com.umbra.mobModule.interGenerics.IClonable;
import com.umbra.mobModule.interGenerics.INameReadable;
import com.umbra.mobModule.interGenerics.Stringlizable;

public interface IAttribute extends
        INameReadable,
        IClonable<IAttribute>,
        Stringlizable
{
    /**
     * DA permição de leitura do valor do atributo aos outros componentes
     * @return Retorna o valor do atributo
     */
    public double getValue();

    /**
     * Da permição de escrita do valor do atributo aos outros componentes
     * @param value Recebe o valor a ser setado no atributo
     */
    public void setValue(double value);
}
