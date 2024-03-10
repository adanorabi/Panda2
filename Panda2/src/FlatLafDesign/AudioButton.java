package FlatLafDesign;


import javax.swing.*;

import Model.PlayAudio;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class AudioButton extends JButton {

    private ImageIcon defaultIcon;
    private ImageIcon clickedIcon;

    public AudioButton(ImageIcon defaultIcon, ImageIcon clickedIcon) {
        this.defaultIcon = defaultIcon;
        this.clickedIcon = clickedIcon;

        // Set default icon
        setIcon(defaultIcon);
    

        // Set button shape to circle
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);

        // Add action listener to handle click event
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleIcon(); // Toggle between default and clicked icon
            }
        });
    }

    private void toggleIcon() {
        // Get the current icon
        Icon currentIcon = getIcon();

        // Check if the current icon is the default icon
        if (currentIcon == defaultIcon) {//audio on
            PlayAudio.playingBackGround.close(); //Yara
            setIcon(clickedIcon);
        } else {//audio off
        	  PlayAudio.playGameSound(); //Yara
            setIcon(defaultIcon);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        int width = getWidth();
        int height = getHeight();

        // Set rendering hints for smoothness
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Create circle shape
        Ellipse2D circle = new Ellipse2D.Float(0, 0, width - 1, height - 1);

        // Fill the circle with the background color
        g2.setColor(getBackground());
        g2.fill(circle);

        // Call super to paint button
        super.paintComponent(g2);

        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(60, 60); // Set a fixed size for the button
    }
}
