/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package space.trader;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

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
    
        @FXML
    private void PilotAdd(ActionEvent event) {
        if((add+add1+add2+add3+add4)<15) {
        add++;
        label1.setText(String.valueOf(add));
        bar.setProgress((add+add1+add2+add3+add4)/(double)15);
        }
    }
    @FXML
    private void FighterAdd(ActionEvent event) {
        if((add+add1+add2+add3+add4)<15) {
        add1++;
        label2.setText(String.valueOf(add1));
         bar.setProgress((add+add1+add2+add3+add4)/(double)15);
        }
    }
    @FXML
    private void TraderAdd(ActionEvent event) {
        if((add+add1+add2+add3+add4)<15) {
        add2++;
        label3.setText(String.valueOf(add2));
         bar.setProgress((add+add1+add2+add3+add4)/(double)15);
        }
    }
    @FXML
    private void EngineerAdd(ActionEvent event) {
        if((add+add1+add2+add3+add4)<15) {
        add3++;
        label4.setText(String.valueOf(add3));
         bar.setProgress((add+add1+add2+add3+add4)/(double)15);
        }
    }
    @FXML
    private void InvestorAdd(ActionEvent event) {
        if((add+add1+add2+add3+add4)<15) {
        add4++;
        label5.setText(String.valueOf(add4));
         bar.setProgress((add+add1+add2+add3+add4)/(double)15);
        }
    }

    @FXML
    private void Done(ActionEvent event) {
        if(user.getText() != null && !user.getText().isEmpty()) {
            name.setText(user.getText());
            user.clear();
            user.setVisible(false);
            label6.setText("Character Created");
        } else {
            label6.setText("Please Enter a Name");
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
