package tamk.tiko.gui;

import controller.*;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

/**
 * GUI.java launches javafx window.
 * 
 * @author      Saku Tynjala saku.tynjala@cs.tamk.fi
 * @version     0.2
 * @since       0.2
 */

public class GUI extends Application {

    private static Stage pStage;

    /**
     * start method to load javFX window properties from GUI.fxml and display it.
     * 
     * @param primaryStage stages not used
     */
    @Override
     public void start(Stage primaryStage) {

        pStage = primaryStage;

         try {
            // Pane root = (Pane)FXMLLoader.load(getClass().getResource("/GUI.fxml"));

            Parent root = FXMLLoader.load(getClass().getResource("/GUI.fxml"));

            Scene scene = new Scene(root, 600, 400);

            primaryStage.setTitle("Shopper 5000 Ultimate");

            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();

         } catch(Exception e) {
            e.printStackTrace();
        }
    }

        public static Stage getPrimaryStage() {
            return pStage;
        }

        private void setPrimaryStage(Stage pStage) {
            GUI.pStage = pStage;
        }

    /**
     * main method to launch javaFX window
     * 
     * @param args 
     */
    public static void main(String args[]){
        launch(args);
    }
    public void closeApplication(Stage primaryStage){
        primaryStage.close();
    }
}