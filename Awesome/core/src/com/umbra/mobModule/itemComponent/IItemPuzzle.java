package com.umbra.mobModule.itemComponent;
import java.util.List;


public interface IItemPuzzle extends IItemGeneric {

    public List<String> getAdjectives();
    public void newAdjective(String newAdj);
    public void modAdj(String src, String newAdj);
}
