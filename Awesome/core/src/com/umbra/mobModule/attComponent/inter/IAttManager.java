package com.umbra.mobModule.attComponent.inter;

import anima.annotation.ComponentInterface;
import anima.component.ISupports;

/**
 * Interface para a criação de atributos
 * 
 * @author luizfrf
 *
 */

@ComponentInterface(
		"<http://purl.org/NET/dcc/com.umbra.mobModule.attComponent.inter.IAttManager>")

public interface IAttManager extends ISupports {
	public IAttribute create(String name, double value);
    public IAttribute create(String name, double value, Double max);
    public IAttribute create(Double min, String name, double value);
    public IAttribute create(Double min, String name, double value, Double max);
}
