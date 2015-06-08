package com.umbra.manager.interfaces;

import anima.annotation.ComponentInterface;
import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.modes.Modes;

@ComponentInterface("<http://purl.org/NET/dcc/com.umbra.com.umbra.manager.interfaces.IMode>")
public interface IMode {

    public abstract void init(IComunicator comunicator, Characters characters);
    public abstract Modes update(float dt);
    public abstract void draw();
    public abstract void handleInput();
    public abstract void dispose();

}
