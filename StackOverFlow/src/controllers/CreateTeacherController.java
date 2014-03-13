/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javax.sql.rowset.serial.SerialBlob;
import services.TransitionService;
import utils.LanguageUtils;

/**
 *
 * @author d.michaelides
 */
public class CreateTeacherController extends StageController{
    private TransitionService service;
    private ResourceBundle labels;
    private final URL fxmlURL;
    private final ResourceBundle resources;
    
    public CreateTeacherController(URL fxml, ResourceBundle res) {
        super();
        fxmlURL = fxml;
        resources = res;
    }
    @FXML private AnchorPane root;
    @FXML private ImageView image;
    @FXML private ScrollPane theScroll;
    @FXML private VBox theV;
    @FXML private BorderPane region;
    @FXML private ProgressIndicator progress;
    @FXML private SplitPane splitPane;
    
    
    @FXML private Label mainTitle;
    @FXML private Label profileLabel;
    @FXML private Button addPictureButton;
    @FXML private Label b_info;
    @FXML private Label name;
    @FXML private Label surname;
    @FXML private TextField nameText;
    @FXML private TextField surnameText;
    @FXML private Label a_info;
    @FXML private Label address1Title;
    @FXML private Label address1StreetNum;
    @FXML private Label address1StreetName;
    @FXML private Label address1Area;
    @FXML private Label address1City;
    @FXML private Label address1Zip;
    @FXML private TextField address1StreetNumText;
    @FXML private TextField address1StreetNameText;
    @FXML private TextField address1AreaText;
    @FXML private TextField address1CityText;
    @FXML private TextField address1ZipText;
    
    @FXML private Label address2Title;
    @FXML private Label address2StreetNum;
    @FXML private Label address2StreetName;
    @FXML private Label address2Area;
    @FXML private Label address2City;
    @FXML private Label address2Zip;
    @FXML private TextField address2StreetNumText;
    @FXML private TextField address2StreetNameText;
    @FXML private TextField address2AreaText;
    @FXML private TextField address2CityText;
    @FXML private TextField address2ZipText;
    @FXML private Label c_info;
    @FXML private Label phone1;
    @FXML private Label phone2;
    @FXML private Label email;
    @FXML private TextField phone1Text;
    @FXML private TextField phone2Text;
    @FXML private TextField emailText;
    @FXML private Button confirmButton;
    @FXML private Button cancelButton;
    @FXML private Button cropButton;
    
    
    
    private Image imgFromUser;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labels = LanguageUtils.getInstance().getCurrentLanguage();
        theV.prefWidthProperty().bind(theScroll.widthProperty());
    }
    
    private void changeLocale(){
        
//        confirmButton.setText(labels.getString("new.teacher.save"));
//        cancelButton.setText(labels.getString("new.student.cancel"));
    }
    
    @FXML 
    private void addImage(Event e){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(LanguageUtils.getInstance().getCurrentLanguage().getString("selectphoto"));
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            Path path = Paths.get(file.getAbsolutePath());
            try {
                byte[] data = Files.readAllBytes(path);
                
                SerialBlob thePic = new SerialBlob(data);
//                teacher.setPicture(thePic);
                
                InputStream is = new ByteArrayInputStream(data);
                imgFromUser = new Image(is);
                image.setImage(imgFromUser);
                cropButton.setDisable(false);
   //            openFile(file);
            } catch (Exception ex) {
                ex.printStackTrace(System.err);
            }
        }
    }
    @FXML
    private void saveTeacher(Event e){
        try {
            showConfirmDialog();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        
        
//        
//        teacher.setFirstname(nametext.getText());
//        teacher.setLastname(surnametext.getText());
//        teacher.setEmail(emailtext.getText());
//        
//        DButils.saveObject(teacher);
    }
    
    @FXML
    private void showSettings(Event event) throws IOException {
    }
    
    
    
    private void showConfirmDialog() throws IOException {
    }
    @FXML
    private void cropImage(Event event) throws IOException {
    
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
 
    