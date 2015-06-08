package com.umbra.battleModule;

/**
 * Classe representativa da parte do corpo a ser atacado durante a batalha
 * 
 * @author Matheus Mortatti Diamantino 156740
 * @author Isadora Sophia Garcia Rodopoulos 158018
 *
 */
public class BodyPart {
    /**
     * Por quanto que o ataque final será aumentado se sucedeer
     */
    private float attackFactor;
    
    /**
     * Chance de sucesso do ataque na dada parte do corpo
     */
    private float hitChance;
    
    /**
     * Nome da parte do corpo
     */
    private String bodyPart;
    
    /**
     * Getter para o fator de ataque
     * 
     * @return float - Fator de ataque
     */
    public float getAttFactor () { return this.attackFactor; }
    
    /**
     * Getter para a chance de ataque
     * 
     * @return float - Chance de ataque
     */
    public float getHitChance () { return this.hitChance; }
    
    /**
     * Getter para o nome da parte do corpo
     * 
     * @return String - Nome da parte do corpo
     */
    public String getBodyPart () { return this.bodyPart; }

    /**
     * Construtor da classe
     * 
     * @param bodyPart
     * @param attackFactor
     * @param hitChance
     */
    public BodyPart (String bodyPart, float attackFactor, float hitChance) {
        this.attackFactor = attackFactor;
        this.hitChance = hitChance;
        this.bodyPart = bodyPart;
    }
}
