package com.umbra.dbModule;

// FALTA IMPLEMENTAR

@ComponentInterface(
        id = "<http://purl.org/NET/dcc/com.umbra.dbModule.umbraDBXML>"
        provides = {"<http://purl.org/NET/dcc/com.umbra.dbModule.iDB"}
)

public class umbraDBXML extends ComponentBase implements iDB{
    public umbraDBXML(){
        System.println("XML");
    }
}
