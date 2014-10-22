/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import space.trader.gameplay.Data;
import space.trader.gameplay.Save;
import space.trader.location.SolarSystem;
import space.trader.location.Universe;

/**
 * FXML Controller class
 *
 * @author jd
 */
public class UniverseScreenController implements Initializable {
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
    private ObservableList<SolarSystem> data = FXCollections.observableArrayList();
    
    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        
        playerName.setText("Welcome to the Universe, " + Data.getPlayer().getName());
        if (currentSys == null) {
            curSysName.setText("In Space");
            curTechLevel.setText("N/A");
        } else {
            curSysName.setText(currentSys.toString());
            curTechLevel.setText(""+currentSys.getTechLevel());
        }
        curSysCoords.setText("(" + currentLoc[0] + "," + currentLoc[1] + ")");
        fuelLevel.setText("Fuel Level: "+fuel);
        fuelCostLabel.setText("Fuel Cost: N/A");
    }  
    
    /**
     * Returns the fuel cost to go a given SolarSystem
     * Traveling one coordinate "unit" costs one unit of fuel
     * @param sys the solar system to calculate fuel cost for
     * @return the fuel cost to travel to the given System
     */
    private int getFuelCost(SolarSystem sys) {
        int x1 = currentLoc[0];
        int x2 = sys.getX();
        int y1 = currentLoc[1];
        int y2 = sys.getY();
        
        int cost = (int) Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
        cost -= (cost*(3*Data.getPlayer().getPilot())/100);
        sys.setFuelCost(cost);
        return cost;
    }
    
    /**
     * Stores the currently selected SolarSystem
     */
    @FXML
    public void selection() {
        selected = (SolarSystem)table.getSelectionModel().getSelectedItem();
        fuelCostLabel.setText("Fuel Cost: " + selected.getFuelCost());
    }
    
    @FXML
    private void EnterPlanetScreen(ActionEvent event) throws IOException {
        if (selected == null) return;
        Data.setSolarSystem(selected);
        selected.makeMarket();
        fuel -= getFuelCost(selected);
        Data.getPlayer().getShip().setFuel(fuel);
        Random r = new Random();
        int encounterProb = r.nextInt(2);
        if(encounterProb == 0 && !(selected.equals(currentSys))) {
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("EncounterScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        } else {
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
    }
    @FXML
    public void saveGame() {
        Save s = new Save();
        s.saveTextFile();
    }
  
}
