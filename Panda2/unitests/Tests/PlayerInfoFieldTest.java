package Tests;

import static org.junit.jupiter.api.Assertions.*;


import java.awt.event.ActionEvent;



import org.junit.jupiter.api.Test;




import Enum.*;
import Controller.FieldIisNull;
import View.InterPlayersInfoFrame;
public class PlayerInfoFieldTest{

    @Test
    public void testEmptyTextFieldsException() {
        /*test on 2 players*/
        InterPlayersInfoFrame frame = new InterPlayersInfoFrame(2, Levels.Medium);
        frame.textField.setText(""); 
        frame.textField2.setText("");
        
        ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "next");

        assertThrows(FieldIisNull.class, () -> {
            frame.actionPerformed(actionEvent);
        });
            
    }
}
