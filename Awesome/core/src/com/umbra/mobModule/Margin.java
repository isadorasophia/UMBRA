package com.umbra.mobModule;

/**
 * Classe que ajudava a imprimir as informações formatadas
 * que ajudava a debugar o código internamente
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class Margin {
    private int space;
    public static final int UNIDADE = 4;
    private Margin (int space){
        this.space = space;
    }
    private Margin(){
        this.space = 0;
    }
    public static String ident(int n){
        Margin inception = new Margin(n);
        return inception.ident();
    }
    public static String ident(int n, String toIdent){
        Margin inception = new Margin(n);
        return inception.ident(toIdent);
    }
    public String ident(){
        String resp = "";
        for(int i = 0; i < space; i++){
            resp += " ";
        }
        return resp;
    }
    public String ident(String toIdent){
        return ident() + toIdent + "\n";
    }
    public int getSpace(){
        return space;
    }
    public int nextSpace(){
        return getSpace() + UNIDADE;
    }
    public Margin next(){
        return new Margin(nextSpace());
    }
    public static Margin first(){
        return new Margin();
    }

}
