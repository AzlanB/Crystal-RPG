import java.util.*;
import static java.lang.System.*;
/**
 * An ingame town, which a number of NPCs reside in
 */
public class Town extends Location{
    int size;
    ArrayList<NPC> npcs;

    /**
     * Creates a town with a name, description, and size, creating NPCs based on the size
     */
    public Town(String name, String desc, int size){
        super(name, desc);
        this.size = Math.max(size, 1);
        npcs = new ArrayList<>();
        for (int i = 0; i < this.size; i++){
            int n = RNG.generate(1, 22)+i;
            switch (Math.min(n, 22)) {
                case 1, 2, 3, 4, 5, 6, 7 -> npcs.add(new Shopkeep(RNG.charName(), RNG.charDesc(), size * 5 + RNG.generate(-1 * size, size), size));
                case 8, 9, 10, 11, 12, 13 -> npcs.add(new Innkeep(RNG.charName(), RNG.charDesc(), size * 10 + RNG.generate(-1 * size, size)));
                case 14, 15, 16, 17, 18 -> npcs.add(new Priest(RNG.charName(), RNG.charDesc(), size * 15 + RNG.generate(-1 * size, size)));
                default -> npcs.add(new QuestNPC(RNG.charName(), RNG.charDesc(), RNG.randQItem(size * 2), RNG.randItem(size * 2)));
            }
        }
    }

    /**
     * Returns the size category of the town
     */
    public String getSizeName(){
        return switch (size) {
            case 1, 2 -> "Hamlet";
            case 3, 4 -> "Village";
            case 5, 6 -> "Small Town";
            case 7, 8 -> "Large Town";
            default -> "City";
        };
    }

    /**
     * Returns a string listing of all the NPCs in the town
     */
    public String getNPCs(){
        String output = "";
        for (int i = 1; i <= npcs.size(); i++){
            output += "("+i+") "+npcs.get(i-1).getName()+" [";
            if (npcs.get(i-1) instanceof QuestNPC){
                if (((QuestNPC)(npcs.get(i-1))).isResolved())
                    output += "Completed Quest";
                else
                    output += "Active Quest";
            }
            else if (npcs.get(i-1) instanceof Shopkeep)
                output += "Shopkeep";
            else if (npcs.get(i-1) instanceof Priest)
                output += "Priest";
            else if (npcs.get(i-1) instanceof Innkeep)
                output += "Innkeep";
            output += "]\n";
        }
        return output;
    }

    /**
     * Runs visiting the town
     */
    public void visit(Player p){
        Scanner console = new Scanner(in);
        out.println("\n--You have arrived at the "+getSizeName()+" of "+getName()+"--\n"+getDesc());
        out.print("\n"+getNPCs()+"\n(0) Move Along\n(1-"+npcs.size()+") Talk to NPC\n\n>>> ");
        int selection = console.nextInt();
        while (selection > 0 && selection <= npcs.size()){
            out.println();
            if (npcs.get(selection-1).talk(p)){
                for (int i = 0; i < npcs.size(); i++){
                    if (i == selection-1 || npcs.get(i) instanceof QuestNPC){}
                    else if (npcs.get(i) instanceof Shopkeep)
                        ((Shopkeep)(npcs.get(i))).setFee(((Shopkeep)(npcs.get(i))).getFee() - (p.getLevel()+RNG.generate(1, 3)));
                    else if (npcs.get(i) instanceof Innkeep)
                        ((Innkeep)(npcs.get(i))).setFee(((Innkeep)(npcs.get(i))).getFee() - (p.getLevel()+RNG.generate(1, 3)));
                    else if (npcs.get(i) instanceof Priest)
                        ((Priest)(npcs.get(i))).setFee(((Priest)(npcs.get(i))).getFee() - (p.getLevel()+RNG.generate(1, 3)));
                }
            }
            out.print("\n"+getNPCs()+"\n(0) Move Along\n(1-"+npcs.size()+") Talk to NPC\n\n>>> ");
            selection = console.nextInt();
        }
    }
}