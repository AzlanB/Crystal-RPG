/**
 * An item that the player can equip and gain bonuses from
 */
public class Equipment extends Item{
    private int slot, statType, statBonus;
    
    /**
     * Creates a piece of equipment with the appropriate perameters
     * @param name The name of the equipment
     * @param desc The ingame description of the equipment
     * @param p The price of the equipment
     * @param se Whether of not the equipment can be sold
     * @param sl The slot that the equipment gets equipped to (0-Head, 1-Neck, 2-Chest, 3-Hand, 4-Ring, 5-Legs)
     * @param sT The type of stat the equipment boosts (0-Strength, 1-Agility, 2-Defense, 3-Health, 4-Charm)
     * @param sB The amount the stat gets increased when the equipment is equipped
     */
    public Equipment(String name, String desc, int p, boolean se, int sl, int sT, int sB){
        super(name, desc, p, se);
        slot = sl;
        statType = sT;
        statBonus = sB;
    }
    
    /**
     * Returns the slot of the equipment (0-Head, 1-Neck, 2-Chest, 3-Hand, 4-Ring, 5-Legs)
     */
    public int getSlot(){
        return slot;
    }
    
    /**
     * Returns what stat the equipment boosts (0-Strength, 1-Agility, 2-Defense, 3-Health, 4-Charm)
     */
    public int getStatType(){
        return statType;
    }
    
    /**
     * Returns the name of the stat the equipment boosts
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
     * Returns the numerical bonus the equipment gives to the stat type
     */
    public int getStatBonus(){
        return statBonus;
    }
}