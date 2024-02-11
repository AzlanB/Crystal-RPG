/**
 * An item to be used in battle which damages the opponent
 */
public class DamagingItem extends Consumable{
    private int damage, hitChance;
    private boolean piercing;
    
    /**
     * Creates a damaging item with the appropriate parameters
     * @param n The name of the item
     * @param d The description of the item
     * @param p The price of the item
     * @param nU The number of times the item can be used
     * @param dam The amount of damage the item deals
     * @param hC The chance of the item hitting the target (out of 100)
     * @param pier Whether the item pierces defense
     */
    public DamagingItem(String n, String d, int p, int nU, int dam, int hC, boolean pier){
        super(n, d, p, nU);
        damage = dam;
        hitChance = hC;
        piercing = pier;
    }
    
    /**
     * Returns the damage the item deals
     */
    public int getDamage(){
        return damage;
    }
    
    /**
     * Returns the chance of the item hitting (out of 100)
     */
    public int getHitChance(){
        return hitChance;
    }
    
    /**
     * Returns whether the item pierces defense
     */
    public boolean isPiercing(){
        return piercing;
    }
}