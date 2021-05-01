/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramit5;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author peera
 */
public class FXMLhowtoplayController implements Initializable {

    @FXML
    private Button Next;
    @FXML
    private HBox HowtoplayImage;
    @FXML
    private Button Back;
    private Stage stage ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
   

        HowtoplayImage.setStyle("-fx-background-image: url('bgImage/bg1.png');" +
        "-fx-background-repeat: stretch;" +
        "-fx-background-size: 500 500;" +
        "-fx-background-position: center center;");
        
        
       
        // TODO
    }    

    @FXML
    private void gonextfunction(ActionEvent event) throws IOException {
        stage = (Stage) Next.getScene().getWindow();
        Parent root2 = FXMLLoader.load(getClass().getResource("FXMLUser.fxml"));                
        Scene scene2 = new Scene(root2,1080,720);         
        stage.setResizable(false);
        stage.setScene(scene2);
        
    }

    @FXML
    private void gobackfunction(ActionEvent event) throws IOException 
    {
        stage = (Stage) Back.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));                
        Scene scene1 = new Scene(root1,1080,720);         
        stage.setResizable(false);
        stage.setScene(scene1);
    
    }
    
}
