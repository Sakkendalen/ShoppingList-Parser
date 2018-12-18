package controller;

import tamk.tiko.*;
import tamk.tiko.gui.*;
import tamk.tiko.parser.*;

import java.net.URL;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.util.List;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Platform;

/**
 * Controller is used fetch objects (String and Int) from javaFX window
 * and controlling them and events to write new shoppinglist .json files and displaying
 * saved JsonObjects to user.
 * 
 * Controller is defined to be used at GUI.fxml
 * 
 * @author      Saku Tynjala saku.tynjala@cs.tamk.fi
 * @version     0.3
 * @since       0.2
 */

public class Controller implements Initializable{

    /**
     * FXML objects that is used to control events,
     * and fetching given input.
     */
    @FXML
    Button add;

    @FXML
    Button clear;

    @FXML
    TextField itemName;

    @FXML
    TextField itemQuantity;

    @FXML
    MenuItem newList;
    
    @FXML
    MenuItem saveList;

    @FXML
    MenuItem closeWindow;

    @FXML MenuItem about;

    @FXML
    Menu helpMenu;

    @FXML
    TableView<JsonObject> ItemList;

    @FXML
    TableColumn<JsonObject, String> name;

    @FXML
    TableColumn<JsonObject, Integer> quantity;

    List<JsonObject> items = new ArrayList<JsonObject>();
    ObservableList<JsonObject> data;

    /**
     * addJsonObject method is called when add button is pressed.
     * method fetches textfield datas and sends them to parser for new
     * JsonObject and adds that to observableArraylist and to List.
     */
    @FXML
    protected void addJsonObject(ActionEvent e) {

        String itemString = "";
        String quantityString = "";
        int quantityInt = -1;

        try{
            itemString = itemName.getText();
            quantityString = itemQuantity.getText();
            quantityInt = Integer.parseInt(itemQuantity.getText());
        } catch( Exception ae){
        }

        if(itemString == null || itemString.matches("\\d*") || !itemString.matches("[a-zA-Z]+")){
            itemName.setText("Invalid Input");
        }
        else if( quantityString == null || !quantityString.matches("\\d*") 
        || quantityString.matches("[a-zA-Z]+") || quantityInt <= 0){
            itemQuantity.setText("Invalid Input");
        }
        else{
            JsonObject temp = new JsonObject(itemString, quantityInt);

            items.add(temp);
            data = ItemList.getItems();
            data.add(temp);

            itemName.clear();
            itemQuantity.clear();

            System.out.println(data);
            System.out.println(itemString);
            System.out.println(quantityString);
        }
    }
    

    /**
     * initialize method is called after all @FXML annotated members have been injected and listens 
     * when buttons are pressed to response them.
     * 
     * @param location GUI.fxml location
     * @param resources to locate objects from GUI.fxml
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        
        ItemList.getItems().addAll(items);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        /**
         * inner method to response add button activity.
         * calls addJsonObject method.
         */
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                addJsonObject(e);
            }
        });

        /**
         * inner method to response clear button activity.
         * Clears textField where user gives input.
         */
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                itemName.clear();
                itemQuantity.clear();
            }
        });

        /**
         * inner method to response newlist menuItem activity.
         * Clears list and observableArrayList if user wants to 
         * start over doing shopList.
         */
        newList.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                items.clear();
                data.clear();
            }
        });

        /**
         * inner method to response saveList menuItem activity.
         * Saves list by creating new JsonWriter and calling WriteFile
         * method from it to save items list to Json file.
         */
        saveList.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {

                JsonWriter writer = new JsonWriter();
                writer.WriteFile(items);

            }
        });

        /**
         * inner method to response about menuItem activity.
         * Poppup window for about menuItem.
         */
        about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                final Stage dialog = new Stage();

                dialog.initModality(Modality.APPLICATION_MODAL);

                dialog.initOwner(GUI.getPrimaryStage());

                VBox dialogVbox = new VBox(20);
                dialogVbox.getChildren().add(
                    new Text("Author: Saku Tynjala"));

                Scene dialogScene = new Scene(dialogVbox, 300, 200);
                dialog.setScene(dialogScene);
                dialog.show();
            }
        });

        //closeWindow menuItem lambda to close App. 
        closeWindow.setOnAction(e -> Platform.exit());
    }

}