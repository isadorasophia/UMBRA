package com.umbra.mapModule;

import com.umbra.Exceptions.UnknownInputException;
import com.umbra.mobModule.mobComponent.inter.IMob;
import anima.annotation.Component;
import anima.component.base.ComponentBase;

import java.util.ArrayList;
import java.util.Random;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.mapModule.Map>",
		provides={"<http://purl.org/NET/dcc/com.umbra.com.umbra.mapModule.IMap>"}
)

public class Map extends ComponentBase implements IMap {
    private static int TAM_Y = 50;
    private static int TAM_X = 10;
    private static Map instance = null;
    private static ArrayList<IMob> monstros = new ArrayList<IMob>();

    private ICell[][] corredor = new ICell[TAM_Y][TAM_X];

    // Método único estático de acesso único ao objeto
    // SINGLETON!!! 
    public Map getInstance(IMob personagem) {
        if (instance == null) {
            instance = new Map();
            instance.init(personagem);
        }
        return instance;
    }

    // Construtor privado
    private void init(IMob personagem){
        CellOperator operator = new CellOperator();
        Random generator = new Random();
        Boolean Ok;

        int n_mobs = 20;


        for (int i = 0; i < TAM_Y; i++) {
            for (int j = 0; j < TAM_X; j++) {
                corredor[i][j] = operator.makeVazio();
            }
        }

        personagem.setPosition(new Position(TAM_Y-2, 3));
        corredor[TAM_Y-2][3].setMob(personagem);

        // Criacao semi-aleatoria para o nosso caso atual de apenas dois puzzles
        operator.makePorta(corredor[TAM_Y-2-generator.nextInt(20)][generator.nextInt(2)*(TAM_X-1)]);
        operator.makePorta(corredor[1+generator.nextInt(24)][generator.nextInt(2)*(TAM_X-1)]);

        /*
        // Coloca puzzles
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
        */

        // Coloca paredes
        for (int i = 0; i < TAM_X; i++) {
            operator.makeParede(corredor[0][i]);
            operator.makeParede(corredor[TAM_Y - 1][i]);
        }
        for (int i = 0; i < TAM_Y; i++) {
            if (corredor[i][0].getDoor() == null)
                operator.makeParede(corredor[i][0]);
            if (corredor[i][TAM_X-1] == null)
                operator.makeParede(corredor[i][TAM_X-1]);
        }

        // Coloca monstros
        for(int i = 1; i < TAM_Y-1; i++) {
            Ok = false;
            for(int j = 1; j < TAM_X-1 && !Ok; j++) {
                if(generator.nextInt(70)%60 == 0){
                    operator.makeMonstro(corredor[i][j], i, j, Math.abs(n_mobs)/8 + 1, monstros);
                    n_mobs--;
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

    public ICell move(IMob entidade, String direction) throws UnknownInputException {
        Position posicao = (Position) entidade.getPosition();
        ICell atual, retorna = null;
        String presenca;

        if(direction.isEmpty()){
            throw new UnknownInputException();
        }
        switch (direction.toUpperCase().charAt(0)) {
            case 'W':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell norte = corredor[posicao.getY()-1][posicao.getX()];
                presenca = posicao.moveNorth(norte, atual);
                if (presenca.equalsIgnoreCase("monstro") || (presenca.equalsIgnoreCase("porta") && entidade.getChar() == '@'))
                    retorna = norte;
                else if (presenca.equalsIgnoreCase("player"))
                    retorna = atual;
                break;

            case 'S':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell sul = corredor[posicao.getY()+1][posicao.getX()];
                presenca = posicao.moveSouth(sul, atual);
                if (presenca.equalsIgnoreCase("monstro") || (presenca.equalsIgnoreCase("porta") && entidade.getChar() == '@'))
                    retorna = sul;
                else if (presenca.equalsIgnoreCase("player"))
                    retorna = atual;
                break;

            case 'A':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell oeste = corredor[posicao.getY()][posicao.getX()-1];
                presenca = posicao.moveWest(oeste, atual);
                if (presenca.equalsIgnoreCase("monstro") || (presenca.equalsIgnoreCase("porta") && entidade.getChar() == '@'))
                    retorna = oeste;
                else if (presenca.equalsIgnoreCase("player"))
                    retorna = atual;
                break;

            case 'D':
                atual = corredor[posicao.getY()][posicao.getX()];
                ICell leste = corredor[posicao.getY()][posicao.getX()+1];
                presenca = posicao.moveEast(leste, atual);
                if (presenca.equalsIgnoreCase("monstro") || (presenca.equalsIgnoreCase("porta") && entidade.getChar() == '@'))
                    retorna = leste;
                else if (presenca.equalsIgnoreCase("player"))
                    retorna = atual;
                break;
            default:
                throw new UnknownInputException();
        }

        if (retorna == null && entidade.getChar() == '@') {
            Random movimento = new Random();
            int player_x = ((Position) entidade.getPosition()).getX();
            int player_y = ((Position) entidade.getPosition()).getY();
            ICell pegou = null;

            for (IMob monstro : monstros) {
                int dX = ((Position) monstro.getPosition()).getX() - player_x;
                int dY = ((Position) monstro.getPosition()).getY() - player_y;

                if (Math.abs(dX) <= 3 && Math.abs(dY) <= 3) {
                    if (movimento.nextInt(2) == 1) {
                        if (dX <= 0) {
                            if (Math.abs(dX) >= Math.abs(dY)) pegou = this.move(monstro, "D");
                            else if (dY <= 0) pegou = this.move(monstro, "S");
                            else pegou = this.move(monstro, "W");
                        } else {
                            if (dX >= Math.abs(dY)) pegou = this.move(monstro, "A");
                            else if (dY <= 0) pegou = this.move(monstro, "S");
                            else pegou = this.move(monstro, "W");
                        }
                    }
                }
                if (pegou != null) return pegou;
            }
        }
        return retorna;
    }
    public void kill(IMob monstro){
        monstros.remove(monstros.indexOf(monstro));
        Position pos = (Position) monstro.getPosition();
        corredor[pos.getY()][pos.getX()].removeMob();
    }
}
