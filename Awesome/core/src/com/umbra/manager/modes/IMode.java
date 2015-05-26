package com.umbra.manager.modes;

import com.umbra.manager.IComunicator;

public interface IMode {
    public abstract void init(IComunicator comunicator);
    public abstract void update(float dt);
    public abstract void draw();
    public abstract void handleInput();
    public abstract void dispose();
}
