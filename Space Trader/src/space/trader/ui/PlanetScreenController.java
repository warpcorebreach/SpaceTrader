
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import space.trader.gameplay.Data;
import space.trader.gameplay.Player;
import space.trader.location.SolarSystem;

/**.
 * FXML Controller class
 *
 * @author trananhduc1004
 */
public class PlanetScreenController implements Initializable {
    /**
     * Label for planet name.
     */
    @FXML
    private Label planetName;
    /**
     * Label for planet Coordination.
     */
    @FXML
    private Label planetCoord;
    /**
     * Label for Fuel.
     */
    @FXML
    private Label fuelLabel;

    /**
     * The player.
     */
    private Player player = Data.getPlayer();
    /**
     * The current planet.
     */
    private SolarSystem planet = Data.getSolarSystem();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        planetName.setText("Name: \n" + planet);
        planetCoord.setText("Coordinates\n" + "X: " + planet.getX() + "  " + "Y: " + planet.getY());
        fuelLabel.setText("Current Fuel Level: " + player.getShip().getFuel());
    }

    /**
     * Method to enter the market screen.
     * @param event the click event
     * @throws IOException
     */
    @FXML
    private void enterMarketScreen(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(
                getClass().getResource("MarketScreen.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
        /**.
     * Method to enter the shipyard screen
     * @param event the click event
     * @throws IOException
     */
    @FXML
    private void enterShipyardScreen(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(
                getClass().getResource("ShipyardScreen.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method to enter the universe screen.
     * @param event the click event
     * @throws IOException
     */
    @FXML
    private void enterUniverseScreen(ActionEvent event) throws IOException {

        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(
                getClass().getResource("UniverseScreen.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
