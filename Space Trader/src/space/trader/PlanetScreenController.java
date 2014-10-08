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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author trananhduc1004
 */
public class PlanetScreenController implements Initializable {
    @FXML
    private Label planetName;
    @FXML
    private Label planetCoord;
    @FXML
    private Button EnterUniverseScreen;
    @FXML
    private Button EnterMarketScren;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        planetName.setText("Hello Duc");
        planetCoord.setText("This is the planet coordination");
    }
    @FXML
    private void EnterMarketScreen(ActionEvent event) throws IOException {
      //  label.setText("Ok. Let's Create Your Character");
          Node node=(Node) event.getSource();
         Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MarketScreen.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
         stage.show();
    }
    @FXML
    private void EnterUniverseScreen(ActionEvent event) throws IOException {
      //  label.setText("Ok. Let's Create Your Character");
          Node node=(Node) event.getSource();
         Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("UniverseScreen.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
         stage.show();
    }
    
}
