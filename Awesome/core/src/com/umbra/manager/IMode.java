package com.umbra.manager;

/**
 * Created by gsiqueira on 5/8/15.
 */
public interface IMode {
    public abstract void init();
    public abstract void update(float dt);
    public abstract void draw();
    public abstract void handleInput();
    public abstract void dispose();
}
