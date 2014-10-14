/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import space.trader.gameplay.Data;
import space.trader.gameplay.Player;
import space.trader.gameplay.Ship;
import space.trader.location.Market;
import space.trader.resources.TradeGood;

/**
 * FXML Controller class
 *
 * @author Weiyu
 */
public class MarketScreenController implements Initializable {
    private Market market;
    private Player player;
    private int cash;
    private ArrayList<TradeGood> tradeGoodList;
    private ArrayList<String> cargo;
    private TradeGood selected;
    private Ship ship;
    
    @FXML
    private Label cashLabel = new Label();
    @FXML
    private Label cargoLabel = new Label();
    @FXML
    private TableView<TradeGood> table = new TableView();
    @FXML
    private TableColumn goodCol = new TableColumn();
    @FXML
    private TableColumn priceCol = new TableColumn();
    @FXML
    private TableColumn quantCol = new TableColumn();
    @FXML
    private ObservableList<TradeGood> data = FXCollections.observableArrayList();
    @FXML
    private ObservableList<String> cargoData = FXCollections.observableArrayList();
    @FXML
    private ListView<String> cargoDisplay = new ListView<>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player = Data.getPlayer();
        market = Data.getMarket();
        tradeGoodList = market.getGoods();
        cash = player.getCash();
        ship = player.getShip();
        cashLabel.setText("Cash: " + cash);
        cargoLabel.setText("Ship's Cargo (" + ship.getCargoSize() + "/20)");
        cargo = new ArrayList<>();
        
        goodCol.setCellValueFactory (
                new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory (
                new PropertyValueFactory<>("price"));
        quantCol.setCellValueFactory (
                new PropertyValueFactory<>("quant"));
        
        data.addAll(tradeGoodList);
        table.setItems(data);
        
        if (!ship.getCargo().isEmpty()) {
            updateCargoScreen();
        }
    }
    
    /**
     * Stores the currently selected good
     */
    @FXML
    public void selection() {
        selected = (TradeGood)table.getSelectionModel().getSelectedItem();
    }
    
    /**
     * Purchase the selected good from the market and add it to the ship's cargo.
     * Prints the ships cargo after the purchase to the console
     * Possible errors: Market is out of the item
     *                  Player's cargo is full
     *                  Player does not have enough money
     */
    @FXML
    public void purchase() {
        if (selected == null) return;
        if (cash - selected.getPrice() < 0) {
            // out of money error message
            System.out.println("you don't have enough money");
        } else if (selected.getQuantity() == 0) {
            // none available error message
            System.out.println("market is out");
        } else {
            boolean buy = ship.addCargo(selected);
            if (buy == false) {
                // cargo full error message
                System.out.println("not enough cargo space");
            } else {
                cash -= selected.getPrice();
                player.setCash(cash);
                cashLabel.setText("Cash: " + cash);
                int q = selected.getQuantity() - 1;
                selected.setQuantity(q);
                
                updateCargoScreen();                
            }
        }
    }
    
    /**
     * Sell the currently selected good for the price listed in the Market
     * window. Removes the good from the ship's cargo.
     * Possible errors: Cargo is empty
     *                  Cargo does not contain selected good
     */
    @FXML
    private void sell() {
        if (selected == null) return;
        int temp = ship.removeCargo(selected);
        if (temp == 0) {
            System.out.println("Cargo is empty");
        } else if (temp == -1) {
            System.out.println("Cargo does not contain current TradeGood");
        } else {
            cash = cash + selected.getPrice();
            player.setCash(cash);
            cashLabel.setText("Cash: " + cash);
            int q = selected.getQuantity() + 1;
            selected.setQuantity(q);
            
            updateCargoScreen();
        }
    } 
    
    /**
     * Update the cargo display window in the Market UI.
     */
    private void updateCargoScreen() {
        cargoLabel.setText("Ship's Cargo " + "(" + ship.getCargoSize() + "/20)");
        cargo.clear();
        cargoData.clear();
        HashMap<String, Integer> c = ship.getCargo();
        for (String item : c.keySet()) {
            cargo.add(item + " " + c.get(item));
        }
        cargoData.addAll(cargo);
        cargoDisplay.setItems(cargoData);
    }
    
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
