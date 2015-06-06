package com.umbra.dbModule;

import java.io.*;

public class DBFactory{
    private String path;
    private iDB helper = null;

    public DBFactory(String path){
        this.path = path;
    }

    public iDB getDB(TypeDB tipo){
        if(tipo == TypeDB.CSV){
            helper = new umbraDBCSV(path);
            return helper;
        }
        else if(tipo == TypeDB.XML){
            return null;
        }
        else if(tipo == TypeDB.TXT){
            helper = new umbraDBTXT(path);
            return helper;
        }
        else{
            return null;
        }
    }
}
