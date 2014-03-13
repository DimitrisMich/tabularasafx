/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.menu;

import controllers.HomePageController;
import controllers.StageController;
import java.io.IOException;
import java.util.HashMap;
import javafx.stage.Stage;

/**
 *
 * @author d.michaelides
 */
public class ScreenNavigator {
    private final Stage stage;
    public static HashMap<String, StageController> controllers;
    private static ScreenNavigator singleton;
    private ScreenNavigator(Stage s){
        stage = s;
    }

    public static ScreenNavigator getInstance(Stage s){
        if(singleton == null){
            singleton = new ScreenNavigator(s);
            controllers = new HashMap<>();
        }
        return singleton;
    }
    
    
    public void goToScreen(String screenName) throws IOException{
        System.out.println("Going to screen -> "+ screenName);
        if(screenName.equals("HomePage")){
            stage.setScene(null);
            stage.setScene(controllers.get(screenName).getScene());
        }else{
            ((HomePageController)controllers.get("HomePage")).goToScreen(screenName);
        }
        
    }
}
