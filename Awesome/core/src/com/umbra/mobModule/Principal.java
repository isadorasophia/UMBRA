package com.umbra.mobModule;

import com.umbra.mobModule.mobComponent.IMonstro;
import com.umbra.mobModule.mobComponent.MobFactory;

public class Principal {
	public static void main(String[] args) {

        IMonstro m = MobFactory.createFactory("Monstro").create(1, null);
        System.out.println(m.getClass()+" "+m.getChar());

        System.out.println("Terminado");
    }
}
