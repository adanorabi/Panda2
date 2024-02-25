package View;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Winner extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Winner frame = new Winner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Winner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(400, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon winIcon = new ImageIcon(Winner.class.getResource("/View/img/winframe.png"));
		int winWidth = 500; // Adjusted width based on grid size
		int winHeight = 300;//Adjusted height based on grid size

		// Scale down the size of the snake image
		Image scaledWinImage = winIcon.getImage().getScaledInstance(winWidth, winHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledWinIcon = new ImageIcon(scaledWinImage);

		// Create a JLabel for the scaled snake image
		JLabel lblNewLabel_3  = new JLabel(scaledWinIcon);
		lblNewLabel_3.setBounds(320, 220,500,500);//

		// Add the snake label to the content pane
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(true);
		contentPane.setComponentZOrder(lblNewLabel_3, 0);    

		
/*********************************************winner**************************************************************/


		winIcon = new ImageIcon(Winner.class.getResource("/View/img/w2.png"));
		 winWidth = 170; // Adjusted width based on grid size
		 winHeight = 170;//Adjusted height based on grid size

		// Scale down the size of the snake image
		 scaledWinImage = winIcon.getImage().getScaledInstance(winWidth, winHeight, Image.SCALE_SMOOTH);
		 scaledWinIcon = new ImageIcon(scaledWinImage);

		// Create a JLabel for the scaled snake image
		JLabel lblNewLabel_w2  = new JLabel(scaledWinIcon);
		lblNewLabel_w2.setBounds(495, 150,170,170);//

		// Add the snake label to the content pane
		contentPane.add(lblNewLabel_w2);
		lblNewLabel_w2.setVisible(true);
		   
		
		
		
/*********************************bg************************************************************************/
		ImageIcon icon = new ImageIcon(MediumLevel.class.getResource("/View/img/game.png"));
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
		lblNewLabel_3.setVisible(true);
		//Repaint container
		contentPane.revalidate();
		contentPane.repaint();


	}
}
