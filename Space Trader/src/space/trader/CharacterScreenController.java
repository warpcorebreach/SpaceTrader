/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Weiyu
 */
public class CharacterScreenController implements Initializable {
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label name;
    @FXML
    private TextField user;
    @FXML
    public int add = 0;
    @FXML
    public int add1 = 0;
    @FXML
    public int add2 = 0;
    @FXML
    public int add3 = 0;
    @FXML
    public int add4 = 0;
    @FXML
    private ProgressBar bar;
    
    public Player p;
    
    Stage prevStage;
    /**
     * return to main menu
     * @param stage previous stage
     */
    public void setPrevStage(Stage stage){
         this.prevStage = stage;
    }
    /**
     * Add stat to Pilot skill point
     * @param event when add button is clicked
     */
    @FXML
    private void PilotAdd(ActionEvent event) {
        if((add+add1+add2+add3+add4)<15) {
        add++;
        label1.setText(String.valueOf(add));
        bar.setProgress((add+add1+add2+add3+add4)/(double)15);
        }
    }
    /**
     * Add stat to Figher skill point
     * @param event when add button is clicked
     */
    @FXML
    private void FighterAdd(ActionEvent event) {
        if((add+add1+add2+add3+add4)<15) {
        add1++;
        label2.setText(String.valueOf(add1));
         bar.setProgress((add+add1+add2+add3+add4)/(double)15);
        }
    }
    /**
     * Add stat to Trader skill point
     * @param event when add button is clicked
     */
    @FXML
    private void TraderAdd(ActionEvent event) {
        if((add+add1+add2+add3+add4)<15) {
        add2++;
        label3.setText(String.valueOf(add2));
         bar.setProgress((add+add1+add2+add3+add4)/(double)15);
        }
    }
    /**
     * Add stat to Engineer skill point
     * @param event when add button is clicked
     */
    @FXML
    private void EngineerAdd(ActionEvent event) {
        if((add+add1+add2+add3+add4)<15) {
        add3++;
        label4.setText(String.valueOf(add3));
         bar.setProgress((add+add1+add2+add3+add4)/(double)15);
        }
    }
    /**
     * Add stat to Investor skill point
     * @param event when add button is clicked
     */
    @FXML
    private void InvestorAdd(ActionEvent event) {
        if((add+add1+add2+add3+add4)<15) {
        add4++;
        label5.setText(String.valueOf(add4));
         bar.setProgress((add+add1+add2+add3+add4)/(double)15);
        }
    }
    /**
     * check if stat and name are set and then save it in Player class
     * @param event when done button is clicked
     */
    @FXML
    private void Done(ActionEvent event) throws IOException {
        if(user.getText() != null && !user.getText().isEmpty()) {
            if((add+add1+add2+add3+add4) < 15) {
                label6.setText("Please allocate all character points.");
            } else {
                // create the game universe
                Universe u = new Universe();
                Data.setUniverse(u);
                
                name.setText(user.getText());
                user.clear();
                user.setVisible(false);
                label6.setText("Character Created");
                p = new Player(name.getText(),add,add1,add2,add3,add4);
                Data.setPlayer(p);
                System.out.println(p.getName() + p.getFighter() + p.getEngineer() + p.getInvestor() + p.getTrader() + p.getPilot());

                Node node=(Node) event.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("UniverseScreen.fxml"));/* Exception */
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            
        } else {
            label6.setText("Please Enter a Name");
        }
    }
    /**
     * return back to main menu
     * @param event back button is clicked
     */
    @FXML
    private void ReturnToMainMenu(ActionEvent event) throws IOException{
         Node node=(Node) event.getSource();
         Stage stage=(Stage) node.getScene().getWindow();
      //  Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));/* Exception */
        Scene scene = new Scene(root);
    
        stage.setScene(scene);
        
        stage.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
