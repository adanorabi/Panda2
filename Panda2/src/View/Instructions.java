package View;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.PlayAudio;

import javax.swing.JTextField;

public class Instructions extends JFrame implements ActionListener {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;


	public Instructions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(110, 100, 1314, 816); // Set frame size here
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// choosing just one radio button , no more!


		JButton backButton = new JButton("<<home page");
		backButton.setIcon(new ImageIcon(Instructions.class.getResource("/View/img/InstructionsHP.jpg")));
		// backButton.setIcon(new ImageIcon("C:\\Users\\97250\\Documents\\GitHub\\Panda2\\Panda2\\src\\View\\img\\InstructionsHP.png"));

		//backButton.setIcon(new ImageIcon("/View/img/InstructionsHP.jbg"));
		backButton.setBounds(47, 725, 255, 44);
		contentPane.add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frame = new MainFrame();
				setVisible(false);
				PlayAudio.PlayBackSound(); // Calling  the function that play back buttons audio -Yara
				frame.setVisible(true);

			}
		});

		ImageIcon coverIcon = new ImageIcon(Instructions.class.getResource("/View/img/gameInstructions.png"));
		int frameWidth = 1357; // Adjusted frame width
		int frameHeight = 764; // Adjusted frame height
		int photoWidth = 1303; // Adjusted photo width
		int photoHeight = 797; // Adjusted photo height

		// Scale down the size of the photo
		Image scaledImage = coverIcon.getImage().getScaledInstance(photoWidth, photoHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(scaledIcon);
		lblNewLabel.setBounds(0, -13, 1395, 781); // Adjusted photo bounds to fit within the frame
		contentPane.add(lblNewLabel);


	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
