
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
import javafx.stage.Stage;
import space.trader.gameplay.Save;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void EnterCreationScreen(ActionEvent event) throws IOException {
      //  label.setText("Ok. Let's Create Your Character");
        
        Node node=(Node) event.getSource();
        Stage stage=(Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("CharacterScreen.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     * Create a new Save object and use that to load a previously saved game.
     * Prints an error message to the console if no saved game file is found.
     */
    @FXML
    private void loadGame(ActionEvent event) throws IOException{
        File f = new File("save.txt");
        if (!f.exists()) {
            System.out.println("No saved game found. Please start a new game.");
        } else {
            Save s = new Save();
            s.loadTextFile();
            Node node=(Node) event.getSource();
            Stage stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("UniverseScreen.fxml"));/* Exception */
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
