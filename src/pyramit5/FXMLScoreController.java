/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramit5;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author peera
 */
public class FXMLScoreController implements Initializable {
    
    
    @FXML
    private Text playername;
    @FXML
    private Text playerscore;
    private Stage stage ; 
    private String name ;
    private String score ;
    @FXML
    private Button Back;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        try {
            ReadFiles();
        } catch (IOException ex) {
            Logger.getLogger(FXMLScoreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
    private void ReadFiles () throws FileNotFoundException, IOException
    {
        FileReader filename = new FileReader("Playername.txt");
        BufferedReader br1 = new BufferedReader (filename);
        name =  br1.readLine();
        br1.close();
        
        FileReader filescore = new FileReader("score.txt");
        BufferedReader br2 = new BufferedReader (filescore);
        score =  br2.readLine();
        br2.close();
        
        playername.setText(name);
        playerscore.setText(score);
                
        
    }

    @FXML
    private void goBack(ActionEvent event)throws IOException {
        
               stage = (Stage) Back.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));                
        Scene scene1 = new Scene(root1,1080,720);         
        stage.setResizable(false);
        stage.setScene(scene1);
    }
    
}
