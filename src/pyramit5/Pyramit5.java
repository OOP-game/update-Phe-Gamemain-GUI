/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramit5;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author peera
 */
public class Pyramit5 extends Application {

    private Stage window;
    private String Playername ;
    private String score ; 
    
    
    @Override
      
    public void start(Stage stage) throws Exception 
    {
       
        Parent root1 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));    
        
        Scene scene1 = new Scene(root1,1080,720);      
        stage.setResizable(false);
        stage.setScene(scene1);
        stage.setTitle("Pyramid Card Game");
        stage.show();
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}