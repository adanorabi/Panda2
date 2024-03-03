package FlatLafDesign;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class BackButton extends JButton {

    private Color hoverBackgroundColor;
    private Color pressedBackgroundColor;

    public BackButton() {
        setContentAreaFilled(false); // Ensure button background is not filled
        setBorder(new EmptyBorder(8, 16, 8, 16)); // Add padding around the button text/icon
      
        setForeground(Color.decode("#408080")); // Set text/icon color

        // Set the background color of the button when hovered
        setHoverBackgroundColor(Color.decode("#bfbfbf"));
        // Set the background color of the button when pressed
        setPressedBackgroundColor(Color.decode("#7f7f7f"));
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isPressed()) {
            g2.setColor(getPressedBackgroundColor());
        } else if (getModel().isRollover()) {
            g2.setColor(getHoverBackgroundColor());
        } else {
            g2.setColor(getBackground());
        }

        // Draw a rounded rectangle as the button background
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

        g2.dispose();

        super.paintComponent(g);
    }
}
