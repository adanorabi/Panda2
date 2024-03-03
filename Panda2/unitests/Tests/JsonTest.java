package Tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import Controller.JsonObserver;
import Controller.SysData;
import Enum.Levels;
import Model.Question;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertEquals;
public class JsonTest {

    private SysData sysData;

    @Before
    public void setUp() {
        sysData = new SysData();
    }

  

    @Test
    public void testUploadQuestionsDifficultyLevels() {
    	JsonObserver.UploadQuestions();

        // Test if questions are uploaded with correct difficulty level
  
        for (Question question : SysData.HardQues) {
            assertEquals("Question difficulty is not hard", Levels.Hard, question.getQLevel());
        }
    }

    @Test
    public void testUploadQuestionsAnswers() {
    	JsonObserver.UploadQuestions();

        // Test if questions are uploaded with correct number of answers
  
        for (Question question : SysData.HardQues) {
            assertEquals("Incorrect number of answers", 4, question.getAnswer().size());
        }
    }
}
