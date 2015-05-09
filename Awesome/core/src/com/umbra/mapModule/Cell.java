package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.IMob;
import com.umbra.puzzlesModule.IPuzzle;

public class Cell implements ICell {
    private IMob entidade;
    private IPuzzle porta;
    private boolean parede;

    // Constructor
    // Caso não tenha entidade e/ou porta, passar null como parametro
    public Cell(IMob entidade, IPuzzle porta, boolean parede) {
        this.entidade = entidade;
        this.porta = porta;
        this.parede = parede;
    }

    // Remove o mob da célula e o retorna
    public IMob removeMob() {
        IMob aux = this.entidade;
        this.entidade = null;
        return aux;
    }

    // Retorna true se for possível adicionar o mob (não há mob na cell)
    // False se o contrário
    public Boolean setMob(IMob entidade) {
        if (this.entidade == null) {
            this.entidade = entidade;
            return true;
        }
        return false;
    }

    public IMob getMob() {
        return this.entidade;
    }

    public IPuzzle getDoor() {
        return this.porta;
    }
    public char getDescription() {
    }

}
