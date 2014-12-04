package space.trader.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Label;
import space.trader.gameplay.Data;
import javafx.event.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author trananhduc1004
 */
public class AnimationController implements Initializable {
    @FXML
    Label topScreenLabel = new Label();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String playerName = Data.getPlayer().getName();
        topScreenLabel.setText("Welcome to the mighty Universe, " + playerName);
    }
    @FXML
    private void startAnimation(ActionEvent event) throws IOException, InterruptedException {
        // Initialize item.
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Group root = new Group();        
        Scene scene = new Scene(root, 640, 400);
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        // translate root node to center of the screen
        root.setTranslateX(320);
        root.setTranslateY(200);
        Timeline rotation = createScene(root);
        rotation.playFromStart();    
        rotation.setOnFinished(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    Parent newRoot = FXMLLoader.load(getClass().getResource("UniverseScreen.fxml"));
                    Scene newScene = new Scene(newRoot);
                    stage.setScene(newScene);
                    stage.show();  
                }
                catch (Exception e)  {
                    System.err.println(e.getMessage());
                }
                // Exception 
                
            }
        });
        
        

}
     
   
    private Timeline createScene(Group root) {
        Group branch = new Group();
        root.getChildren().add(branch);

        // Create a big blue plane
        Circle planet = new Circle(65);
        planet.setFill(Color.BLUE);
        branch.getChildren().add(planet);
        // Create a red satellite
        Circle satellite = new Circle(10);
        satellite.setFill(Color.RED);
        branch.getChildren().add(satellite);
        satellite.setTranslateY(-150);

        // rotate the branch
        Timeline rotation = new Timeline();
        rotation.setCycleCount(2);
        rotation.setRate(1);
        rotation.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(
                        branch.rotateProperty(), 0)),
                new KeyFrame(Duration.seconds(5), new KeyValue(branch
                        .rotateProperty(), 360)));
        return rotation;
    }
}
