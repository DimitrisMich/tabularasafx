/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import services.TransitionService;
import utils.LanguageUtils;
import utils.menu.ScreenNavigator;
import utils.menu.TreeMenuBuilder;

/**
 *
 * @author d.michaelides
 */
public class CreateClassController extends StageController{
    private TransitionService service;
    
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
    @FXML private TreeView treeMenu;
    
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
    
    
    @FXML private ChoiceBox<String> day1;
    @FXML private ChoiceBox<String>  day2;
    @FXML private ChoiceBox<String>  day3;
    @FXML private ChoiceBox<String>  day4;
    @FXML private ChoiceBox<String>  day5;
    @FXML private ChoiceBox<String>  day6;
    @FXML private ChoiceBox<String>  day7;
    @FXML private ChoiceBox<String>  day8;
    @FXML private ChoiceBox<String>  day9;
    @FXML private ChoiceBox<String>  day10;
    @FXML private ChoiceBox<String>  day11;
    
    @FXML private ComboBox<String>  hour1;
    @FXML private ComboBox<String>  hour2;
    @FXML private ComboBox<String>  hour3;
    @FXML private ComboBox<String>  hour4;
    @FXML private ComboBox<String>  hour5;
    @FXML private ComboBox<String>  hour6;
    @FXML private ComboBox<String>  hour7;
    @FXML private ComboBox<String>  hour8;
    @FXML private ComboBox<String>  hour9;
    @FXML private ComboBox<String>  hour10;
    @FXML private ComboBox<String>  hour11;
    
    @FXML private ComboBox<String>  minute1;
    @FXML private ComboBox<String>  minute2;
    @FXML private ComboBox<String>  minute3;
    @FXML private ComboBox<String>  minute4;
    @FXML private ComboBox<String>  minute5;
    @FXML private ComboBox<String>  minute6;
    @FXML private ComboBox<String>  minute7;
    @FXML private ComboBox<String>  minute8;
    @FXML private ComboBox<String>  minute9;
    @FXML private ComboBox<String>  minute10;
    @FXML private ComboBox<String>  minute11;
    
    @FXML private ComboBox<String>  duration1;
    @FXML private ComboBox<String>  duration2;
    @FXML private ComboBox<String>  duration3;
    @FXML private ComboBox<String>  duration4;
    @FXML private ComboBox<String>  duration5;
    @FXML private ComboBox<String>  duration6;
    @FXML private ComboBox<String>  duration7;
    @FXML private ComboBox<String>  duration8;
    @FXML private ComboBox<String>  duration9;
    @FXML private ComboBox<String>  duration10;
    @FXML private ComboBox<String>  duration11;
    
    @FXML private ChoiceBox<String> choice;
    
    private ArrayList<ChoiceBox<String>> days = new ArrayList<>(11);
    private ArrayList<ComboBox<String>> hours = new ArrayList<>(11);
    private ArrayList<ComboBox<String>> minutes = new ArrayList<>(11);
    private ArrayList<ComboBox<String>> durations = new ArrayList<>(11);
    
    
    private ArrayList<String> choose_times = new ArrayList<>(
            Arrays.asList("-------",
            "1", "2", "3", "4", "5", "6",
                "7", "8",  "9",  "10", "11"));
    
    private ArrayList<String> common_hours_24 = new ArrayList<>(
            Arrays.asList("-------",
            "13",
                "14", "15", "16", "17", "18",
                "19", "20",  "21",  "22"));
    
    private ArrayList<String> common_minutes = new ArrayList<>(
            Arrays.asList("-------", "00", "15", "20",
                "30", "40", "45"));
    
    private ArrayList<String> days_strings = new ArrayList<>(
            Arrays.asList("-------",
                "Monday","Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday", "Sunday"));
    
    private ArrayList<String> common_durations = new ArrayList<>(
            Arrays.asList("-------",
                "30","45", "60",
                "75", "90", "120"));
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("initialize -0- : "+ Calendar.getInstance().getTimeInMillis());
        
        TreeMenuBuilder.buildTheMenu();
        treeMenu.setRoot(TreeMenuBuilder.getTheMenuRoot());
        TreeMenuBuilder.setHandlers(treeMenu);        
        setMenuFilter();
        labels = LanguageUtils.getInstance().getCurrentLanguage();
        theV.prefWidthProperty().bind(theScroll.widthProperty());
        
        choice.getItems().clear();
        choice.getItems().addAll(choose_times);
        choice.getSelectionModel().selectFirst();
        
        days.add(day1);
        days.add(day2);
        days.add(day3);
        days.add(day4);
        days.add(day5);
        days.add(day6);
        days.add(day7);
        days.add(day8);
        days.add(day9);
        days.add(day10);
        days.add(day11);
        
        hours.add(hour1);
        hours.add(hour2);
        hours.add(hour3);
        hours.add(hour4);
        hours.add(hour5);
        hours.add(hour6);
        hours.add(hour7);
        hours.add(hour8);
        hours.add(hour9);
        hours.add(hour10);
        hours.add(hour11);
        
        minutes.add(minute1);
        minutes.add(minute2);
        minutes.add(minute3);
        minutes.add(minute4);
        minutes.add(minute5);
        minutes.add(minute6);
        minutes.add(minute7);
        minutes.add(minute8);
        minutes.add(minute9);
        minutes.add(minute10);
        minutes.add(minute11);
        
        durations.add(duration1);
        durations.add(duration2);
        durations.add(duration3);
        durations.add(duration4);
        durations.add(duration5);
        durations.add(duration6);
        durations.add(duration7);
        durations.add(duration8);
        durations.add(duration9);
        durations.add(duration10);
        durations.add(duration11);
        
        EventHandler<KeyEvent> handler = utils.EventFilters.getOnlyNumbersFilter();
        for(int i = 0; i < 11; i++){
            // filtering not numbers
            hours.get(i).addEventFilter(KeyEvent.KEY_RELEASED, handler);
            minutes.get(i).addEventFilter(KeyEvent.KEY_RELEASED, handler);
            // text listener (hours)
            ChangeListener<String> lister = utils.EventFilters.getHoursListener(hours.get(i), 24);
            hours.get(i).getEditor().textProperty().addListener(lister);
            
            // text listener (minutes)
            ChangeListener<String> minutesListener = utils.EventFilters.getHoursListener(minutes.get(i), 60);
            minutes.get(i).getEditor().textProperty().addListener(minutesListener);
        
            durations.get(i).getItems().clear();
            durations.get(i).getItems().addAll(common_durations);
            durations.get(i).getSelectionModel().selectFirst();
            minutes.get(i).getItems().clear();
            minutes.get(i).getItems().addAll(common_minutes);
            minutes.get(i).getSelectionModel().selectFirst();
            hours.get(i).getItems().clear();
            hours.get(i).getItems().addAll(common_hours_24);
            hours.get(i).getSelectionModel().selectFirst();
            days.get(i).getItems().clear();
            days.get(i).getItems().addAll(days_strings);
            days.get(i).getSelectionModel().selectFirst();
        }
        
        
        choice.valueProperty().addListener(
            new ChangeListener() {
                public void changed(ObservableValue observable, 
                                    Object oldVal, Object newVal) {
                    int newValue_int;
                    try{
                        newValue_int = Integer.parseInt((String) newVal);
                    }catch(Exception e){
                        newValue_int = 0;
                    }
                    int oldValue_int;
                    try{
                        oldValue_int = Integer.parseInt((String) oldVal);
                    }catch(Exception e){
                        oldValue_int = 0;
                    }
                    
                    dayTitle.setDisable(newValue_int == 0);
                    hourTitle.setDisable(newValue_int == 0);
                    durationTitle.setDisable(newValue_int == 0);

                    if( newValue_int >= oldValue_int){
                        for(int i = oldValue_int; i < newValue_int; i++){
                            days.get(i).setDisable(false);
                            hours.get(i).setDisable(false);
                            minutes.get(i).setDisable(false);
                            durations.get(i).setDisable(false);
                        }
                    }else{
                        if(oldValue_int == 11){
                            oldValue_int = 10;
                        }
                        
                        for(int i = oldValue_int; i >=  newValue_int; i--){
                            days.get(i).setDisable(true);
                            hours.get(i).setDisable(true);
                            minutes.get(i).setDisable(true);
                            durations.get(i).setDisable(true);
                        }
                    }
                    }
            });
        System.out.println("initialize -1- : "+ Calendar.getInstance().getTimeInMillis());
    }
    private void changeLocale(){
    }
    
    
    @FXML
    private void changeLanguage(Event event) throws IOException {
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
    private void showSettings(Event event) throws IOException {
    }
    
    @FXML
    private void addTeacher(Event event) throws IOException {
    }
    @FXML
    private void clearTeacher(Event event) throws IOException {
    }
}
 
    