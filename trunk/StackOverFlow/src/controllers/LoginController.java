/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import images.Images;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import screens.FXMLs;
import services.TransitionService;
import utils.LanguageUtils;
import utils.menu.ScreenNavigator;

/**
 *
 * @author d.michaelides
 */
public class LoginController extends StageController{
    private TransitionService service;
    
    @FXML private Button cancelButton;
    @FXML private Label welcomeLabel;
    @FXML private Label usernameLabel;
    @FXML private Label passwordLabel;
    
    @FXML private ImageView language;
    private Image img;
    private ResourceBundle labels;
    private AnchorPane root;
    private Scene nextScene;
    @FXML private BorderPane region;
    @FXML private ProgressIndicator progress;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    /**
     Set the text to all visible elements of the stage
     * plus change flag
     */
    private void changeLocale(ResourceBundle labels){
        usernameLabel.setText(labels.getString("username"));
        cancelButton.setText(labels.getString("cancel"));
        welcomeLabel.setText(labels.getString("welcome"));
        passwordLabel.setText(labels.getString("password"));
        if(labels.getLocale() == Locale.ENGLISH){
            img = new Image(Images.class.getResource("UnitedKingdom.png").toString());
        }else{
            img = new Image(Images.class.getResource("Greece.png").toString());
        }
        language.setImage(img);
    }
    
    
    @FXML
    private void changeLanguage(Event event) throws IOException {
        labels = LanguageUtils.getInstance().switchLanguage();
        changeLocale(labels);
    }

    @FXML
    private void goToHomePage(Event event) throws IOException {
        ScreenNavigator.initFields(service, stage, myFXMLLoader, region, progress, null);
        ScreenNavigator.goToScreen("HomePage");
    }
}
 
    