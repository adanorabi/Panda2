package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicRadioButtonUI;

import Enum.Levels;

import java.awt.EventQueue;

import Enum.Levels;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import javax.swing.JButton;
import javax.swing.JComponent;
import Model.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import Model.*;
public class InterPlayersInfoFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JRadioButton redRadioButton;
	private JRadioButton greenRadioButton;
	private JRadioButton blueRadioButton;
	private JRadioButton yRadioButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField2;
	private JRadioButton redRadioButton2;
	private JRadioButton greenRadioButton2;
	private JRadioButton blueRadioButton2;
	private JRadioButton yRadioButton2;
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	private JTextField textField3;
	private JRadioButton redRadioButton3;
	private JRadioButton greenRadioButton3;
	private JRadioButton blueRadioButton3;
	private JRadioButton yRadioButton3;
	private final ButtonGroup buttonGroup3 = new ButtonGroup();
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JTextField textField_1;
	private JLabel lblNewLabel_1_4;
	private JLabel lblNewLabel_10;
	private JRadioButton redRadioButton2_1;
	private JRadioButton greenRadioButton2_1;
	private JRadioButton blueRadioButton2_1;
	private JRadioButton yRadioButton2_1;
	private int Num=2;
	private final ButtonGroup buttonGroup4 = new ButtonGroup();
	private Levels level;
	public InterPlayersInfoFrame(final int NumofPlayers, Levels gameLevel) {
		Num=NumofPlayers;
		level=gameLevel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1106, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("player1 nickname:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(63, 96, 350, 20);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(246, 101, 105, 19);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("player1 color:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(63, 140, 350, 20);
		contentPane.add(lblNewLabel_1_1);

		redRadioButton = new JRadioButton("Red");
		redRadioButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		redRadioButton.setBackground(new Color(173, 216, 230));
		redRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (redRadioButton.isSelected()) {
					redRadioButton.setForeground(Color.RED);
					greenRadioButton.setForeground(Color.black);
					blueRadioButton.setForeground(Color.black);
					yRadioButton.setForeground(Color.black);

					disableAndMarkColorButton(redRadioButton2);
					enableColorButton(greenRadioButton2);
					enableColorButton(blueRadioButton2);
					enableColorButton(yRadioButton2);    
					redRadioButton2.setSelected(false);
					if(NumofPlayers==3) {
						disableAndMarkColorButton(redRadioButton3);
						enableColorButton(greenRadioButton3);
						enableColorButton(blueRadioButton3);
						enableColorButton(yRadioButton3);
						redRadioButton3.setSelected(false);
					}else if(NumofPlayers==4) {
						disableAndMarkColorButton(redRadioButton3);
						enableColorButton(greenRadioButton3);
						enableColorButton(blueRadioButton3);
						enableColorButton(yRadioButton3);
						disableAndMarkColorButton(redRadioButton2_1);
						enableColorButton(greenRadioButton2_1);
						enableColorButton(blueRadioButton2_1);
						enableColorButton(yRadioButton2_1);
						redRadioButton3.setSelected(false);
						redRadioButton2_1.setSelected(false);
					}

				}

			}
		});
		redRadioButton.setBounds(63, 200, 70, 23);
		contentPane.add(redRadioButton);
		buttonGroup.add(redRadioButton);

		greenRadioButton = new JRadioButton("Green");
		greenRadioButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		greenRadioButton.setBackground(new Color(173, 216, 230));
		greenRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (greenRadioButton.isSelected()) {
					greenRadioButton.setForeground((new Color(0, 153, 0)));
					redRadioButton.setForeground(Color.black);
					blueRadioButton.setForeground(Color.black);
					yRadioButton.setForeground(Color.black);
					disableAndMarkColorButton(greenRadioButton2);
					enableColorButton(redRadioButton2);
					enableColorButton(blueRadioButton2);
					enableColorButton(yRadioButton2);

					//   greenRadioButton2.setSelected(false);
					if(NumofPlayers==3) {
						disableAndMarkColorButton(greenRadioButton3);
						enableColorButton(redRadioButton3);
						enableColorButton(blueRadioButton3);
						enableColorButton(yRadioButton3);
						// greenRadioButton3.setSelected(false);
					}
					else if(NumofPlayers==4) {
						disableAndMarkColorButton(greenRadioButton3);
						enableColorButton(redRadioButton3);
						enableColorButton(blueRadioButton3);
						enableColorButton(yRadioButton3);

						disableAndMarkColorButton(greenRadioButton2_1);
						enableColorButton(redRadioButton2_1);
						enableColorButton(blueRadioButton2_1);
						enableColorButton(yRadioButton2_1);
						// greenRadioButton3.setSelected(false);
						//  greenRadioButton2_1.setSelected(false);
					}
				}
			}
		});
		greenRadioButton.setBounds(142, 200, 90, 23);
		contentPane.add(greenRadioButton);
		buttonGroup.add(greenRadioButton);

		blueRadioButton = new JRadioButton("Blue");
		blueRadioButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		blueRadioButton.setBackground(new Color(173, 216, 230));
		blueRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (blueRadioButton.isSelected()) {
					blueRadioButton.setForeground(Color.BLUE);
					greenRadioButton.setForeground(Color.black);
					redRadioButton.setForeground(Color.black);
					yRadioButton.setForeground(Color.black);
					disableAndMarkColorButton(blueRadioButton2);
					enableColorButton(greenRadioButton2);
					enableColorButton(redRadioButton2);
					enableColorButton(yRadioButton2);

					if(NumofPlayers==3) {
						disableAndMarkColorButton(blueRadioButton3);
						enableColorButton(greenRadioButton3);
						enableColorButton(redRadioButton3);
						enableColorButton(yRadioButton3);
					}else if(NumofPlayers==4) {
						disableAndMarkColorButton(blueRadioButton3);
						enableColorButton(greenRadioButton3);
						enableColorButton(redRadioButton3);
						enableColorButton(yRadioButton3);

						disableAndMarkColorButton(blueRadioButton2_1);
						enableColorButton(greenRadioButton2_1);
						enableColorButton(redRadioButton2_1);
						enableColorButton(yRadioButton2_1);
					}
				}
			}
		});
		blueRadioButton.setBounds(246, 200, 70, 23);
		contentPane.add(blueRadioButton);
		buttonGroup.add(blueRadioButton);
		yRadioButton = new JRadioButton("yellow");
		yRadioButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		yRadioButton.setBackground(new Color(173, 216, 230));
		yRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (yRadioButton.isSelected()) {
					yRadioButton.setForeground(Color.YELLOW);
					greenRadioButton.setForeground(Color.black);
					blueRadioButton.setForeground(Color.black);
					redRadioButton.setForeground(Color.black);

					disableAndMarkColorButton(yRadioButton2);
					enableColorButton(greenRadioButton2);
					enableColorButton(redRadioButton2);
					enableColorButton(blueRadioButton2);
					if(NumofPlayers==3) {
						disableAndMarkColorButton(yRadioButton3);
						enableColorButton(greenRadioButton3);
						enableColorButton(redRadioButton3);
						enableColorButton(blueRadioButton3);
					}
					else  if(NumofPlayers==4) {
						disableAndMarkColorButton(yRadioButton2_1);
						enableColorButton(greenRadioButton2_1);
						enableColorButton(redRadioButton2_1);
						enableColorButton(blueRadioButton2_1);
						disableAndMarkColorButton(yRadioButton3);
						enableColorButton(greenRadioButton3);
						enableColorButton(redRadioButton3);
						enableColorButton(blueRadioButton3);
					}


				}
			}
		});
		yRadioButton.setBounds(333, 200, 100, 23);
		contentPane.add(yRadioButton);
		buttonGroup.add(yRadioButton);

		lblNewLabel_2 = new JLabel("");


		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/View/img/wpanda.png")));;
		lblNewLabel_2.setBounds(723, 93, 100, 130);
		contentPane.add(lblNewLabel_2);
		
	//add actionl func

}
