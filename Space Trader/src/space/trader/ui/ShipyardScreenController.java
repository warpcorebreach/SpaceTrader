package space.trader.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
import space.trader.resources.Equipment.Shield;
import space.trader.resources.Equipment.Weapon;
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
    private ArrayList<Weapon> weaponAvailable;
    private ArrayList<Shield> shieldAvailable;
    private ArrayList<String> names;
    private ArrayList<String> weaponNames;
    private ArrayList<String> shieldNames;
    private Ship ship;
    private ShipType selected;
    private Weapon selectedWeapon;
    private Shield selectedShield;
        
    @FXML
    private TextArea txt = new TextArea();
    @FXML
    private ChoiceBox choice = new ChoiceBox();
    @FXML
    private ChoiceBox choice2 = new ChoiceBox();
    @FXML
    private ChoiceBox choice3 = new ChoiceBox();
    @FXML
    private TextArea txt2 = new TextArea();
    @FXML
    private Button ret = new Button();
    @FXML
    private Button buy = new Button();
    @FXML
    private Label cur = new Label();
    @FXML
    private Label cash = new Label();
    @FXML 
    private Label refuelCost = new Label();
    @FXML
    private Label fuelLabel = new Label();
    private int fuelcost;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player = Data.getPlayer();
        sol = Data.getSolarSystem();
        shipyard = new Shipyard(sol);
        shipsAvailable = shipyard.getShips();
        weaponAvailable = shipyard.getWeapons();
        shieldAvailable = shipyard.getShields();
        ship = player.getShip();
        names = new ArrayList<>();
        shieldNames = new ArrayList<>();
        weaponNames = new ArrayList<>();
        cur.setText("Current Ship: "+ship.getShipType().getName());
        cash.setText("Cash: "+player.getCash());
        fuelcost = (ship.getShipType().getMaxFuel() - ship.getFuel()) * 50 * ship.getShipType().getFuelCost();
        
        refuelCost.setText("Refuel Cost: " + fuelcost);
        
        if (shipsAvailable.isEmpty()) {
            txt.setText("Sorry, no ships \nare available\nat this time.");
        } else {
            for (ShipType s : shipsAvailable) {
                names.add(s.getName());
            }
            choice.setItems(FXCollections.observableArrayList(names));
        }
        if (weaponAvailable.isEmpty()) {
            txt2.setText("Sorry, no weapons \nare available\nat this time.");
        } else {
            for (Weapon w : weaponAvailable) {
                weaponNames.add(w.getName());
            }
            choice2.setItems(FXCollections.observableArrayList(weaponNames));
        }        
        if (shieldAvailable.isEmpty()) {
            txt2.setText("Sorry, no shields \nare available \nat this time.");
        } else {
            for (Shield s : shieldAvailable) {
                shieldNames.add(s.getName());
            }
            choice3.setItems(FXCollections.observableArrayList(shieldNames));
        }
        if (shieldAvailable.isEmpty() && weaponAvailable.isEmpty()) {
            txt2.setText("Sorry, no shields or \nweapons are available\nat this time.");
        }
    }
    
    /**
     * If the player has enough cash the selected Ship is purchased and
     * immediately usable by the player.
     */
    @FXML
    private void purchase() {
        if(selected ==  null) {
            txt.setText("Please select a ship.");
        } else if((ship.getShipType().getName().equals(selected.getName()))) {
            txt.setText("You already have a\n " +ship.getShipType().getName()); 
        } else if (selected.getPrice() <= player.getCash()) {
            ship.setShipType(selected);
            cur.setText("Current Ship: "+ship.getShipType().getName());
            player.setCash(player.getCash()-ship.getShipType().getPrice());
            cash.setText("Cash: "+player.getCash());
            
        } else if (selected.getPrice() > player.getCash()) {
            txt.setText("Sorry trader, you can't\nafford that.");
        }
    }
    /**
     * If the player has enough cash and Player's ship has weapon slot avaliable then the selected Weapon is purchased and
     * immediately usable by the player.
     */
    @FXML
    private void purchaseWeapon() {
        if(selectedWeapon == null) {
            txt2.setText("Please select a weapon.");
        } else if (selectedWeapon != null && selectedWeapon.getCost() <= player.getCash() && ship.getWeaponsSize() < ship.getShipType().getWeaponSlot()) {
            ship.addWeapon(selectedWeapon);
            player.setCash(player.getCash()-selectedWeapon.getCost());
            cash.setText("Cash: "+player.getCash());
            
        } else if (selectedWeapon.getCost() > player.getCash()) {
            txt2.setText("Sorry trader, you can't\nafford that.");
        } else if (ship.getWeaponsSize() >= ship.getShipType().getWeaponSlot()) {
            txt2.setText("Sorry trader, your \nship doesn't have \nenough WeaponSlots.");
        }
    }
    
    /**
     * If the player has enough cash and Player's ship has shield slot avaliable then the selected Shield is purchased and
     * immediately usable by the player.
     */
    @FXML
    private void purchaseShield() {
        if(selectedShield == null) {
           txt2.setText("Please select a shield.");
        } else if (selectedShield != null && selectedShield.getCost() <= player.getCash() && ship.getShieldsSize() < ship.getShipType().getShieldSlot()) {
            ship.addShield(selectedShield);
            player.setCash(player.getCash()-selectedShield.getCost());
            cash.setText("Cash: "+player.getCash());
            
        } else if (selectedShield.getCost() > player.getCash()) {
            txt2.setText("Sorry trader, you can't\nafford that.");
        } else if (ship.getShieldsSize() >= ship.getShipType().getShieldSlot()) {
            txt2.setText("Sorry trader, your \nship doesn't have \nenough ShieldSlots.");
        }
    }
    
    /**
     * Action Event when a Ship Type is selected from the menu.
     */
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
     * Action Event when a weapon is selected from the menu.
     */
    @FXML
    private void selectWeapon() {
        choice2.getSelectionModel().selectedIndexProperty().addListener(
            new ChangeListener<Number>() {
                public void changed(ObservableValue v, Number val, Number new_val) {
                    Weapon w = weaponAvailable.get(new_val.intValue());
                    txt2.setText(w.toString());
                    selectedWeapon = w;
                }
            });
    }
    /**
     * Action Event when a Shield is selected from the menu.
     */
    @FXML
    private void selectShield() {
        choice3.getSelectionModel().selectedIndexProperty().addListener(
            new ChangeListener<Number>() {
                public void changed(ObservableValue v, Number val, Number new_val) {
                    Shield s = shieldAvailable.get(new_val.intValue());
                    txt2.setText(s.toString());
                    selectedShield = s;
                }
            });
    }
    /**
     * Refuel the ship
     */
    @FXML
    private void refuel() {
     if(fuelcost>player.getCash()) {
         fuelLabel.setText("Not enough Money.");
     } else {
         ship.setFuel(ship.getShipType().getFuel());
         fuelLabel.setText("Refuel Successfully.");
         player.setCash(player.getCash() - fuelcost);
         fuelcost = (ship.getShipType().getMaxFuel() - ship.getFuel()) * 50 * ship.getShipType().getFuelCost();
         refuelCost.setText("Refuel Cost: " + fuelcost);
         cash.setText("Cash: " + player.getCash());
     }
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
    
    //hideUpgrades();
    
}

