package com.umbra.mobModule.attComponent.inter;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;

/**
 * Interface para a criação de atributos
 * 
 * @author Luiz Fernando Rodrigues da Fonseca
 * @author Lucas Alves Racoci
 *
 */

@ComponentInterface(
		"<http://purl.org/NET/dcc/com.umbra.mobModule.attComponent.inter.IAttManager>")

public interface IAttManager extends ISupports {
    /**
     * Substitui o primeiro construtor de Attribute, recebendo como parâmetros:
     * @param name : o nome do atributo a ser criado
     * @param value : o valor inicial do atributo a ser criado
     * @return : retorna o atributo construído com os parâmetros passados
     */
    public IAttribute create(String name, double value);

    /**
     * Substitui o segundo construtor de Attribute, recebendo como parâmetros:
     * @param name : o nome do atributo a ser criado
     * @param value : o valor inicial do atributo a ser criado
     * @param max : o valor máximo do atributo a ser criado
     * @return : retorna o atributo construído com os parâmetros passados
     */
    public IAttribute create(String name, double value, double max);

    /**
     * Substitui o terceiro construtor de Attribute, recebendo como parâmetros:
     * @param min : o valor mínimo do atributo a ser criado
     * @param name : o nome do atributo a ser criado
     * @param value : o valor inicial do atributo a ser criado
     * @return : retorna o atributo construído com os parâmetros passados
     */
    public IAttribute create(double min, String name, double value);

    /**
     * Esse é o mais completo de todos os construtores de Attribute, permite que o atributo esteja limitado em um
     * intervalo conexo, também é o que produz o atributo mais limitado, setando os parâmetros:
     * @param min : o valor mínimo do atributo a ser criado
     * @param name : o nome do atributo a ser criado
     * @param value : o valor inicial do atributo a ser criado
     * @param max : o valor máximo do atributo a ser criado
     * @return : retorna o atributo construído com os parâmetros passados
     */
    public IAttribute create(Double min, String name, double value, Double max);
    public IAttribute create(double min, String name, double value, double max);
}
