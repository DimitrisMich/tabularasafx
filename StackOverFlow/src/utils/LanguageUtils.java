package utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author d.michaelides
 */
public class LanguageUtils {
     private static LanguageUtils language = new LanguageUtils( );
   
   /* A private Constructor prevents any other 
    * class from instantiating.
    */
   private LanguageUtils(){ }
   
   /* Static 'instance' method */
   public static LanguageUtils getInstance( ) {
      return language;
   }
   
   
    private static boolean turn = false;
    private final static ResourceBundle labelsGr = ResourceBundle.getBundle("Labels", new Locale("el"));
    private final static ResourceBundle labelsEn = ResourceBundle.getBundle("Labels",Locale.ENGLISH);
    private static ResourceBundle currentLabels = labelsEn;
    
    public ResourceBundle switchLanguage(){
        turn = !turn;
        if(turn){
            currentLabels = labelsEn;
        }
        else{
            currentLabels = labelsGr;
        }
        return currentLabels;
    }
    public ResourceBundle switchLanguage(int language){
        if(language == 1){
            currentLabels = labelsEn;
        }
        else{
            currentLabels = labelsGr;
        }
        return currentLabels;
    }
    public ResourceBundle getResourceBundle(int language){
        if(language == 1)
            return labelsEn;
        return labelsGr;
    
    }
    public ResourceBundle getCurrentLanguage(){
        return currentLabels;
    }
}
