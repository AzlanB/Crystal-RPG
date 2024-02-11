/**
 * Ingame locations that the player can visit
 */
public abstract class Location{
    private String name, desc;
    
    /**
     * Creates a location with a name and description
     */
    public Location(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
    
    /**
     * Returns the name of the location
     */
    public String getName(){
        return name;
    }
    
    /**
     * Returns the description of the location
     */
    public String getDesc(){
        return desc;
    }
    
    /**
     * Runs what happens when the player visits the location
     */
    public abstract void visit(Player p);
}