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
        if (instance == null) {
            instance = new Map();
            instance.init(personagem);
        }
        return instance;
    }

    // Construtor privado
    public void init(IMob personagem){
        CellOperator operator = new CellOperator();
        Random generator = new Random();
        Boolean Ok;
        int cont = 0;


        for (int i = 0; i < TAM_Y; i++) {
            for (int j = 0; j < TAM_X; j++) {
                corredor[i][j] = operator.makeVazio();
            }
        }

        personagem.setPosition(new Position(TAM_Y-2, 3));
        corredor[TAM_Y-2][3].setMob(personagem);

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
        ICell[][] response = new Cell[2*size + 1][2*size + 1];
        int index_i = 0;
        int index_j = 0;
        for (int i = pos.getY() - size; i <= pos.getY() + size ; i++) {
            for( int j = pos.getX() - size; j <= pos.getX() + size; j++){
                if(i < 0 || i >= TAM_Y || j < 0 || j >= TAM_X) {
                    response[index_i][index_j++] = null;
                }
                else {
                    response[index_i][index_j++] = corredor[i][j];
                }
            }
            index_j = 0;
            index_i++;
        }

        return response;
    }

    // Retorna uma célula se houver um monstro ou porta para onde se quer mover
    // Retorna null se há uma parede, se conseguiu mover ou se a direção passada não seja válida

    public ICell move(IMob entidade, String direction) {
        Position posicao = (Position) entidade.getPosition();
        ICell atual;

        if(direction.isEmpty()){
            throw new UnknownInputException();
        }
        switch (direction.charAt(0)) {
            case 'W':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell norte = corredor[posicao.getY()+1][posicao.getX()];
                if (posicao.moveNorth(norte, atual).equalsIgnoreCase("ocupado"))
                    return norte;
                break;
            case 'S':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell sul = corredor[posicao.getY()-1][posicao.getX()];
                if (posicao.moveSouth(sul, atual).equalsIgnoreCase("ocupado"))
                    return sul;
                break;
            case 'A':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell oeste = corredor[posicao.getY()][posicao.getX()-1];
                if (posicao.moveWest(oeste, atual).equalsIgnoreCase("ocupado"))
                    return oeste;
                break;
            case 'D':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell leste = corredor[posicao.getY()][posicao.getX()+1];
                if (posicao.moveEast(leste, atual).equalsIgnoreCase("ocupado"))
                    return leste;
                break;
            default:
                throw new UnknownInputException();
        }
        return null;
    }
    public void kill(IMob monstro){
        
    }
}
