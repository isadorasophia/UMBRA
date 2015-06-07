package com.umbra.dbModule;

import anima.annotation.*;
import anima.component.base.ComponentBase;

import java.io.*;

@Component(
        id = "<http://purl.org/NET/dcc/com.umbra.dbModule.umbraDBTXT>",
        provides = {"<http://purl.org/NET/dcc/com.umbra.dbModule.iDB"}
)

public class UmbraDBTXT extends ComponentBase implements iDB{
    private String path;
    private File file;

    // Construtor
    public umbraDBTXT(String name_of_file){
        path = name_of_file + ".txtdb";

        try {
            file = new File(path);
            if( !file.exists() ) {
                file.createNewFile();
            }
        }
        //Caso não tenha encontrado o arquivo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Caso tenha dado algum outro erro
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedReader readDB(){
        FileReader openedFile = null;
        //Faz o arquivo em disco ir para a memória para agilizar a leitura
        BufferedReader bufferedFile = null;

        try{
            openedFile = new FileReader(file);
            bufferedFile = new BufferedReader(openedFile);
        }catch (IOException e) {
            e.printStackTrace();
        }

        return bufferedFile;
    }

    private void closeDB(BufferedReader reader){
        try{
            reader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getFromDB() throws NullPointerException{
        String linha;
        String valor = "";
        BufferedReader bufferedFile = this.readDB();

        try{
            while ((linha = bufferedFile.readLine()) != null) {
                valor = valor + linha + '\n';
            }
            return valor;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            this.closeDB(bufferedFile);
        }

        throw new NullPointerException();

    }

    @Override
    public String[] getFromDB(String info) throws NullPointerException, NoMethod {
    	throw new NoMethod("Esse DB n�o suporta esse tipo de m�todo, tente usar este m�todo"
				+ "sem passar par�metros");
    }

    @Override
    public String[] getFromDB(String info1, String info2) throws NullPointerException, NoMethod{
    	throw new NoMethod("Esse DB n�o suporta esse tipo de m�todo, tente usar este m�todo"
    						+ "sem passar par�metros");
    }

    @Override
    public boolean saveDB(Object obj)throws NullPointerException, NoMethod {
    	throw new NoMethod("Esse DB n�o suporta esse tipo de m�todo");
    }

    @Override
    public Object getObject()throws NullPointerException, NoMethod {
    	throw new NoMethod("Esse DB n�o suporta esse tipo de m�todo");
    }

}