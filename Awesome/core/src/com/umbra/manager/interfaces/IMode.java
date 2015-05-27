package com.umbra.manager.interfaces;

import com.umbra.manager.Characters;
import com.umbra.manager.interfaces.IComunicator;

public interface IMode {
    public abstract void init(IComunicator comunicator, Characters characters);
    public abstract void update(float dt);
    public abstract void draw();
    public abstract void handleInput();
    public abstract void dispose();
}
