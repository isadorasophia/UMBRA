package com.umbra.dbModule;

/**
 * Fabrica para geração de bancos de dados diferentes
 * 
 * @author Henrique Noronha Facioli
 * @author Thiago Silva de Farias
 *
 */

import com.umbra.dbModule.enums.TypeDB;
import com.umbra.dbModule.interfaces.iDB;
import com.umbra.dbModule.products.UmbraDBCSV;
import com.umbra.dbModule.products.UmbraDBTXT;
import com.umbra.dbModule.products.UmbraDBXML;

public class DBFactory{
    private String path;
    private iDB helper = null;

    public DBFactory(String path){
        this.path = path;
    }

    public iDB getDB(TypeDB tipo){
        if(tipo == TypeDB.CSV){
            helper = new UmbraDBCSV(path);
        }
        else if(tipo == TypeDB.XML){
            helper = new UmbraDBXML(path);
        }
        else if(tipo == TypeDB.TXT){
            helper = new UmbraDBTXT(path);
        }
        else{
            return null;
        }

        return helper;
    }
}
