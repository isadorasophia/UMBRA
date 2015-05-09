package com.umbra.mobModule.attComponent;

public interface Modificator {
    public IAttribute modify(IAttribute src, double ... parameters);
    public IAttribute unmodify(IAttribute src, double ... parameters);
}
