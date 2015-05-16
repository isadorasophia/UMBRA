package com.umbra.vultoModule;

public class VultoSingleton {
    private static IVulto uniqueInstance = null;

    public static IVulto instance(){
        if(uniqueInstance == null) uniqueInstance = new Vulto();
        return uniqueInstance;
    }
}
