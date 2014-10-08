/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import space.trader.items.*;

/**
 * FXML Controller class
 *
 * @author Weiyu
 */
public class MarketScreenController implements Initializable {
    // Getting datas from UI
    @FXML
    public ArrayList<String> goodsList = Data.getMarket().getGoods();    
    @FXML
    private ArrayList<Integer> pricesList = Data.getMarket().getPrices();
    @FXML
    private ArrayList<Integer> quantityList = Data.getMarket().getQuantity();
    @FXML
    private TableView<TradeGood> tableGoods = new TableView<TradeGood>();
    // Initialize elements in UI
    @FXML
    private ListView priceListView;
    @FXML
    private ListView goodListView;
    @FXML
    private ListView quantityListView;      
    ObservableList observablePriceList = FXCollections.observableArrayList();
    ObservableList observableGoodList = FXCollections.observableArrayList();
    ObservableList observableQuantityList = FXCollections.observableArrayList();
    ObservableList observableCargoNameList = FXCollections.observableArrayList();
    @FXML
    ChoiceBox buyChoiceBox;
    @FXML
    ChoiceBox sellChoiceBox; //use this for sale
    @FXML
    // Initialize UI unrelated data;
    public String selected;
    private Player player = Data.getPlayer();
    @FXML
    public int cash = player.getCash();
    @FXML
    private Label cashLabel;
    public ArrayList<TradeGood> tradeGoodList = Data.getMarket().getTradeGoods();
    @FXML
    public ArrayList<String> cargoNameList = Data.getPlayer().getShip().getCargoName();
    public ArrayList<TradeGood> shipCargo = Data.getPlayer().getShip().getCargo();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  for(int i = 0; i < goods.size)
    // Set items for the observable List
    //Price LIst
    observablePriceList.setAll(pricesList);
    priceListView.setItems(observablePriceList);
    //Good List
    observableGoodList.setAll(goodsList);
    goodListView.setItems(observableGoodList);
    //Quantity List
    observableQuantityList.setAll(quantityList);
    quantityListView.setItems(observableQuantityList);
    // Set the choice box
    buyChoiceBox.setItems(observableGoodList);
    cashLabel.setText("Cash: " + cash);
    observableCargoNameList.setAll(cargoNameList);
    sellChoiceBox.setItems(observableCargoNameList);
    }
    
    @FXML
    public void selection() {
        
        selected = (String)buyChoiceBox.getValue();
        System.out.println(selected);
        for(int i = 0; i < goodsList.size(); i++) {
            if(goodsList.get(i).equals(selected)) {
                // Get price and quantity of the good in index
                int quantity = quantityList.get(i);
                int price = pricesList.get(i);
                // Update the quantity List
                
                if ((cash >= price ) && (quantity > 0)) {
                    // Update the quantity, cash, and print on UI
                    quantity--;
                    quantityList.set(i, quantity);
                    observableQuantityList.setAll(quantityList);
                	quantityListView.setItems(observableQuantityList);
                    cash = cash - pricesList.get(i);
                    cashLabel.setText("Cash: " + cash);
                    player.setCash(cash);
                    // Update cargo
                    ArrayList<TradeGood> cargo = player.getShip().getCargo();
                    cargo.add(tradeGoodList.get(i));
                    player.getShip().setCargo(cargo);
                    cargoNameList = Data.getPlayer().getShip().getCargoName();
                    observableCargoNameList.setAll(cargoNameList);
                    sellChoiceBox.setItems(observableCargoNameList);
                }
            }
        }
    }
    @FXML
    private void EnterPlanetScreen(ActionEvent event) throws IOException {
      //  label.setText("Ok. Let's Create Your Character");
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void sell() {
        selected = (String)sellChoiceBox.getValue();
        System.out.println(selected);
        for(int i = 0; i < goodsList.size(); i++) {
            if(goodsList.get(i).equals(selected)) {
                // Get price and quantity of the good in index
                int quantity = quantityList.get(i);
                ++quantity;
                quantityList.set(i, quantity);                
                int price = pricesList.get(i);
                TradeGood good = tradeGoodList.get(i);
                // Update the quantity List
                observableQuantityList.setAll(quantityList);
                quantityListView.setItems(observableQuantityList);
                ArrayList<TradeGood> cargo = player.getShip().getCargo();
                // How to remove the good from the cargo
                for (int j = 0; j < cargo.size(); j++) {
                    if (good.getClass() == cargo.get(j).getClass()) {
                        // Update cargo
                        cargo.remove(j);                        
                        break;
                    }
                }
                    
                cash = cash + pricesList.get(i);
                cashLabel.setText("Cash: " + cash);
                player.setCash(cash);
                player.getShip().setCargo(cargo);
                cargoNameList = Data.getPlayer().getShip().getCargoName();
                observableCargoNameList.setAll(cargoNameList);
                sellChoiceBox.setItems(observableCargoNameList);
                
                
            }
        }
        
    }

    

        
        
    
}
