/**
 * A character in the game which is capable of fighting, primarily enemies
 */
public class HostileCharacter extends Character{
    private int strength, agility, defense, maxHealth, currentHealth;
    private String attackMessage;
    
    /**
     * Constructs a HostileCharacter with the appropriate parameters
     * @param name The character's name
     * @param s The character's strength
     * @param a The character's agility
     * @param d The character's defense
     * @param h The character's maximum health, which also sets their current health
     * @param aM What the character says/does while attacking
     */
    public HostileCharacter(String name, int s, int a, int d, int h, String aM){
        super(name);
        strength = s;
        agility = a;
        defense = d;
        currentHealth = maxHealth = h;
        attackMessage = aM;
    }
    
    /**
     * Returns a formatted string with the name, current health, max health, strength, agility, and defense of the character
     */
    public String toString(){
        return String.format("%-15s  %-12s  %-9s  %-9s  %-9s", getName()+":", "[HP "+currentHealth+"/"+maxHealth+"]", "[STR "+strength+"]", "[AGI "+agility+"]", "[DEF "+defense+"]");
    }
    
    /**
     * Sets the strength of the character to str
     */
    public void setStrength(int str){strength = str;}
    
    /**
     * Returns the strength of the character
     */
    public int getStrength(){return strength;}
    
    /**
     * Sets the agility of the character to agi
     */
    public void setAgility(int agi){agility = agi;}
    
    /**
     * Returns the agility of the character
     */
    public int getAgility(){return agility;}
    
    /**
     * Sets the defense of the character to def
     */
    public void setDefense(int def){defense = def;}
    
    /**
     * Returns the defense of the character
     */
    public int getDefense(){return defense;}
    
    /**
     * Sets the current health of the character to cH
     */
    public void setCurrentHealth(int cH){currentHealth = cH;}
    
    /**
     * Returns the current health of the character
     */
    public int getCurrentHealth(){return currentHealth;}
    
    /**
     * Sets the max health of the character to mH
     */
    public void setMaxHealth(int mH){maxHealth = mH;}
    
    /**
     * Returns the max health of the character
     */
    public int getMaxHealth(){return maxHealth;}
    
    /**
     * Returns the attack message of the character
     */
    public String getAttackMessage(){return attackMessage;}
}