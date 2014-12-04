
package space.trader.ui;

import java.io.File;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import space.trader.gameplay.Data;
import space.trader.gameplay.Player;
import space.trader.location.Universe;

/**.
 * FXML Controller class
 *
 * @author Weiyu
 */
public class CharacterScreenController implements Initializable {
    /**.
     * Label 1
     */
    @FXML
    private Label label1;
    /**.
     * Label 2
     */
    @FXML
    private Label label2;
    /**.
     * Label 3
     */
    @FXML
    private Label label3;
    /**.
     * Label 4
     */
    @FXML
    private Label label4;
    /**.
     * Label 5
     */
    @FXML
    private Label label5;
    /**.
     * Label 6
     */
    @FXML
    private Label label6;
    /**.
     * Label name
     */
    @FXML
    private Label name;
    /**.
     * User text field
     */
    @FXML
    private TextField user;
    /**.
     * Add field number 0
     */
    @FXML
    public int add = 0;
    /**.
     * Add field number 1
     */
    @FXML
    public int add1 = 0;
    /**.
     * Add field number 2
     */
    @FXML
    public int add2 = 0;
    /**.
     * Add field number 3
     */
    @FXML
    public int add3 = 0;
    /**.
     * Add field number 4
     */
    @FXML
    public int add4 = 0;
    /**.
     * Progression bar
     */
    @FXML
    private ProgressBar bar;
    /**.
     * The player
     */
    private Player p;
    MediaPlayer mediaPlayer;
 /*   Stage prevStage;
    
    public void setPrevStage(Stage stage){
         this.prevStage = stage;
    }*/
    /**.
     * Method to add points to pilot field
     * @param event The action event of adding
     */
    @FXML
    private void pilotAdd(ActionEvent event) {
        if ((add + add1 + add2 + add3 + add4) < 15) {
            add++;
            label1.setText(String.valueOf(add));
            bar.setProgress((add + add1 + add2 + add3 + add4) / (double) 15);
        }
    }
    /**.
     * Method to add points to Fighter field
     * @param event The action event of adding
     */
    @FXML
    private void fighterAdd(ActionEvent event) {
        if ((add + add1 + add2 + add3 + add4) < 15) {
            add1++;
            label2.setText(String.valueOf(add1));
            bar.setProgress((add + add1 + add2 + add3 + add4) / (double) 15);
        }
    }
    /**.
     * Method to add points to Trader field
     * @param event The action event of adding
     */
    @FXML
    private void traderAdd(ActionEvent event) {
        if ((add + add1 + add2 + add3 + add4) < 15) {
            add2++;
            label3.setText(String.valueOf(add2));
            bar.setProgress((add + add1 + add2 + add3 + add4) / (double) 15);
        }
    }
    /**.
     * Method to add points to engineer field
     * @param event The action event of adding
     */
    @FXML
    private void engineerAdd(ActionEvent event) {
        if ((add + add1 + add2 + add3 + add4) < 15) {
            add3++;
            label4.setText(String.valueOf(add3));
            bar.setProgress((add + add1 + add2 + add3 + add4) / (double) 15);
        }
    }
    /**.
     * Method to add points to investor field
     * @param event The action event of adding
     */
    @FXML
    private void investorAdd(ActionEvent event) {
        if ((add + add1 + add2 + add3 + add4) < 15) {
            add4++;
            label5.setText(String.valueOf(add4));
            bar.setProgress((add + add1 + add2 + add3 + add4) / (double) 15);
        }
    }
    /**.
     * Method to be called when clicking done button
     * @param event the clicking event
     * @throws IOException an exception
     */
    @FXML
    private void done(ActionEvent event) throws IOException {
        if (user.getText() != null && !user.getText().isEmpty()) {
            if ((add + add1 + add2 + add3 + add4) < 15) {
                label6.setText("Please allocate all character points.");
            } else {
                // create the game universe
                Universe u = new Universe();
                Data.setUniverse(u);
                
                name.setText(user.getText());
                user.clear();
                user.setVisible(false);
                label6.setText("Character Created");
                p = new Player(name.getText(), add, add1, add2, add3, add4);
                Data.setPlayer(p);
                
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("Animation.fxml"));
                // Exception 
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            
        } else {
            label6.setText("Please Enter a Name");
        }
    }
    /**. 
     * Method to return to the main menu
     * @param event the clicking event
     * @throws IOException An exception
     */
    @FXML
    private void returnToMainMenu(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        // Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        // Exception
        Scene scene = new Scene(root);
    
        stage.setScene(scene);
        mediaPlayer.stop();
        stage.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            mediaPlayer = new MediaPlayer(new Media(new File("src/space/trader/music/b.mp3").toURI().toString()));
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
        // TODO
    }       
}