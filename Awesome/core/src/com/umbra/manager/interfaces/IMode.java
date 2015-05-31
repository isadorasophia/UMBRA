package com.umbra.manager.interfaces;

import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IComunicator;
import com.umbra.manager.modes.Modes;

public interface IMode {
    public abstract void init(IComunicator comunicator, Characters characters);
    public abstract Modes update(float dt);
    public abstract void draw();
    public abstract void handleInput();
    public abstract void dispose();
}
