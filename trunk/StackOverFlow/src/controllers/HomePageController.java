/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import services.TransitionService;
import utils.menu.ScreenNavigator;
import utils.menu.TreeMenuBuilder;

/**
 *
 * @author d.michaelides
 */
public class HomePageController extends StageController{
    private TransitionService service;
    @FXML private BorderPane region;
    @FXML private ProgressIndicator progress;
    @FXML private SplitPane splitPane;
    @FXML private TreeView treeMenu;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TreeMenuBuilder.buildTheMenu();
        treeMenu.setRoot(TreeMenuBuilder.getTheMenuRoot());
        TreeMenuBuilder.setHandlers(treeMenu);        
        setMenuFilter();
    }
    
    
    private void setMenuFilter(){
        treeMenu.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                ScreenNavigator.initFields(service, stage, myFXMLLoader, region, progress, splitPane);
            }
        });
    }
    
    
    @FXML
    private void changeLanguage(Event event) throws IOException {
    }
    @FXML
    private void closeWindow(Event event) throws IOException {
        stage.close();
    }
}
    