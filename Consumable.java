/**
 * An item which can only be used a certain number of times
 */
public abstract class Consumable extends Item{
    private int numUses;
    
    /**
     * Creates a consumable with the appropriate parameters
     */
    public Consumable(String name, String desc, int price, int numUses){
        super(name, desc, price, true);
        this.numUses = numUses;
    }
    
    /**
     * Returns the number of uses the consumable has left
     */
    public int getNumUses(){
        return numUses;
    }
    
    /**
     * Sets the number of uses the consumable has left
     */
    public void setNumUses(int numUses){
        this.numUses = numUses;
    }
}