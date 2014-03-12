/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.menu;

import java.util.Calendar;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import services.TransitionService;

/**
 *
 * @author d.michaelides
 */
public class ScreenNavigator {
    private static TransitionService service;
    private static Stage stage;
    private static FXMLLoader myFXMLLoader;
    private static Region region;
    private static ProgressIndicator progress;
    private static SplitPane splitPane;
    private static int currentScreen = -1;
    
    public static void initFields(
                TransitionService ser, Stage sta,
                FXMLLoader myFXMLLoad, Region reg,
                ProgressIndicator prog, SplitPane split){
        service = ser;
        stage = sta;
        myFXMLLoader = myFXMLLoad;
        region = reg;
        progress = prog;
        splitPane = split;
    }
    
    public static void goToScreen(String screenName){
            
            service = new TransitionService(screenName, splitPane, myFXMLLoader, stage);
            service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent t) {
                    stage.setScene(new Scene (service.getValue().getRoot(), service.getValue().getX(), service.getValue().getY()));
                    System.out.println("service.done_() : "+ Calendar.getInstance().getTimeInMillis());

                }});

            region.visibleProperty().bind(service.runningProperty());
            progress.visibleProperty().bind(service.runningProperty());
            progress.progressProperty().bind(service.progressProperty());
            System.out.println("service.start() : "+ Calendar.getInstance().getTimeInMillis());
            service.start();
            System.out.println("service.done() : "+ Calendar.getInstance().getTimeInMillis());
    }
}
