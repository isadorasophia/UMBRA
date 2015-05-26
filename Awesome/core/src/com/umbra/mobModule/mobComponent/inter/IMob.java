package com.umbra.mobModule.mobComponent.inter;


public interface IMob extends IMobGeneric {
    public boolean dead();
    public char getChar();
    /* Retorna true se ainda esta vivo, falso caso contrário */
    public boolean decreaseHP (double hp);
    public void attsPrint();
}
