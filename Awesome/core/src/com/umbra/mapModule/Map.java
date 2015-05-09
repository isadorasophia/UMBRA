package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.IMob;
import java.util.Random;

public class Map implements IMap{
    static int TAM_Y = 50;
    static int TAM_X = 5;

    private ICell[][] corredor = new ICell[TAM_Y][TAM_X];

    @Override
    public void initialPosition(IMob personagem){
        Random generator = new Random();
        int cont = 0;
        Boolean Ok;

        personagem.setPosition(TAM_Y,3);

        for(int i = 1;i < TAM_Y-1; i++) {
            Ok = false;
            for(int j = 1; j < TAM_Y-1 && !Ok; j++) {
                if(generator.nextInt(21)%7 == 0){
                    /*Falta instancia o monstro com suas caracteristicas*/
                    IMob monstro = new IMob(null,null,null);
                    corredor[i][j] = new Cell(IMob, null);

                    Ok = true;
                }
            }
        }
    }

    @Override
    public void getPosition(IPosition posicao) {
        return;
    }

    @Override
    public boolean move(IMob entidade, char direction) {
        IPosition posicao = entidade.getPosition();
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
            case 'l':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell leste = corredor[posicao.getY()][posicao.getX()+1];
                return posicao.moveEast(leste, atual);
            default:
                return false;
        }
    }
}
