package com.umbra.mobModule.attComponent.impl;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.mobModule.attComponent.inter.IAttManager;
import com.umbra.mobModule.attComponent.inter.IAttribute;

@Component(
		id="<http://purl.org/NET/dcc/com.umbra.mobModule.attComponent.impl.AttCreator>",
		provides={"<http://purl.org/NET/dcc/com.umbra.mobModule.attComponent.inter.IAttManager>"}
)

public class AttCreator extends ComponentBase implements IAttManager {
    /**
     * Substitui o primeiro construtor de Attribute, recebendo apenas o nome e o valor inicial, cria um atributo que
     * poderá ser lido e modificado pelos outros componentes.
     * @param name : o nome do atributo a ser criado
     * @param value : o valor inicial do atributo a ser criado
     * @return : retorna o atributo construído com os parâmetros passados
     */
    public IAttribute create(String name, double value){
        IAttribute resp;
        resp = new Attribute(name, value);
        return resp;
    }

    /**
     * Semelhante ao anterior, esse método susbstitui o segundo construtor de Attribute, que recebe, além do que já
     * foi explicitado no anterior, o valor máximo do atributo.
     * @param name : o nome do atributo a ser criado
     * @param value : o valor inicial do atributo a ser criado
     * @param max : o valor máximo do atributo a ser criado
     * @return : retorna o atributo construído com os parâmetros passados
     */
    public IAttribute create(String name, double value, double max){
        IAttribute resp;
        resp = new Attribute(name, value, max);
        return resp;
    }

    /**
     * Semelhante ao anterior, mas dessa vez substituindo o terceiro construtor de Attribute e recebendo, e recebendo
     * o valor mínimo ao invés do máximo. A ordem que os parâmetros são passados serve para que todos estes métodos
     * tenham assinaturas diferentes apesar de nomes iguais.
     * @param min : o valor mínimo do atributo a ser criado
     * @param name : o nome do atributo a ser criado
     * @param value : o valor inicial do atributo a ser criado
     * @return : retorna o atributo construído com os parâmetros passados
     */
    public IAttribute create(double min, String name, double value){
        IAttribute resp;
        resp = new Attribute(min, name, value);
        return resp;
    }

    /**
     * Esse é o mais completo de todos os construtores de Attribute, recebendo tanto o valor máximo quanto o mínimo,
     * permite que o atributo esteja limitado em um intervalo conexo, também é o que produz o atributo mais limitado
     * @param min : o valor mínimo do atributo a ser criado
     * @param name : o nome do atributo a ser criado
     * @param value : o valor inicial do atributo a ser criado
     * @param max : o valor máximo do atributo a ser criado
     * @return : retorna o atributo construído com os parâmetros passados
     */
    public IAttribute create(Double min, String name, double value, Double max){
        IAttribute resp;
        resp = new Attribute(min, name, value,  max);
        return resp;
    }
    public IAttribute create(double min, String name, double value, double max){
        IAttribute resp;
        resp = new Attribute(min, name, value,  max);
        return resp;
    }

}
