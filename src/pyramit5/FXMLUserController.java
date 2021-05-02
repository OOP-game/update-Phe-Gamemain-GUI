/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pyramit5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author peera
 */
public class FXMLUserController implements Initializable {

    @FXML
    private TextField Namefilled;
    @FXML
    private Text Text;
    @FXML
    private Button Next;
    private Stage stage;

    private String name;
    private int counter = 1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void getnamefunction(ActionEvent event) {

    }

    public String getName() {
        return name;
    }

    @FXML
    private void nextfunction(ActionEvent event) throws IOException {

        System.out.println("Clicked");

        stage = (Stage) Next.getScene().getWindow();
        Parent root1 = FXMLLoader.load(getClass().getResource("FXMLGame.fxml"));
        Scene scene1 = new Scene(root1, 1080, 720);
        stage.setResizable(false);
        stage.setScene(scene1);
        
        FileWriter file = new FileWriter("Playername.txt");
        BufferedWriter bw = new BufferedWriter(file);
        name = Namefilled.getText();
        bw.write(name);
        bw.close();
    }

    private void toString(int counter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
