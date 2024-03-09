package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import Enum.Levels;
import Model.PlayAudio;

public class LevelGame extends JFrame  implements ActionListener {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JRadioButton EasyRadioButton;
	private JRadioButton MeduimRadioButton;
	private JRadioButton HardRadioButton;

	// frame to choose level game, and number of players
	public LevelGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 70,1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Choose players numbers :");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		lblNewLabel_1.setBounds(351, 509, 294, 27);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Choose game level :");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		lblNewLabel_2.setBounds(351, 255, 300, 41);
		contentPane.add(lblNewLabel_2);
		// combobox for choosing number of players between 2-4
		final JComboBox comboBox = new JComboBox();
		for(int i=2;i<=4;i++)
		{
			comboBox.addItem(i);

		}
		comboBox.setBounds(671, 514, 103, 27);
		contentPane.add(comboBox);

		EasyRadioButton = new JRadioButton("Easy");
		EasyRadioButton.setBounds(617, 230, 113, 31);
		contentPane.add(EasyRadioButton);
		EasyRadioButton.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		EasyRadioButton.setBackground(new Color(204, 102, 0));

		MeduimRadioButton = new JRadioButton("Medium");
		MeduimRadioButton.setBounds(617, 281, 123, 27);
		contentPane.add(MeduimRadioButton);
		MeduimRadioButton.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		MeduimRadioButton.setBackground(new Color(204, 102, 0));

		HardRadioButton = new JRadioButton("Hard");
		HardRadioButton.setBounds(617, 327, 103, 27);
		contentPane.add(HardRadioButton);
		HardRadioButton.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		HardRadioButton.setBackground(new Color(204, 102, 0));

		// choosing just one radio button , no more!
		ButtonGroup G = new ButtonGroup();
		G.add(EasyRadioButton);
		G.add(MeduimRadioButton);
		G.add(HardRadioButton);
		//Yara
				// ActionListener for EasyRadioButton  -Yara
				EasyRadioButton.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        PlayAudio.playRadioSound();
				        // Any additional actions you want to perform when EasyRadioButton is selected
				    }
				});

				// ActionListener for MeduimRadioButton
				MeduimRadioButton.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        PlayAudio.playRadioSound();
				        // Any additional actions you want to perform when MeduimRadioButton is selected
				    }
				});

				// ActionListener for HardRadioButton
				HardRadioButton.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        PlayAudio.playRadioSound();
				        // Any additional actions you want to perform when HardRadioButton is selected
				    }
				});
		// next button and send information to next frame
		JButton btnNewButton = new JButton("Next>>");

		ImageIcon winIcon2 = new ImageIcon(LevelGame.class.getResource("/View/img/next.png"));
		int winWidth = 170; // Adjusted width based on grid size
		int winHeight = 45;//Adjusted height based on grid size

		// Scale down the size of the image
		Image scaledWinImage2 = winIcon2.getImage().getScaledInstance(winWidth, winHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledWinIcon2 = new ImageIcon(scaledWinImage2);
		btnNewButton = new JButton(scaledWinIcon2);
		btnNewButton.setBounds(961, 794, 154, 41);
		contentPane.add(btnNewButton);

		// when the user click next
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (EasyRadioButton.isSelected()||MeduimRadioButton.isSelected() ||HardRadioButton.isSelected() )
				{
					int numOfPlayers=(Integer)comboBox.getSelectedItem();
					Levels gameLevel;
					if(EasyRadioButton.isSelected())
					{
						gameLevel=Levels.Easy;
					}
					else if(MeduimRadioButton.isSelected())
					{
						gameLevel=Levels.Medium;

					}
					else {
						gameLevel=Levels.Hard;
					}
					// send numofplayer and level game to next frame
					InterPlayersInfoFrame frame=new InterPlayersInfoFrame(numOfPlayers,gameLevel); 
					setVisible(false);
					frame.setVisible(true);
				}
				// when the user doesnt choose a level
				else {
					JOptionPane.showMessageDialog(getContentPane(),"You need to choice game Level");

				}

			}
		});

		// home page icon for the button
		ImageIcon winIcon1 = new ImageIcon(LevelGame.class.getResource("/View/img/hp.png"));
		winWidth = 170; // Adjusted width based on grid size
		winHeight = 45;//Adjusted height based on grid size

		// Scale down the size of the snake image
		Image scaledWinImage1 = winIcon1.getImage().getScaledInstance(winWidth, winHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledWinIcon1 = new ImageIcon(scaledWinImage1);
		JButton btnNewButton_1 = new JButton(scaledWinIcon1);
		btnNewButton_1.setBounds(138, 786, 170, 49);
		// return to home page frame
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frame=new MainFrame(); 
				setVisible(false);
				frame.setVisible(true);

			}
		});


		// icon for level game
		ImageIcon winIcon = new ImageIcon(Winner.class.getResource("/View/img/level.png"));
		winWidth = 350; // Adjusted width based on grid size
		winHeight = 250;//Adjusted height based on grid size

		// Scale down the size of the image
		Image scaledWinImage = winIcon.getImage().getScaledInstance(winWidth, winHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledWinIcon = new ImageIcon(scaledWinImage);

		// Create a JLabel for the scaled image
		JLabel lblNewLabel_4  = new JLabel(scaledWinIcon);
		lblNewLabel_4.setBounds(608, 194, 300, 270);//

		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(true);
	
		ImageIcon icon = new ImageIcon(Winner.class.getResource("/View/img/gamebg.jpg"));
		//Verify image dimensions
		int containerWidth = 1200;
		int containerHeight = 900;
		System.out.println("Container size: " + containerWidth + "x" + containerHeight);
		//Create JLabel with scaled image
		Image scaledImg = icon.getImage().getScaledInstance(containerWidth, containerHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);		
		JLabel lblNewLabel = new JLabel(scaledIcon);
		lblNewLabel.setBounds(0, 0,1200, 891);
		contentPane.add(lblNewLabel);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
