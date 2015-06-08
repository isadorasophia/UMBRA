package com.umbra.dbModule;

public class DBFactory{
    private String path;
    private iDB helper = null;

    public DBFactory(String path){
        this.path = path;
    }

    public iDB getDB(TypeDB tipo){
        if(tipo == TypeDB.CSV){
            helper = new umbraDBCSV(path);
        }
        else if(tipo == TypeDB.XML){
            helper = new umbraDBXML(path);
        }
        else if(tipo == TypeDB.TXT){
            helper = new umbraDBTXT(path);
        }
        else{
            return null;
        }

        return helper;
    }
}
