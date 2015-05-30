package com.umbra.vultoModule;

import anima.annotation.Component;
import anima.component.base.ComponentBase;


@Component(
		id="<http://purl.org/NET/dcc/com.umbra.vultoModule.Vulto>",
		provides={"<http://purl.org/NET/dcc/com.umbra.com.umbra.vultoModule.IVulto>"}
)
public class Vulto extends ComponentBase implements IVulto {
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

    public boolean chooseAction(String action, StringBuilder result) throws UnknownInputException {
        boolean isAlive = false;
        System.out.print(action);
        if(action.equalsIgnoreCase("f")) isAlive = chooseAction(Action.FIGHT,result);
        else if(action.equalsIgnoreCase("h")) isAlive = chooseAction(Action.HIDE, result);
        else if(action.equalsIgnoreCase("r")) isAlive = chooseAction(Action.RUN, result);
        else throw new UnknownInputException();
        return isAlive;
    }

    public boolean chooseAction(Action action, StringBuilder result) {
    	switch(action){
    	case FIGHT:
    		result.append("fight");
    		break;
    	case HIDE:
    		result.append("hide");
    		break;
    	case RUN:
    		result.append("run");
    		break;
    	}
        return false;
    }
}
