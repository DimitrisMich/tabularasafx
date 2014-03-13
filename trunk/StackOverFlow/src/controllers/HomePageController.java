/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import utils.menu.ScreenNavigator;
import utils.menu.TreeMenuBuilder;

/**
 *
 * @author d.michaelides
 */
public class HomePageController extends StageController{
    private final URL fxmlURL;
    private final ResourceBundle resources;
    
    public HomePageController(URL fxml, ResourceBundle res) {
        fxmlURL = fxml;
        resources = res;
    }
    @FXML private TreeView treeMenu;
    @FXML private AnchorPane rightPane;
    
            
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        TreeMenuBuilder.buildTheMenu();
        treeMenu.setRoot(TreeMenuBuilder.getTheMenuRoot());
        setHandlers(treeMenu);
    }
    
    @FXML
    private void changeLanguage(Event event) throws IOException {
    }
    
    @FXML
    private void closeWindow(Event event) throws IOException {
        stage.close();
    }
    public void goToScreen(String screenName) throws IOException{
        System.out.println("home -> "+ screenName);
        rightPane.getChildren().clear();
        rightPane.getChildren().add(ScreenNavigator.getInstance(null).controllers.get(screenName).getScroll());
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
        } catch (RuntimeException | IOException x) {
            System.out.println("loader.getController()=" + loader.getController());
            System.out.println("loader.getLocation()=" + loader.getLocation());
            throw new RuntimeException("Failed to load " + fxmlURL.getFile(), x); //NOI18N
        }
    }
    
    private void setHandlers(final TreeView treeMenu){
        treeMenu.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent)
            { 
                try{
                if(mouseEvent.getButton() == MouseButton.PRIMARY){
                    if(mouseEvent.getClickCount() == 1) {
                        TreeItem<String> item = (TreeItem<String>) treeMenu.getSelectionModel().getSelectedItem();
                        if(item != null){
                            if(item.getValue().equals("Create")){
                                switch(item.getParent().getValue()){
                                    case "Classes"  :
                                        goToScreen("CreateClass");
                                    break;
                                    case "Students"  :
                                        goToScreen("CreateStudent");
                                    break;
                                    case "Teachers"  :
                                        goToScreen("CreateTeacher");
                                    break;
                                    default:break;
                                }
                            }
                            else if(item.getValue().equals("Home")){
                                try {
                                    ScreenNavigator.getInstance(null).goToScreen("Home");
                                } catch (IOException ex) {
                                    Logger.getLogger(HomePageController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }else{
                    }
                }
                }catch(Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
        
    }
}
    