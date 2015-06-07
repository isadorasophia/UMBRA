package com.umbra.mobModule.mobComponent.impl;

import com.umbra.dbModule.DBFactory;
import com.umbra.dbModule.TypeDB;
import com.umbra.dbModule.iDB;
import com.umbra.mapModule.IPosition;
import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.dbMobModule.dbMob.dbMonstro.BDMonstro;
import com.umbra.mobModule.enums.Att;
import com.umbra.mobModule.exceptions.BadConstructorException;
import com.umbra.mobModule.mobComponent.inter.IMonstro;
import com.umbra.mobModule.mobComponent.inter.IPlayer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    private static final int NUMBEROFMONSTRO = 3;

    /**
     * Acessa o banco de dados para criar o monstro com o id
     * @param id
     * @return Retorna uma lista que contem necessáriamente um nome e uma descrição
     */
    private static List<String> monster(int id){
        List<String> resp = new ArrayList<String>(2);
        String path = BDMonstro.class.getResource(".").getPath() + "/monstro" + ((id % NUMBEROFMONSTRO) + 1);

        String name = null;
        String description = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path + ".txt"));
            name = br.readLine();
            for(String line = br.readLine(); line != null; line = br.readLine()){
                description += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        resp.add(0, name);
        resp.add(1, description);

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
        String description = monster.get(1);
        Hashtable<String,IAttribute> atts = new Hashtable<String, IAttribute>();

        IMonstro resp = new Monstro(name, description, position, atts, id);

        Random r = new Random(id*nivel);

        double maxHp = randomLinearAtt(r, nivel,  42.0/100, 0, Att.HP);
        resp.setAtt(0, Att.HP.getName(), maxHp, maxHp);

        double xp = randomLinearAtt(r, nivel, 25.0/100, 0, Att.XP);
        resp.setAtt(Att.XP.getName(), xp);

        double defense = randomLinearAtt(r, nivel, 22.0/100, 0, Att.DEFENSE);
        resp.setAtt(Att.DEFENSE.getName(), defense);

        double attack = randomLinearAtt(r, nivel, 34.0/100, 0, Att.ATTACK);
        resp.setAtt(Att.ATTACK.getName(), attack);

        double dexterity = randomLinearAtt(r, nivel, 42.0/100, 0, Att.DEXTERITY);
        resp.setAtt(Att.DEXTERITY.getName(), dexterity);

        double luck = r.nextDouble();
        resp.setAtt(Att.LUCK.getName(), luck);

        double evasiveness = randomLinearAtt(r, nivel, 52.0/100, 0, Att.EVASIVENESS);
        resp.setAtt(Att.EVASIVENESS.getName(), evasiveness);

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
