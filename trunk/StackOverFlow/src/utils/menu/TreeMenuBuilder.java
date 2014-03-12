/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.menu;

import java.io.IOException;
import java.util.Calendar;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import services.TransitionService;

/**
 * Builds a tree menu !! not used at the moment
 * @author d.michaelides
 */
public class TreeMenuBuilder {
    private static TreeView theMenu;
    private static boolean handlersAreSet;
    
    public static TreeItem<String> getTheMenuRoot(){
        return theMenu.getRoot();
    }
    
    public static void buildTheMenu(){
//        theMenu.setEditable(true);
        if(theMenu == null){
            theMenu = new TreeView();
            try{
                TreeItem<String> root = new TreeItem<> ("Home", getIcon("home.png"));
                root.setExpanded(true);
                TreeItem<String> students = new TreeItem<> ("Students", getIcon("student.png"));
                    TreeItem<String> students_create = new TreeItem<> ("Create");         
                    students.getChildren().add(students_create);
                    TreeItem<String> item2 = new TreeItem<> ("View All");         
                    students.getChildren().add(item2);

                TreeItem<String> teachers = new TreeItem<> ("Teachers", getIcon("teacher.png"));
                    TreeItem<String>teachers_create = new TreeItem<> ("Create");         
                    teachers.getChildren().add(teachers_create);
                    TreeItem<String> teachers2 = new TreeItem<> ("View All");         
                    teachers.getChildren().add(teachers2);

                TreeItem<String> classes = new TreeItem<> ("Classes", getIcon("class.png"));
                    TreeItem<String>class_create = new TreeItem<> ("Create");         
                    classes.getChildren().add(class_create);
                    TreeItem<String> classes2 = new TreeItem<> ("View All");
                    classes.getChildren().add(classes2);
                TreeItem<String> other = new TreeItem<> ("Other", getIcon("other.png"));
                    TreeItem<String>other_table = new TreeItem<> ("Table");         
                    TreeItem<String>other_time_table = new TreeItem<> ("Time Table");         
                    other.getChildren().add(other_table);      
                    other.getChildren().add(other_time_table);

                root.getChildren().add(students);
                root.getChildren().add(teachers);
                root.getChildren().add(classes);
                root.getChildren().add(other);
                
                theMenu.setRoot(root);
            }catch(Exception e){
                e.printStackTrace(System.out);
            }
        }
    }
    public static void setHandlers(final TreeView treeMenu){
        treeMenu.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent mouseEvent)
            { 
                if(mouseEvent.getButton() == MouseButton.PRIMARY){
                    if(mouseEvent.getClickCount() == 1) {
                        TreeItem<String> item = (TreeItem<String>) treeMenu.getSelectionModel().getSelectedItem();
                        if(item != null){
                            if(item.getValue().equals("Create")){
                                switch(item.getParent().getValue()){
                                    case "Classes"  : ScreenNavigator.goToScreen("CreateClass");
                                    
                                    System.out.println("ScreenNavigator : "+ Calendar.getInstance().getTimeInMillis());
                                    break;
                                    default:break;
                                }
                            }
                            else if(item.getValue().equals("View All")){
                                switch(item.getParent().getValue()){
                                    default:break;
                                }
                            }
                            else if(item.getValue().equals("Home")){
                                    ScreenNavigator.goToScreen("HomePage");
                            }
                            else if(item.getValue().equals("Table")){
                                if( item.getParent().getValue().equals("Other")){
                                }
                            }
                            else if(item.getValue().equals("Time Table")){
                                if( item.getParent().getValue().equals("Other")){
                                }
                            }
                        }
                    }else{
                    }
                }
            }
        });
        
    }
    
        public static void buildTheMenu(TreeView menu){
//            menu.setEditable(true);

            try{
                TreeItem<String> rootItem = new TreeItem<> ("Home", getIcon("home.png"));
                rootItem.setExpanded(true);
                TreeItem<String> students = new TreeItem<> ("Students", getIcon("student.png"));
                    TreeItem<String> item = new TreeItem<> ("Create");         
                    students.getChildren().add(item);
                    TreeItem<String> item2 = new TreeItem<> ("View All");
                    students.getChildren().add(item2);

                TreeItem<String> teachers = new TreeItem<> ("Teachers", getIcon("teacher.png"));
                    TreeItem<String> teachers1 = new TreeItem<> ("Create");         
                    teachers.getChildren().add(teachers1);
                    TreeItem<String> teachers2 = new TreeItem<> ("View All");         
                    teachers.getChildren().add(teachers2);

                TreeItem<String> classes = new TreeItem<> ("Classes", getIcon("class.png"));
                    TreeItem<String> classes1 = new TreeItem<> ("Create");         
                    classes.getChildren().add(classes1);
                    TreeItem<String> classes2 = new TreeItem<> ("View All");         
                    classes.getChildren().add(classes2);

                rootItem.getChildren().add(students);
                rootItem.getChildren().add(teachers);
                rootItem.getChildren().add(classes);
                menu.setRoot(rootItem);
            }catch(Exception e){
                e.printStackTrace(System.out);
            }
        }
    
    private static ImageView getIcon(String iconName){
        ImageView icon =  new ImageView(new Image(ClassLoader.getSystemResourceAsStream("images/icons/"+iconName),12,12,true,true));
        return icon;
    }
}
