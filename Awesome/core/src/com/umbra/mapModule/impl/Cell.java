package com.umbra.mapModule.impl;

import com.umbra.mapModule.inter.ICell;
import com.umbra.mobModule.mobComponent.inter.IMob;
import com.umbra.puzzlesModule.IPuzzle;

public class Cell implements ICell {
    private IMob entidade;
    private IMob colisao;
    private IPuzzle porta;
    private boolean parede;

    // Constructor
    // Caso não tenha entidade e/ou porta, passar null como parametro
    public Cell() {
        this.entidade = null;
        this.porta = null;
        this.parede = false;
    }

    // Remove o mob da célula e o retorna
    public IMob removeMob() {
        IMob aux;
        if(this.colisao != null){
            aux = colisao;
            colisao = null;
            return aux;
        }
        aux = this.entidade;
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
        else{
            colisao = entidade;
            return false;
        }
    }

    public IMob getMob() {
        return this.entidade;
    }

    public void setDoor(IPuzzle porta) {
        this.porta = porta;
    }

    public IPuzzle getDoor() {
        return this.porta;
    }

    public void setParede(boolean p){
        parede = p;
    }
    public boolean getParede(){
        return parede;
    }

    public char getDescription() {
        if(entidade != null){
            return entidade.getChar();
        }
        else if(parede) {
            return '#';
        }else if(porta != null){
           return '[';
        }
        else{
            return '.';
        }
    }

}
