package com.umbra.dbModule;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;

import java.io.*;

@ComponentInterface(
        value = "<http://purl.org/NET/dcc/com.umbra.dbModule.iDB>"
)

<<<<<<< HEAD
public interface iDB extends ISupports{
    public String getFromDB() throws NullPointerException, NoMethod;
    public String[] getFromDB(String info) throws NullPointerException, NoMethod;
    public String[] getFromDB(String info1, String info2) throws NullPointerException, NoMethod;
    public void saveDB(Object obj) throws NullPointerException, NoMethod;
    public Object getObject() throws NullPointerException, NoMethod;
=======
public interface iDB extends ISupports {
    public BufferedReader readDB();
    public String getFromDB();
    public String[] getFromDB(String info);
    public String[] getFromDB(String info1, String info2);
    public boolean saveDB(Object obj);
    public Object getObject();
>>>>>>> e5f66a90f25594cfee29e57597020155815a3bed
}
