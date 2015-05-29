package com.umbra.dbModule;

import java.io.*;

public class dbReader {

    //Talvez fazer um factory que a primeira vez que o cara abrir um db ele ficar aberto?

    private static String openFile(String path, String info){
        //Abre o arquivo em disco
        File file = new File(path);
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
