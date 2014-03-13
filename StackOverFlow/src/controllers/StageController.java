/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.TransitionService;
import utils.menu.MyClassLoader;

/**
 *
 * @author d.michaelides
 */
public abstract class StageController implements Initializable {
    protected Stage stage;
    protected FXMLLoader myFXMLLoader;
    public static ClassLoader cachingClassLoader = new MyClassLoader(FXMLLoader.getDefaultClassLoader()); 
    
    private Scene scene;
    private Parent root;
    private ScrollPane scroll;
    
    
    public Parent getRoot() {
        if (root == null) {
            makeRoot();
//            toolStylesheetDidChange(null);
        }
        return root;
    }
    public ScrollPane getScroll() {
        if (scroll == null) {
            makeScroll();
//            toolStylesheetDidChange(null);
        }
        return scroll;
    }
    public void makeScroll(){
        if (root == null) {
            makeRoot();
        }
        scroll = (ScrollPane)root.getChildrenUnmodifiable().get(0);
    }
    
    
    public Scene getScene() {
        assert Platform.isFxApplicationThread();
        
        if (scene == null) {
            System.out.println(" get Scene() ");
            scene = new Scene(getRoot());
//            controllerDidCreateScene();
        }
        
        return scene;
    }
    /**
     * to be implemented by sub-classes
     */
    protected abstract void makeRoot();
    
    /**
     * to be implemented by sub-classes
     */
    protected void controllerDidCreateScene() {
    }
    
    
    
    protected  final void setRoot(Parent root) {
        assert root != null;
        this.root = root;
    }
    
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
