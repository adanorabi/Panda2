package Controller;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
//-----------------------Yomna-------------------------
public class Screenshot {
	
    private static final String SCREENSHOT_FOLDER = "screenshots";
    private static final Map<Integer, String> screenshotMap = new HashMap<>();
//	loadExistingScreenshots this function laod all the screenshots that in that we save so we can show them in the history
    public static void loadExistingScreenshots() {
        File folder = new File(SCREENSHOT_FOLDER);
        if (!folder.exists()) {
            folder.mkdir();
        } else {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".png")) {
                        String[] parts = file.getName().split("_");
                        if (parts.length == 2) {
                            try {
                                int id = Integer.parseInt(parts[1].split("\\.")[0]);
                                screenshotMap.put(id, file.getAbsolutePath());
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

//    captureScreenshot this function take a screenshot of the game frame
//    it receive the frame that it will take the screenshot of it, 
//    and it receive integer that is the id of the game so we can save the capture by the gameid
    public static int captureScreenshot(JFrame frame,int id) {
      
        File screenshot = new File(SCREENSHOT_FOLDER + File.separator + "screenshot_" + id + ".png");
        try {
            // Capture screenshot of the JFrame
            Rectangle frameRect = frame.getBounds();
            Robot robot = new Robot();
            BufferedImage screenImage = robot.createScreenCapture(frameRect);

            // Save the screenshot to a file
            ImageIO.write(screenImage, "png", screenshot);
            screenshotMap.put(id, screenshot.getAbsolutePath());
            System.out.println("Screenshot captured and saved as: " + screenshot.getAbsolutePath());
            return id;
        } catch (AWTException | IOException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

//   getScreenshotPathById it get the screenshot by the integer(that it is the gameid) that it received 
    private static String getScreenshotPathById(int screenshotId) {
        return screenshotMap.getOrDefault(screenshotId, null);
    }
// showScreenshot this function show the screenshot by the integer that it receive
    public static void showScreenshot(int screenshotId) {
        String screenshotPath = getScreenshotPathById(screenshotId);
        if (screenshotPath != null) {
            JFrame frame = new JFrame("Screenshot " + screenshotId);
            JLabel label = new JLabel(new ImageIcon(screenshotPath));
            frame.add(label);
            frame.pack();
            frame.setVisible(true);
        } else {
            System.out.println("Screenshot not found.");
        }
    }

}
