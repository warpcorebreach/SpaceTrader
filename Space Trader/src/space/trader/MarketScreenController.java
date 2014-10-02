/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import space.trader.items.TradeGood;
import java.util.ArrayList;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

/**
 * FXML Controller class
 *
 * @author Weiyu
 */
public class MarketScreenController implements Initializable {

    @FXML
    public ArrayList<String> goods = Data.getMarket().getGoods();
    
    @FXML
    private ArrayList<Integer> prices = Data.getMarket().getPrices();
    @FXML
    private ArrayList<Integer> q = Data.getMarket().getQuantity();
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      //  for(int i = 0; i < goods.size)
    observableList.setAll(prices);
    listView.setItems(observableList);
        observableList2.setAll(goods);
    listView2.setItems(observableList2);
            observableList3.setAll(q);
    listView3.setItems(observableList3);
 /*       listView.setCellFactory(new Callback<ListView<Integer>, javafx.scene.control.ListCell<Inetger>>() {
        @Override
        public ListCell<Intger> call(ListView<Inetger> listView) {
            return new ListViewCell();
        }
    }); */
    }

        
        
    
}
