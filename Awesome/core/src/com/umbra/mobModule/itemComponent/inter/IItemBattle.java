package com.umbra.mobModule.itemComponent.inter;

import com.umbra.mobModule.enums.Operation;
import com.umbra.mobModule.exceptions.CannotDoubleModifyAttributeException;
import com.umbra.mobModule.exceptions.CannotUnmodifyWhatHasNotBeenModifiedException;
import com.umbra.mobModule.mobComponent.inter.IMob;

/**
 * Interface que contém os métodos de um item de batalha que será usado no jogo
 * 
 * @author Lucas Alves Racoci
 * @author Luiz Fernando Rodrigues da Fonseca
 *
 */

public interface IItemBattle extends IItem {
    /**
     * Adiciona um modificador de atributos
     * @param attName nome do atributo a ser modificado
     * @param parameter parametro usado para modificar o atributo
     * @param type modificação a ser feita
     */
    public void addModAtt(String attName, double parameter, Operation type);

    /**
     * Adiciona um modificador de atributos do tipo que adiciona valores
     * @param attName nome do atributo a ser modificado
     * @param parameter valor que será adicionado quando este modificador for acionado
     */
    public void addModAtt(String attName, double parameter);

    /**
     * Atualiza os atributos de um mob com os modificadores de atributos pertinentes
     * @param src Mob com os atributos a serem modificados
     * @throws CannotDoubleModifyAttributeException  Exceção lançada quando houver tentativa de remodificar um atributo
     *                                               que já foi modificado pelo mesmo modificador de atributo
     */
    public void updateMob(IMob src) throws CannotDoubleModifyAttributeException ;

    /**
     * Desfaz tudo que o método responsável por atualizar o mob fez
     * @param src Mob com os atributos a serem desmodificados
     * @throws CannotUnmodifyWhatHasNotBeenModifiedException Exceção lançada quando houver tentativa de desmodificar
     *                                                       um mob que ainda não tenha sido modificado
     */
    public void unupdateMob(IMob src) throws CannotUnmodifyWhatHasNotBeenModifiedException;
}
