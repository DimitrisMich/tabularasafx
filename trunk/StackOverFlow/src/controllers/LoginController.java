/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import images.Images;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import screens.FXMLs;
import utils.LanguageUtils;
import utils.menu.ScreenNavigator;

/**
 *
 * @author d.michaelides
 */
public class LoginController{
    
    @FXML private Button cancelButton;
    @FXML private Label welcomeLabel;
    @FXML private Label usernameLabel;
    @FXML private Label passwordLabel;
    
    @FXML private ImageView language;
    private Image img;
    private ResourceBundle labels;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
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
        Node  source = (Node)  event.getSource(); 
        ScreenNavigator.getInstance((Stage) source.getScene().getWindow()).goToScreen("HomePage");
    }
    
    public void initializeAll(Stage stage){
        labels = LanguageUtils.getInstance().getCurrentLanguage();
        System.out.println(" initialize All screens");
        
        ScreenNavigator.getInstance(stage).controllers.put("HomePage",      new HomePageController(     FXMLs.class.getResource("HomePage.fxml"),      labels));
        ScreenNavigator.controllers.put("CreateClass",   new CreateClassController(  FXMLs.class.getResource("CreateClass.fxml"),   labels));
        ScreenNavigator.controllers.put("CreateStudent", new CreateStudentController(FXMLs.class.getResource("CreateStudent.fxml"), labels));
        ScreenNavigator.controllers.put("CreateTeacher", new CreateTeacherController(FXMLs.class.getResource("CreateTeacher.fxml"), labels));
        ScreenNavigator.controllers.put("Home", new HomeController(FXMLs.class.getResource("Home.fxml"), labels));
    
    }
}
 
    