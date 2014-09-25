/*
 * CS2340
 * Team StarFox(19)
 * Members: Weiyu Li, Duc Tran, Justin Coates, JD Arthur, Qifeng Li
 * For our project, we will be reimplement the game Space Trader. 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SpaceTrader extends Application {
    // Create the universe as a List of solar system
    private ObservableList<SolarSystem> Universe = FXCollections.observableArrayList();
    
    @Override
    public void start(Stage stage) throws Exception {
        // Loa
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
  
        Scene scene = new Scene(root);    
        stage.setScene(scene);
        stage.show();
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(SolarSystem.universeGenerate());
        launch(args);
    } 
    
}
