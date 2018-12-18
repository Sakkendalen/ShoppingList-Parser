package tamk.tiko.parser;

/**
 * JsonObject is object which contains Items and quantities for Shoppinglist.json file
 * 
 * @author      Saku Tynjala saku.tynjala@cs.tamk.fi
 * @version     0.3
 * @since       0.1
 */
public class JsonObject{
    private String nameString;
    private Integer quantityInt;


    /**
     * Basic Constructor
     */
    public JsonObject(){}

    /**
     * Constructor that sends given parameters to setters to set
     * this object itemString and quantityInt.
     * 
     * @param itemName to define item e.g  Item: "Milk".
     * @param quantityData to define how many items.
     */
    public JsonObject(String itemName, int quantityData){
        setName(itemName);
        setQuantity(quantityData);
    }

    /**
     * setName method to define nameString.
     * 
     * @param itemName to define item e.g  Item: "Milk".
     */
    public void setName(String itemName){
        this.nameString = itemName;
    }

    /**
     * setQuantity method to define quantityInt.
     * 
     * @param quantityData to define how many items.
     */
    public void setQuantity(int quantityData){
        this.quantityInt = quantityData;
    }

    /**
     * getName method to return this object nameString.
     * 
     * @return This object item name.
     */
    public String getName(){
        return nameString;
    }
    
    /**
     * getQuantity method to Return this object quantityInt.
     * 
     * @return This object item quantity.
     */
    public int getQuantity(){
        return quantityInt;
    }

}