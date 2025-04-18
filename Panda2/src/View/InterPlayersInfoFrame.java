package View;

import java.awt.EventQueue;
import Controller.*;
import Enum.Levels;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import javax.swing.JButton;
import javax.swing.JComponent;
import Enum.*;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import Model.*;
public class InterPlayersInfoFrame extends JFrame implements ActionListener{
	/*********************************************ADAN********************************************************/
	  private final Map<JRadioButton, ButtonGroup> buttonGroupMap = new HashMap<JRadioButton, ButtonGroup>();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField;
	private JRadioButton redRadioButton;
	private JRadioButton greenRadioButton;
	private JRadioButton blueRadioButton;
	private JRadioButton yRadioButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JTextField textField2;
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
	public InterPlayersInfoFrame(final int NumofPlayers, Levels gameLevel) {/*Gitting the player number and the choosen level-Adan*/
		  
		Num=NumofPlayers;
		level=gameLevel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 70,1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			/*creating a name field and color group for player 1- Adan*/
		JLabel lblNewLabel_1 = new JLabel("player1 nickname:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_1.setBounds(83, 166, 350, 20);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(266, 166, 123, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("player1 color:");//jlable for color choosing -Adan
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(83, 225, 350, 20);
		contentPane.add(lblNewLabel_1_1);

		redRadioButton = new JRadioButton("Red");//adding red color
		redRadioButton.setActionCommand("Red");
		redRadioButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		redRadioButton.setBackground(new Color(173, 216, 230));
		redRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (redRadioButton.isSelected()) {
					redRadioButton.setForeground(Color.RED);//change the button for red color-Adan
					greenRadioButton.setForeground(Color.black);//if there was a chosen color before make it black-Adan
					blueRadioButton.setForeground(Color.black);
					yRadioButton.setForeground(Color.black);

					/*disable the other players from choosing red color*/
					disableAndMarkColorButton(redRadioButton2);
					enableColorButton(greenRadioButton2);
					enableColorButton(blueRadioButton2);
					enableColorButton(yRadioButton2);    
					 System.out.println(buttonGroup2.getSelection());
					 
					//buttonGroup2.clearSelection();
					if(NumofPlayers==3) {//check if the player number is 3 and disable the red color for player 3-Adan
						disableAndMarkColorButton(redRadioButton3);
						enableColorButton(greenRadioButton3);
						enableColorButton(blueRadioButton3);
						enableColorButton(yRadioButton3);
						redRadioButton3.setSelected(false);
					}else if(NumofPlayers==4) {//check if the player number is 4 and disable the red color for player 3 and 4-Adan
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
		redRadioButton.setBounds(83, 282, 70, 23);
		contentPane.add(redRadioButton);
		buttonGroup.add(redRadioButton);
/*do the same color check for green-Adan*/
		greenRadioButton = new JRadioButton("Green");
		greenRadioButton.setActionCommand("Green");
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
						disableAndMarkColorButton(greenRadioButton3);//disaple color green to be choosen by the others-Adan
						enableColorButton(redRadioButton3);
						enableColorButton(blueRadioButton3);
						enableColorButton(yRadioButton3);
						// greenRadioButton3.setSelected(false);
					}
					else if(NumofPlayers==4) {
						disableAndMarkColorButton(greenRadioButton3);//disaple color green to be choosen by the others-Adan
						enableColorButton(redRadioButton3);
						enableColorButton(blueRadioButton3);
						enableColorButton(yRadioButton3);

						disableAndMarkColorButton(greenRadioButton2_1);//disaple color green to be choosen by the others-Adan
						enableColorButton(redRadioButton2_1);
						enableColorButton(blueRadioButton2_1);
						enableColorButton(yRadioButton2_1);
						// greenRadioButton3.setSelected(false);
						//  greenRadioButton2_1.setSelected(false);
					}
				}
			}
		});
		greenRadioButton.setBounds(164, 282, 102, 23);
		contentPane.add(greenRadioButton);
		buttonGroup.add(greenRadioButton);
		/*do the same color check for blue-Adan*/
		blueRadioButton = new JRadioButton("Blue");
		blueRadioButton.setActionCommand("Blue");
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
						disableAndMarkColorButton(blueRadioButton3);//disaple color blue to be choosen by the others-Adan
						enableColorButton(greenRadioButton3);
						enableColorButton(redRadioButton3);
						enableColorButton(yRadioButton3);
					}else if(NumofPlayers==4) {
						disableAndMarkColorButton(blueRadioButton3);//disaple color blue to be choosen by the others-Adan
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
		blueRadioButton.setBounds(266, 282, 100, 23);
		contentPane.add(blueRadioButton);
		buttonGroup.add(blueRadioButton);
		/*do the same color check for green-Yellow*/
		yRadioButton = new JRadioButton("Yellow");
		yRadioButton.setActionCommand("Yellow");
		yRadioButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		yRadioButton.setBackground(new Color(173, 216, 230));
		yRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (yRadioButton.isSelected()) {
					yRadioButton.setForeground(Color.YELLOW);
					greenRadioButton.setForeground(Color.black);
					blueRadioButton.setForeground(Color.black);
					redRadioButton.setForeground(Color.black);

					disableAndMarkColorButton(yRadioButton2);//disaple color yellow to be choosen by the others-Adan
					enableColorButton(greenRadioButton2);
					enableColorButton(redRadioButton2);
					enableColorButton(blueRadioButton2);
					if(NumofPlayers==3) {
						disableAndMarkColorButton(yRadioButton3);//disaple color yellow to be choosen by the others-Adan
						enableColorButton(greenRadioButton3);
						enableColorButton(redRadioButton3);
						enableColorButton(blueRadioButton3);
					}
					else  if(NumofPlayers==4) {
						disableAndMarkColorButton(yRadioButton2_1);//disaple color yellow to be choosen by the others-Adan
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
		yRadioButton.setBounds(368, 282, 116, 23);
		contentPane.add(yRadioButton);
		buttonGroup.add(yRadioButton);

		lblNewLabel_2 = new JLabel("");


		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/View/img/wpanda.png")));//set the panda icon- Adan
		lblNewLabel_2.setBounds(731, 166, 100, 130);
		contentPane.add(lblNewLabel_2);
		//getting the player 2 info-Adan
		JLabel lblNewLabel_2 = new JLabel("player2 nickname:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_2.setBounds(600, 166, 350, 20);
		contentPane.add(lblNewLabel_2);

		textField2 = new JTextField();
		textField2.setBounds(780, 166, 116, 29);
		contentPane.add(textField2);
		textField2.setColumns(10);

		JLabel lblNewLabel_1_2 = new JLabel("player2 color:");//color group for player 2-Adan
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_1_2.setBounds(600, 225, 400, 20);
		contentPane.add(lblNewLabel_1_2);

		redRadioButton2 = new JRadioButton("Red");
		redRadioButton2.setActionCommand("Red");
		redRadioButton2.setFont(new Font("Tahoma", Font.BOLD, 20));
		redRadioButton2.setBackground(new Color(173, 216, 230));
		redRadioButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (redRadioButton2.isSelected()) {
					redRadioButton2.setForeground(Color.RED);//make the choosen button red
					greenRadioButton2.setForeground(Color.black);
					blueRadioButton2.setForeground(Color.black);
					yRadioButton2.setForeground(Color.black);
					if(NumofPlayers>=3) {
						disableAndMarkColorButton(redRadioButton3);
						if(NumofPlayers==4)
							disableAndMarkColorButton(redRadioButton2_1);
					}
					if(greenRadioButton.isSelected()&&NumofPlayers>=3) {//disable the color for player 3 and 4 if they are clicked by player 1 and 2
						disableAndMarkColorButton(greenRadioButton3);
						enableColorButton(blueRadioButton3);
						enableColorButton(yRadioButton3);
						greenRadioButton3.setSelected(false);
						if(NumofPlayers==4) {//disable the color for player 3 if they are clicked by player 1 and 2-Adan
							disableAndMarkColorButton(greenRadioButton2_1);
							enableColorButton(blueRadioButton2_1);
							enableColorButton(yRadioButton2_1);
							greenRadioButton2_1.setSelected(false);
						}
					}else if(blueRadioButton.isSelected()&&NumofPlayers>=3) {//disaple color blue to be choosen by the others-Adan
						if(NumofPlayers==4) {
							disableAndMarkColorButton(blueRadioButton2_1);
							enableColorButton(greenRadioButton2_1);
							enableColorButton(yRadioButton2_1);
							blueRadioButton2_1.setSelected(false);
						}
						disableAndMarkColorButton(blueRadioButton3);
						enableColorButton(greenRadioButton3);
						enableColorButton(yRadioButton3);
						blueRadioButton3.setSelected(false);
					}else if(yRadioButton.isSelected()&&NumofPlayers>=3) {
						if(NumofPlayers==4) {
							disableAndMarkColorButton(yRadioButton2_1);//disaple color yellow to be choosen by the others-Adan
							enableColorButton(greenRadioButton2_1);
							enableColorButton(blueRadioButton2_1);
							yRadioButton2_1.setSelected(false);
						}
						disableAndMarkColorButton(yRadioButton3);
						enableColorButton(greenRadioButton3);
						enableColorButton(blueRadioButton3);
						yRadioButton3.setSelected(false);
					}

				}
			}
		});
		redRadioButton2.setBounds(580, 282, 90, 23);
		contentPane.add(redRadioButton2);
		buttonGroup2.add(redRadioButton2);
/*same color syncronization*/
		greenRadioButton2 = new JRadioButton("Green");
		greenRadioButton2.setActionCommand("Green");
		greenRadioButton2.setFont(new Font("Tahoma", Font.BOLD, 20));
		greenRadioButton2.setBackground(new Color(173, 216, 230));
		greenRadioButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (greenRadioButton2.isSelected()) {
					redRadioButton2.setForeground(Color.black);
					greenRadioButton2.setForeground((new Color(0, 153, 0)));
					blueRadioButton2.setForeground(Color.black);
					yRadioButton2.setForeground(Color.black);
					if(NumofPlayers>=3) {
						disableAndMarkColorButton(greenRadioButton3);//green color desapled if player 1 choosed it-Adan
						if(NumofPlayers==4)
							disableAndMarkColorButton(greenRadioButton2_1);
					}
					if(redRadioButton.isSelected()&&NumofPlayers>=3) {//done
						disableAndMarkColorButton(redRadioButton3);
						enableColorButton(blueRadioButton3);
						enableColorButton(yRadioButton3);
						redRadioButton3.setSelected(false);
						if(NumofPlayers==4) {
							disableAndMarkColorButton(redRadioButton2_1);//red color desapled if player 2 choosed it-Adan
							enableColorButton(blueRadioButton2_1);
							enableColorButton(yRadioButton2_1);
							redRadioButton2_1.setSelected(false);
						}
					}else if(blueRadioButton.isSelected()&&NumofPlayers>=3) {
						if(NumofPlayers==4) {
							disableAndMarkColorButton(blueRadioButton2_1);//blue color desapled if player 2 choosed it-Adan
							enableColorButton(redRadioButton2_1);
							enableColorButton(yRadioButton2_1);
							blueRadioButton2_1.setSelected(false);
						}
						disableAndMarkColorButton(blueRadioButton3);
						enableColorButton(redRadioButton3);
						enableColorButton(yRadioButton3);
						blueRadioButton3.setSelected(false);
					}else if(yRadioButton.isSelected()&&NumofPlayers>=3) {
						if(NumofPlayers==4) {//yellow color desapled if player 2 choosed it-Adan
							disableAndMarkColorButton(yRadioButton2_1);
							enableColorButton(redRadioButton2_1);
							enableColorButton(blueRadioButton2_1);
							yRadioButton2_1.setSelected(false);
						}
						disableAndMarkColorButton(yRadioButton3);
						enableColorButton(redRadioButton3);
						enableColorButton(blueRadioButton3);
						yRadioButton3.setSelected(false);
					}

				}
			}
		});
		greenRadioButton2.setBounds(680, 282, 105, 23);
		contentPane.add(greenRadioButton2);
		buttonGroup2.add(greenRadioButton2);

		blueRadioButton2 = new JRadioButton("Blue");
		blueRadioButton2.setActionCommand("Blue");
		blueRadioButton2.setFont(new Font("Tahoma", Font.BOLD, 20));
		blueRadioButton2.setBackground(new Color(173, 216, 230));
		blueRadioButton2.addActionListener(new ActionListener() {//if the cooden color is blue for player 2
			public void actionPerformed(ActionEvent e) {
				if (blueRadioButton2.isSelected()) {
					redRadioButton2.setForeground(Color.BLACK);
					greenRadioButton2.setForeground(Color.BLACK);
					blueRadioButton2.setForeground(Color.BLUE);//make the button blue
					yRadioButton2.setForeground(Color.BLACK);

					// Disable blue for player 3 and player 4
					if (NumofPlayers >= 3) {
						disableAndMarkColorButton(blueRadioButton3);
						if (NumofPlayers == 4) {
							disableAndMarkColorButton(blueRadioButton2_1);
						}
					}

					// Handle color buttons for player 3 and player 4 when NumofPlayers is greater than or equal to 3
					if (redRadioButton.isSelected() && NumofPlayers >= 3) {
						disableAndMarkColorButton(redRadioButton3);
						enableColorButton(greenRadioButton3); // Change to greenRadioButton3
						enableColorButton(yRadioButton3);
						redRadioButton3.setSelected(false);
						if (NumofPlayers == 4) {
							disableAndMarkColorButton(redRadioButton2_1);//red color desapled if player 1 choosed it-Adan
							enableColorButton(greenRadioButton2_1);
							enableColorButton(yRadioButton2_1);
							redRadioButton2_1.setSelected(false);
						}
					} else if (greenRadioButton.isSelected() && NumofPlayers >= 3) {
						if (NumofPlayers == 4) {
							disableAndMarkColorButton(greenRadioButton2_1);//green color desapled if player 2 choosed it-Adan
							enableColorButton(redRadioButton2_1);
							enableColorButton(yRadioButton2_1);
							blueRadioButton2_1.setSelected(false);
						}
						disableAndMarkColorButton(greenRadioButton3);
						enableColorButton(redRadioButton3);
						enableColorButton(yRadioButton3);
						blueRadioButton3.setSelected(false);
					} else if (yRadioButton.isSelected() && NumofPlayers >= 3) {
						if (NumofPlayers == 4) {
							disableAndMarkColorButton(yRadioButton2_1);//yellow color desapled if player 2 choosed it-Adan
							enableColorButton(greenRadioButton2_1);
							enableColorButton(redRadioButton2_1);
							yRadioButton2_1.setSelected(false);
						}
						disableAndMarkColorButton(yRadioButton3);
						enableColorButton(greenRadioButton3);
						enableColorButton(redRadioButton3);
						blueRadioButton3.setSelected(false);
					}
				}
			}

		});

		blueRadioButton2.setBounds(790, 282, 90, 23);
		contentPane.add(blueRadioButton2);
		buttonGroup2.add(blueRadioButton2);
		yRadioButton2 = new JRadioButton("Yellow");
		yRadioButton2.setActionCommand("Yellow");
		yRadioButton2.setFont(new Font("Tahoma", Font.BOLD, 20));
		yRadioButton2.setBackground(new Color(173, 216, 230));
		yRadioButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//if the choosen color is yellow-ADAN
				if (yRadioButton2.isSelected()) {
					yRadioButton2.setForeground(Color.YELLOW);//make the color yellow-ADAN
					greenRadioButton2.setForeground(Color.black);
					blueRadioButton2.setForeground(Color.black);
					redRadioButton2.setForeground(Color.black);

					if(NumofPlayers>=3) {
						disableAndMarkColorButton(yRadioButton3);//diable other player from choosing yellow
						if(NumofPlayers==4) {
							disableAndMarkColorButton(yRadioButton2_1);
							System.out.println("yellow");
						}
					}
					if(redRadioButton.isSelected()&&NumofPlayers>=3) {//red color desapled if player 1 choosed it-Adan
						disableAndMarkColorButton(redRadioButton3);
						enableColorButton(blueRadioButton3);
						enableColorButton(greenRadioButton3);
						redRadioButton3.setSelected(false);
						if(NumofPlayers==4) {
							disableAndMarkColorButton(redRadioButton2_1);
							enableColorButton(blueRadioButton2_1);
							enableColorButton(greenRadioButton2_1);
							redRadioButton2_1.setSelected(false);
						}
					}

					if(greenRadioButton.isSelected()&&NumofPlayers>=3) {//green color desapled if player 1 choosed it-Adan
						disableAndMarkColorButton(greenRadioButton3);
						enableColorButton(blueRadioButton3);
						enableColorButton(redRadioButton3);
						greenRadioButton3.setSelected(false);
						if(NumofPlayers==4) {
							disableAndMarkColorButton(greenRadioButton2_1);
							enableColorButton(blueRadioButton2_1);
							enableColorButton(redRadioButton2_1);
							greenRadioButton2_1.setSelected(false);
						}
					}

					else if(blueRadioButton.isSelected()&&NumofPlayers>=3) {//blue color desapled if player 1 choosed it-Adan
						if(NumofPlayers==4) {
							disableAndMarkColorButton(blueRadioButton2_1);
							enableColorButton(greenRadioButton2_1);
							enableColorButton(redRadioButton2_1);
							blueRadioButton2_1.setSelected(false);
						}
						disableAndMarkColorButton(blueRadioButton3);
						enableColorButton(greenRadioButton3);
						enableColorButton(redRadioButton3);
						blueRadioButton3.setSelected(false);
					}

				}
			}
		});
		yRadioButton2.setBounds(888, 282, 123, 23);
		contentPane.add(yRadioButton2);
		buttonGroup2.add(yRadioButton2);

		lblNewLabel_2 = new JLabel("");


		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/View/img/wpanda.png")));//setting the panda icon-Adan

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(383, 225, 900, 13);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(613, -14, 100, 130);
		contentPane.add(lblNewLabel_2_1);
		lblNewLabel_2.setBounds(204, 175, 100, 130);
		contentPane.add(lblNewLabel_2);
		//*********************************************player3
		if(NumofPlayers==3 || NumofPlayers==4) {//check if the number of player are more than 3-Adan
			JLabel lblNewLabel_3 = new JLabel("player3 nickname:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 20));
			lblNewLabel_3.setBounds(83, 360, 350, 20);
			contentPane.add(lblNewLabel_3);

			textField3 = new JTextField();//test field for player 3 -ADAN
			textField3.setBounds(270, 360, 116, 29);
			contentPane.add(textField3);
			textField3.setColumns(10);

			JLabel lblNewLabel_1_3 = new JLabel("player3 color:");//payer 3 color 
			lblNewLabel_1_3.setFont(new Font("Tahoma", Font.ITALIC, 20));
			lblNewLabel_1_3.setBounds(88, 420, 400, 20);
			contentPane.add(lblNewLabel_1_3);

			redRadioButton3 = new JRadioButton("Red");
			redRadioButton3.setActionCommand("Red");
			redRadioButton3.setFont(new Font("Tahoma", Font.BOLD, 20));
			redRadioButton3.setBackground(new Color(173, 216, 230));
			redRadioButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {//if player 3 choosed color red then dont allow player 4 to choose it-Adan
					if (redRadioButton3.isSelected()) {
						redRadioButton3.setForeground(Color.RED);//MAKE THE COLOR RED
						greenRadioButton3.setForeground(Color.black);
						blueRadioButton3.setForeground(Color.black);
						yRadioButton3.setForeground(Color.black);
						
						System.out.println(NumofPlayers);
						if(NumofPlayers==4) {//disaple player 4 from choosing the choosed colors-Adan
							disableAndMarkColorButton(redRadioButton2_1);
							enableColorButton(blueRadioButton2_1);
							enableColorButton(yRadioButton2_1);
							enableColorButton(greenRadioButton2_1);
						if (greenRadioButton2.isSelected()) {/*check IF THE green COLOR IS CHOOSEN DISAPLE IT FOR THE LAST PLAYER*/
							System.out.println("green and red ");
							disableAndMarkColorButton(greenRadioButton2_1);
							enableColorButton(blueRadioButton2_1);
							enableColorButton(yRadioButton2_1);
							greenRadioButton2_1.setSelected(false);
							if(blueRadioButton.isSelected()) {

								disableAndMarkColorButton(blueRadioButton2_1);//DINT ALLAW PLAYER4 FROM CHOOSING WHAT PLAYER1 AND 2 CHOOSED
								
								enableColorButton(yRadioButton2_1);
								blueRadioButton2_1.setSelected(false);
											
						}

							else if(yRadioButton.isSelected()) {

								disableAndMarkColorButton(yRadioButton2_1);
								
								enableColorButton(blueRadioButton2_1);
								yRadioButton2_1.setSelected(false);
									
							}
						}
						else if(blueRadioButton2.isSelected()) {//if blue is choosen by player 3 dont allow player 4 to choose it-Adan

							disableAndMarkColorButton(blueRadioButton2_1);
							enableColorButton(greenRadioButton2_1);
							enableColorButton(yRadioButton2_1);
							blueRadioButton2_1.setSelected(false);
							 if(greenRadioButton.isSelected()) {

									disableAndMarkColorButton(greenRadioButton2_1);
									
									enableColorButton(yRadioButton2_1);
									blueRadioButton2_1.setSelected(false);
									
									
									
								}

								else if(yRadioButton.isSelected()) {

									disableAndMarkColorButton(yRadioButton2_1);
									
									enableColorButton(greenRadioButton2_1);
									yRadioButton2_1.setSelected(false);
										
								}
							
							
						}

						else if(yRadioButton.isSelected()) {//if yellow is choosen by player 3 dont allow player 4 to choose it-Adan

							disableAndMarkColorButton(yRadioButton2_1);
							enableColorButton(greenRadioButton2_1);
							enableColorButton(blueRadioButton2_1);
							yRadioButton2_1.setSelected(false);
							 if(greenRadioButton.isSelected()) {

									disableAndMarkColorButton(greenRadioButton2_1);//GREEN COLOR DISABLED FOR PLAYER 4
									
									enableColorButton(blueRadioButton2_1);
									blueRadioButton2_1.setSelected(false);
									
									
									
								}

								else if(blueRadioButton.isSelected()) {

									disableAndMarkColorButton(blueRadioButton2_1);//BLUE COLOR DISABLED FOR PLAYER 4
									
									enableColorButton(greenRadioButton2_1);
									yRadioButton2_1.setSelected(false);
										
								}
							
							
							
						}



					}
					}


				}
			});

			redRadioButton3.setBounds(83, 470, 70, 23);
			contentPane.add(redRadioButton3);
			buttonGroup3.add(redRadioButton3);

			greenRadioButton3 = new JRadioButton("Green");
			greenRadioButton3.setActionCommand("Green");
			greenRadioButton3.setFont(new Font("Tahoma", Font.BOLD, 20));
			greenRadioButton3.setBackground(new Color(173, 216, 230));
			greenRadioButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (greenRadioButton3.isSelected()) {
						greenRadioButton3.setForeground((new Color(0, 153, 0)));//GREEN COLOR FOR PLAYER 3
						redRadioButton3.setForeground(Color.black);
						blueRadioButton3.setForeground(Color.black);
						yRadioButton3.setForeground(Color.black);
						
						
						if(NumofPlayers==4) {//CHECK IF THE PLAYER NUMBER IS 4
							disableAndMarkColorButton(greenRadioButton2_1);
							enableColorButton(blueRadioButton2_1);
							enableColorButton(yRadioButton2_1);
							enableColorButton(redRadioButton2_1);
						if (redRadioButton2.isSelected()) {/*check red AND DISAPLE IT FOR PLAYER 4 IF IT WAS CHOOSEN*/
							
							disableAndMarkColorButton(redRadioButton2_1);
							enableColorButton(blueRadioButton2_1);
							enableColorButton(yRadioButton2_1);
							
							if(blueRadioButton.isSelected()) {/*check BLUE AND DISAPLE IT FOR PLAYER 4 IF IT WAS CHOOSEN*/

								disableAndMarkColorButton(blueRadioButton2_1);
								
								enableColorButton(yRadioButton2_1);
								blueRadioButton2_1.setSelected(false);
											
						}

							else if(yRadioButton.isSelected()) {/*check YELLOW AND DISAPLE IT FOR PLAYER 4 IF IT WAS CHOOSEN*/

								disableAndMarkColorButton(yRadioButton2_1);
								
								enableColorButton(blueRadioButton2_1);
								yRadioButton2_1.setSelected(false);
									
							}
						}
						else if(blueRadioButton2.isSelected()) {

							disableAndMarkColorButton(blueRadioButton2_1);
							enableColorButton(redRadioButton2_1);
							enableColorButton(yRadioButton2_1);
							blueRadioButton2_1.setSelected(false);
							 if(redRadioButton.isSelected()) {

									disableAndMarkColorButton(redRadioButton2_1);/*check red AND DISAPLE IT FOR PLAYER 4 IF IT WAS CHOOSEN-ADAN*/
									
									enableColorButton(yRadioButton2_1);
									blueRadioButton2_1.setSelected(false);
									
									
									
								}

								else if(yRadioButton.isSelected()) {

									disableAndMarkColorButton(yRadioButton2_1);/*check YELLOW AND DISAPLE IT FOR PLAYER 4 IF IT WAS CHOOSEN-ADAN*/
									
									enableColorButton(redRadioButton2_1);
									yRadioButton2_1.setSelected(false);
										
								}
							
							
						}

						else if(yRadioButton.isSelected()) {

							disableAndMarkColorButton(yRadioButton2_1);/*check YELLOW AND DISAPLE IT FOR PLAYER 4 IF IT WAS CHOOSEN-ADAN*/
							yRadioButton2_1.setSelected(false);
							 if(redRadioButton.isSelected()) {

									disableAndMarkColorButton(redRadioButton2_1);/*check red AND DISAPLE IT FOR PLAYER 4 IF IT WAS CHOOSEN-ADAN*/
									
									enableColorButton(blueRadioButton2_1);
									blueRadioButton2_1.setSelected(false);
									
									
									
								}

								else if(blueRadioButton.isSelected()) {/*check BLUE AND DISAPLE IT FOR PLAYER 4 IF IT WAS CHOOSEN-ADAN*/

									disableAndMarkColorButton(blueRadioButton2_1);
									
									enableColorButton(redRadioButton2_1);
									yRadioButton2_1.setSelected(false);
										
								}
							
							
							
						}



					}
					}
				}
			});
			greenRadioButton3.setBounds(162, 470, 102, 23);//SETTING GREEN BUTTON-ADAN
			contentPane.add(greenRadioButton3);
			buttonGroup3.add(greenRadioButton3);

			blueRadioButton3 = new JRadioButton("Blue");//CREATING BLUE BUTTON FOR PLAYER 3
			blueRadioButton3.setActionCommand("Blue");
			blueRadioButton3.setFont(new Font("Tahoma", Font.BOLD, 20));
			blueRadioButton3.setBackground(new Color(173, 216, 230));
			blueRadioButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (blueRadioButton3.isSelected()) {
						blueRadioButton3.setForeground(Color.BLUE);//IF BLUE WAS CHOOSEN BY PLAYER 3 MAKE IT BLUR COLOR
						greenRadioButton3.setForeground(Color.black);
						redRadioButton3.setForeground(Color.black);
						yRadioButton3.setForeground(Color.black);

						
						if(NumofPlayers==4) {
							disableAndMarkColorButton(blueRadioButton2_1);//DIABLE PLAYER 4 FROM CHOOSING BLUE
							enableColorButton(redRadioButton2_1);
							enableColorButton(yRadioButton2_1);
							enableColorButton(greenRadioButton2_1);
						if (redRadioButton2.isSelected()) {/*check IF red WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/
							
							disableAndMarkColorButton(redRadioButton2_1);
							enableColorButton(greenRadioButton2_1);
							enableColorButton(yRadioButton2_1);
							redRadioButton2_1.setSelected(false);
							if(greenRadioButton.isSelected()) {

								disableAndMarkColorButton(greenRadioButton2_1);/*check IF GREEN WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/
								
								enableColorButton(yRadioButton2_1);
								greenRadioButton2_1.setSelected(false);
											
						}else if(yRadioButton.isSelected()) {/*check IF YELLOW WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/

							disableAndMarkColorButton(yRadioButton2_1);
							
							enableColorButton(greenRadioButton2_1);
							yRadioButton2_1.setSelected(false);
								
						}
						}
							if (greenRadioButton2.isSelected()) {/*check green*/
								
								disableAndMarkColorButton(greenRadioButton2_1);
								enableColorButton(redRadioButton2_1);
								enableColorButton(yRadioButton2_1);
								greenRadioButton2_1.setSelected(false);
								if(redRadioButton.isSelected()) {

									disableAndMarkColorButton(redRadioButton2_1);/*check IF RED WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/
									
									enableColorButton(yRadioButton2_1);
									blueRadioButton2_1.setSelected(false);
												
							}

								else if(yRadioButton.isSelected()) {

									disableAndMarkColorButton(yRadioButton2_1);/*check IF YELLOW WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/
									
									enableColorButton(redRadioButton2_1);
									yRadioButton2_1.setSelected(false);
										
								}
							}

				
						

						else if(yRadioButton.isSelected()) {

							disableAndMarkColorButton(yRadioButton2_1);/*check IF YELLOW WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/
							yRadioButton2_1.setSelected(false);
							 if(redRadioButton.isSelected()) {

									disableAndMarkColorButton(redRadioButton2_1);/*check IF RED WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/
									
									enableColorButton(greenRadioButton2_1);
									blueRadioButton2_1.setSelected(false);
									
									
									
								}

								else if(greenRadioButton.isSelected()) {

									disableAndMarkColorButton(greenRadioButton2_1);/*check IF GREEN WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/
									
									enableColorButton(redRadioButton2_1);
									yRadioButton2_1.setSelected(false);
										
								}
							
							
							
						}



					
					
					}
				
					}}
			});
			blueRadioButton3.setBounds(276, 470,100, 23);
			contentPane.add(blueRadioButton3);
			buttonGroup3.add(blueRadioButton3);
			yRadioButton3 = new JRadioButton("Yellow");
			yRadioButton3.setActionCommand("Yellow");
			yRadioButton3.setFont(new Font("Tahoma", Font.BOLD, 20));
			yRadioButton3.setBackground(new Color(173, 216, 230));
			yRadioButton3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (yRadioButton3.isSelected()) {
						yRadioButton3.setForeground(Color.YELLOW);//SET THE BUTTTON IN YELLOW COLOR
						greenRadioButton3.setForeground(Color.black);
						blueRadioButton3.setForeground(Color.black);
						redRadioButton3.setForeground(Color.black);
						
						
						if(NumofPlayers==4) {
							disableAndMarkColorButton(yRadioButton2_1);//DISAPLE PLAYER 4 FROM CHOOSING YELLOW-ADAN
							enableColorButton(blueRadioButton2_1);
							enableColorButton(redRadioButton2_1);
							enableColorButton(greenRadioButton2_1);
						if (redRadioButton2.isSelected()) {/*check red*/
							
							disableAndMarkColorButton(redRadioButton2_1);/*check IF RED WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/
							enableColorButton(greenRadioButton2_1);
							enableColorButton(blueRadioButton2_1);
							redRadioButton2_1.setSelected(false);
							if(greenRadioButton.isSelected()) {

								disableAndMarkColorButton(greenRadioButton2_1);/*check IF GREEN WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/
								
								enableColorButton(blueRadioButton2_1);
								greenRadioButton2_1.setSelected(false);
											
						}else if(blueRadioButton.isSelected()) {/*check IF  BLUE WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/

							disableAndMarkColorButton(blueRadioButton2_1);
							
							enableColorButton(greenRadioButton2_1);
							blueRadioButton2_1.setSelected(false);
								
						}
						}
							if (greenRadioButton2.isSelected()) {/*check green*/
								
								disableAndMarkColorButton(greenRadioButton2_1);/*check IF GREEN WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/
								enableColorButton(redRadioButton2_1);
								enableColorButton(blueRadioButton2_1);
								greenRadioButton2_1.setSelected(false);
								if(redRadioButton.isSelected()) {

									disableAndMarkColorButton(redRadioButton2_1);/*check IF RED WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/
									
									enableColorButton(blueRadioButton2_1);
									redRadioButton2_1.setSelected(false);
												
							}

								else if(blueRadioButton.isSelected()) {

									disableAndMarkColorButton(blueRadioButton2_1);/*check IF BLUE WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/
									
									enableColorButton(redRadioButton2_1);
									redRadioButton2_1.setSelected(false);
										
								}
							}

				
						

						else if(blueRadioButton.isSelected()) {/*check IF BLUE WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/

							disableAndMarkColorButton(blueRadioButton2_1);
							blueRadioButton2_1.setSelected(false);
							 if(redRadioButton.isSelected()) {/*check IF RED WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/

									disableAndMarkColorButton(redRadioButton2_1);
									
									enableColorButton(greenRadioButton2_1);
									blueRadioButton2_1.setSelected(false);
									
									
									
								}

								else if(greenRadioButton.isSelected()) {

									disableAndMarkColorButton(greenRadioButton2_1);/*check IF GREEN WAS CHOOSED AND IF YES DISBLE IT FOR PLAYER 4-ADAN*/
									
									enableColorButton(redRadioButton2_1);
									yRadioButton2_1.setSelected(false);
										
								}
							
							
							
						}

						}
					}
					
				}
			});
			yRadioButton3.setBounds(383, 470,116, 23);//SET YELLOW BUTTON-ADAN
			contentPane.add(yRadioButton3);
			buttonGroup2.add(yRadioButton3);
			buttonGroup3.add(yRadioButton3);

			lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.setIcon(new ImageIcon(InterPlayersInfoFrame.class.getResource("/View/img/wpanda.png")));
			lblNewLabel_8.setBounds(210, 360, 100, 130);
			contentPane.add(lblNewLabel_8);
		}
		//******************player4
		if (NumofPlayers==4 ) {
			lblNewLabel_9 = new JLabel("player4 nickname:");//PLAYER4 NICKNAME
			lblNewLabel_9.setFont(new Font("Tahoma", Font.ITALIC, 20));
			lblNewLabel_9.setBounds(600, 360, 350, 20);
			contentPane.add(lblNewLabel_9);
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(790, 360, 116, 29);
			contentPane.add(textField_1);
			lblNewLabel_1_4 = new JLabel("player4 color:");//PLAYER 4 COLOR
			lblNewLabel_1_4.setFont(new Font("Tahoma", Font.ITALIC, 20));
			lblNewLabel_1_4.setBounds(600, 420, 400, 20);
			contentPane.add(lblNewLabel_1_4);
			lblNewLabel_10 = new JLabel("");
			lblNewLabel_10.setBounds(743, 360, 100, 130);
			lblNewLabel_10.setIcon(new ImageIcon(getClass().getResource("/View/img/wpanda.png")));//SETTINF PANDA ICON FOR PLAYER 4
			contentPane.add(lblNewLabel_10);
			redRadioButton2_1 = new JRadioButton("Red");
			redRadioButton2_1.setActionCommand("Red");
			redRadioButton2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			redRadioButton2_1.setBackground(new Color(173, 216, 230));
			redRadioButton2_1.setBounds(600, 470, 70, 23);
			contentPane.add(redRadioButton2_1);
			redRadioButton2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (redRadioButton2_1.isSelected()) {
						redRadioButton2_1.setForeground(Color.RED);//MAKE IT RED
						greenRadioButton2_1.setForeground(Color.black);
						blueRadioButton2_1.setForeground(Color.black);
						yRadioButton2_1.setForeground(Color.black);

					}
				}
			});
			greenRadioButton2_1 = new JRadioButton("Green");
			greenRadioButton2_1.setActionCommand("Green");
			greenRadioButton2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			greenRadioButton2_1.setBackground(new Color(173, 216, 230));
			greenRadioButton2_1.setBounds(680, 470, 105, 23);
			contentPane.add(greenRadioButton2_1);
			greenRadioButton2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {//MAKE IT BLUE
					if (greenRadioButton2_1.isSelected()) {
						redRadioButton2_1.setForeground(Color.black);
						greenRadioButton2_1.setForeground(new Color(0, 153, 0));
						blueRadioButton2_1.setForeground(Color.black);
						yRadioButton2_1.setForeground(Color.black);

					}
				}
			});
			blueRadioButton2_1 = new JRadioButton("Blue");
			blueRadioButton2_1.setActionCommand("Blue");
			blueRadioButton2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			blueRadioButton2_1.setBackground(new Color(173, 216, 230));
			blueRadioButton2_1.setBounds(790, 470, 90, 23);
			contentPane.add(blueRadioButton2_1);
			blueRadioButton2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (blueRadioButton2_1.isSelected()) {
						redRadioButton2_1.setForeground(Color.black);
						greenRadioButton2_1.setForeground(Color.black);
						blueRadioButton2_1.setForeground(Color.blue);//MAKE IT BLUE
						yRadioButton2_1.setForeground(Color.black);

					}
				}
			});
			yRadioButton2_1 = new JRadioButton("Yellow");
			yRadioButton2_1.setActionCommand("Yellow");
			yRadioButton2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
			yRadioButton2_1.setBackground(new Color(173, 216, 230));
			yRadioButton2_1.setBounds(888, 470, 123, 23);
			contentPane.add(yRadioButton2_1);
			yRadioButton2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (yRadioButton2_1.isSelected()) {
						redRadioButton2_1.setForeground(Color.black);
						greenRadioButton2_1.setForeground(Color.black);
						blueRadioButton2_1.setForeground(Color.black);
						yRadioButton2_1.setForeground(Color.YELLOW);//MAKE IT YELLOW

					}
				}
			});
			buttonGroup4.add(redRadioButton2_1);
			buttonGroup4.add(greenRadioButton2_1);
			buttonGroup4.add(blueRadioButton2_1);
			buttonGroup4.add(yRadioButton2_1);


		}
		//****************************************************
		JButton btnNewButton = new JButton("next");
		btnNewButton.addActionListener(this);
		ImageIcon winIcon2 = new ImageIcon(LevelGame.class.getResource("/View/img/next.png"));
		int winWidth = 170; // Adjusted width based on grid size
		int winHeight = 45;//Adjusted height based on grid size

		// Scale down the size of the snake image
		Image scaledWinImage2 = winIcon2.getImage().getScaledInstance(winWidth, winHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledWinIcon2 = new ImageIcon(scaledWinImage2);
		btnNewButton.setIcon(scaledWinIcon2);
		btnNewButton.setBounds(946, 794, 158, 41);
		contentPane.add(btnNewButton);

	
		btnNewButton_1 = new JButton("back");
		ImageIcon winIcon1 = new ImageIcon(LevelGame.class.getResource("/View/img/back.png"));
		winWidth = 170; // Adjusted width based on grid size
		winHeight = 45;//Adjusted height based on grid size

		// Scale down the size of the snake image
		Image scaledWinImage1 = winIcon1.getImage().getScaledInstance(winWidth, winHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledWinIcon1 = new ImageIcon(scaledWinImage1);
		JButton btnNewButton_1 = new JButton(scaledWinIcon1);
		btnNewButton_1.setBounds(138, 786, 143, 49);

		contentPane.add(btnNewButton_1);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LevelGame f=new LevelGame();
				setVisible(false);
				PlayAudio.PlayBackSound(); // calling the function that play back buttons audio- Yara
				f.setVisible(true);
			}
		});

		ImageIcon icon = new ImageIcon(Winner.class.getResource("/View/img/sky.png"));
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
	private void disableAndMarkColorButton(JRadioButton button) {//DIABLE THE COLOR AND MAKE IT GRAY-ADAN
		
		button.setEnabled(false);
		System.out.println(button.isSelected());
		if(button.isSelected()==true) {
			System.out.println("it is true");
			 ButtonGroup group = buttonGroupMap.get(button);
		
		        if (group != null) {
		        	System.out.println("it is true2");
		            group.clearSelection();
		        }
		}
		button.setForeground(Color.GRAY); // Change color to indicate it's disabled
		button.setUI(new BasicRadioButtonUI() {
			@Override
			protected void paintText(Graphics g, JComponent c, Rectangle textRect, String text) {
				super.paintText(g, c, textRect, text);
				g.setColor(Color.GRAY);//MAKE IT GRAY-ADAN
				g.drawLine(textRect.x, textRect.y + textRect.height / 2, textRect.x + textRect.width, textRect.y + textRect.height / 2);
			}
		});
	}

	// Method to enable a color button
	private void enableColorButton(JRadioButton button) {//ENABLE
		button.setEnabled(true);
		button.setForeground(Color.BLACK); // Reset color to indicate it's enabled
		button.setUI(new BasicRadioButtonUI());
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s=e.getActionCommand();
		Player p1=null,p2=null,p3=null,p4=null;
		if(s.equals("next")) {
			try {//CHECK IF THERE IS A NULL FIELD
				if(textField.getText().equals("")||textField2.getText().equals("")||buttonGroup.getSelection() == null||buttonGroup2.getSelection() == null)
				{
					throw new FieldIisNull();
				}

				else if(textField.getText().equals(textField2.getText()))
				{
					throw new UnvalidExceptions("you can not enter the same nickname!!");
				}else {
					PlayerColor color;
					ButtonModel selectedButtonModel = buttonGroup.getSelection();
					System.out.println(selectedButtonModel);
					if (selectedButtonModel != null) {
					    String colorString = selectedButtonModel.getActionCommand();
					    System.out.println(colorString);
					    if (colorString.equals("Red")) {
						    color = PlayerColor.Red;
						} else if (colorString.equals("Green")) {
						    color = PlayerColor.Green;
						} else if (colorString.equals("Blue")) {
						    color = PlayerColor.Blue;
						} else {
						    // Handle the case where the color string is not recognized
						    // For example, you could throw an exception or set a default color
						    color = PlayerColor.Yellow; // Assuming you have a default color defined in your enum
						}
						System.out.println(color);
						 p1=new Player(color,textField.getText(),0,0,1);
					
					  
					}
					
					 ButtonModel colorString1 = buttonGroup2.getSelection(); // Assuming this returns the color string
					 
					 
					 String colorString = colorString1.getActionCommand();
						System.out.println("*************inter info**********the player 2 color: "+colorString);
						
					if (colorString.equals("Red")) {
					    color = PlayerColor.Red;
					} else if (colorString.equals("Green")) {
					    color = PlayerColor.Green;
					} else if (colorString.equals("Blue")) {
					    color = PlayerColor.Blue;
					} else {
					    // Handle the case where the color string is not recognized
					    // For example, you could throw an exception or set a default color
					    color = PlayerColor.Yellow; // Assuming you have a default color defined in your enum
					}
					

					System.out.println(color);
					 p2=new Player(color,textField2.getText(),0,0,2);
					 if (p1.getPlayerColor() == p2.getPlayerColor()) {
		                    throw new UnvalidExceptions("select a color for player 2!!");
		                }
				}
				if(Num>=3) {
					if(textField.getText().equals("")||textField2.getText().equals("")||textField3.getText().equals("")||buttonGroup3.getSelection() == null||buttonGroup.getSelection() == null||buttonGroup2.getSelection() == null)
					{
						throw new FieldIisNull();
					}

					else if(textField.getText().equals(textField2.getText())||textField.getText().equals(textField3.getText())||textField3.getText().equals(textField2.getText()))
					{
						throw new UnvalidExceptions("you can not enter the same nickname!!");
					}else {
						
						PlayerColor color;

						ButtonModel colorString1 = buttonGroup3.getSelection(); // Assuming this returns the color string
						String colorString2 =colorString1.getActionCommand(); // Assuming this returns the color string
						System.out.println("*************inter info**********the player 3 color: "+colorString2);
						
						if (colorString2.equals("Red")) {
						    color = PlayerColor.Red;
						} else if (colorString2.equals("Green")) {
						    color = PlayerColor.Green;
						} else if (colorString2.equals("Blue")) {
						    color = PlayerColor.Blue;
						} else {
						    // Handle the case where the color string is not recognized
						    // For example, you could throw an exception or set a default color
						    color = PlayerColor.Yellow; // Assuming you have a default color defined in your enum
						}
						

						 p3=new Player(color,textField3.getText(),0,0,3);
						 if (p3.getPlayerColor() == p2.getPlayerColor()||p3.getPlayerColor() == p1.getPlayerColor()) {
			                    throw new UnvalidExceptions("select a color for player 3!!");
			                }
					}
					if(Num==4) {
						if(textField.getText().equals("")||textField2.getText().equals("")||textField3.getText().equals("")||textField_1.getText().equals("")||buttonGroup3.getSelection() == null||buttonGroup4.getSelection() == null||buttonGroup.getSelection() == null||buttonGroup2.getSelection() == null)
						{
							throw new FieldIisNull();
						}

						else if(textField.getText().equals(textField2.getText())||textField.getText().equals(textField3.getText())||textField.getText().equals(textField_1.getText())||textField3.getText().equals(textField2.getText())||textField_1.getText().equals(textField2.getText())||textField3.getText().equals(textField_1.getText()))
						{
							throw new UnvalidExceptions("you can not enter the same nickname!!");
						}
						else {
							System.out.println("player 4 opject");
							PlayerColor color;
							ButtonModel colorString1 = buttonGroup4.getSelection(); // Assuming this returns the color string
							String colorString3 =colorString1.getActionCommand(); // Assuming this returns the color string
							System.out.println("*************inter info**********the player 4 color: "+colorString3);
							System.out.println("player 4 name: "+textField_1.getText());
							if (colorString3.equals("Red")) {
							    color = PlayerColor.Red;
							} else if (colorString3.equals("Green")) {
							    color = PlayerColor.Green;
							} else if (colorString3.equals("Blue")) {
							    color = PlayerColor.Blue;
							} else {
							    // Handle the case where the color string is not recognized
							    // For example, you could throw an exception or set a default color
							    color = PlayerColor.Yellow; // Assuming you have a default color defined in your enum
							}
							

							 p4=new Player(color,textField_1.getText(),0,0,4);//
							 if (p3.getPlayerColor() == p2.getPlayerColor()||p3.getPlayerColor() == p1.getPlayerColor()) {
				                    throw new UnvalidExceptions("select a color for player 4!!");
				                }
						}
						
					}
					
				}
			
					
				
				if(Levels.Easy==level)
				{
					EasyLevel easyBoard= new EasyLevel(p1,p2,p3,p4,Num);
					setVisible(false);
					PlayAudio.PlayGameStartSound(); // calling the function to play start game audio-Yara
					easyBoard.setVisible(true);
				}
				else if(Levels.Medium==level)
				{
					System.out.println("number"+Num);
					MediumLevel medBoard= new MediumLevel(p1,p2,p3,p4,Num);
				
					setVisible(false);	
					PlayAudio.PlayGameStartSound(); // calling the function to play start game audio-Yara
					medBoard.setVisible(true);
				}
				else if(Levels.Hard==level)
				{
					HardLevel hardBoard= new HardLevel(p1,p2,p3,p4,Num);
					setVisible(false);
					PlayAudio.PlayGameStartSound(); // calling the function to play start game audio-Yara
					hardBoard.setVisible(true);
				}
			}
			catch (FieldIisNull ev){
				JOptionPane.showMessageDialog(contentPane,ev.getMessage());	
				System.out.println("throw ex");
			} catch (UnvalidExceptions ex) {
				JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
			}catch (Exception ex) {
	            // Handle any unexpected exceptions
	            ex.printStackTrace(); // Or log the exception
	            JOptionPane.showMessageDialog(contentPane, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
		}

	}
	 private void addButtonToGroup(ButtonGroup group, JRadioButton button) {
	        group.add(button);
	        buttonGroupMap.put(button, group);
	    }
	

}
	


