package com.umbra.dbModule;

import java.io.*;

public class umbraBase{
    private String path;
    private File file;

    // Construtor do banco de dados
    public umbraBase(String name_of_file){
        path = "core/dataBase/" + name_of_file;

        try {
            file = new File(path);
            if( !file.exists() ) {
                file.createNewFile();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Caso tenha ddo algum outro erro
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Talvez fazer um factory que a primeira vez que o cara abrir um db ele ficar aberto?

    private String readDb(String info){
        //Abre o arquivo em disco
        FileInputStream openedFile = null;
        //Faz o arquivo em disco ir para a memória para agilizar a leitura
        BufferedReader bufferedFile = null;
        String linha;
        String[] valores;

        try {
            openedFile = new FileInputStream(file);
            bufferedFile = new BufferedReader(openedFile);

            while (bufferedFile !=  null) {
                linha = bufferedFile.readLine();
                valores = linha.split(",");
                for(int i = 0; i < valores.length; i++){
                    if(valores[i].equalsIgnoreCase(info)){
                        return valores;
                    }
                }
            }

            bufferedFile.close();
            openedFile.close();
        }
        //Primeiro catch caso passe o arquivo com nome errado
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Caso tenha ddo algum outro erro
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
