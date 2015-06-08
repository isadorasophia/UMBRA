package com.umbra.mobModule.exceptions;

/**
 * Exceção que é disparada quando o inventário está cheio e
 * se deseja adicionar um novo item nele, sendo que ela
 * também tem uma variável para guardar a quantidade de
 * itens que tinham sido colocados antes de lotar
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public class FullInventoryException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 9141170041645409555L;
	private int addItens;
	public FullInventoryException() {
        super();
    }
    public FullInventoryException(String message) {
        super(message);
    }
    public FullInventoryException(String message, Throwable cause) {
        super(message, cause);
    }
    public FullInventoryException(Throwable cause) {
        super(cause);
    }
    public int getAddItens(){
        return addItens;
    }
    public void setAddItens(int addItens){
        this.addItens = addItens;
    }
}
