import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;
/**
 * The playable character
 */
public class Player extends HostileCharacter{
    private int baseStrength, baseAgility, baseDefense, baseHealth, baseCharm, charm, level, exp, gold, fatigue, timesThreatened;
    private boolean checkThreatened;
    private ArrayList<Item> inv;
    private Equipment[] equipped;

    /**
     * Creates the starting player with the appropriate name and attack message.
     * All stats are set to 5 with the exception of health which is 10. Level is 1,
     * and exp, gold, and fatigue is 0. The inventory and equipped items arraylists are empty.
     */
    public Player(String name, String attackMessage){
        super(name, 5, 5, 5, 10, attackMessage);
        baseStrength = baseAgility = baseDefense = baseCharm = charm = 5;
        exp = gold = fatigue = timesThreatened = 0;
        baseHealth = 10;
        level = 1;
        checkThreatened = false;
        inv = new ArrayList<>();
        equipped = new Equipment[8];
    }

    /**
     * Returns a formatted string with the name, current health, max health, strength, agility, defense,
     * charm, gold, level, and exp of the player
     */
    public String toString(){
        return super.toString()+String.format("  %-9s\n%-15s  %-12s  %-20s  %-9s  Exp: "+exp+"/"+getNeededExp(), "[CHA "+charm+"]", "", "Gold: "+gold, "Status: "+getFatigueLevel(), "Level: "+level);
    }

    /**
     * Sets the player's base strength to str
     */
    public void setBaseStrength(int str){baseStrength = str;}

    /**
     * Returns the player's base strength
     */
    public int getBaseStrength(){return baseStrength;}

    /**
     * Sets the player's base agility to agi
     */
    public void setBaseAgility(int agi){baseAgility = agi;}

    /**
     * Returns the player's base agility
     */
    public int getBaseAgility(){return baseAgility;}

    /**
     * Sets the player's base defense to def
     */
    public void setBaseDefense(int def){baseDefense = def;}

    /**
     * Returns the player's base defense
     */
    public int getBaseDefense(){return baseDefense;}

    /**
     * Sets the player's base health to hp
     */
    public void setBaseHealth(int hp){baseHealth = hp;}

    /**
     * Returns the player's base health
     */
    public int getBaseHealth(){return baseHealth;}

    /**
     * Sets the player's base charm to cha
     */
    public void setBaseCharm(int cha){baseCharm = cha;}

    /**
     * Returns the player's base charm
     */
    public int getBaseCharm(){return baseCharm;}

    /**
     * Sets the player's charm to cha
     */
    public void setCharm(int cha){charm = cha;}

    /**
     * Returns the player's charm
     */
    public int getCharm(){return charm;}

    /**
     * Sets the player's exp to exp
     */
    public void setExp(int exp){this.exp = exp;}

    /**
     * Returns the player's exp
     */
    public int getExp(){return exp;}

    /**
     * Returns the player's level
     */
    public int getLevel(){return level;}

    /**
     * Sets the player's fatigue to f and notifies the player should be checked for if it could be close to death from fatigue
     */
    public void setFatigue(int f){fatigue = f; checkThreatened = true;}

    /**
     * Returns the numerical value of the player's fatigue
     */
    public int getFatigue(){return fatigue;}

    /**
     * Returns a string based on how much fatigue the player has
     */
    public String getFatigueLevel(){
        return fatigue < level/2.0 ? "Perfect" : fatigue < level ? "Alright" : fatigue < 2*level ? "Lagging" : timesThreatened > 0 ? "Critical" : "Exhausted";
    }

    /**
     * Sets the player's gold to g
     */
    public void setGold(int g){gold = g;}

    /**
     * Returns the player's gold
     */
    public int getGold(){return gold;}

    /**
     * Returns how much exp the player needs to level up
     */
    public int getNeededExp(){
        int need = 100;
        for (int i = 1; i < level; i++)
            need *= 1.5;
        return need;
    }

    /**
     * Levels up the player
     */
    public void levelUp(){
        Scanner console = new Scanner(in);
        level++;
        out.println("Level Up!");
        out.println("(1) HP :  "+baseHealth+"\t->  "+(baseHealth += 4));
        out.println("(2) STR:  "+baseStrength+"\t->  "+(baseStrength += 2));
        out.println("(3) AGI:  "+baseAgility+"\t->  "+(baseAgility += 2));
        out.println("(4) DEF:  "+baseDefense+"\t->  "+(baseDefense += 2));
        out.println("(5) CHA:  "+baseCharm+"\t->  "+(baseCharm += 2));

        out.print("\nChoose a Stat to Boost Further >>> ");
        switch (console.nextInt()) {
            case 2 -> baseStrength += 3;
            case 3 -> baseAgility += 3;
            case 4 -> baseDefense += 3;
            case 5 -> baseCharm += 3;
            default -> baseHealth += 3;
        }
        out.println();
        fatigue /= 2;
        refreshStats();
        setCurrentHealth(getMaxHealth());
    }

    /**
     * Adds an item to the inventory
     */
    public void store(Item i){
        inv.add(i);
    }

    /**
     * Removes an item from the inventory, returning a boolean depending on if it was successful
     */
    public boolean retrieve(Item i){
        return inv.remove(i);
    }

    /**
     * Removes the item at the specified index of the inventory, returning a boolean depending on if it was successful
     */
    public boolean retrieve(int i){
        if (i < 1 || i > inv.size())
            return false;
        inv.remove(i-1);
        return true;
    }

    /**
     * Returns how many items are in the player's inventory
     */
    public int getInvSize(){
        return inv.size();
    }

    /**
     * Returns a string with the contents of the inventory
     */
    public String getInv(){
        String output = "";
        for (int i = 1; i < inv.size()+1; i++){
            output += "("+i+") "+inv.get(i-1).getName()+(inv.get(i-1).isSellable() ? (" ["+inv.get(i-1).getPrice()+"g]"):(""))+"\n\t"+inv.get(i-1).getDesc()+"\n";
            if (inv.get(i-1) instanceof Equipment)
                output += "\tEquipment - "+((Equipment)(inv.get(i-1))).getStatTypeName()+" +"+((Equipment)(inv.get(i-1))).getStatBonus()+"\n";
            else if (inv.get(i-1) instanceof BuffingItem)
                output += "\tConsumable - "+((BuffingItem)(inv.get(i-1))).getStatTypeName()+" +"+((BuffingItem)(inv.get(i-1))).getStatBonus()+"\n";
            else if (inv.get(i-1) instanceof DamagingItem)
                output += "\tConsumable - "+((DamagingItem)(inv.get(i-1))).getHitChance()+"% to hit for "+((DamagingItem)(inv.get(i-1))).getDamage()+(((DamagingItem)(inv.get(i-1))).isPiercing() ? " Piercing Damage\n" : " Damage\n");
        }
        return output;
    }

    /**
     * Returns whether or not the player has the specified item in their inventory
     */
    public boolean hasItem(Item i){
        return inv.contains(i);
    }

    /**
     * Returns the item at the index in the inventory
     */
    public Item getItem(int i){
        return inv.get(i);
    }

    /**
     * Returns a string with the contents of the equipped items
     */
    public String getEquipped(){
        String output = "";
        output += String.format("(1) %-7s "+(equipped[0] != null ? equipped[0].getName() + "("+equipped[0].getStatTypeName()+" +"+equipped[0].getStatBonus()+")\n%-12s"+equipped[0].getDesc() : "Empty"), "Head:", "")+"\n";
        output += String.format("(2) %-7s "+(equipped[1] != null ? equipped[1].getName() + "("+equipped[1].getStatTypeName()+" +"+equipped[1].getStatBonus()+")\n%-12s"+equipped[1].getDesc() : "Empty"), "Neck:", "")+"\n";
        output += String.format("(3) %-7s "+(equipped[2] != null ? equipped[2].getName() + "("+equipped[2].getStatTypeName()+" +"+equipped[2].getStatBonus()+")\n%-12s"+equipped[2].getDesc() : "Empty"), "Chest:", "")+"\n";
        output += String.format("(4) %-7s "+(equipped[3] != null ? equipped[3].getName() + "("+equipped[3].getStatTypeName()+" +"+equipped[3].getStatBonus()+")\n%-12s"+equipped[3].getDesc() : "Empty"), "Hand 1:", "")+"\n";
        output += String.format("(5) %-7s "+(equipped[4] != null ? equipped[4].getName() + "("+equipped[4].getStatTypeName()+" +"+equipped[4].getStatBonus()+")\n%-12s"+equipped[4].getDesc() : "Empty"), "Hand 2:", "")+"\n";
        output += String.format("(6) %-7s "+(equipped[5] != null ? equipped[5].getName() + "("+equipped[5].getStatTypeName()+" +"+equipped[5].getStatBonus()+")\n%-12s"+equipped[5].getDesc() : "Empty"), "Ring 1:", "")+"\n";
        output += String.format("(7) %-7s "+(equipped[6] != null ? equipped[6].getName() + "("+equipped[6].getStatTypeName()+" +"+equipped[6].getStatBonus()+")\n%-12s"+equipped[6].getDesc() : "Empty"), "Ring 2:", "")+"\n";
        output += String.format("(8) %-7s "+(equipped[7] != null ? equipped[7].getName() + "("+equipped[7].getStatTypeName()+" +"+equipped[7].getStatBonus()+")\n%-12s"+equipped[7].getDesc() : "Empty"), "Legs:", "")+"\n";
        return output;
    }

    /**
     * Uses a buffing item in the inventory, returning whether it was successful
     */
    public boolean use(int i){
        if (i < 1 || i > inv.size() || !(inv.get(i-1) instanceof BuffingItem))
            return false;
        ((BuffingItem)(inv.get(i-1))).tick();
        return true;
    }

    /**
     * Puts an equipped item back in the inventory, returning a boolean depending on if it was successful
     */
    public boolean unequip(int i){
        if (i < 1 || i > 8 || equipped[i-1] == null)
            return false;
        inv.add(equipped[i-1]);
        equipped[i-1] = null;
        return true;
    }

    /**
     * Equips an item from the inventory, returning a boolean depending on if it was successful
     */
    public boolean equip(int i){
        if (i < 1 || i > inv.size() || !(inv.get(i-1) instanceof Equipment))
            return false;
        switch (((Equipment)(inv.get(i-1))).getSlot()){
            case 0: if (equipped[0] != null){return false;} equipped[0] = (Equipment)(inv.remove(i-1)); break;
            case 1: if (equipped[1] != null){return false;} equipped[1] = (Equipment)(inv.remove(i-1)); break;
            case 2: if (equipped[2] != null){return false;} equipped[2] = (Equipment)(inv.remove(i-1)); break;
            case 3: if (equipped[3] != null){if (equipped[4] != null){return false;} equipped[4] = (Equipment)(inv.remove(i-1));} else {equipped[3] = (Equipment)(inv.remove(i-1));} break;
            case 4: if (equipped[5] != null){if (equipped[6] != null){return false;} equipped[6] = (Equipment)(inv.remove(i-1));} else {equipped[5] = (Equipment)(inv.remove(i-1));} break;
            case 5: if (equipped[7] != null){return false;} equipped[7] = (Equipment)(inv.remove(i-1)); break;
        }
        return true;
    }

    /**
     * Applies a tick to every currently active BuffingItem
     */
    public void tickAll(){
        for (int i = 0; i < inv.size(); i++){
            if (inv.get(i) instanceof BuffingItem && ((BuffingItem)(inv.get(i))).isInUse()){
                ((BuffingItem)(inv.get(i))).tick();
                if (((BuffingItem)(inv.get(i))).getTicks() == 0 && ((BuffingItem)(inv.get(i))).getNumUses() == 0){
                    inv.remove(i);
                    i--;
                }
            }
        }
    }

    /**
     * Returns the number of times the player has been threatened
     */
    public int getTimesThreatened(){
        return timesThreatened;
    }

    /**
     * Recalculates the player's current stats, including item bonuses, fatigue penalties, etc.
     */
    public void refreshStats(){
        int strB = 0, agiB = 0, defB = 0, hpB = 0, chaB = 0;
        for (int i = 0; i < equipped.length; i++){
            if (equipped[i] != null){
                switch (equipped[i].getStatType()){
                    case 0: strB += equipped[i].getStatBonus(); break;
                    case 1: agiB += equipped[i].getStatBonus(); break;
                    case 2: defB += equipped[i].getStatBonus(); break;
                    case 3: hpB += equipped[i].getStatBonus(); break;
                    case 4: chaB += equipped[i].getStatBonus(); break;
                }
            }
        }

        for (int i = 0; i < inv.size(); i++){
            if (inv.get(i) instanceof BuffingItem && ((BuffingItem)(inv.get(i))).isInUse()){
                switch (((BuffingItem)(inv.get(i))).getStatType()){
                    case 0: strB += ((BuffingItem)(inv.get(i))).getStatBonus(); break;
                    case 1: agiB += ((BuffingItem)(inv.get(i))).getStatBonus(); break;
                    case 2: defB += ((BuffingItem)(inv.get(i))).getStatBonus(); break;
                    case 3: setCurrentHealth(getCurrentHealth()+((BuffingItem)(inv.get(i))).getStatBonus()); ((BuffingItem)(inv.get(i))).setInUse(false); break;
                    case 4: chaB += ((BuffingItem)(inv.get(i))).getStatBonus(); break;
                }
            }
        }

        int fatiguePenalty = (int)Math.round(fatigue*(level*2/3.0));
        if (checkThreatened){
            if (baseStrength <= fatiguePenalty || baseAgility <= fatiguePenalty || baseDefense <= fatiguePenalty || baseCharm <= fatiguePenalty){
                timesThreatened++;
            }
            else
                timesThreatened = 0;
            checkThreatened = false;
        }
        setStrength((baseStrength <= fatiguePenalty ? 1 : baseStrength - fatiguePenalty)+strB);
        setAgility((baseAgility <= fatiguePenalty ? 1 : baseAgility - fatiguePenalty)+agiB);
        setDefense((baseDefense <= fatiguePenalty ? 1 : baseDefense - fatiguePenalty)+defB);
        setMaxHealth(baseHealth + hpB);
        charm = (baseCharm <= fatiguePenalty ? 1 : baseCharm - fatiguePenalty)+chaB;
    }
}