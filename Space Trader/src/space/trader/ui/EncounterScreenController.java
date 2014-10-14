/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader.ui;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import space.trader.gameplay.Data;

/**
 * FXML Controller class
 *
 * @author Weiyu
 */
public class EncounterScreenController implements Initializable {
    @FXML
    private Label encounter = new Label();
    int fuel = Data.getPlayer().getShip().getFuel();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Random r = new Random();
        int encounterProb = r.nextInt(8);
        if(encounterProb == 0) {
            encounter.setText("A fuel leak has occured on your ship. You have lost half of your fuels.");
            fuel = fuel/2;
            Data.getPlayer().getShip().setFuel(fuel);
        } else {
                        encounter.setText("A fuel leak has occured on your ship. You have lost half of your fuels.");
            fuel = fuel/2;
            Data.getPlayer().getShip().setFuel(fuel);
        }
    }    
    
    @FXML
    private void EnterPlanetScreen(ActionEvent event) throws IOException {
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
