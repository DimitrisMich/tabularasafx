package utils;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyEvent;

/**
 * Will contain all filters to stop input of various characters
 * Filter to stop digits, maybe filter to stop other things, don't know
 * @author d.michaelides
 */
public class EventFilters {
    public static EventHandler<KeyEvent> getOnlyNumbersFilter(){
        
        javafx.event.EventHandler<KeyEvent> h = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent key) {
                if(!key.getCharacter().matches("[0-9]") && !key.getCharacter().equals("\b")){
                    if(!key.isAltDown() && !key.isControlDown() ){
                        key.consume();
                    }
                }
            }
        };
        return h;
    }
    
    
    
    
    public static ChangeListener<String> getHoursListener(final ComboBox<String> comboBox, final int limit){
        ChangeListener<String> listener = new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (comboBox.getEditor().getText().length() > 2) {
                    String s = comboBox.getEditor().getText().substring(0, 2);
                    comboBox.getEditor().setText(s);
                    comboBox.getEditor().positionCaret(2);
                }
                if(comboBox.getEditor().getText() != null && !comboBox.getEditor().getText().isEmpty()){
                    try{
                        int hour_int = Integer.parseInt(comboBox.getEditor().getText());
                        if(hour_int > limit){
                            comboBox.getEditor().setText(Integer.toString(limit));
                        }else if(hour_int < 0){
                            comboBox.getEditor().setText("0");
                        }
                    }catch(Exception e){
                    
                    }
                }
            }
        };
        return listener;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
   
    

