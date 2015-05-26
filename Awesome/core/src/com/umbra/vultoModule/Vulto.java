package com.umbra.vultoModule;

import anima.annotation.Component;


@Component(
		id="<http://purl.org/NET/dcc/com.umbra.vultoModule.Vulto>",
		provides={"<http://purl.org/NET/dcc/com.umbra.com.umbra.vultoModule.IVulto>"}
)
public class Vulto implements IVulto {
    private int distance;
    private double lightProtection;

    public Vulto(){
        distance = 100;
        lightProtection = 0;
    }
    public boolean checkVulto(){
        return distance-- == 0;
    }
    public void lightInterference(double light){
    	lightProtection = light;
    }

    public boolean chooseAction(String action) throws UnknownInputException {
        boolean areAlive = false;
        if(action.equalsIgnoreCase("fight")) areAlive = chooseAction(Action.FIGHT);
        else if(action.equalsIgnoreCase("hide")) areAlive = chooseAction(Action.HIDE);
        else if(action.equalsIgnoreCase("run")) areAlive = chooseAction(Action.RUN);
        else throw new UnknownInputException();
        return areAlive;
    }

    public boolean chooseAction(Action action) {
        return false;
    }
}
