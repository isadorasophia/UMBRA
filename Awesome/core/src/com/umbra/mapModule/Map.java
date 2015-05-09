package com.umbra.mapModule;

import com.umbra.mobModule.mobComponent.IMob;
import java.util.Random;

public class Map implements IMap{
    private ICell[][] corredor = new ICell[25][5];

    @Override
    public void initialPosition(){
        int cont = 0;



        for(int i = 0;i < 25; i++) {
            for(int j = 0; j < 5; j++) {
                if(i == 0 || j == 0 || i == ||){
                    corredor[i][j] = new Cell(null, null);
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
                ICell leste = corredor[posicao.getY()][posicao.getX()-1];
                return posicao.moveEast(leste, atual);
            default:
                return false;
        }
    }
}
