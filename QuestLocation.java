import java.util.*;
import static java.lang.System.*;
/**
 * A location in which a player can get a reward by providing a certain item
 */
public class QuestLocation extends Location{
    private boolean resolved;
    private String needText, finishText;
    private Item needItem, reward;

    /**
     * Creates a quest location with the appropriate perameters
     * @param name The name of the location
     * @param desc The description of the location
     * @param nI The item needed to obtain the location's reward
     * @paran nT The message the player gets to communicate what item they need
     * @param rew The reward given once provided with the correct item
     * @param fT The message the player gets upon claiming the reward
     */
    public QuestLocation(String name, String desc, Item nI, String nT, Item rew, String fT){
        super(name, desc);
        resolved = false;
        needItem = nI;
        needText = nT;
        reward = rew;
        finishText = fT;
    }

    /**
     * Returns whether the reward has already been claimed or not
     */
    public boolean getResolved(){
        return resolved;
    }

    /**
     * Runs what happens when the player visits the location
     */
    public void visit(Player p){
        Scanner console = new Scanner(in);
        out.println("\n--You have entered "+getName()+"--\n"+getDesc()+"\n");
        if (!resolved)
            out.println(needText+"\n");
        out.println("(0) Move Along");
        if (!resolved && p.hasItem(needItem)){
            out.println("(1) Use "+needItem.getName());
        }
        out.print("\n>>> ");
        if (console.nextInt() == 1 && p.retrieve(needItem)){
            out.println("\n"+finishText+"\nYou have gained a "+reward.getName());
            p.store(reward);
            resolved = true;
        }
        out.println();
    }
}