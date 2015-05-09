package com.umbra.mapModule;

public interface IPosition {
    public Boolean moveNorth(ICell norte, ICell atual);
    public Boolean moveSouth(ICell sul, ICell atual);
    public Boolean moveWest(ICell oeste, ICell atual);
    public Boolean moveEast(ICell leste, ICell atual);
    public int getX();
    public int getY();
}
