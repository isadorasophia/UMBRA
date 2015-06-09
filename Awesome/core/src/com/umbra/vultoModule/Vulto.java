package com.umbra.vultoModule;

import anima.annotation.Component;
import anima.component.base.ComponentBase;

import com.umbra.Exceptions.EmptyInputException;
import com.umbra.Exceptions.InputException;
import com.umbra.Exceptions.UnknownInputException;

import java.util.Random;


@Component(
		id="<http://purl.org/NET/dcc/com.umbra.vultoModule.Vulto>",
		provides={"<http://purl.org/NET/dcc/com.umbra.com.umbra.vultoModule.IVulto>"}
)
public class Vulto extends ComponentBase implements IVulto {

    private int distance;
    private double lightProtection;

    public Vulto(){
        distance = 1000;
        lightProtection = 0;
    }

    public boolean checkVulto(){
        return distance+lightProtection == 0;
    }

    public void lightInterference(double light){
    	lightProtection = light;
    }

    public boolean chooseAction(String action, StringBuilder result, double luck) throws InputException {
        boolean isAlive = false;

        System.out.print(action);
        if(action.length() == 0) throw new EmptyInputException();
        if(action.equalsIgnoreCase("f") || action.equalsIgnoreCase("face")) isAlive = chooseAction(Action.FIGHT, result, luck);
        else  if(action.equalsIgnoreCase("h") || action.equalsIgnoreCase("hide")) isAlive = chooseAction(Action.HIDE, result, luck);
        else if(action.equalsIgnoreCase("r") || action.equalsIgnoreCase("run")) isAlive = chooseAction(Action.RUN, result, luck);
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
