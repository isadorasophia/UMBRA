package com.umbra.mobModule.mobComponent.inter;

import com.umbra.mobModule.attComponent.inter.IAttribute;
import com.umbra.mobModule.interGenerics.*;

/**
 * Interface que possui os métodos de um mob genérico
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IMobGeneric extends
        IPositionable,
        IDescriptionReadable,
        INameReadable,
        ITypeReadable,
        Stringlizable
{
	
	/**
	 * Pega um atributo do mob genérico
	 * @param type
	 * @return
	 */
    public IAttribute getAtt(String type);

    /**
     * Modifica um atributo com um valor
     * @param type
     * @param value
     */
    public void setAtt(String type, double value);
    
    /**
     * Modifica um atributo e seu valor máximo
     * @param type
     * @param value
     * @param max
     */
    public void setAtt(String type, double value, double max);
    
    /**
     * Modifica um atributo e seu valor mínimo
     * @param min
     * @param type
     * @param value
     */
    public void setAtt(double min, String type, double value);
    
    /**
     * Modifica um atributo, seus valores mínimo e máximo
     * @param min
     * @param type
     * @param value
     * @param max
     */
    public void setAtt(double min, String type, double value, double max);

    /**
     * Checa se o mob genérico tem o atributo
     * @param name
     * @return
     */
    public boolean hasAtt(String name);
}
