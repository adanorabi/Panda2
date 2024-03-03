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

public class Screenshot {
	
    private static final String SCREENSHOT_FOLDER = "screenshots";
    private static final Map<Integer, String> screenshotMap = new HashMap<>();
	
    private static void loadExistingScreenshots() {
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

    public static int captureScreenshot(JFrame frame) {
        int screenshotId = getNextScreenshotId();
        File screenshot = new File(SCREENSHOT_FOLDER + File.separator + "screenshot_" + screenshotId + ".png");
        try {
            // Capture screenshot of the JFrame
            Rectangle frameRect = frame.getBounds();
            Robot robot = new Robot();
            BufferedImage screenImage = robot.createScreenCapture(frameRect);

            // Save the screenshot to a file
            ImageIO.write(screenImage, "png", screenshot);
            screenshotMap.put(screenshotId, screenshot.getAbsolutePath());
            System.out.println("Screenshot captured and saved as: " + screenshot.getAbsolutePath());
            return screenshotId;
        } catch (AWTException | IOException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    private static int getNextScreenshotId() {
    	int size =screenshotMap.size();
        return size++; // Modified to start from 1
    }
    
    private static String getScreenshotPathById(int screenshotId) {
        return screenshotMap.getOrDefault(screenshotId, null);
    }

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
