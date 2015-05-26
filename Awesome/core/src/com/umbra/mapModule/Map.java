package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.IMob;
import com.umbra.puzzlesModule.IPuzzle;

import java.util.Arrays;
import java.util.Random;

public class Map implements IMap{
    private static int TAM_Y = 50;
    private static int TAM_X = 5;
    private static Map instance = null;

    private ICell[][] corredor = new ICell[TAM_Y][TAM_X];

    // Método único estático de acesso único ao objeto
    // SINGLETON!!! 
    public static Map getInstance(IMob personagem) {
        if (instance == null)
            instance = new Map(personagem);
        return instance;
    }

    // Contrutor privado.
    private Map(IMob personagem){
        Random generator = new Random();
        Boolean Ok;
        int cont = 0;

        personagem.setPosition(new Position(TAM_Y-2, 3));

        for(int i = 0; i < TAM_Y; i++){
            if(generator.nextInt(22)%7 == 0){
                //Falta instancia o puzzle com suas caracteristicas
                /*
                IPuzzle sala = new IPuzzle() ;
                if(generator.nextInt(2)%2 == 0){
                    corredor[i][TAM_X-1] = new Cell(null, sala);
                }else{
                    corredor[i][0] = new Cell(null, sala);
                }
                */
            }
        }

        for(int i = 1;i < TAM_Y-1; i++) {
            Ok = false;
            for(int j = 1; j < TAM_Y-5 && !Ok; j++) {
                if(generator.nextInt(22)%7 == 0){
                    //Falta instancia o monstro com suas caracteristicas
                    /*
                    IMob monstro = new IMob(null,null,null);
                    corredor[i][j] = new Cell(monstro, null);
                    */
                    cont++;
                    Ok = true;
                }
            }
        }
    }

    public ICell getCell(IPosition posicao) {
        Position pos = (Position) posicao;
        return corredor[pos.getY()][pos.getX()];
    }

    public ICell[][] getCell(IPosition posicao,int size) {
        Position pos = (Position) posicao;
        size--;
        ICell[][] response = new Cell[size][size];
        int index = 0;
        for (int i = pos.getY() - size; i <= pos.getY() + size ; i++) {
            response[index++] = Arrays.copyOfRange(corredor[i],pos.getX()-size,pos.getX()+size);
        }
        return response;
    }
    public boolean move(IMob entidade, char direction) {
        Position posicao = (Position) entidade.getPosition();
        ICell atual;

        switch (direction) {
            case 'n':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell norte = corredor[posicao.getY()+1][posicao.getX()];
                return posicao.moveNorth(norte, atual);
            case 's':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell sul = corredor[posicao.getY()-1][posicao.getX()];
                return posicao.moveSouth(sul, atual);
            case 'w':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell oeste = corredor[posicao.getY()][posicao.getX()-1];
                return posicao.moveWest(oeste, atual);
            case 'e':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell leste = corredor[posicao.getY()][posicao.getX()+1];
                return posicao.moveEast(leste, atual);
            default:
                return false;
        }
    }
}
