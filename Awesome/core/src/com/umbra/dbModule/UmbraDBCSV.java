import java.io.*;

public class UmbraDBCSV implements iDB{
    private String path;
    private File file;

    // Construtor do banco de dados
    public umbraBase(String name_of_file){
        path = name_of_file;

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

    public BufferedReader readDB(){
        FileReader openedFile = null;
        //Faz o arquivo em disco ir para a memória para agilizar a leitura
        BufferedReader bufferedFile = null;

        try {
            openedFile = new FileReader(file);
            bufferedFile = new BufferedReader(openedFile);

            return bufferedFile;
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

    public void closeDB(BufferedReader reader){
        reader.close();
    }

    public String[] searchDB(String info){
        String linha;
        String[] valores;
        BufferedReader bufferedFile = this.readDB();


        while (bufferedFile !=  null) {
            linha = bufferedFile.readLine();
            valores = linha.split(",");
            for(int i = 0; i < valores.length; i++){
                if(valores[i].equalsIgnoreCase(info)){
                    return valores;
                }
            }
        }

        return null;
    }

    //Sobrecarga de métodos
    public String[] searchDB(String info1, String info2){
        Boolean achou = false;
        String linha;
        String[] valores;
        BufferedReader bufferedFile = this.readDB();

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

        return null;
    }
}
