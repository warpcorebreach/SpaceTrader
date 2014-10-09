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
import javafx.collections.*;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import space.trader.items.TradeGood;

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
    private TradeGood selected;
    private Ship ship;
    
    @FXML
    private Button buy;
    @FXML
    private Label label1;
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
        label1.setText("Cash: " + cash);
        
        goodCol.setCellValueFactory (
                new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory (
                new PropertyValueFactory<>("price"));
        quantCol.setCellValueFactory (
                new PropertyValueFactory<>("quant"));
        
        data.addAll(tradeGoodList);
        table.setItems(data);
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
                label1.setText("Cash: " + cash);
                int q = selected.getQuantity() - 1;
                selected.setQuantity(q);
                
                System.out.println("==== Cargo ====");
                for (String s : ship.getCargo().keySet()) {
                    System.out.println(s + " " + ship.getCargo().get(s));
                }
                System.out.println();
            }
        }
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
            label1.setText("Cash: " + cash);
            int q = selected.getQuantity() + 1;
            selected.setQuantity(q);
            System.out.println("Remove Successfully");
        }
    }   

}
