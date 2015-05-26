package com.umbra.mobModule.itemComponent.inter;
import java.util.List;


public interface IItemPuzzle extends IItem {

    public List<String> getAdjectives();
    public void newAdjective(String newAdj);
    public void modAdj(String src, String newAdj);
}
