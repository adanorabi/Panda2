package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Before;
import org.junit.Test;
import Controller.SysData;
import Enum.Levels;
import Model.Question;

public class JsonReaderTest {

    private SysData sysData;

    @Before
    public void setUp() {
        sysData = new SysData();
    }

    @Test
    public void testUploadQuestions() {
        SysData.UploadQuestions();

        // Test if questions are uploaded correctly
        ArrayList<Question> easyQuestions = SysData.EasyQues;
        ArrayList<Question> mediumQuestions = SysData.MidQues;
        ArrayList<Question> hardQuestions = SysData.HardQues;

        // Test if questions are not null
        assertNotNull("Easy questions list is null", easyQuestions);
        assertNotNull("Medium questions list is null", mediumQuestions);
        assertNotNull("Hard questions list is null", hardQuestions);

        // Test if questions are uploaded with correct difficulty level
        for (Question question : easyQuestions) {
            assertEquals("Question difficulty is not easy", Levels.Easy, question.getQLevel());
        }

        for (Question question : mediumQuestions) {
            assertEquals("Question difficulty is not medium", Levels.Medium, question.getQLevel());
        }

        for (Question question : hardQuestions) {
            assertEquals("Question difficulty is not hard", Levels.Hard, question.getQLevel());
        }

        // Test if questions are uploaded with correct content and answers
      
        assertEquals("Incorrect number of easy questions", 10, easyQuestions.size());
        assertEquals("Incorrect number of medium questions", 10, mediumQuestions.size());
        assertEquals("Incorrect number of hard questions", 10, hardQuestions.size());

        // Test specific question content and answers
        for (Question question : easyQuestions) {
  
            assertEquals("Incorrect number of answers", 4, question.getAnswer().size());
          
        }
        for (Question question : mediumQuestions) {
      
            assertEquals("Incorrect number of answers", 4, question.getAnswer().size());

        }
        for (Question question : hardQuestions) {
      assertEquals("Incorrect number of answers", 4, question.getAnswer().size());
         
        }
        
    }
}
