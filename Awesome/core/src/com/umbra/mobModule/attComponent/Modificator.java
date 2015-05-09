package com.umbra.mobModule.attComponent;

import java.util.*;

public interface Modificator {
    public IAttribute modify(IAttribute src, List<Double> parameter);
}
