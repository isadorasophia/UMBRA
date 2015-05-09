package com.umbra.mobModule;

public interface IFactory<T> {
    public  T instantiate(String subtype, Object ... parameter);

}
