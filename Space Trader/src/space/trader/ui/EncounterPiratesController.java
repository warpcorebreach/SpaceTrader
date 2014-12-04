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
import space.trader.gameplay.Player;

/**
 * FXML Controller class
 *
 * @author trananhduc1004
 */
public class EncounterPiratesController implements Initializable {
    @FXML
    private Label warningLabel = new Label();

    @FXML
    private Label pirateLabel = new Label();

    @FXML
    private Label playerLabel = new Label();

    private Player player;
    private int cash, playerPower, piratePower;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player = Data.getPlayer();
        cash = player.getCash();

        Random rand = new Random();
        playerPower = player.getShip().getWeaponPower() + player.getFighter();
        piratePower = Math.abs(rand.nextInt(65)
                - player.getShip().getShieldPower());
        pirateLabel.setText("" + piratePower);
        playerLabel.setText("" + playerPower);
    }
     @FXML
    private void runtoPlanet(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass()
                    .getResource("PlanetScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     @FXML
    private void attackPirate(ActionEvent event) throws IOException {
        // if player's weapon power >= pirate's power the player will
        // defeat the pirates
        boolean playerWin = playerPower >= piratePower;
        if (playerWin) {
           Data.getPlayer().setCash(cash + 5000);
           warningLabel.setText("You win and get 5000");
        } else {
            Data.getPlayer().setCash(cash / 2);
            warningLabel.setText("You lose and lost half of you cash");
        }

        Node node = (Node) event.getSource();
        node.setDisable(true);
    }
}
