/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramit5;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author peera
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    public Button Start;
    @FXML
    public Button Score;
    @FXML
    private Button Exit;

    boolean clicked = false;
    private Stage stage;

    //for checking button     
    private int a = 0;
    private String strA;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void startfunction(ActionEvent event) throws IOException {
        stage = (Stage) Start.getScene().getWindow();

        Parent root2 = FXMLLoader.load(getClass().getResource("FXMLhowtoplay.fxml"));
        Scene scene2 = new Scene(root2, 1080, 720);
        stage.setResizable(false);
        stage.setScene(scene2);

    }

    @FXML
    private void scorefunction(ActionEvent event) throws IOException {

        stage = (Stage) Start.getScene().getWindow();

        Parent root3 = FXMLLoader.load(getClass().getResource("FXMLScore.fxml"));
        Scene scene3 = new Scene(root3, 1080, 720);
        stage.setResizable(false);
        stage.setScene(scene3);

    }

    @FXML
    private void exitfunction(ActionEvent event) throws IOException {

        Stage closegamestage = (Stage) Exit.getScene().getWindow();
        closegamestage.close();

    }

}
