/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import java.io.IOException;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author jd
 */
public class UniverseScreenController implements Initializable {
    @FXML
    private Label label1;
    private Universe universe;
    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        universe = Data.getUniverse();
        label1.setText("Welcome, " + Data.getPlayer().getName() + "!"
                + " Current Fuel Level is " + Data.getPlayer().getShip().getFuel());
    }  
    
    @FXML
    private void EnterPlanetScreen(ActionEvent event) throws IOException {
        // make a Market for testing purposes
        // temporary until travel is implemented
        universe.getUniverse().get(0).makeMarket();

        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
  
}
