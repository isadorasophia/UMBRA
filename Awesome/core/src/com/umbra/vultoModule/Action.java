package com.umbra.vultoModule;

public enum Action {

    HIDE("You try to hide and you are so scared that can't move a muscle. ",
            "But he finds you and everything become dark.",
            "He passes through where you are, but you don't see each other.",45.0/100.0),
    RUN("You try to run, faster than you ever ran before. ",
            "The figure approaches. No, no, it can't be! As it comes closer and closer, you begin to recognize it… Yes, it is horrible, but far worse than you could imagine. You want to cry, to scream… useless.",
            "Somehow, you found a reason to not give up. You run for your life, for your luck and your sake - and you succeed. For once.",90.0/100.0),
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
