package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import FlatLafDesign.BackButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Enum.PlayerColor;
import FlatLafDesign.BackButton;
import Model.Player;

import javax.sound.sampled.*;
import javax.swing.JButton;
public class Winner extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Timer timer;
	private JLabel p1Label;
	private JLabel p2Label;
	private JLabel p3Label;
	private JLabel p4Label;
	private JLabel p2name;
	private JLabel p1name;
	private JLabel p3name;
	private JLabel p4name;
	private Icon p1icon;
	private Icon p2icon;
	private Icon p3icon;
	private Icon p4icon;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Winner(Player p1,Player p2,Player p3,Player p4,int num) {
	//	int num=4;
//		Player p1=new Player( PlayerColor.Red, "yara",4, 4,2);//wenner
//		Player p2=new Player ( PlayerColor.Yellow, "yomna", 4, 4,2);//2nd
//		Player p3=new Player ( PlayerColor.Green, "ghaidaa", 4, 4,2);//3rd
//		Player p4=new Player ( PlayerColor.Blue, "adan", 4, 4,2);//4rd
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(400, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 // Play victory sound
        playVictorySound();

		ImageIcon winIcon = new ImageIcon(Winner.class.getResource("/View/img/winframe.png"));
		int winWidth = 500; // Adjusted width based on grid size
		int winHeight = 300;//Adjusted height based on grid size

		// Scale down the size of the snake image
		Image scaledWinImage = winIcon.getImage().getScaledInstance(winWidth, winHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledWinIcon = new ImageIcon(scaledWinImage);

		// Create a JLabel for the scaled snake image
		JLabel lblNewLabel_3  = new JLabel(scaledWinIcon);
		lblNewLabel_3.setBounds(320, 260,500,500);//

		// Add the snake label to the content pane
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(true);
		contentPane.setComponentZOrder(lblNewLabel_3, 0);    

		
/*********************************************winner**************************************************************/


		winIcon = new ImageIcon(Winner.class.getResource("/View/img/win.png"));
		 winWidth = 200; // Adjusted width based on grid size
		 winHeight = 200;//Adjusted height based on grid size

		// Scale down the size of the snake image
		 scaledWinImage = winIcon.getImage().getScaledInstance(winWidth, winHeight, Image.SCALE_SMOOTH);
		 scaledWinIcon = new ImageIcon(scaledWinImage);

		// Create a JLabel for the scaled snake image
		JLabel lblNewLabel_w2  = new JLabel(scaledWinIcon);
		lblNewLabel_w2.setBounds(470, 180,200,200);//

		// Add the snake label to the content pane
		contentPane.add(lblNewLabel_w2);
		lblNewLabel_w2.setVisible(true);
		
/*********************************w3************************************************************************/	   

		winIcon = new ImageIcon(Winner.class.getResource("/View/img/w3.png"));
		 winWidth = 600; // Adjusted width based on grid size
		 winHeight = 200;//Adjusted height based on grid size

		// Scale down the size of the snake image
		 scaledWinImage = winIcon.getImage().getScaledInstance(winWidth, winHeight, Image.SCALE_SMOOTH);
		 scaledWinIcon = new ImageIcon(scaledWinImage);

		// Create a JLabel for the scaled snake image
		JLabel lblNewLabel_w3  = new JLabel(scaledWinIcon);
		lblNewLabel_w3.setBounds(300, 20,600,200);//

		// Add the snake label to the content pane
		contentPane.add(lblNewLabel_w3);
		lblNewLabel_w3.setVisible(true);
/************************************************************************players*******************************************************/
		if(p2.getPlayerColor()==PlayerColor.Red) {
			p2icon= new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
		}
		else if(p2.getPlayerColor()==PlayerColor.Green) {
			p2icon= new ImageIcon(EasyLevel.class.getResource("/View/img/g.png"));
		}
		else if(p2.getPlayerColor()==PlayerColor.Blue) {
			p2icon= new ImageIcon(EasyLevel.class.getResource("/View/img/b.png"));
		}
		else {
			p2icon= new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));	
		}
		Image scaledP2Image = ((ImageIcon) p2icon).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledP2Icon = new ImageIcon(scaledP2Image);
		// Create a JLabel for player p2
		p2Label = new JLabel(scaledP2Icon);
		p2Label.setBounds(370, 320, 100, 100); // Set bounds for player p1 label

		// Add player p1 label to the content pane
		contentPane.add(p2Label);

		// Ensure player p1 label is visible
		p2Label.setVisible(true);

		p2name = new JLabel(p2.getNickName());
		p2name.setFont(new Font("Times New Roman", Font.BOLD, 20));
		p2name.setBounds(390, 430, 200, 40);
		contentPane.add(p2name,0);
		/**player1**/
		if(p1.getPlayerColor()==PlayerColor.Red) {
			p1icon= new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
		}
		else if(p1.getPlayerColor()==PlayerColor.Green) {
			p1icon= new ImageIcon(EasyLevel.class.getResource("/View/img/g.png"));
		}
		else if(p1.getPlayerColor()==PlayerColor.Blue) {
			p1icon= new ImageIcon(EasyLevel.class.getResource("/View/img/b.png"));
		}
		else {
			p1icon= new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));	
		}
		Image scaledP1Image = ((ImageIcon) p1icon).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledP1Icon = new ImageIcon(scaledP1Image);
		// Create a JLabel for player p2
		p1Label = new JLabel(scaledP1Icon);
		p1Label.setBounds(530, 200, 100, 100); // Set bounds for player p1 label

		// Add player p1 label to the content pane
		contentPane.add(p1Label,0);

		// Ensure player p1 label is visible
		p1Label.setVisible(true);

		p1name = new JLabel(p1.getNickName());
		p1name.setFont(new Font("Times New Roman", Font.BOLD, 20));
		p1name.setBounds(540, 370, 200, 40);
		contentPane.add(p1name,0);
		/*player3*/
		if(num>2) {
		if(p3.getPlayerColor()==PlayerColor.Red) {
			p3icon= new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
		}
		else if(p3.getPlayerColor()==PlayerColor.Green) {
			p3icon= new ImageIcon(EasyLevel.class.getResource("/View/img/g.png"));
		}
		else if(p3.getPlayerColor()==PlayerColor.Blue) {
			p3icon= new ImageIcon(EasyLevel.class.getResource("/View/img/b.png"));
		}
		else {
			p3icon= new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));	
		}
		Image scaledP3Image = ((ImageIcon) p3icon).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledP3Icon = new ImageIcon(scaledP3Image);
		// Create a JLabel for player p2
		p3Label = new JLabel(scaledP3Icon);
		p3Label.setBounds(670, 340, 100, 100); // Set bounds for player p1 label

		// Add player p1 label to the content pane
		contentPane.add(p3Label);

		// Ensure player p1 label is visible
		p3Label.setVisible(true);

		p3name = new JLabel(p3.getNickName());
		p3name.setFont(new Font("Times New Roman", Font.BOLD, 20));
		p3name.setBounds(690, 430, 200, 40);
		contentPane.add(p3name,0);
		}
		if(num==4) {
			if(p4.getPlayerColor()==PlayerColor.Red) {
				p4icon= new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
			}
			else if(p4.getPlayerColor()==PlayerColor.Green) {
				p4icon= new ImageIcon(EasyLevel.class.getResource("/View/img/g.png"));
			}
			else if(p4.getPlayerColor()==PlayerColor.Blue) {
				p4icon= new ImageIcon(EasyLevel.class.getResource("/View/img/b.png"));
			}
			else {
				p4icon= new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));	
			}
			Image scaledP4Image = ((ImageIcon) p4icon).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon scaledP4Icon = new ImageIcon(scaledP4Image);
			// Create a JLabel for player p2
			p4Label = new JLabel(scaledP4Icon);
			p4Label.setBounds(830, 460, 100, 100); // Set bounds for player p1 label

			// Add player p1 label to the content pane
			contentPane.add(p4Label);

			// Ensure player p1 label is visible
			p4Label.setVisible(true);

			p4name = new JLabel(p4.getNickName());
			p4name.setFont(new Font("Times New Roman", Font.BOLD, 20));
			p4name.setBounds(860, 540, 200, 40);
			contentPane.add(p4name,0);
		}
		
/*********************************bg************************************************************************/
		ImageIcon icon = new ImageIcon(Winner.class.getResource("/View/img/winnerbg.png"));
		System.out.println("Image loaded: " + icon.getImageLoadStatus());

		//Verify image dimensions
		int containerWidth = 1200;
		int containerHeight = 700;
		System.out.println("Container size: " + containerWidth + "x" + containerHeight);
		//Create JLabel with scaled image
		Image scaledImg = icon.getImage().getScaledInstance(containerWidth, containerHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);		
		JLabel lblNewLabel = new JLabel(scaledIcon);
		lblNewLabel.setBounds(0, 0,containerWidth, containerHeight);//
		//Set layout manager to BorderLayout


		//Add JLabel to center of contentPane
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Winner.class.getResource("/View/img/w3.png")));
		lblNewLabel_1.setBounds(567, 20, 45, 13);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_3.setVisible(true);
		//Repaint container
		contentPane.revalidate();
		contentPane.repaint();
/******************************move*******************/
		timer = new Timer(50, new ActionListener() {
            int y = 20; // Initial Y position of the sprinkle
            int speed = 5; // Speed at which the sprinkle falls
            int containerHeight = 250; // Height of the container

            @Override
            public void actionPerformed(ActionEvent e) {
                // Update position of the sprinkle
                y += speed; // Move the sprinkle down
                // If the sprinkle reaches the bottom of the container, reset its position to the top
                if (y >= containerHeight) {
                    y = 20; // Reset position
                }
                lblNewLabel_w3.setLocation(300, y); // Update sprinkle position
                // Repaint container
                contentPane.revalidate();
                contentPane.repaint();
            }
        });
        timer.start(); // Start the animation loop
  
/****************player movement**************/
     headMove();

		BackButton backButton = new BackButton();
		backButton.setBounds(20, 600, 100, 40); // Set the bounds of the button
		backButton.setText("Home"); // Set the text of the button
		backButton.setFont(new Font("Arial", Font.BOLD, 16)); // Set the font of the button text
		backButton.setForeground(Color.black); // Set the text color
		backButton.setHoverBackgroundColor(Color.white); // Set the background color when hovered
		backButton.setPressedBackgroundColor(Color.decode("#7f7f7f")); // Set the background color when pressed
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrame f=new MainFrame();
				f.setVisible(true);
				JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
		        frame.dispose();
			}
			
		});
		contentPane.add(backButton,0);

	}
	public void headMove() {
		Timer playerMoveTimer = new Timer(100, new ActionListener() {
		    double angle = 0; // Initial angle for tilting
		    double tiltRange = Math.PI / 18; // Adjust this value to control the tilt range
		    boolean tiltDirection = true; // Flag to indicate the tilting direction

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Update the angle for tilting based on the tilting direction
		        if (tiltDirection) {
		            angle += 0.1; // Tilting right
		        } else {
		            angle -= 0.1; // Tilting left
		        }

		        // Check if the tilt angle exceeds the tilt range, then change the direction
		        if (angle >= tiltRange || angle <= -tiltRange) {
		            tiltDirection = !tiltDirection; // Change the direction
		        }

		        // Calculate the tilt angle based on the triangle wave function
		        double tiltAngle = tiltRange * Math.sin(angle);

		        // Apply the tilt transformation to the player icon
		        applyTiltTransformation(p1Label, tiltAngle);
		        // Apply the tilt transformation to other player icons if needed
		        // applyTiltTransformation(p2Label, tiltAngle);
		        // applyTiltTransformation(p3Label, tiltAngle);
		        // applyTiltTransformation(p4Label, tiltAngle);
		    }

		    // Method to apply tilt transformation to a JLabel
		    private void applyTiltTransformation(JLabel label, double tiltAngle) {
		        // Create a transformation matrix for rotation
		        AffineTransform transform = new AffineTransform();
		        transform.rotate(tiltAngle, label.getWidth() / 2, label.getHeight());

		        // Apply the transformation to the label
		        BufferedImage image = new BufferedImage(
		                label.getWidth(), label.getHeight(), BufferedImage.TYPE_INT_ARGB);
		        Graphics2D g2d = image.createGraphics();
		        g2d.setTransform(transform);
		        g2d.drawImage(((ImageIcon) label.getIcon()).getImage(), 0, 0, null);
		        g2d.dispose();

		        // Set the transformed image as the icon of the label
		        label.setIcon(new ImageIcon(image));
		    }
		});

		// Start the player movement timer
		playerMoveTimer.start();


	}
	// Method to play victory sound
    private void playVictorySound() {
        try {
            File audioFile = new File("victory.wav"); // Adjust the file path accordingly
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
