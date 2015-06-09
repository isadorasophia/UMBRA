package com.umbra.mobModule.mobComponent.impl;

import com.umbra.dbModule.*;
import com.umbra.dbModule.enums.TypeDB;
import com.umbra.dbModule.exceptions.NoMethod;
import com.umbra.dbModule.interfaces.iDB;
import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.enums.Att;
import com.umbra.mobModule.exceptions.BadConstructorException;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

/**
 * Classe que implementa uma fábrica de monstros, extendendo a fábrica abstrata
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class FabricaDeMonstro extends MobFactory {
    private static int id = 0;
    private static final int NUMERODEMONSTROS = 3;

    /**
     * Acessa o banco de dados para criar o monstro com o id
     * @param id
     * @return Retorna uma lista que contem necessáriamente um nome e uma descrição
     */
    private static List<String> monster(int id){
        //Instanciando um db do tipo CSV
        DBFactory factory = new DBFactory("monstro");
        iDB dbMonsters = factory.getDB(TypeDB.CSV);

        //Recuperando dados do monstroX do DB
        String[] fields = null;
        String monsterX = "monstro" + ((id % NUMERODEMONSTROS) + 1);
        try {
            fields = dbMonsters.getFromDB(monsterX);
        } catch (NoMethod e) {
            e.printStackTrace();
        }

        List<String> resp = new ArrayList<String>(4);

        String name = fields[1];
        String win = fields[2];
        String death = fields[3];
        String description = "";

        for(int i = 4; i < fields.length; i++){
            description += fields[i] + '\n';
        }

        resp.add(0, name);
        resp.add(1, win);
        resp.add(2, death);
        resp.add(3, description);

        return resp;

    }


    /**
     * Cria um valor aleatório para um atributo de acordo com
     * o nivel e um desvio padrão percentual aleatório
     * @param r
     * @param nivel
     * @param percentDev
     * @param rounding
     * @param att
     * @return
     */
    private double randomLinearAtt(Random r, int nivel, double percentDev, int rounding, Att att){
        double coef = att.getIncrement();
        double resp = coef*nivel + att.getBase();
        double dev = percentDev * resp;
        resp += r.nextDouble() * dev/2;
        double tens = Math.floor(Math.pow(10, rounding));
        resp = Math.floor(resp/tens)*tens;
        resp = Math.abs(resp);
        return resp;
    }
    
    /**
     * Cria um monstro com seus atributos de acordo com seu nivel passado
     */
    public IMonstro create(int nivel, IPosition position){
        List<String> monster = monster(id);

        String name =  monster.get(0);
        String win = monster.get(1);
        String death = monster.get(2);
        String description = monster.get(3);
        Hashtable<String,IAttribute> atts = new Hashtable<String, IAttribute>();

        IMonstro resp = new Monstro(name, description, position, atts, id);

        resp.setWinDescription(win);
        resp.setDeathDescription(death);
        
        Random r = new Random(id*nivel);

        double maxHp = randomLinearAtt(r, nivel,  42.0/100, 0, Att.HP);
        resp.setAtt(0, Att.HP.getName(), maxHp, maxHp);

        double xp = randomLinearAtt(r, nivel, 25.0/100, 0, Att.XP);
        resp.setAtt(0, Att.XP.getName(), xp);

        double defense = randomLinearAtt(r, nivel, 22.0/100, 0, Att.DEFENSE);
        resp.setAtt(0, Att.DEFENSE.getName(), defense);

        double attack = randomLinearAtt(r, nivel, 34.0/100, 0, Att.ATTACK);
        resp.setAtt(0, Att.ATTACK.getName(), attack);

        double dexterity = randomLinearAtt(r, nivel, 42.0/100, 0, Att.DEXTERITY);
        resp.setAtt(0, Att.DEXTERITY.getName(), dexterity);

        double luck = randomLinearAtt(r, nivel, 42.0/100, 0, Att.LUCK);
        resp.setAtt(0, Att.LUCK.getName(), luck);

        double evasiveness = randomLinearAtt(r, nivel, 52.0/100, 0, Att.EVASIVENESS);
        resp.setAtt(0, Att.EVASIVENESS.getName(), evasiveness);

        id++;

        return resp;
    }

    /**
     * Retorna uma exceção pois não se pode instanciar um player nesse caso
     */
    public IPlayer instantiate(String name, String description, IPosition position) throws BadConstructorException {
        throw new BadConstructorException();
    }



}
