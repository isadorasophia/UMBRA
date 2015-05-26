package com.umbra.vultoModule;

public interface IVulto {
    public boolean checkVulto();
    public void lightInterference(double light);
    public boolean chooseAction(String action) throws UnknownInputException;
}
