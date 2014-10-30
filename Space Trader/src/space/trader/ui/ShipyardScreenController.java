package space.trader.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import space.trader.gameplay.Data;
import space.trader.gameplay.Player;
import space.trader.gameplay.Ship;
import space.trader.location.*;
import space.trader.resources.ShipTypes.ShipType;

/**
 * FXML Controller class
 *
 * @author trananhduc1004
 */
public class ShipyardScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Shipyard shipyard;
    private SolarSystem sol;
    private Player player;
    private ArrayList<ShipType> shipsAvailable;
    private ArrayList<String> names;
    private Ship ship;
    private ShipType selected;
        
    @FXML
    private TextArea txt = new TextArea();
    @FXML
    private ChoiceBox choice = new ChoiceBox();
    @FXML
    private Button ret = new Button();
    @FXML
    private Button buy = new Button();
    @FXML
    private Label cur = new Label();
    @FXML
    private Label cash = new Label();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player = Data.getPlayer();
        sol = Data.getSolarSystem();
        shipyard = new Shipyard(sol);
        shipsAvailable = shipyard.getShips();
        ship = player.getShip();
        names = new ArrayList<>();
        cur.setText("Current Ship: "+ship.getShipType().getName());
        cash.setText("Cash: "+player.getCash());
        
        if (shipsAvailable.isEmpty()) {
            txt.setText("Sorry, no ships are available\nat this time.");
        } else {
            for (ShipType s : shipsAvailable) {
                names.add(s.getName());
            }
            choice.setItems(FXCollections.observableArrayList(names));
        }
        
        
    }
    
    @FXML
    private void purchase() {
        if (selected != null && selected.getPrice() <= player.getCash()) {
            ship.setShipType(selected);
            cur.setText("Current Ship: "+ship.getShipType().getName());
            player.setCash(player.getCash()-ship.getShipType().getPrice());
            cash.setText("Cash: "+player.getCash());
        } else if (selected.getPrice() > player.getCash()) {
            txt.setText("Sorry trader, you can't\nafford that.");
        }
    }
    
    @FXML
    private void select() {
        choice.getSelectionModel().selectedIndexProperty().addListener(
            new ChangeListener<Number>() {
                public void changed(ObservableValue v, Number val, Number new_val) {
                    ShipType s = shipsAvailable.get(new_val.intValue());
                    txt.setText(s.toString());
                    selected = s;
                }
            });
    }
    
    
    /**
     * Return to Planet screen 
     */    
    @FXML
    private void EnterPlanetScreen(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}

