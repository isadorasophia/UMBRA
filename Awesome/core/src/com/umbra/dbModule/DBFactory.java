package com.umbra.dbModule;

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
