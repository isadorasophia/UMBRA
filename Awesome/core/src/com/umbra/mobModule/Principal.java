package com.umbra.mobModule;

import com.umbra.mobModule.mobComponent.Creator;
import com.umbra.mobModule.mobComponent.IMonstro;

public class Principal {
	public static void main(String[] args) {

        IMonstro m = (IMonstro) Creator.create("Mob").instantiate("Monstro", 1, 2);
        m.getId();
        System.out.println(m.getClass()+" "+m.getChar());

        System.out.println("Terminado");
    }
}
