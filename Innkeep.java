import java.util.*;
import static java.lang.System.*;
/**
 * An NPC which controls ingame Inns where you can sleep
 */
public class Innkeep extends NPC{
    private int fee;
    
    /**
     * Creates an innkeep with a name, description, and fee
     */
    public Innkeep(String name, String desc, int fee){
        super(name, desc);
        this.fee = fee > 0 ? fee : 1;
    }
    
    /**
     * Returns the price of using the inn
     */
    public int getFee(){
        return fee;
    }
    
    /**
     * Changes the price of using the inn
     */
    public void setFee(int fee){
        this.fee = fee;
    }
    
    /**
     * Runs using the inn, returning whether the player stayed a night
     */
    public boolean talk(Player p){
        Scanner console = new Scanner(in);
        int tempPrice = fee-p.getCharm() > 0 ? fee-p.getCharm() : 1;
        out.println("--You approach "+getName()+"--\n"+getDesc()+"\n");
        out.println(getName()+": \"Welcome to my inn. The price for a night is "+tempPrice+" gold.\"\n");
        out.println("(0) Move Along");
        if (p.getGold() >= tempPrice)
            out.println("(1) Stay a Night [You have "+p.getGold()+"g]");
        out.print("\n>>> ");
        boolean paid = false;
        if (console.nextInt() == 1 && p.getGold() >= tempPrice){
            paid = true;
            p.setGold(p.getGold()-tempPrice);
            out.println("\nYou pay "+tempPrice+" gold to sleep off the troubles of the previous day");
            fee += p.getLevel()+RNG.generate(1, 3);
            p.setFatigue(0);
            p.setCurrentHealth(p.getCurrentHealth()+p.getMaxHealth()/2);
            if (p.getCurrentHealth() > p.getMaxHealth())
                p.setCurrentHealth(p.getMaxHealth());
        }
        out.println();
        return paid;
    }
}