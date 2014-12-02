
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
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;
import space.trader.gameplay.Save;

/**
 * Controller class for the initial game screen.
 * @author Justin
 */
public class FXMLDocumentController implements Initializable {

    private MediaPlayer mediaPlayer;
    /**
     * Loads and displays the character creation screen.
     * @param event an ActionEvent which triggers this method
     * @throws IOException throws an exception if FXMLLoader cannot find the
     * given FXML file
     */
    @FXML
    private void enterCreationScreen(final ActionEvent event)
        throws IOException {
        
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass()
                .getResource("CharacterScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        mediaPlayer.stop();
        stage.show();
    }

    @Override
    public void initialize(final URL url, final ResourceBundle rb) {
        // TODO
            mediaPlayer = new MediaPlayer(new Media(new File("src/space/trader/music/a.mp3").toURI().toString()));
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
    }

    /**
     * Create a new Save object and use that to load a previously saved game.
     * Prints an error message to the console if no saved game file is found.
     *
     * @param event an ActionEvent which triggers this method
     * @throws IOException throws an exception if FXMLLoader cannot find the
     * given FXML file to load
     */
    @FXML
    private void loadGame(final ActionEvent event) throws IOException {
        File f = new File("save.txt");
        if (!f.exists()) {
            System.out.println("No saved game found. Please start a new game.");
        } else {
            mediaPlayer.stop();
            Save s = new Save();
            s.loadTextFile();
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass()
                    .getResource("UniverseScreen.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
