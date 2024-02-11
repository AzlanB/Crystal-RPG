import java.util.*;
import static java.lang.System.*;
/**
 * An NPC which the player can purchace items from
 */
public class Shopkeep extends NPC{
    private int fee, size;
    private ArrayList<Item> inv;

    /**
     * Creates a Shopkeep with a name, description, fee, and inventory size, generating an inventory of random items from it
     */
    public Shopkeep(String name, String desc, int fee, int s){
        super(name, desc);
        this.fee = fee > 0 ? fee : 1;
        size = s > 1 ? s + RNG.generate(-1, 1) : 1;
        inv = new ArrayList<Item>();
        for (int i = 0; i < size; i++){
            inv.add(RNG.randItem(size*2));
        }
    }

    /**
     * Returns the additional charge applied to every item
     */
    public int getFee(){
        return fee;
    }

    /**
     * Changes the additional charge applied to every item
     */
    public void setFee(int fee){
        this.fee = fee;
    }

    /**
     * Restocks the shopkeep's inventory
     */
    public void restock(){
        for (int i = inv.size(); i < size; i++){
            inv.add(RNG.randItem(size*2));
        }
    }

    /**
     * Returns the string list of the shopkeep's inventory
     */
    public String getInv(Player p){
        String output = "";
        int tempPrice = fee-p.getCharm() > 0 ? fee-p.getCharm() : 1;
        for (int i = 1; i <= inv.size(); i++){
            output += "("+i+") "+inv.get(i-1).getName()+(inv.get(i-1).isSellable() ? (" ["+(inv.get(i-1).getPrice()+tempPrice)+"g]"):(""))+"\n\t"+inv.get(i-1).getDesc()+"\n";
            if (inv.get(i-1) instanceof Equipment)
                output += "\tEquipment - "+((Equipment)(inv.get(i-1))).getStatTypeName()+" +"+((Equipment)(inv.get(i-1))).getStatBonus()+"\n";
            else if (inv.get(i-1) instanceof BuffingItem)
                output += "\tConsumable - "+((BuffingItem)(inv.get(i-1))).getStatTypeName()+" +"+((BuffingItem)(inv.get(i-1))).getStatBonus()+"\n";
            else if (inv.get(i-1) instanceof DamagingItem)
                output += "\tConsumable - "+((DamagingItem)(inv.get(i-1))).getHitChance()+"% for "+((DamagingItem)(inv.get(i-1))).getDamage()+(((DamagingItem)(inv.get(i-1))).isPiercing() ? " Piercing Damage\n" : " Damage\n");
        }
        return output;
    }

    /**
     * Runs talking to the shopkeep, returning whether the player bought something
     */
    public boolean talk(Player p){
        Scanner console = new Scanner(in);
        int tempPrice = fee-p.getCharm() > 0 ? fee-p.getCharm() : 1;
        out.println("--You approach "+getName()+"--\n"+getDesc()+"\n");
        out.println(getName()+": \"Welcome. Here's what I've got in stock\"\n\n"+getInv(p));
        out.print("(0) Move Along\n(1-"+inv.size()+") Buy an Item [You have "+p.getGold()+"g]\n\n>>> ");
        int selection = console.nextInt();
        boolean paid = false;
        while (selection > 0 && selection <= inv.size()){
            if (inv.get(selection-1).getPrice()+tempPrice > p.getGold())
                out.println("\nYou don't have enough gold to buy that\n");
            else{
                out.println("\n"+getName()+": \"Pleasure doing business with you\"\nYou have bought the "+inv.get(selection-1).getName()+"\n");
                p.setGold(p.getGold()-(inv.get(selection-1).getPrice()+tempPrice));
                p.store(inv.remove(selection-1));
                paid = true;
            }
            out.print(getInv(p)+"\n(0) Move Along\n(1-"+inv.size()+") Buy an Item [You have "+p.getGold()+"g]\n>>> ");
            selection = console.nextInt();
        }
        if (paid)
            fee += p.getLevel()+RNG.generate(1, 3);
        return paid;
    }
}