/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
        currentLoc = INIT_LOC;
        universe = Data.getUniverse();
        fuel = Data.getPlayer().getShip().getFuel();
        systems = new ArrayList<>();
        
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
        //curSysName.setText(currentSys.toString());
        curSysCoords.setText("(" + currentLoc[0] + "," + currentLoc[1] + ")");
        fuelLevel.setText("Fuel Level: "+fuel);
        //curTechLevel.setText(""+currentSys.getTechLevel());
    }  
    
    private int getFuelCost(SolarSystem sys) {
        int x1 = currentLoc[0];
        int x2 = sys.getX();
        int y1 = currentLoc[1];
        int y2 = sys.getY();
        
        return (int) Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
    
    @FXML
    public void selection() {
        selected = (SolarSystem)table.getSelectionModel().getSelectedItem();
    }
    
    @FXML
    private void EnterPlanetScreen(ActionEvent event) throws IOException {
        if (selected == null) return;
        Data.setSolarSystem(selected);
        selected.makeMarket();
       
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
  
}
