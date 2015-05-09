package com.umbra.mobModule.attComponent;

public interface IModAtt {
    public IAttribute modify(IAttribute src);
    public IAttribute unmodify(IAttribute src);
    public String getName();
}
