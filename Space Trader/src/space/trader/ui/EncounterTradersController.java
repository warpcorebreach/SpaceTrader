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
import javafx.scene.control.Button;
import java.util.Random;

/**
 * FXML Controller class
 *
 * @author trananhduc1004
 */
public class EncounterTradersController implements Initializable {
    @FXML
    private Label infoLabel = new Label();
    @FXML
    private Button rock = new Button();
    @FXML
    private Button paper = new Button();
    @FXML
    private Button scissors = new Button();
    boolean playerWin = (new Random()).nextBoolean();
    int cash;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cash = Data.getPlayer().getCash();
    }
     @FXML
    private void giveRock(ActionEvent event) throws IOException {
        cash = Data.getPlayer().getCash();
        if (playerWin) {
            cash = cash * 3 / 2;
            Data.getPlayer().setCash(cash);
            infoLabel.setText("Trader give scissors. You won. Your money: " + cash);
        } else {
            cash = cash / 2;
            Data.getPlayer().setCash(cash);
            infoLabel.setText("Trader give scissors. You lost. Your money: " + cash);
        }
        
        // Trader either chose scissor or paper
        rock.setDisable(true);
        paper.setDisable(true);
        scissors.setDisable(true);
    }
     @FXML
    private void givePaper(ActionEvent event) throws IOException {
        cash = Data.getPlayer().getCash();
        if (playerWin) {
            cash = cash * 3 / 2;
            Data.getPlayer().setCash(cash);
            infoLabel.setText("Trader give rock. You won. Your money: " + cash);
        } else {
            cash = cash / 2;
            Data.getPlayer().setCash(cash);
            infoLabel.setText("Trader give scissors. You lost. Your money: " + cash);
        }
        
        // Trader either chose scissor or paper
        rock.setDisable(true);
        paper.setDisable(true);
        scissors.setDisable(true);
    }
    @FXML
    private void giveScissors(ActionEvent event) throws IOException {
        cash = Data.getPlayer().getCash();
        if (playerWin) {
            cash = cash * 3 / 2;
            Data.getPlayer().setCash(cash);
            infoLabel.setText("Trader give paper. You won. Your money: " + cash);
        } else {
            cash = cash / 2;
            Data.getPlayer().setCash(cash);
            infoLabel.setText("Trader give rock. You lost. Your money: " + cash);
        }
        
        // Trader either chose scissor or paper
        rock.setDisable(true);
        paper.setDisable(true);
        scissors.setDisable(true);
    }
    @FXML
     private void  backToPlanet(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass()
                    .getResource("PlanetScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
