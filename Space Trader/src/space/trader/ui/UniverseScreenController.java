
package space.trader.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
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
import space.trader.gameplay.Save;
import space.trader.gameplay.Ship;
import space.trader.location.SolarSystem;
import space.trader.location.Universe;

/**
 * FXML Controller class.
 *
 * @author jd
 */
public class UniverseScreenController implements Initializable {

    /**
     * The Player's initial (x,y) coordinates in the Universe.
     */
    private final int[] INIT_LOC = {25, 75};

    private Universe universe;
    private SolarSystem currentSys, selected;
    private ArrayList<SolarSystem> systems;
    private int[] currentLoc;
    private int fuel;

    @FXML
    private Label curTechLevel;
    @FXML
    private Label playerName;
    @FXML
    private Label curSysName;
    @FXML
    private Label curSysCoords;
    @FXML
    private Label fuelLevel;
    @FXML
    private Label fuelCostLabel;
    @FXML
    private TableView<SolarSystem> table = new TableView();
    @FXML
    private TableColumn sysCol = new TableColumn();
    @FXML
    private TableColumn coordCol = new TableColumn();
    @FXML
    private TableColumn techCol = new TableColumn();
    @FXML
    private ObservableList<SolarSystem> data
            = FXCollections.observableArrayList();
    @FXML
    private ObservableList<String> shipCargoData
            = FXCollections.observableArrayList();
    @FXML
    private ListView<String> ShipCargo = new ListView<>();
    @FXML
    private Label universeShipCargoLabel;
    @FXML
    private Label weaponsLabel;
    @FXML
    private Label shieldsLabel;
    @FXML
    private Label shipTypeLabel;
    @FXML
    private Label fuelLabel;
    @FXML
    private TextArea weaponsArea;
    @FXML
    private TextArea shieldsArea;
    @FXML
    private Label characterLabel;
    @FXML
    private Label pilotLabel;
    @FXML
    private Label fighterLabel;
    @FXML
    private Label traderLabel;
    @FXML
    private Label engineerLabel;
    @FXML
    private Label investorLabel;
    @FXML
    private Label cashLabel;



    /*
     * Initializes the controller class.
     */
    @Override
    public final void initialize(URL url, ResourceBundle rb) {
        universe = Data.getUniverse();
        fuel = Data.getPlayer().getShip().getFuel();
        systems = new ArrayList<>();
        if (Data.getSolarSystem() != null) {
            currentSys = Data.getSolarSystem();
            currentLoc = new int[2];
            currentLoc[0] = currentSys.getX();
            currentLoc[1] = currentSys.getY();
        } else {
            currentLoc = INIT_LOC;
        }

        // populate Universe with systems in range
        for (SolarSystem sys : universe.getSystems()) {
            if (getFuelCost(sys) <= fuel) {
                systems.add(sys);
            }
        }

        sysCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        coordCol.setCellValueFactory(
                new PropertyValueFactory<>("coords"));
        techCol.setCellValueFactory(
                new PropertyValueFactory<>("techLevel"));

        data.addAll(systems);
        table.setItems(data);

        playerName.setText("Welcome to the Universe, " + Data.getPlayer()
                .getName());
        if (currentSys == null) {
            curSysName.setText("In Space");
            curTechLevel.setText("N/A");
        } else {
            curSysName.setText(currentSys.toString());
            curTechLevel.setText("" + currentSys.getTechLevel());
        }
        curSysCoords.setText("(" + currentLoc[0] + "," + currentLoc[1] + ")");
        fuelLevel.setText("Fuel Level: " + fuel);
        fuelCostLabel.setText("Fuel Cost: N/A");
        showCargo();
        showShipAttributes();
        showCharacterAttributes();
    }

    /**
     * Returns the fuel cost to go a given SolarSystem.
     * Traveling one coordinate "unit" costs one unit of fuel
     * @param sys the solar system to calculate fuel cost for
     * @return the fuel cost to travel to the given System
     */
    private int getFuelCost(final SolarSystem sys) {
        int x1 = currentLoc[0];
        int x2 = sys.getX();
        int y1 = currentLoc[1];
        int y2 = sys.getY();

        int cost = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        cost -= (cost * (3 * Data.getPlayer().getPilot()) / 100);
        sys.setFuelCost(cost);
        return cost;
    }

    /**
     * Stores the currently selected SolarSystem.
     */
    @FXML
    public final void selection() {
        selected = (SolarSystem) table.getSelectionModel().getSelectedItem();
        fuelCostLabel.setText("Fuel Cost: " + selected.getFuelCost());
    }

    /**
     * This method controls the appearance of a random event.
     *
     * It generates a random number, and uses this to determine where to go.
     * Currently, there is a 50% chance of encounters, so half the time, it
     * will go to the planet screen, and half the time it will to the encounter
     * screen.
     *
     * @param event an ActionEvent which triggers the method
     * @throws IOException throws an exception if FXMLLoader cannot find the
     * given FXML file
     */

    @FXML
    private void enterPlanetScreen(final ActionEvent event) throws IOException {
        if (selected == null) {
            return;
        }
        Data.setSolarSystem(selected);
        selected.makeMarket();
        fuel -= getFuelCost(selected);
        Data.getPlayer().getShip().setFuel(fuel);
        Random r = new Random();
        //if (encounterProb == 0 ) && !(selected.equals(currentSys))
        int encounterProb = r.nextInt(4);
        if (encounterProb < 3 ) {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass()
                    .getResource("EncounterScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass()
                    .getResource("PlanetScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    /**
     * Create a new Save object and use that to save the current state of the
     * game.
     */
    @FXML
    public final void saveGame() {
        Save s = new Save();
        s.saveTextFile();
    }

    /**
     * Displays the player's cargo in the character tab.
     */
    private void showCargo() {
        Player player = Data.getPlayer();
        Ship ship = player.getShip();
        universeShipCargoLabel.setText("Ship's Cargo " + "("
                + ship.getCargoSize() + "/" + ship.getMaxCargoSize() + ")");
        if (ship.getCargoSize() == 0) {
            shipCargoData.clear();
            shipCargoData.add("You don't have any\ntrade goods.");
            ShipCargo.setItems(shipCargoData);
        } else {
            ArrayList<String> cargo = new ArrayList<>();
            shipCargoData.clear();
            for (Map.Entry item : ship.getCargo().entrySet()) {
                cargo.add(item.getKey() + " (" + item.getValue() + ")");
            }
            shipCargoData.addAll(cargo);
            ShipCargo.setItems(shipCargoData);
        }
    }

    /**
     * Displays the player's Ship information in the character tab.
     */
    private void showShipAttributes() {
        Player player = Data.getPlayer();
        Ship ship = player.getShip();
        weaponsLabel.setText("Weapons: " + "(" + ship.getWeaponsSize() + "/"
                + ship.getShipType().getWeaponSlot() + ")");
        shieldsLabel.setText("Shields: " + "(" + ship.getShieldsSize() + "/"
                + ship.getShipType().getShieldSlot() + ")");
        shipTypeLabel.setText("Ship Type: " + ship.getShipType().getName());
        fuelLabel.setText("Fuel Remaining: " + ship.getFuel());

        if (ship.getWeaponsSize() == 0) {
            weaponsArea.setText("You don't have any weapons.");
        } else {
            StringBuilder buf = new StringBuilder();
            for (int i = 0; i < ship.getWeapons().size(); i++) {
                buf.append(ship.getWeapons().get(i));
            }
            String weaponsOut = buf.toString();
            weaponsArea.setText(weaponsOut);
        }
        if (ship.getShieldsSize() == 0) {
            shieldsArea.setText("You don't have any shields.");
        } else {
            StringBuilder buf = new StringBuilder();
            for (int i = 0; i < ship.getShields().size(); i++) {
                buf.append(ship.getShields().get(i));
            }
            String shieldsOut = buf.toString();
            weaponsArea.setText(shieldsOut);
        }
    }

    /**
     * Displays the player character's attributed in the character tab.
     */
    private void showCharacterAttributes() {
        Player player = Data.getPlayer();
        characterLabel.setText("Character: " + player.getName());
        pilotLabel.setText("Pilot: " + player.getPilot());
        fighterLabel.setText("Fighter: " + player.getFighter());
        traderLabel.setText("Trader: " + player.getTrader());
        engineerLabel.setText("Engineer: " + player.getEngineer());
        investorLabel.setText("Investor: " + player.getInvestor());
        cashLabel.setText("Cash: " + player.getCash());

    }

}
