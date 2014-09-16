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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Duc
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    @FXML
    private void EnterCreationScreen(ActionEvent event) throws IOException {
        label.setText("Ok. Let's Create Your Character");
          Node node=(Node) event.getSource();
         Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("CharacterScreen.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
         stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
