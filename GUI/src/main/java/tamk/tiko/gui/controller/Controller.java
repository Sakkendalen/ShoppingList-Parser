package controller;

import tamk.tiko.*;
import tamk.tiko.gui.*;
import tamk.tiko.parser.*;

import java.net.URL;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Controller is used fetch objects (String and Int) from javaFX window what user 
 * wants to be saved in shoppinglist and display them to user
 * and send to parser Objects to parse them to JSON. Controller is defined to be used at GUI.fxml
 * 
 * @author      Saku Tynjala saku.tynjala@cs.tamk.fi
 * @version     0.2
 * @since       0.2
 */

public class Controller implements Initializable{

    //Objects from GUI.fxml
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
    MenuItem loadList;

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

    @FXML
    protected void addJsonObject(ActionEvent event) {

        String i = itemName.getText();
        int t = Integer.parseInt(itemQuantity.getText());

        JsonObject temp = new JsonObject(i, t);

        items.add(temp);

        data = ItemList.getItems();
        data.add(temp);

        System.out.println(data);
        System.out.println(i);
        System.out.println(t);

        itemName.clear();
        itemQuantity.clear();
    }
    

    /**
     * initialize method is called after all @FXML annotated members have been injected.
     * 
     * @param location GUI.fxml location
     * @param resources to locate objects from GUI.fxml
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        
        ItemList.getItems().addAll(items);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                addJsonObject(e);
            }
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                itemName.clear();
                itemQuantity.clear();
            }
        });

        newList.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                items.clear();
                data.clear();
            }
        });

        saveList.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                JsonWriter writer = new JsonWriter();
                writer.WriteFile(items);
            }
        });

        loadList.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {

                //SHIIIIIT
                System.out.println("load");
            }
        });

        /**
         * poppup
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

        closeWindow.setOnAction(e -> Platform.exit());
    }

}