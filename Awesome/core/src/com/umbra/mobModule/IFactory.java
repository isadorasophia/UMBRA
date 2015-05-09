package com.umbra.mobModule;

/**
 * Created by racoci on 07/05/15.
 */
public interface IFactory<T> {
    public  T instantiate(String subtype, String nameNew);
    public  T instantiate(String subtype);

}
