package com.umbra.vultoModule;

public enum Action {
    HIDE("You try to hide and you are so scared that can't move a muscle. ","But he finds you and everything become dark.",
            "He passes through where you are, but you don't see each other.",45.0/100.0),
    RUN("You try to run, faster than you ever ran before. ","But he reaches you and everything become dark.",
            "You let him behind, but don't have sure where you are.",90.0/100.0),
    FIGHT("He is coming and you will see his face. That is the last thing you remember before everything became dark.",
            "","",0.0);

    public String answer;
    public String lost;
    public String won;
    public double probability_constant;

    Action(String answer,String lost, String won, double probability_constant){
        this.answer = answer;
        this.lost = lost;
        this.won = won;
        this.probability_constant = probability_constant;
    }
}
