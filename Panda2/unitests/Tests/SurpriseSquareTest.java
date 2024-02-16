//package Tests;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;
//
//import Model.SurpriseSquare;
//
//public class SurpriseSquareTest {
//
//    @Test
//    public void testRandSurpriseReturnsValidValues() {
//        SurpriseSquare surpriseSquare = new SurpriseSquare(0, 0); // Assuming squareRow and squareCol are not used in the test
//
//        // Run the RandSurprise method multiple times and ensure it returns valid values
//        for (int i = 0; i < 1000; i++) { // Running the test 1000 times
//            int surprise = surpriseSquare.RandSurprise();
//            assertTrue("Surprise value should be either -10 or 10", surprise == -10 || surprise == 10);
//        }
//    }
//}
