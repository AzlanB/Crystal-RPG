/**
 * Ingame inanimate items the player can aquire
 */
public class Item{
    private String name, desc;
    private int price;
    private boolean sellable;
    
    /**
     * Constructs an Item with the appropriate parameters
     */
    public Item(String name, String desc, int price, boolean sellable){
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.sellable = sellable;
    }
    
    /**
     * Returns the name of the item
     */
    public String getName(){
        return name;
    }
    
    /**
     * Returns the description of the item
     */
    public String getDesc(){
        return desc;
    }
    
    /**
     * Returns the price of the item
     */
    public int getPrice(){
        return price;
    }
    
    /**
     * Returns whether or not the item is sellable
     */
    public boolean isSellable(){
        return sellable;
    }
}