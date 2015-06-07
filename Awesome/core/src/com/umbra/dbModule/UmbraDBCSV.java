package com.umbra.dbModule;

import anima.component.IRequires;
import anima.component.ISupports;
import anima.component.InterfaceType;

import java.io.*;

public class UmbraDBCSV implements iDB{
    private String path;
    private File file;

    // Construtor do banco de dados
    public UmbraDBCSV(String name_of_file){
        path = name_of_file + ".csvdb";

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

    public BufferedReader readDB(){
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

    public void closeDB(BufferedReader reader){
        try{
            reader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public String getFromDB() throws NullPointerException {
        throw new NullPointerException();
    }

    public String[] getFromDB(String info) throws NullPointerException{
        String linha;
        String[] valores;
        BufferedReader bufferedFile = this.readDB();

        try{
            while (bufferedFile !=  null) {
                linha = bufferedFile.readLine();
                valores = linha.split(",");
                for(int i = 0; i < valores.length; i++){
                    if(valores[i].equalsIgnoreCase(info)){
                        return valores;
                    }
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            this.closeDB(bufferedFile);
        }

        throw new NullPointerException();
    }

    //Sobrecarga de métodos
    public String[] getFromDB(String info1, String info2) throws NullPointerException {
        Boolean achou = false;
        String linha;
        String[] valores;
        BufferedReader bufferedFile = this.readDB();

        try{
            while (bufferedFile !=  null) {
                linha = bufferedFile.readLine();
                valores = linha.split(",");
                for(int i = 0; i < valores.length; i++){
                    if(valores[i].equalsIgnoreCase(info1) || valores[i].equalsIgnoreCase(info2)){
                        if(achou){
                            return valores;
                        }
                        achou = true;
                    }
                }
            }
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
    public <T extends ISupports> T queryInterface(String s) {
        return null;
    }

    @Override
    public <T extends ISupports> T queryInterface(String s, InterfaceType interfaceType) {
        return null;
    }

    @Override
    public <T extends ISupports> IRequires<T> queryReceptacle(String s) {
        return null;
    }

    @Override
    public int addRef() {
        return 0;
    }

    @Override
    public int release() {
        return 0;
    }

    @Override
    public String getInstanceId() {
        return null;
    }
}
