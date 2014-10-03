/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import java.awt.event.ActionListener;
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
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import space.trader.items.TradeGood;

/**
 * FXML Controller class
 *
 * @author Weiyu
 */
public class MarketScreenController implements Initializable {

    @FXML
    public ArrayList<String> goodsList = Data.getMarket().getGoods();
    
    @FXML
    private ArrayList<Integer> pricesList = Data.getMarket().getPrices();
    @FXML
    private ArrayList<Integer> quantityList = Data.getMarket().getQuantity();
    @FXML
    private TableView<TradeGood> tableGoods = new TableView<TradeGood>();
    @FXML
    private ListView listView;
    @FXML
    private ListView listView2;
    @FXML
    private ListView listView3;      
    ObservableList observableList = FXCollections.observableArrayList();
    ObservableList observableList2 = FXCollections.observableArrayList();
    ObservableList observableList3 = FXCollections.observableArrayList();
    @FXML
    ChoiceBox cb;
    @FXML
    ChoiceBox cb2; //use this for sale
    @FXML
    public String selected;
    private Player p = Data.getPlayer();
    @FXML
    public int cash = p.getCash();
    @FXML
    private Label label1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  for(int i = 0; i < goods.size)
    observableList.setAll(pricesList);
    listView.setItems(observableList);
        observableList2.setAll(goodsList);
    listView2.setItems(observableList2);
            observableList3.setAll(quantityList);
    listView3.setItems(observableList3);
    cb.setItems(observableList2);
    label1.setText("Cash: " + cash);
    }
    
    @FXML
    public void selection() {
        
        selected = (String)cb.getValue();
        System.out.println(selected);
        for(int i = 0; i < goodsList.size(); i++) {
            if(goodsList.get(i).equals(selected)) {
                // Get price and quantity of the good in index
                int quantity = quantityList.get(i);
                int price = pricesList.get(i);
                observableList3.setAll(quantityList);
                listView3.setItems(observableList3);
                if ((cash >= price ) && (quantity > 0)) {
                    quantityList.set(i, --quantity);
                    
                    cash = cash - pricesList.get(i);
                    label1.setText("Cash: " + cash);
                    p.setCash(cash);
                }
            }
        }
    }
    @FXML
    public void sell() {
        
    }

    

        
        
    
}
