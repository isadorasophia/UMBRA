package com.umbra.dbModule;

//Apenas para Teste
public class DbTeste{

    public static void main(String args[]){
        //Criacao da fabrica
        //Cada modulo deve colocar o nome do modulo (String) no construtor
        //Nesse caso seria o módulo "teste"
        DBFactory factory = new DBFactory("item");

        iDB objectDBCSV = factory.getDB(TypeDB.CSV);
        iDB objectDBTXT = factory.getDB(TypeDB.TXT);
        iDB objectDBXML = factory.getDB(TypeDB.XML);

        /* ---- Teste CSV ---- */
        //Retorna um vetor de string
        String[] csv = null;
        try {
            csv = objectDBCSV.getFromDB("itemPuzzle");
		} catch (NullPointerException | NoMethod e) {
			e.printStackTrace();
		}


        System.out.println("Toda a linha do CSV que possua a palavra itemPuzzle:");
        for(String a : csv){
            System.out.println(a);
        }

        /* ---- Teste TXT ---- */
        //Retorna uma unica string que contem todo o conteudo do arquivo

        String txt = null;
        try {
			txt = objectDBTXT.getFromDB();
		} catch (NullPointerException | NoMethod e) {
			e.printStackTrace();
		}
        System.out.println("O arquivo em txt:");
        System.out.println(txt);


        /* ---- Testes XML ---- */
        //Deve salvar qualquer tipo de objeto e de recuperá-lo!
        /*
        ObjectForTestsPurposeOnly primeiroObjeto = new ObjectForTestsPurposeOnly();
        ObjectForTestsPurposeOnly segundoObjeto = null;

        primeiroObjeto.cresce();
        primeiroObjeto.cresce();
        primeiroObjeto.cresce();
        //Salva o primeiro objeto no arquivo
        try {
            objectDBXML.saveDB(primeiroObjeto);
		} catch (NullPointerException | NoMethod e) {
			e.printStackTrace();
		}
        //Resgata o objeto 1 e salva em 2
        try {
            segundoObjeto = (ObjectForTestsPurposeOnly)objectDBXML.getObject();
		} catch (NullPointerException | NoMethod e) {
			e.printStackTrace();
		}

        System.out.println( segundoObjeto.getIdade() );
        */
    }
}
