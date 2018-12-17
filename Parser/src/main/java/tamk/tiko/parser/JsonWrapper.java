package tamk.tiko.parser;

import java.util.List;
import java.util.ArrayList;

/**
 * JsonWrapper is used to add Json object essential signs e.g curly signs.
 * 
 * @author      Saku Tynjala saku.tynjala@cs.tamk.fi
 * @version     0.2
 * @since       0.2
 */

public class JsonWrapper{

    final char start = '{';
    final char end = '}';
    final char arrayStart = '[';
    final char arrayEnd = ']';
    final char comma = ',';
    final char quatation = '"';
    final char colon = ':';
    final String startString = start + "\n  " + "" + quatation + "Items" + quatation + colon + " " + arrayStart + "\n\t  ";

    /**
     * basic constructor.
     */
    public JsonWrapper(){}

    /**
     * wrapAll method formats all given arguments to json.
     * 
     * @param itemsData List of JsonObjects
     * @return String as json pattern
     */
    public String wrapAll(List<JsonObject> itemsData){

        String returnString = startString;

        for(JsonObject item : itemsData){

            if(itemsData.indexOf(item) == (itemsData.size() - 1)){

                returnString += start + "\n      " + "" + quatation + 
                "Item" + quatation + colon +  " " + quatation + item.getName() + quatation + comma + "\n      " + quatation + 
                "Quantity" + quatation + colon + " " + quatation + item.getQuantity() + quatation +
                "\n    " + end + "\n  " + arrayEnd + "\n" + end;

            }
            else{

                returnString += start + "\n      " + "" + quatation + 
                "Item" + quatation + colon +  " " + quatation + item.getName() + quatation + comma + "\n      " + quatation + 
                "Quantity" + quatation + colon + " " + quatation + item.getQuantity() + quatation +
                "\n    " + end + comma + "\n    ";

            }

        }

        return returnString;
    }
}