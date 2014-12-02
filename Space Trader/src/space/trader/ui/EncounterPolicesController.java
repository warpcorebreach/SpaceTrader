package space.trader.ui;

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
import javafx.stage.Stage;
import space.trader.gameplay.Data;
import java.util.Random;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author trananhduc1004
 */
public class EncounterPolicesController implements Initializable {
    @FXML
    Label warning = new Label();
    int cash = Data.getPlayer().getCash();
    int fee = 500;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
     @FXML
    private void runFromPolice(ActionEvent event) throws IOException {
        
        boolean beCaught = (new Random()).nextBoolean();
        if (beCaught) {
            fee = cash * 2 / 3;
            warning.setText("Sorry, you are caught. Must pay " + fee );
            Node node = (Node) event.getSource();
            node.setDisable(true);
        }   else {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass()
                        .getResource("PlanetScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        
    }
     @FXML
    private void payFee(ActionEvent event) throws IOException {
        
        Data.getPlayer().setCash(cash - fee);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass()
                        .getResource("PlanetScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();      
    }
}
