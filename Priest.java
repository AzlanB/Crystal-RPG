import java.util.*;
import static java.lang.System.*;
/**
 * An NPC who controls ingame churches and offers healing
 */
public class Priest extends NPC{
    private int fee;
    
    /**
     * Creates a priest with a name, description, and fee
     */
    public Priest(String name, String desc, int fee){
        super(name, desc);
        this.fee = fee > 0 ? fee : 1;
    }
    
    /**
     * Returns the price of using the church
     */
    public int getFee(){
        return fee;
    }
    
    /**
     * Changes the price of using the church
     */
    public void setFee(int fee){
        this.fee = fee;
    }
    
    /**
     * Runs using the church, returning whether the player was healed
     */
    public boolean talk(Player p){
        Scanner console = new Scanner(in);
        int tempPrice = fee-p.getCharm() > 0 ? fee-p.getCharm() : 1;
        out.println("--You approach "+getName()+"--\n"+getDesc()+"\n");
        out.println(getName()+": \"Welcome to the church, lost soul. The price for our healing service is "+tempPrice+" gold.\"\n");
        out.println("(0) Move Along");
        if (p.getGold() >= tempPrice)
            out.println("(1) Get Healed [You have "+p.getGold()+"g]");
        out.print("\n>>> ");
        boolean paid = false;
        if (console.nextInt() == 1 && p.getGold() >= tempPrice){
            paid = true;
            p.setGold(p.getGold()-tempPrice);
            out.println("\nYou pay "+tempPrice+" gold to be healed, rejuvenating you");
            fee += p.getLevel()+RNG.generate(1, 3);
            p.setFatigue(p.getFatigue()/2);
            p.setCurrentHealth(p.getMaxHealth());
        }
        out.println();
        return paid;
    }
}