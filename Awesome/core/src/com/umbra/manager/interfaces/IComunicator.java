package com.umbra.manager.interfaces;

public interface IComunicator {
    public void setText(String fullText);
    public String getInput();
    public boolean update(float dt);
    public void draw();
    public void dispose();
}
