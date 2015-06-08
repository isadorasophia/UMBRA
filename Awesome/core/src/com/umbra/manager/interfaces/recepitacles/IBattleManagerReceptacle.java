package com.umbra.manager.interfaces.recepitacles;

import anima.annotation.ComponentInterface;
import com.umbra.battleModule.IBattleManager;

@ComponentInterface("<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IBattleManegerReceptacle>")
public interface IBattleManagerReceptacle {
    public void connect(IBattleManager battleManager);
}
