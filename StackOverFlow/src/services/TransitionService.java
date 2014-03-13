/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import screens.FXMLs;
import controllers.StageController;
import java.util.Calendar;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.LanguageUtils;
import utils.menu.MyClassLoader;


/**
 *
 * @author d.michaelides
 */
public class TransitionService extends Service<SceneComponents> {
    private String sceneName;
    private SplitPane splitPane;
    private FXMLLoader myLoader;
    private Stage stage;
    public static ClassLoader cachingClassLoader = new MyClassLoader(FXMLLoader.getDefaultClassLoader()); 
    
    public TransitionService (String sceneName, SplitPane splitPane, FXMLLoader myLoader, Stage stage){
        this.sceneName = sceneName;
        this.splitPane = splitPane;
        this.myLoader = myLoader;
        this.stage = stage;
    }
    
    @Override
    protected Task createTask() {
        return new GetObjectTask();
    }
        
        private class GetObjectTask extends Task<SceneComponents> {
            @Override
            protected SceneComponents call() throws Exception {
            try{
                double x = stage.getWidth() - (stage.getWidth() - stage.getScene().getWidth());
                double y = stage.getHeight() - (stage.getHeight() - stage.getScene().getHeight());
                FXMLLoader myFXLoader = new FXMLLoader(FXMLs.class.getResource(sceneName+".fxml"), LanguageUtils.getInstance().getCurrentLanguage()); 
                myFXLoader.setClassLoader(cachingClassLoader); 
                AnchorPane root = (AnchorPane)myFXLoader.load();
                
                StageController controler = ((StageController) myFXLoader.getController());
                controler.setStage(stage);
                controler.setFXMLLoader(myLoader);
                
                if(splitPane!= null){
                    double divPosition = splitPane.getDividerPositions()[0];
                    ((SplitPane)myFXLoader.getNamespace().get("splitPane")).setDividerPosition(0, divPosition);
                }
                return new SceneComponents(root, x, y);
                
            }catch(Exception e){
                e.printStackTrace();
                return null;
                        
            }
            }
        }
        
    }
    

