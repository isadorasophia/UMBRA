package com.umbra.dbModule;

// FALTA IMPLEMENTAR

import anima.annotation.*;
import anima.component.base.ComponentBase;

import java.io.BufferedReader;

@Component(
        id = "<http://purl.org/NET/dcc/com.umbra.dbModule.umbraDBXML>",
        provides = {"<http://purl.org/NET/dcc/com.umbra.dbModule.iDB"}
)

public class UmbraDBXML extends ComponentBase implements iDB{
    public UmbraDBXML(){
        System.out.println("XML");
    }

    @Override
    public BufferedReader readDB() {
        return null;
    }

    @Override
    public String getFromDB() {
        return null;
    }

    @Override
    public String[] getFromDB(String info) {
        return new String[0];
    }

    @Override
    public String[] getFromDB(String info1, String info2) {
        return new String[0];
    }
}
