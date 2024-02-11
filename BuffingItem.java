/**
 * A consumable that boosts a stat
 */
public class BuffingItem extends Consumable{
    private int statType, statBonus, ticks;
    private boolean inUse;
    
    /**
     * Creates a buffing item with the appropriate parameters
     * @param n The name of the item
     * @param d The description of the item
     * @param p The price of the item
     * @param nU The number of uses the item has
     * @param sT The type of stat the item boosts (0-Strength, 1-Agility, 2-Defense, 3-Health, 4-Charm)
     * @param sB The numerical boost to the stat the item provides
     */
    public BuffingItem(String n, String d, int p, int nU, int sT, int sB){
        super(n, d, p, nU);
        statType = sT;
        statBonus = sB;
        inUse = false;
        ticks = 0;
    }
    
    /**
     * Returns whether the item is currently in use
     */
    public boolean isInUse(){
        return inUse;
    }
    
    /**
     * Sets whether the item is currently in use
     */
    public void setInUse(boolean inUse){
        this.inUse = inUse;
    }
    
    /**
     * Returns the type of stat the item boosts (0-Strength, 1-Agility, 2-Defense, 3-Health, 4-Charm)
     */
    public int getStatType(){
        return statType;
    }
    
    /**
     * Returns the name of the stat the item boosts
     */
    public String getStatTypeName(){
        switch(statType){
            case 0: return "Strength";
            case 1: return "Agility";
            case 2: return "Defense";
            case 3: return "Health";
            case 4: return "Charm";
        }
        return "[Error]";
    }
    
    /**
     * Returns the numerical boost to the stat the item provides
     */
    public int getStatBonus(){
        return statBonus;
    }
    
    /**
     * Makes the active effect of the item progress by one time step, or starts the 3 turn timer if at 0 already
     */
    public void tick(){
        if (ticks == 0){
            ticks = 3;
            inUse = true;
            setNumUses(getNumUses()-1);
        }
        else{
            ticks--;
            if (ticks == 0)
                inUse = false;
        }
    }
    
    /**
     * Returns the number of time steps left on the active effect of the item
     */
    public int getTicks(){
        return ticks;
    }
}