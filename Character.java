/**
 * Humanoid characters within the game, consists of a name
 */
public abstract class Character{
    private String name;
    
    /**
     * Creates a character with a name
     */
    public Character(String name){
        this.name = name;
    }
    
    /**
     * Returns the character's name
     */
    public String getName(){return name;}
}