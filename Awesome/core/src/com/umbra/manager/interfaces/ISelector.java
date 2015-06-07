package com.umbra.manager.interfaces;

import anima.annotation.ComponentInterface;
import com.umbra.manager.modes.Modes;

@ComponentInterface("<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.ISelector>")
public interface ISelector {

    public void init();
    public void setMode(Modes state);
    public void update(float dt);
    public void draw();
    public void dispose();

}
