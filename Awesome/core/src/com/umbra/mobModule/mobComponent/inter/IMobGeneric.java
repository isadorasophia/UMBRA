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
	 * @param type : nome do atributo
	 * @return O atributo
	 */
    public IAttribute getAtt(String type);

    /**
     * Modifica um atributo com um valor, mas mantém
     * os valores mínimos e máximos antigos
     * @param type : nome do atributo
     * @param value : valor novo
     */
    public void setAtt(String type, double value);
    
    /**
     * Modifica um atributo e seu valor máximo, muda mínimo para null
     * @param type : nome do atributo
     * @param value : valor novo
     * @param max : novo máximo
     */
    public void setAtt(String type, double value, double max);
    
    /**
     * Modifica um atributo e seu valor mínimo, muda máximo para null
     * @param min : novo mínimo
     * @param type : nome do atributo
     * @param value : valor novo
     */
    public void setAtt(double min, String type, double value);
    
    /**
     * Modifica um atributo, seus valores mínimo e máximo
     * @param min : novo mínimo
     * @param type : nome do atributo
     * @param value : valor novo
     * @param max : novo máximo
     */
    public void setAtt(double min, String type, double value, double max);

    /**
     * Checa se o mob genérico tem o atributo
     * @param name : nome do atributo
     * @return Se o mob genérico tem o atributo
     */
    public boolean hasAtt(String name);
}
