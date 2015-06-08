package com.umbra.dbModule;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import java.io.*;

import com.umbra.dbModule.data.Directory;

@Component(
        id = "<http://purl.org/NET/dcc/com.umbra.dbModule.UmbraDBTXT>",
        provides = {"<http://purl.org/NET/dcc/com.umbra.dbModule.iDB"}
)

public class UmbraDBTXT extends ComponentBase implements iDB{
    private String path;
    private File file;
    private String dir = Directory.DIRETORIO;

    // Construtor
    public UmbraDBTXT(String name_of_file){
        path = dir + name_of_file + ".txtdb";

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
    	throw new NoMethod("Esse DB não suporta esse tipo de método, tente usar este método"
				+ "sem passar parâmetros");
    }

    @Override
    public String[] getFromDB(String info1, String info2) throws NullPointerException, NoMethod{
        throw new NoMethod("Esse DB não suporta esse tipo de método, tente usar este método"
				+ "sem passar parâmetros");
    }

    @Override
    public void saveDB(Object obj)throws NullPointerException, NoMethod {
    	throw new NoMethod("Esse DB não suporta esse tipo de método");
    }

    @Override
    public Object getObject()throws NullPointerException, NoMethod {
    	throw new NoMethod("Esse DB não suporta esse tipo de método");
    }


}
