package com.umbra.manager;

public interface IComunicator {
    public void setText(String fullText);
    public boolean update(float dt);
    public void draw();
    public void dispose();
}
