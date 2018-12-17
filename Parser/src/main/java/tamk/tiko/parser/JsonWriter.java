package tamk.tiko.parser;

import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

/**
 * JsonWriter is used to write JsonObject to .json file.
 * 
 * @author      Saku Tynjala saku.tynjala@cs.tamk.fi
 * @version     0.1
 * @since       0.1
 */

public class JsonWriter{
    
    /**
     * Basic Constructor
     */
    public JsonWriter(){}

    /**
     * Writes .Json file of given JsonObject
     * 
     * @param toWrite JsonObject to be written in .json file
     */
    public void WriteFile(List<JsonObject> toWrite){

        JsonWrapper wrapText = new JsonWrapper();

        String writtenString = wrapText.wrapAll(toWrite);

        try {
            FileWriter fileWriter = new FileWriter("ShopList.json");
            fileWriter.write(writtenString);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}