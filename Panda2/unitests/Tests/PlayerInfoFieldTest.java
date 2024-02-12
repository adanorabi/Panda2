package Tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.fail;

import java.awt.event.ActionEvent;



import org.junit.jupiter.api.Test;

import Controller.FieldIisNull;

import static org.junit.Assert.*;
import Enum.*;
import Controller.*;
import View.InterPlayersInfoFrame;
public class PlayerInfoFieldTest{

    @Test
    public void testEmptyTextFieldsException() {
        /*test on 2 players*/
        InterPlayersInfoFrame frame = new InterPlayersInfoFrame(2, Levels.Medium);
        frame.textField.setText(""); // Assuming textField is accessible and represents the player name field
        frame.textField2.setText("");
        // Create an ActionEvent with the appropriate action command
        ActionEvent actionEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "next");

        // Use try-catch block to catch the expected exception
        try {
        	frame.actionPerformed(actionEvent);
            // If no exception is thrown, fail the test
            fail("Expected FieldIisNull exception was not thrown");
        } catch (FieldIisNull e) {
            // If FieldIisNull exception is thrown, assert true
            assertTrue("FieldIisNull exception is thrown", true);
        }
            
    }
}
