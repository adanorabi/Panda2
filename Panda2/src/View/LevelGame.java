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

public class LevelGame extends JFrame  implements ActionListener {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JRadioButton EasyRadioButton;
	private JRadioButton MeduimRadioButton;
	private JRadioButton HardRadioButton;

	/**
	 * Create the frame.
	 */
	public LevelGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1106, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Choose players numbers :");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		lblNewLabel_1.setBounds(261, 323, 294, 27);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Choose game level :");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		lblNewLabel_2.setBounds(307, 49, 300, 41);
		contentPane.add(lblNewLabel_2);
		// combobox for choosing nimber of players
		final JComboBox comboBox = new JComboBox();
        for(int i=2;i<=4;i++)
    {
        	comboBox.addItem(i);
    
    }
		comboBox.setBounds(565, 323, 94, 21);
		contentPane.add(comboBox);

		EasyRadioButton = new JRadioButton("Easy");
		EasyRadioButton.setBounds(442, 129, 113, 21);
		contentPane.add(EasyRadioButton);
		EasyRadioButton.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		EasyRadioButton.setBackground(new Color(204, 102, 0));

		MeduimRadioButton = new JRadioButton("Medium");
		MeduimRadioButton.setBounds(442, 163, 123, 21);
		contentPane.add(MeduimRadioButton);
		MeduimRadioButton.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		MeduimRadioButton.setBackground(new Color(204, 102, 0));
		
		HardRadioButton = new JRadioButton("Hard");
		HardRadioButton.setBounds(442, 206, 103, 21);
		contentPane.add(HardRadioButton);
		HardRadioButton.setFont(new Font("Trebuchet MS", Font.ITALIC, 20));
		HardRadioButton.setBackground(new Color(204, 102, 0));
		
		// choosing just one radio button , no more!
		ButtonGroup G = new ButtonGroup();
		G.add(EasyRadioButton);
		G.add(MeduimRadioButton);
		G.add(HardRadioButton);
		// next button and send information to next frame
		JButton btnNewButton = new JButton("Next>>");
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/View/img/next.png")));
		btnNewButton.setBounds(926, 544, 94, 27);
		contentPane.add(btnNewButton);
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
    			InterPlayersInfoFrame frame=new InterPlayersInfoFrame(numOfPlayers,gameLevel); 
    					setVisible(false);
    					frame.setVisible(true);
            	}
            	else {
					JOptionPane.showMessageDialog(getContentPane(),"You need to choice game Level");

            	}
            	
            }
        });
		
		JButton btnNewButton_1 = new JButton("<<home page");
		btnNewButton_1.setIcon(new ImageIcon(LevelGame.class.getResource("/View/img/hp.png")));
	//	btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("/imgs/MainBG.png")));
		btnNewButton_1.setBounds(167, 530, 177, 27);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	MainFrame frame=new MainFrame(); 
				setVisible(false);
				frame.setVisible(true);

            }
        });
		
		
		ImageIcon winIcon = new ImageIcon(Winner.class.getResource("/View/img/level.png"));
		int winWidth = 250; // Adjusted width based on grid size
		int winHeight = 200;//Adjusted height based on grid size

		// Scale down the size of the snake image
		Image scaledWinImage = winIcon.getImage().getScaledInstance(winWidth, winHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledWinIcon = new ImageIcon(scaledWinImage);

		// Create a JLabel for the scaled snake image
		JLabel lblNewLabel_4  = new JLabel(scaledWinIcon);
		lblNewLabel_4.setBounds(392, 80, 300, 250);//

		// Add the snake label to the content pane
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(true);
		//contentPane.setComponentZOrder(lblNewLabel_4, 0);    
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/View/img/gamebg.jpg")));
		lblNewLabel.setBounds(10, -17, 1106, 645);
		contentPane.add(lblNewLabel);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
