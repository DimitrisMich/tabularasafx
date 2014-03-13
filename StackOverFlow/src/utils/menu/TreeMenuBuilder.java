/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.menu;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Builds a tree menu 
 * @author d.michaelides
 */
public class TreeMenuBuilder {
    private static TreeView theMenu;
    
    public static TreeItem<String> getTheMenuRoot(){
        return theMenu.getRoot();
    }
    
    public static void buildTheMenu(){
        if(theMenu == null){
            theMenu = new TreeView();
            try{
                TreeItem<String> root = new TreeItem<> ("Home", getIcon("home.png"));
                root.setExpanded(true);
                TreeItem<String> students = new TreeItem<> ("Students", getIcon("student.png"));
                    TreeItem<String> students_create = new TreeItem<> ("Create");         
                    students.getChildren().add(students_create);

                TreeItem<String> teachers = new TreeItem<> ("Teachers", getIcon("teacher.png"));
                    TreeItem<String>teachers_create = new TreeItem<> ("Create");         
                    teachers.getChildren().add(teachers_create);

                TreeItem<String> classes = new TreeItem<> ("Classes", getIcon("class.png"));
                    TreeItem<String>class_create = new TreeItem<> ("Create");         
                    classes.getChildren().add(class_create);
                TreeItem<String> other = new TreeItem<> ("Other", getIcon("other.png"));

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
    
    
    
    private static ImageView getIcon(String iconName){
        ImageView icon =  new ImageView(new Image(ClassLoader.getSystemResourceAsStream("images/icons/"+iconName),12,12,true,true));
        return icon;
    }
}
