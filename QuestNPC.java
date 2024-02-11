import java.util.*;
import static java.lang.System.*;
/**
 * An NPC that provides a reward once given a desired item
 */
public class QuestNPC extends NPC{
    private boolean resolved;
    private Item desire, reward;

    /**
     * Creates a quest NPC with the appropriate parameters
     */
    public QuestNPC(String name, String desc, Item d, Item r){
        super(name, desc);
        desire = d;
        reward = r;
        resolved = false;
    }

    /**
     * Returns whether the quest NPC's reward has already been claimed or not
     */
    public boolean isResolved(){
        return resolved;
    }

    /**
     * Allows the player to interact with the quest NPC, returning whether the quest is resolved
     */
    public boolean talk(Player p){
        Scanner console = new Scanner(in);
        out.println("--You approach "+getName()+"--\n"+getDesc()+"\n");
        if (!resolved)
            out.println(getName()+": \"Excuse me, do you have a "+desire.getName()+"?\"\n\n(0) \"No, sorry\"");
        else
            out.println(getName()+": \"Thank you for the help!\"\n\n(0) Move Along");
        if (!resolved && p.hasItem(desire)){
            out.println("(1) Give the "+desire.getName());
        }
        out.print("\n>>> ");
        if (console.nextInt() == 1 && p.retrieve(desire)){
            out.println("\nYou give "+getName()+" the "+desire.getName()+"\n"+getName()+": \"Please take this in return\"\nYou gain a "+reward.getName());
            p.store(reward);
            resolved = true;
        }
        out.println();
        return resolved;
    }
}