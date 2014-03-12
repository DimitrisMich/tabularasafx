/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controllers.StageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import screens.FXMLs;
import utils.LanguageUtils;

/**
 *
 * @author d.michaelides
 */
public class TabulaRasaFX extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Tabula Rasa");
        
        

        // 2. Create FXML loader
        FXMLLoader myLoader = new FXMLLoader(FXMLs.class.getResource("Login.fxml"), LanguageUtils.getInstance().getCurrentLanguage());
        // 3. Load the screen
        AnchorPane login = (AnchorPane)myLoader.load();
        // 4. get Controller to set the stage in it

        StageController controler = ((StageController) myLoader.getController());
        controler.setStage(stage);
        controler.setFXMLLoader(myLoader);
        Scene myScene = new Scene(login);
        stage.setScene(myScene);
        stage.show();
        stage.toFront();
       
    }

    public static void main(String[] args) {
        launch(args);
    }
}