/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author d.michaelides
 */
public class HomeController extends StageController{
    private final URL fxmlURL;
    private final ResourceBundle resources;
    private ResourceBundle labels;
    
    @FXML private AnchorPane root;
    
    public HomeController(URL fxml, ResourceBundle res) {
        super();
        fxmlURL = fxml;
        resources = res;
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    /**
     Set the text to all visible elements of the stage
     * plus change flag
     */
    private void changeLocale(){
    }
    
    
    @FXML
    private void changeLanguage(Event event) throws IOException {
    }
    
    
    @FXML
    private void showSettings(Event event) throws IOException {
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
            System.out.println("loader.getResources()=" + loader.getResources());
            throw new RuntimeException("Failed to load " + fxmlURL.getFile(), x); //NOI18N
        }
    }
}
 
    