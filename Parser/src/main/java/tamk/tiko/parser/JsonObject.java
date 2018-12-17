package tamk.tiko.parser;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * JsonObject is object which contains Items and quantities for Shoppinglist.json file
 * 
 * @author      Saku Tynjala saku.tynjala@cs.tamk.fi
 * @version     0.1
 * @since       0.1
 */
public class JsonObject{
    private String nameString;
    private int quantityInt;
    // private SimpleStringProperty name = new SimpleStringProperty("");
    // private SimpleIntegerProperty quantity = new SimpleIntegerProperty();

    /**
     * Basic Constructor
     */
    public JsonObject(){}

    /**
     * Constructor which adds item (String) and quantity (int) to textData.
     * 
     * @param itemName to define item e.g  Item: "Milk".
     * @param quantityData to define how many items.
     */
    public JsonObject(String itemName, int quantityData){
        // setName(itemName);
        setName(itemName);
        // setQuantity(quantityData);
        setQuantity(quantityData);
    }

    // public void setName(String itemName){
    //     name.set(itemName);
    // }

    // public void setQuantity(int quantityData){
    //     quantity.set(quantityData);
    // }

    public void setName(String itemName){
        this.nameString = itemName;
    }

    public void setQuantity(int quantityData){
        this.quantityInt = quantityData;
    }

    /**
     * getItem method to return this object NameData.
     * 
     * @return This object item name.
     */
    // public SimpleStringProperty getName(){
    //     return name;
    // }
    
    // /**
    //  * getQuantity method to Return this object quanityData.
    //  * 
    //  * @return This object item quantity.
    //  */
    // public SimpleIntegerProperty getQuantity(){
    //     return quantity;
    // }

    /**
     * getItem method to return this object NameData.
     * 
     * @return This object item name.
     */
    public String getName(){
        return nameString;
    }
    
    /**
     * getQuantity method to Return this object quanityData.
     * 
     * @return This object item quantity.
     */
    public int getQuantity(){
        return quantityInt;
    }

}