
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
    int cash = Data.getPlayer().getCash();
    private static final int ENCOUNTER_RANDMAX = 20;
    String nextScreentoEnter = "PlanetScreen.fxml";
    /**
     * Initializes the controller class.
     * Randomly determines which encounter to load
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Random r = new Random();
        int encounterProb = r.nextInt(ENCOUNTER_RANDMAX);
        if (encounterProb == 0) {
            encounter.setText("A fuel leak has occured on your ship."
                               + " You have lost half of your fuels.");
            fuel = fuel / 2;
            Data.getPlayer().getShip().setFuel(fuel);
        } else if (encounterProb == 1) {
            encounter.setText("You got robbed by bandits and have "
                               + "lost half of your cash.");
            cash = cash / 2;
            Data.getPlayer().setCash(cash);
        } else if (encounterProb == 2) {
            encounter.setText("You have discovered an abandoned spaceship"
                               + " with cash and fuel inside!");
            fuel = Data.getPlayer().getShip().getShipType().getMaxFuel();
            cash = cash + 2500;
            Data.getPlayer().setCash(cash);
            Data.getPlayer().getShip().setFuel(fuel);
        } else if (encounterProb == 3) {
            encounter.setText("Your ship accidentally hit an asteroid! You "
                             + "have to spend half of your cash repairing it.");
            cash = cash / 2;
            Data.getPlayer().setCash(cash);
        } else if (encounterProb == 4) {
            encounter.setText("You have discovered rare minerals on a"
                               + " nearby asteroid. Your cash increases!");
            cash = cash + 10000;
            Data.getPlayer().setCash(cash);
        } else if (encounterProb < 10) {
            encounter.setText("Oh NO. You have encountered a Pirates");
            nextScreentoEnter = "EncounterPirates.fxml"; 
        } else if (encounterProb < 15) {
            encounter.setText("You have met a Policeman");
            nextScreentoEnter = "EncounterPolices.fxml"; 
        } else if (encounterProb < 20) {
            encounter.setText("You met another trader");
            nextScreentoEnter = "EncounterTraders.fxml"; 
        }
    }
    
    @FXML
    private void enterPlanetScreen(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass()
                    .getResource(nextScreentoEnter));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
