package com.umbra.manager;

import com.umbra.manager.modes.Modes;

public interface ISelector {
    public void setMode(Modes state);
    public void update(float dt);
    public void draw();
    public void dispose();
}
