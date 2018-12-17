import tamk.tiko.parser.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;

/**
 * Main.java purpose is to launch javafx window and connect it with parser.
 * 
 * @author      Saku Tynjala saku.tynjala@cs.tamk.fi
 * @version     0.1
 * @since       0.1
 */

 public class Main {

    /**
     * main method to start the application and in future connect parser and javafx-GUI
     * 
     * @param args command line arguments
     */
    public static void main(String [] args) {

        String author = "Saku Tynjala";
        System.out.println("Author: " + author);
        boolean loop = true;
        Scanner input = new Scanner (System.in);
        String q;
        String item;
        int quantity;

        List<JsonObject> items = new ArrayList<JsonObject> ();

        while(loop){
            System.out.println("Give an itemname");
            item = input.nextLine();
            System.out.println("Give a quantity");
            quantity = input.nextInt();
            input.nextLine();

            items.add(new JsonObject(item, quantity));

            System.out.println("continue?");
            q = input.nextLine();
            if(q.equals("no")){
                loop = false;
            }
        }

        JsonWriter test2 = new JsonWriter();
        // File file = new File("");
        
        test2.WriteFile(items);
        
    }
}