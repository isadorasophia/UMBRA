package com.umbra.battleModule;

public class BodyPart {
    // By how much the final attack will increase if it succeeds (1 ~ 2)
    private float attackFactor;
    // Chance of succeeding the attack on the body part
    private float hitChance;
    // The name of the bodyPart
    private String bodyPart;



    public BodyPart (String bodyPart, float attackFactor, float hitChance) {
        this.attackFactor = attackFactor;
        this.hitChance = hitChance;
        this.bodyPart = bodyPart;
    }

    public float getAttFactor () {
        return this.attackFactor;
    }

    public float getHitChance () {
        return this.hitChance;
    }

    public String getBodyPart () {
        return this.bodyPart;
    }

}
