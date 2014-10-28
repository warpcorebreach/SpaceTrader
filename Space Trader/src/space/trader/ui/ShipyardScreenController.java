package space.trader.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import space.trader.gameplay.Data;
import space.trader.gameplay.Player;
import space.trader.gameplay.Ship;
import space.trader.location.*;
import space.trader.resources.ShipType;

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
    private int cash;
    private ArrayList<ShipType> shipsAvailable;
    private Ship ship;;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player = Data.getPlayer();
        sol = Data.getSolarSystem();
        shipyard = new Shipyard(sol);
        shipsAvailable = shipyard.getShips();
        cash = player.getCash();
        ship = player.getShip();
        
        
    }
    
    @FXML
    private void showShipList() {
        System.out.println(shipyard);
    }
    
    
}

