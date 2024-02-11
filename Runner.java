import java.awt.event.KeyEvent;
import java.util.*;
import static java.lang.System.*;
public class Runner{
    private static ArrayList<Location> locs;
    private static int fatigueTicks;
    private static boolean dead;

    public static void main(String[] args){
        Scanner console = new Scanner(in);
        out.print("What is your name? >>> ");
        String pname = console.nextLine();
        out.print("What is your battlecry? >>> ");
        Player p = new Player(pname, console.nextLine());
        out.println();
        dead = false;
        locs = new ArrayList<>();
        fatigueTicks = 0;
        while (!dead){
            out.println("--You are on the world map--\n");
            out.print("(1) Wander\n(2) Go to Location\n(3) See Status\n(4) Manage Inventory\n(5) Make Camp\n(6) Quit Game\n\n>>> ");
            switch (console.nextInt()) {
                case 1 -> wander(p);
                case 2 -> goToLocation(p);
                case 3 -> {
                    out.print("\n" + p + "\n\n(1) Move Along\n\n>>> ");
                    console.nextInt();
                }
                case 4 -> manageInv(p);
                case 5 -> makeCamp(p);
                case 6 -> {
                    out.print("Are you sure? (0 to quit) >>> ");
                    if (console.nextInt() == 0)
                        dead = true;
                }
            }
            out.println();
            if (p.getTimesThreatened() >= 3)
                dead = true;
        }
        out.print("---------GAME OVER---------");
    }

    /**
     * Runs the player's choice to wander
     */
    public static void wander(Player p){
        switch (RNG.generate(1, 10)) {
            case 1 -> {
                out.println("\nYou discovered a new location");
                locs.add(RNG.generate(1, 3) == 1 ? RNG.randQLoc(p.getLevel()) : new Town(RNG.locName(), RNG.townDesc(), (p.getLevel() / 2) + RNG.generate(-1, 1)));
            }
            case 2, 3, 4, 5, 6 -> out.println("\nNothing of note happened");
            default -> encounter(p);
        }
        p.tickAll();
    }

    /**
     * Returns the list of discovered locations as a string
     */
    public static String getLocs(){
        String output = "";
        for (int i = 1; i <= locs.size(); i++){
            output += "("+i+") "+locs.get(i-1).getName()+" [";
            if (locs.get(i-1) instanceof Town)
                output += ((Town)(locs.get(i-1))).getSizeName();
            else if (locs.get(i-1) instanceof QuestLocation)
                output += (((QuestLocation)(locs.get(i-1))).getResolved() ? "Completed Quest" : "Active Quest");
            output += "]\n";
        }
        return output;
    }

    /**
     * Runs the player attempting to visit a past location
     */
    public static void goToLocation(Player p){
        Scanner console = new Scanner(in);
        out.print("\n"+getLocs()+"\n(0) Move Along\n(1-"+locs.size()+") Go To Location\n\n>>> ");
        int selection = console.nextInt();
        if (selection > 0 && selection <= locs.size()){
            wander(p);
            locs.get(selection-1).visit(p);
        }
    }

    /**
     * Runs the inventory management menu for the player
     */
    public static void manageInv(Player p){
        Scanner console = new Scanner(in);
        out.print("\n(0) Move Along\n(1) Equip/Use Item\n(2) Unequip Item\n\n>>> ");
        int selection = console.nextInt();
        while (selection == 1 || selection == 2){
            if (selection == 1){
                out.print("\n"+p.getInv()+"\n(0) Move Along\n(1-"+p.getInvSize()+") Equip/Use Item\n\n>>> ");
                int choice = console.nextInt();
                if (!p.equip(choice))
                    p.use(choice);
            }
            else{
                out.print("\n"+p.getEquipped()+"\n(0) Move Along\n(1-8) Unequip Item\n\n>>> ");
                p.unequip(console.nextInt());
            }
            p.refreshStats();
            out.println("\n(0) Move Along\n(1) Equip/Use Item\n(2) Unequip Item\n\n>>> ");
            selection = console.nextInt();
        }
    }

    /**
     * Runs the player making camp
     */
    public static void makeCamp(Player p){
        if (RNG.generate(1, 5) == 1)
            encounter(p);
        else
            out.print("\nYou sleep peacefully");
        if (!dead) {
            out.println("\nAfter sleeping, your fatigue has been reset, and you have been healed slightly");
            p.setFatigue(0);
            p.setCurrentHealth(p.getCurrentHealth() + p.getMaxHealth() / 3);
            if (p.getCurrentHealth() > p.getMaxHealth())
                p.setCurrentHealth(p.getMaxHealth());
        }
    }

    /**
     * Runs what happens when the player gets an encounter
     */
    public static void encounter(Player p){
        switch (RNG.generate(1, 20)){
            case 1: out.println("\nYou come across a travelling salesman\n"); (new Shopkeep(RNG.charName(), RNG.charDesc(), p.getLevel()/2*5+RNG.generate(-1*p.getLevel()/2, p.getLevel()/2), p.getLevel()/2)).talk(p); break;
            case 2: out.println("\nYou come across a wandering priest\n"); (new Priest(RNG.charName(), RNG.charDesc(), p.getLevel()/2*15+RNG.generate(-1*p.getLevel()/2, p.getLevel()/2))).talk(p); break;
            case 3: out.println("\nYou found an item"); p.store(RNG.randItem(p.getLevel())); break;
            default: out.println("\nYou get attacked!"); battle(p);
        }
        if (fatigueTicks == 3){
            p.setFatigue(p.getFatigue()+1);
            fatigueTicks = 0;
        }
        else
            fatigueTicks++;
    }

    /**
     * Runs the ingame battles against random enemies
     */
    public static void battle(Player p){
        Scanner console = new Scanner(in);
        HostileCharacter e = new HostileCharacter(RNG.enemyName(), RNG.generate(p.getDefense()*2/3, p.getDefense()*5/6), RNG.generate(p.getAgility()*2/3, p.getAgility()*5/6), RNG.generate(p.getStrength()*2/3, p.getStrength()*5/6), RNG.generate(p.getMaxHealth()*2/3, p.getMaxHealth()*5/6), RNG.battlecry());
        boolean fled = false;
        while (p.getCurrentHealth() > 0 && e.getCurrentHealth() > 0){
            out.print("\n"+p+"\n"+e+"\n\n(1) Attack\n(2) Use an Item\n(3) Flee\n\n>>> ");
            int selection = console.nextInt();
            if (selection == 1){
                if (RNG.check(p.getAgility()) >= RNG.check(e.getAgility())-3){
                    int defenseCheck = RNG.check(e.getDefense());
                    int strengthCheck = RNG.check(p.getStrength());
                    e.setCurrentHealth(e.getCurrentHealth()-(strengthCheck < defenseCheck ? 0 : strengthCheck-defenseCheck));
                    out.println("\n"+p.getName()+": \""+p.getAttackMessage()+"\"\nThe attack hit, dealing "+(strengthCheck < defenseCheck ? 0 : strengthCheck-defenseCheck)+" damage");
                }
                else
                    out.println("\nThe attack missed");
            }
            else if (selection == 2){
                out.print("\n"+p.getInv()+"\nPick an Item to Use >>> ");
                int choice = console.nextInt();
                if (choice > 0 && choice <= p.getInvSize() && p.getItem(choice-1) instanceof DamagingItem){
                    if (RNG.generate(1, 100) <= ((DamagingItem)(p.getItem(choice-1))).getHitChance()){
                        if (((DamagingItem)(p.getItem(choice-1))).isPiercing()){
                            e.setCurrentHealth(e.getCurrentHealth()-((DamagingItem)(p.getItem(choice-1))).getDamage());
                            out.println("The item hits, dealing "+((DamagingItem)(p.getItem(choice-1))).getDamage()+" damage");
                        }
                        else{
                            int defenseCheck = RNG.check(e.getDefense());
                            e.setCurrentHealth(e.getCurrentHealth()-(((DamagingItem)(p.getItem(choice-1))).getDamage() < defenseCheck ? 0 : ((DamagingItem)(p.getItem(choice-1))).getDamage() - defenseCheck));
                            out.println("The item hits, dealing "+(((DamagingItem)(p.getItem(choice-1))).getDamage() < defenseCheck ? 0 : ((DamagingItem)(p.getItem(choice-1))).getDamage() - defenseCheck)+" damage");
                        }
                        p.retrieve(choice);
                    }
                    else
                        out.println("\nThe item missed");
                }
                else if (!p.use(choice)) continue;
            }
            else if (selection == 3){
                if (RNG.check(p.getAgility()) >= RNG.check(e.getAgility())+3){
                    e.setCurrentHealth(0);
                    fled = true;
                }
                else
                    out.println("\nYou could not escape");
            }
            else continue;
            p.refreshStats();
            if (e.getCurrentHealth() > 0){
                if (RNG.check(p.getAgility()) >= RNG.check(e.getAgility())-3){
                    int defenseCheck = RNG.check(p.getDefense());
                    int strengthCheck = RNG.check(e.getStrength());
                    p.setCurrentHealth(p.getCurrentHealth()-(strengthCheck < defenseCheck ? 0 : strengthCheck-defenseCheck));
                    out.println("\n"+e.getName()+": \""+e.getAttackMessage()+"\"\nThe enemy attack hit, dealing "+(strengthCheck < defenseCheck ? 0 : strengthCheck-defenseCheck)+" damage");
                }
                else
                    out.println("\nThe enemy attack missed");
            }
            p.tickAll();
        }
        if (p.getCurrentHealth() <= 0)
            dead = true;
        else if (fled){
            int expGained = p.getNeededExp()/20 + RNG.generate(-p.getNeededExp()/80, p.getNeededExp()/80);
            p.setExp(p.getExp()+expGained);
            int goldGained = (p.getLevel()+RNG.generate(1, 15))/2;
            p.setGold(p.getGold()+goldGained);
            out.println("\nSuccessfully got away, gaining "+goldGained+" gold and "+expGained+" exp");
        }
        else{
            int expGained = p.getNeededExp()/10 + RNG.generate(-p.getNeededExp()/40, p.getNeededExp()/40);
            p.setExp(p.getExp()+expGained);
            int goldGained = p.getLevel()+RNG.generate(1, 15);
            p.setGold(p.getGold()+goldGained);
            out.println("\nYou win, gaining "+goldGained+" gold and "+expGained+" exp");
        }
        if (p.getExp() >= p.getNeededExp())
            p.levelUp();
    }
}