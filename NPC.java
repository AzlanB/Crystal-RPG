/**
 * Non-Player Characters that are friendly within the game, consists of a description
 */
public abstract class NPC extends Character{
    private String desc;
    
    /**
     * Creates an NPC with a name and a description
     */
    public NPC(String name, String desc){
        super(name);
        this.desc = desc;
    }
    
    /**
     * Returns the NPC's description
     */
    public String getDesc(){return desc;}
    
    /**
     * Allows the player to interact with the NPC
     */
    public abstract boolean talk(Player p);
}