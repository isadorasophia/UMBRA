package com.umbra.dbModule.data;

/**
 * Classe utilizada para fornecer um path para o banco de dados.
 * 
 * @author Henrique Noronha Facioli
 * @author Thiago Silva de Farias
 *
 */
public class Directory {
    public static String DIRETORIO = Directory.class.getResource(".").getPath();
}
