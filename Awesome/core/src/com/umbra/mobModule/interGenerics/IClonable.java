package com.umbra.mobModule.interGenerics;


public interface IClonable<T> {
    /**
     * Permite clonar um objeto do tipo clonável, isto é que implemente a interface IClonable
     * @return retorna um clone do objeto
     */
    public T clone();
}
