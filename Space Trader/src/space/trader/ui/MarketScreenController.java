
package space.trader.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import space.trader.location.Market;
import space.trader.resources.TradeGoods.TradeGood;

/** MarketScreen Controller class.
 * Control UI of Market
 * @author Weiyu
 */
public class MarketScreenController implements Initializable {
    private Market market;
    private Player player;
    private int cash;
    private List<TradeGood> tradeGoodList;
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
    private ObservableList<TradeGood> data
            = FXCollections.observableArrayList();
    @FXML
    private ObservableList<String> cargoData
            = FXCollections.observableArrayList();
    @FXML
    private ListView<String> cargoDisplay = new ListView<>();
    @FXML
    private TextArea mnn = new TextArea();

    /**
     * Initializes the controller class.
     * @param  url URL input for the initialize
     * @param rb resourceBundle for initialize
     */
    @Override
    public void initialize(final URL url , final ResourceBundle rb) {
        player = Data.getPlayer();
        market = Data.getMarket();
        tradeGoodList = market.getGoods();
        cash = player.getCash();
        ship = player.getShip();
        cashLabel.setText("Cash: " + cash);
        cargoLabel.setText("Ship's Cargo (" + ship.getCargoSize()
                + "/" + ship.getMaxCargoSize());
        cargo = new ArrayList<>();
        mnn.setText("Welcome to our market, friend!\nWe have the best prices "
                + "in the Galaxy - we made sure of that.");

        goodCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        priceCol.setCellValueFactory(
                new PropertyValueFactory<>("price"));
        quantCol.setCellValueFactory(
                new PropertyValueFactory<>("quant"));

        data.addAll(tradeGoodList);
        table.setItems(data);

        if (!ship.getCargo().isEmpty()) {
            updateCargoScreen();
        }
    }

    /**selects from table.
     * Stores the currently selected good
     */
    @FXML
    private void selection() {
        selected = (TradeGood) table.getSelectionModel().getSelectedItem();
    }

    /** add to Ship's cargo.
     * Purchase the selected good from the market
     * Prints the ships cargo after the purchase to the console
     * Possible errors: Market is out of the item
     *                  Player's cargo is full
     *                  Player does not have enough money
     */
    @FXML
    private void purchase() {
        if (selected == null) {
            return;
        }
        if (cash - selected.getPrice() < 0) {
            // out of money error message
            mnn.setText("You can't afford that, trader.");
        } else if (selected.getQuantity() == 0) {
            // none available error message
            mnn.setText("Our pirates, er, friendly traders are out acquiring "
                    + "more.");
        } else {
            boolean buy = ship.addCargo(selected);
            if (!buy) {
                // cargo full error message
                mnn.setText("You'll need more cargo space to store that.");
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
        if (selected == null) {
            return;
        }
        int temp = ship.removeCargo(selected);
        if (temp == 0) {
            mnn.setText("You're cargo is empty...");
        } else if (temp == -1) {
            mnn.setText("You don't have any " + selected.getName()
                    + " to sell.\n"
                    + "Watch yourself, trader.");
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

        cargoLabel.setText("Ship's Cargo " + "(" + ship.getCargoSize()
                + "/" + ship.getMaxCargoSize() + ")");
        cargo.clear();
        cargoData.clear();
        Map<String, Integer> c = ship.getCargo();
        for (Map.Entry e : c.entrySet()) {
            cargo.add(e.getKey() + " (" + e.getValue() + ")");
        }
        cargoData.addAll(cargo);
        cargoDisplay.setItems(cargoData);
    }

    /** Change Screen.
     * Return to Planet screen
     * @param event the action click by user
     * @throws IOException from user
     */
    @FXML
    private void enterPlanetScreen(final ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("PlanetScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
