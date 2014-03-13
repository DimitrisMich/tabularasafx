/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import utils.LanguageUtils;

/**
 *
 * @author d.michaelides
 */
public class CreateClassController extends StageController{
    private final URL fxmlURL;
    private final ResourceBundle resources;
    
    public CreateClassController(URL fxml, ResourceBundle res) {
        super();
        fxmlURL = fxml;
        resources = res;
    }
    
    @FXML private ImageView language;
    @FXML private Button saveButton;
    @FXML private Button cancelButton;
    @FXML private Button clearTeacher;
    private Image img;
    private ResourceBundle labels;
    @FXML private AnchorPane root;
    private Scene nextScene;
    @FXML private VBox theV;
    @FXML private ScrollPane theScroll;
    @FXML private VBox theV2;
    @FXML private ScrollPane theScroll2;
    @FXML private BorderPane region;
    @FXML private ProgressIndicator progress;
    @FXML private SplitPane splitPane;
    
    @FXML private GridPane timeTable;
    
    @FXML private Label pageTitle;
    @FXML private Label b_info;
    @FXML private Label name;
    @FXML private Label description;
    @FXML private TextField nameText;
    @FXML private TextArea descriptionText;
    
    @FXML private Label teacherTitle;
    @FXML private Label teacherSelect;
    @FXML private Label timeTableTitle;
    @FXML private Label timesPW;
    @FXML private Label dayTitle;
    @FXML private Label hourTitle;
    @FXML private Label durationTitle;
    @FXML private Label selectedTeacher;
    @FXML private Label selectedTeacherName;
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        labels = LanguageUtils.getInstance().getCurrentLanguage();
        theV.prefWidthProperty().bind(theScroll.widthProperty());
    }
    private void changeLocale(){
    }
    
    
    @FXML
    private void changeLanguage(Event event) throws IOException {
    }
    
    
    @FXML
    private void showSettings(Event event) throws IOException {
    }
    
    @FXML
    private void addTeacher(Event event) throws IOException {
    }
    @FXML
    private void clearTeacher(Event event) throws IOException {
    }
    
    

    @Override
    protected void makeRoot() {
        final FXMLLoader loader = new FXMLLoader();
        
        loader.setClassLoader(cachingClassLoader); 
        loader.setController(this);
        loader.setLocation(fxmlURL);
        loader.setResources(resources);
        try {
            setRoot((Parent)loader.load());
//            controllerDidLoadFxml();
        } catch (RuntimeException | IOException x) {
            System.out.println("loader.getController()=" + loader.getController());
            System.out.println("loader.getLocation()=" + loader.getLocation());
            throw new RuntimeException("Failed to load " + fxmlURL.getFile(), x); //NOI18N
        }
    }
    
    
    
}
 
    