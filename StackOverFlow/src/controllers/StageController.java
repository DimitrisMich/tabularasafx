/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import services.TransitionService;

/**
 *
 * @author d.michaelides
 */
public class StageController implements Initializable {
    protected Stage stage;
    protected FXMLLoader myFXMLLoader;
    
    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void setFXMLLoader(FXMLLoader loader){
        this.myFXMLLoader = loader;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
