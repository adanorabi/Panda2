package View;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GifExample extends JFrame {

    public GifExample() {
        setTitle("GIF Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        // Create a JLabel to hold the GIF
        JLabel gifLabel = new JLabel();
        // Load the GIF file as an ImageIcon
        ImageIcon gifIcon = new ImageIcon(getClass().getResource("/view/img/sadpanda1.gif"));
        
        // Convert ImageIcon to Image
        Image gifImage = gifIcon.getImage();
        
        // Create a BufferedImage to draw text onto the GIF
        BufferedImage bufferedImage = new BufferedImage(
            gifIcon.getIconWidth(), 
            gifIcon.getIconHeight(), 
            BufferedImage.TYPE_INT_ARGB
        );

        // Draw the GIF onto the BufferedImage
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(gifImage, 0, 0, null);
        
        // Draw text onto the BufferedImage
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 24));
        g2d.drawString("Your Text Here", 50, 50); // Adjust position as needed
        
        // Dispose Graphics2D
        g2d.dispose();
        
        // Convert the BufferedImage back to an ImageIcon
        ImageIcon modifiedIcon = new ImageIcon(bufferedImage);
        
        // Set the ImageIcon to the JLabel
        gifLabel.setIcon(modifiedIcon);

        // Add the JLabel to the frame
        add(gifLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Create and show the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            // Create an instance of GifExample
            GifExample gifExample = new GifExample();
            // Show the frame
            gifExample.setVisible(true);
        });
    }
}
