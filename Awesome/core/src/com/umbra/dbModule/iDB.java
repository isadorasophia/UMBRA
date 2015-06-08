package com.umbra.dbModule;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;

@ComponentInterface(
        value = "<http://purl.org/NET/dcc/com.umbra.dbModule.iDB>"
)

public interface iDB extends ISupports {
    public String getFromDB() throws NullPointerException, NoMethod;

    public String[] getFromDB(String info) throws NullPointerException, NoMethod;

    public String[] getFromDB(String info1, String info2) throws NullPointerException, NoMethod;

    public void saveDB(Object obj) throws NullPointerException, NoMethod;

    public Object getObject() throws NullPointerException, NoMethod;
}