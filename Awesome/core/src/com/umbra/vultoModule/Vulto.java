package com.umbra.vultoModule;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import java.util.Random;


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

    public boolean chooseAction(String action, StringBuilder result, double luck) throws UnknownInputException {
        boolean isAlive = false;

        System.out.print(action);
        if(action.charAt(0) == 'f' || action.charAt(0) == 'F') isAlive = chooseAction(Action.FIGHT, result, luck);
        else  if(action.charAt(0) == 'h' || action.charAt(0) == 'H') isAlive = chooseAction(Action.HIDE, result, luck);
        else if(action.charAt(0) == 'r' || action.charAt(0) == 'R') isAlive = chooseAction(Action.RUN, result, luck);
        else throw new UnknownInputException();
        return isAlive;
    }

    public boolean chooseAction(Action action, StringBuilder result, double luck) {
        Random random = new Random();
        boolean live;

        result.append(action.answer);
        if (random.nextDouble() % 100 < action.probability_constant * luck) {
            result.append(action.won);
            live = true;
        }else{
            result.append(action.lost);
            live = false;
        }
        return live;
    }
}
