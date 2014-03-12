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


/**
 *
 * @author d.michaelides
 */
public class TransitionService extends Service<SceneComponents> {
    private String sceneName;
    private SplitPane splitPane;
    private FXMLLoader myLoader;
    private Stage stage;
    
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
            System.out.println("call() 0  : "+ Calendar.getInstance().getTimeInMillis());
                double x = stage.getWidth() - (stage.getWidth() - stage.getScene().getWidth());
                double y = stage.getHeight() - (stage.getHeight() - stage.getScene().getHeight());
                FXMLLoader myFXLoader = new FXMLLoader(FXMLs.class.getResource(sceneName+".fxml"), LanguageUtils.getInstance().getCurrentLanguage());
                AnchorPane root = (AnchorPane)myFXLoader.load();
                
                StageController controler = ((StageController) myFXLoader.getController());
                controler.setStage(stage);
                controler.setFXMLLoader(myLoader);
                
                if(splitPane!= null){
                    double divPosition = splitPane.getDividerPositions()[0];
                    ((SplitPane)myFXLoader.getNamespace().get("splitPane")).setDividerPosition(0, divPosition);
                }
            System.out.println("call() 1  : "+ Calendar.getInstance().getTimeInMillis());
                return new SceneComponents(root, x, y);
                
            }catch(Exception e){
                System.out.println("EXCEPTION EXCEPTION EXCEPTION EXCEPTION EXCEPTION  ");
                e.printStackTrace();
                return null;
                        
            }
            }
        }
        // Example for Using a Task:
        // fetch available product types in the background
        //Task<ProductType[]> getProductTypes = new Task<ProductType[]>(){
        //    @Override protected ProductType[] call() throws Exception {
        //        ProductTypeClient ptClient = new ProductTypeClient();
        //        ProductType[] types = ptClient.findAll_JSON(ProductType[].class);
        //        ptClient.close();
        //        return types;
        //    }
        //};
        //...
        //new Thread(getProductTypes).start();
        
        
    }
    

