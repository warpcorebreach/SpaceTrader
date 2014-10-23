
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
    /**
     * Initializes the controller class.
     * Randomly determines which encounter to load
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Random r = new Random();
        int encounterProb = r.nextInt(8);
        if(encounterProb == 0) {
            encounter.setText("A fuel leak has occured on your ship. You have lost half of your fuels.");
            fuel = fuel/2;
            Data.getPlayer().getShip().setFuel(fuel);
        } else if (encounterProb == 1) {
            encounter.setText("You got robbed by bandits and have lost all of your cash");
            cash = 0;
            Data.getPlayer().setCash(cash);
        } else if (encounterProb == 2) {
            encounter.setText("You have discovered an abandoned SpacedShip with cash and fuel inside.");
            fuel = fuel + 50;
            cash = cash + 2500;
            Data.getPlayer().setCash(cash);
            Data.getPlayer().getShip().setFuel(fuel);
        } else if (encounterProb == 3) {
            encounter.setText("Your ship accidently hit an Asteroid, You have to spend half of your cash repairing it.");
            cash = cash/2;
            Data.getPlayer().setCash(cash);
        } else if (encounterProb == 4) {
            encounter.setText("Your have discovered rare minerals on a nearby Asteroid. your cash increases");
            cash = cash + 10000;
            Data.getPlayer().setCash(cash);
        } else if (encounterProb == 5) {
            encounter.setText("Reserved for Pirates");
        } else if (encounterProb == 6) {
            encounter.setText("Reseved for Police");
        } else if (encounterProb == 7) {
            encounter.setText("Reserved for Merchant");
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
