/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javafx.scene.Parent;

/**
 *
 * @author d.michaelides
 */
public class SceneComponents {
    private Parent root;
    private double x;
    private double y;
    
    public SceneComponents(Parent theRoot, double width, double height){
        root = theRoot;
        x = width;
        y = height;
    }
    public Parent getRoot(){
        return root;
    }
    public double getX(){
    return x;
    }
    public double getY(){
    return y;
    }
    
    
}
