package com.umbra.dbModule;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;

import java.io.*;

@ComponentInterface(
        value = "<http://purl.org/NET/dcc/com.umbra.dbModule.iDB>"
)

public interface iDB extends ISupports {
    public BufferedReader readDB();
    public String getFromDB();
    public String[] getFromDB(String info);
    public String[] getFromDB(String info1, String info2);
}
