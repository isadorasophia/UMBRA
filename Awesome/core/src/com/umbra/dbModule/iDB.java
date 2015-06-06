package com.umbra.dbModule;

import java.io.*;

public interface iDB{
    public BufferedReader readDB();
    public String getFromDB();
    public String[] getFromDB(String info);
    public String[] getFromDB(String info1, String info2);
}
