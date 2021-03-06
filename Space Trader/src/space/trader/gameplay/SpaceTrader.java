/*
 * CS2340
 * Team StarFox(19)
 * Members: Weiyu Li, Duc Tran, Justin Coates, JD Arthur, Qifeng Li
 * For our project, we will be reimplement the game Space Trader. 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader.gameplay;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**.
 * Representing the game space trader
 * @author trananhduc1004
 */
public class SpaceTrader extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/space/trader/ui/FXMLDocument.fxml"));
  
        Scene scene = new Scene(root);    
        stage.setScene(scene);
        stage.show();
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } 
    
}