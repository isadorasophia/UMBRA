package com.umbra.mapModule;

import com.umbra.Exceptions.UnknownInputException;
import com.umbra.mobModule.mobComponent.inter.IMob;
import com.umbra.puzzlesModule.IPuzzle;
import anima.annotation.Component;
import anima.component.base.ComponentBase;

import java.util.Arrays;
import java.util.Random;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.mapModule.Map>",
		provides={"<http://purl.org/NET/dcc/com.umbra.com.umbra.mapModule.IMap>"}
)
public class Map extends ComponentBase implements IMap {
    private static int TAM_Y = 50;
    private static int TAM_X = 10;
    private static Map instance = null;

    private ICell[][] corredor = new ICell[TAM_Y][TAM_X];

    // Método único estático de acesso único ao objeto
    // SINGLETON!!! 
    public static Map getInstance(IMob personagem) {
        if (instance == null)
            instance = new Map(personagem);
        return instance;
    }

    // Construtor privado
    private Map(IMob personagem){
        CellOperator operator = new CellOperator();
        Random generator = new Random();
        Boolean Ok;
        int cont = 0;

        personagem.setPosition(new Position(TAM_Y-2, 3));

        for (int i = 1; i < TAM_Y-1; i++) {
            for (int j = 1; j < TAM_X - 1; j++) {
                corredor[i][j] = operator.makeVazio();
            }
        }

        for (int i = 0; i < TAM_X; i++) {
            operator.makeParede(corredor[0][i]);
            operator.makeParede(corredor[TAM_Y-1][i]);
        }
        for (int i = 0; i < TAM_Y; i++) {
            operator.makeParede(corredor[i][0]);
            operator.makeParede(corredor[i][TAM_X-1]);
        }

        for(int i = 1; i < TAM_Y-1; i++) {
            if(generator.nextInt(22)%10 == 0) {
                //Falta instancia o puzzle com suas caracteristicas
                if (generator.nextInt(2)%2 == 0) {
                    operator.makePorta(corredor[i][TAM_X-1]);
                } else {
                    operator.makePorta(corredor[i][0]);
                }
            }
        }

        for(int i = 1; i < TAM_Y-1; i++) {
            Ok = false;
            for(int j = 1; j < TAM_X-1 && !Ok; j++) {
                if(generator.nextInt(70)%60 == 0){
                    operator.makeMonstro(corredor[i][j], i, j);
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

    public IMob move(IMob entidade, String direction) {
        Position posicao = (Position) entidade.getPosition();
        ICell atual;

        switch (direction.charAt(0)) {
            case 'n':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell norte = corredor[posicao.getY()+1][posicao.getX()];
                return posicao.moveNorth(norte, atual);
            case 's':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell sul = corredor[posicao.getY()-1][posicao.getX()];
                return posicao.moveSouth(sul, atual);
            case 'l':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell oeste = corredor[posicao.getY()][posicao.getX()-1];
                return posicao.moveWest(oeste, atual);
            case 'o':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell leste = corredor[posicao.getY()][posicao.getX()+1];
                return posicao.moveEast(leste, atual);
            default:
                throw(new UnknownInputException());
        }
    }
}
