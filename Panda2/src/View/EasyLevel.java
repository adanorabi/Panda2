package View;
import Enum.Levels;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import Enum.Levels;
import Enum.SnakeColor;
import Model.Game;
import Model.*;

public class EasyLevel extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblEasyTable; // Label for the easytable image
	private JLabel lblSnake; 
	private JLabel glblSnake;// Label for the snake image
	private JLabel rlblSnake;
	private JLabel ylblSnake;
	private JLabel lblsur;
	private JLabel lblq;
	private JLabel lblLadder; 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EasyLevel frame = new EasyLevel();
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
	public EasyLevel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Label for the easytable image
		lblEasyTable = new JLabel("");
		lblEasyTable.setIcon(new ImageIcon(EasyLevel.class.getResource("/View/img/easytable.png")));
		lblEasyTable.setBounds(214, 125, 861, 602);
		contentPane.add(lblEasyTable);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(EasyLevel.class.getResource("/View/img/dice-1.png")));
		lblNewLabel_2.setBounds(27, 633, 150, 150);
		contentPane.add(lblNewLabel_2);


		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EasyLevel.class.getResource("/View/img/game.png")));
		lblNewLabel.setBounds(0, 0, 1200, 900);
		contentPane.add(lblNewLabel);
		ArrayList<String> answers= new ArrayList<String>();
		answers.add("qq");
		answers.add("bb");
		answers.add("cc");
		answers.add("dd");
		Question q= new Question(1, Levels.Easy,"what is scrum master?", answers,"cc");
		q.setAnswer(answers);
		System.out.println(q.getAnswer());
		displayQuestionWindow(q);
//		Game g=new Game(3, Levels.Easy, 7, 7);
//		g.createGame();
//		g.PlacespecialSquares(Levels.Easy);
//		g.placeNormalSquares();
//		g.PlaceSnakes();
//		g.placeLadders();
//		int i, j;
//		for(i=0; i<g.getSnakes().size();i++)
//		{
//			SnakeColor color= g.getSnakes().get(i).getColor();
//			int xHead=g.getSnakes().get(i).getXHeadNum();
//			int xTail=g.getSnakes().get(i).getXTailNum();
//			int yHead=g.getSnakes().get(i).getYHeadNum();
//			int yTail=g.getSnakes().get(i).getYTailNum();
//			if(color==SnakeColor.Blue)
//			{
//				setbluesnake(xHead,yHead,xTail,yTail);
//				System.out.println("bluessnake (" +xHead  + "," + yHead+ "," + xTail+ "," + yTail+ "):" );
//
//			}
//			else if(color==SnakeColor.Green)
//			{
//				setgreensnake(xHead,yHead,xTail,yTail);
//				System.out.println("greensnake (" + xHead + "," + yHead +"," +  xTail+ "," + yTail+ "):" );
//
//			}
//			else if(color==SnakeColor.Red)
//			{
//				setredsnake(xHead,yHead);
//				System.out.println("redsnake (" + xHead + "," + yHead+"," +  xTail+ "," + yTail+ "):" );
//
//			}
//			else if (color==SnakeColor.Yellow)
//			{
//				setyellowsnake(xHead, yHead, xTail, yTail);
//				System.out.println("yellow (" + xHead + "," + yHead +"," +  xTail+ "," + yTail+ "):" );
//
//			}
//		}
//		for(i=0; i<g.getLadders().size();i++)
//		{
//			int length= g.getLadders().get(i).getLength();
//			int xHead=g.getLadders().get(i).getXEnd();
//			int xTail=g.getLadders().get(i).getXStart();
//			int yHead=g.getLadders().get(i).getYEnd();
//			int yTail=g.getLadders().get(i).getYStart();
//			System.out.println("lader ("+ length + "," + xHead + "," + yHead +"," +  xTail+ "," + yTail+"):" );
//			setLadders(length,xHead,yHead,xTail,yTail);
//		}
//		for (i=0 ; i<7; i++)
//		{
//			for (j=0 ; j<7; j++ )
//			{
//				if(g.getPlaces()[i][j]==3) {
//					setq(i, j);
//					System.out.println("question (" + i + "," + j + "):" );
//
//				}
//			}
//		}

	}
	// blue snakes function
	public void setbluesnake(int xhead, int yhead, int xtail, int ytail) {
		// Load the snake image
		ImageIcon snakeIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/bluesnake2.png"));

		// Calculate the position of the snake head and tail
		int snakeHeadX = 214 + xhead * 122; // Adjusted x position based on the board offset and grid size
		int snakeHeadY = 641 - yhead * 86; // Adjusted y position based on the board offset and grid size
		int snakeTailX = 214 + xtail * 122; // Adjusted x position based on the board offset and grid size
		int snakeTailY = 641 - ytail * 86; // Adjusted y position based on the board offset and grid size

		// Calculate the size of the snake image
		int snakeWidth = Math.abs(snakeHeadX - snakeTailX) + 122; // Adjusted width based on grid size
		int snakeHeight = Math.abs(snakeHeadY - snakeTailY) + 86; // Adjusted height based on grid size

		// Scale down the size of the snake image
		Image scaledSnakeImage = snakeIcon.getImage().getScaledInstance(snakeWidth, snakeHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledSnakeIcon = new ImageIcon(scaledSnakeImage);

		// Create a JLabel for the scaled snake image
		lblSnake = new JLabel(scaledSnakeIcon);
		lblSnake.setBounds(Math.min(snakeHeadX, snakeTailX), Math.min(snakeHeadY, snakeTailY), snakeWidth, snakeHeight);

		// Add the snake label to the content pane
		contentPane.add(lblSnake);

		// Ensure the snake label is visible
		lblSnake.setVisible(true);

		// Move the snake label to the front
		contentPane.setComponentZOrder(lblSnake, 0);

		// Repaint the content pane to ensure the changes are displayed
		contentPane.revalidate();
		contentPane.repaint();
	}
	// red snakes function
	public void setredsnake(int xhead, int yhead) {
		// Load the snake image
		ImageIcon snakeIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/redsnake.png"));

		// Calculate the position of the snake head and tail
		int snakeHeadX = 245 + xhead * 122; // Adjusted x position based on the board offset and grid size
		int snakeHeadY =680-yhead*86;

		// Calculate the size of the snake image
		int snakeWidth = 60; // Adjusted width based on grid size
		int snakeHeight = 40;//Adjusted height based on grid size

		// Scale down the size of the snake image
		Image scaledSnakeImage = snakeIcon.getImage().getScaledInstance(snakeWidth, snakeHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledSnakeIcon = new ImageIcon(scaledSnakeImage);

		// Create a JLabel for the scaled snake image
		rlblSnake = new JLabel(scaledSnakeIcon);
		rlblSnake.setBounds(snakeHeadX,snakeHeadY, snakeWidth, snakeHeight);

		// Add the snake label to the content pane
		contentPane.add(rlblSnake);

		// Ensure the snake label is visible
		rlblSnake.setVisible(true);

		// Move the snake label to the front
		contentPane.setComponentZOrder(rlblSnake, 0);

		// Repaint the content pane to ensure the changes
		contentPane.revalidate();
		contentPane.repaint();
	}
	// set yellow snakes function
	public void  setyellowsnake(int xhead, int yhead, int xtail, int ytail) {
		ImageIcon snakeIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/yellosnake.png"));

		// Calculate the position of the snake head and tail
		int snakeHeadX = 214 + xhead * 122; // Adjusted x position based on the board offset and grid size
		int snakeHeadY = 641 - yhead * 86; // Adjusted y position based on the board offset and grid size
		int snakeTailX = 214 + xtail * 122; // Adjusted x position based on the board offset and grid size
		int snakeTailY = 641 - ytail * 86; // Adjusted y position based on the board offset and grid size
		// Calculate the size of the snake image
		int snakeWidth = Math.abs(snakeHeadX - snakeTailX) + 122; // Adjusted width based on grid size
		int snakeHeight = Math.abs(snakeHeadY - snakeTailY) + 86; // Adjusted height based on grid size

		// Scale down the size of the snake image
		Image scaledSnakeImage = snakeIcon.getImage().getScaledInstance(snakeWidth, snakeHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledSnakeIcon = new ImageIcon(scaledSnakeImage);
		// Create a JLabel for the scaled snake image
		ylblSnake = new JLabel(scaledSnakeIcon);
		ylblSnake.setBounds(snakeHeadX,snakeHeadY, snakeWidth, snakeHeight);

		// Add the snake label to the content pane
		contentPane.add(ylblSnake);

		// Ensure the snake label is visible
		ylblSnake.setVisible(true);

		// Move the snake label to the front
		contentPane.setComponentZOrder(ylblSnake, 0);

		// Repaint the content pane to ensure the changes are displayed
		contentPane.revalidate();
		contentPane.repaint();
	}
	public void setgreensnake(int xhead, int yhead, int xtail, int ytail) {
		// Load the snake image
		ImageIcon snakeIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/greensnake.png"));

		// Calculate the position of the snake head and tail
		int snakeHeadX = 214 + xhead * 122; // Adjusted x position based on the board offset and grid size
		int snakeHeadY = 641 - yhead * 86; // Adjusted y position based on the board offset and grid size
		int snakeTailX = 214 + xtail * 122; // Adjusted x position based on the board offset and grid size
		int snakeTailY = 641 - ytail * 86; // Adjusted y position based on the board offset and grid size

		// Calculate the size of the snake image
		int snakeWidth = Math.abs(snakeHeadX - snakeTailX) + 122; // Adjusted width based on grid size
		int snakeHeight = Math.abs(snakeHeadY - snakeTailY) + 86; // Adjusted height based on grid size

		// Scale down the size of the snake image
		Image scaledSnakeImage = snakeIcon.getImage().getScaledInstance(snakeWidth, snakeHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledSnakeIcon = new ImageIcon(scaledSnakeImage);

		// Create a JLabel for the scaled snake image
		glblSnake = new JLabel(scaledSnakeIcon);
		glblSnake.setBounds(snakeHeadX,snakeHeadY, snakeWidth, snakeHeight);

		// Add the snake label to the content pane
		contentPane.add(glblSnake);

		// Ensure the snake label is visible
		glblSnake.setVisible(true);

		// Move the snake label to the front
		contentPane.setComponentZOrder(glblSnake, 0);

		// Repaint the content pane to ensure the changes are displayed
		contentPane.revalidate();
		contentPane.repaint();
	}
	// set ladders
	public void setLadders(int typeOfLader, int xhead, int yhead, int xtail, int ytail) {
		int ladderHeadX = 230 + xhead * 122; // Adjusted x position based on the board offset and grid size
		int ladderHeadY = 641 - yhead * 86; // Adjusted y position based on the board offset and grid size
		int ladderTailX = 230 + xtail * 122; // Adjusted x position based on the board offset and grid size
		int ladderTailY = 641 - ytail * 86; // Adjusted y position based on the board offset and grid size
		ImageIcon ladderIcon=null;
		// Calculate the size of the snake image
		int ladderWidth = Math.abs(ladderHeadX - ladderTailX) + 80; // Adjusted width based on grid size
		int ladderHeight = Math.abs(ladderHeadY - ladderTailY) + 70; // Adjusted height based on grid size


		// Load the ladder image based on the ladder type
		switch (typeOfLader) {
		case 1:
			ladderIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/ladder1.png"));
			break;
		case 2:
			ladderIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/ladder2.png"));
			break;
		case 3:
			ladderIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/ladder3.png"));
			break;
		case 4:
			ladderIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/ladder4.png"));
			break;
		default:
			// Default ladder image
			ladderIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/default_ladder.png"));
			break;
		}

		// Scale down the size of the snake image
		Image scaledLadderImage = ladderIcon.getImage().getScaledInstance(ladderWidth, ladderHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledLadderIcon = new ImageIcon(scaledLadderImage);
		// Create a JLabel for the scaled snake image
		lblLadder = new JLabel(scaledLadderIcon);
		lblLadder.setBounds(ladderHeadX,ladderHeadY, ladderWidth, ladderHeight);

		// Add the snake label to the content pane
		contentPane.add(lblLadder);

		// Ensure the snake label is visible
		lblLadder.setVisible(true);

		// Move the snake label to the front
		contentPane.setComponentZOrder(lblLadder, 0);

		// Repaint the content pane to ensure the changes are displayed
		contentPane.revalidate();
		contentPane.repaint();
	}
	public void setsurprise(int x, int y) {
		// Load the surprise image
		ImageIcon snakeIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/q.png"));

		// Calculate the position of the surprise
		int sX = 260 + x * 122; 
		int sY =660-y*86;

		// Calculate the size of the snake image
		int width = 50; // Adjusted width based on grid size
		int height = 50;//Adjusted height based on grid size

		// Scale down the size of the snake image
		Image scaledImage = snakeIcon.getImage().getScaledInstance( width, height, Image.SCALE_SMOOTH);
		ImageIcon scaledSnakeIcon = new ImageIcon(scaledImage);

		// Create a JLabel for the scaled snake image
		lblsur = new JLabel(scaledSnakeIcon);
		lblsur.setBounds(sX,sY, width, height);

		// Add the snake label to the content pane
		contentPane.add(lblsur);

		// Ensure the snake label is visible
		lblsur.setVisible(true);

		// Move the snake label to the front
		contentPane.setComponentZOrder(lblsur, 0);

		// Repaint the content pane to ensure the changes
		contentPane.revalidate();
		contentPane.repaint();
	}
	public void setq(int x, int y) {
		// Load the surprise image
		ImageIcon snakeIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/surprise.png"));

		// Calculate the position of the surprise
		int sX = 260 + x * 122; 
		int sY =660-y*86;

		// Calculate the size of the snake image
		int width = 30; // Adjusted width based on grid size
		int height = 30;//Adjusted height based on grid size

		// Scale down the size of the snake image
		Image scaledImage = snakeIcon.getImage().getScaledInstance( width, height, Image.SCALE_SMOOTH);
		ImageIcon scaledSnakeIcon = new ImageIcon(scaledImage);

		// Create a JLabel for the scaled snake image
		lblq = new JLabel(scaledSnakeIcon);
		lblq.setBounds(sX,sY, width, height);

		// Add the snake label to the content pane
		contentPane.add(lblq);

		// Ensure the snake label is visible
		lblq.setVisible(true);

		// Move the snake label to the front
		contentPane.setComponentZOrder(lblq, 0);

		// Repaint the content pane to ensure the changes
		contentPane.revalidate();
		contentPane.repaint();
	}
	public void displayQuestionWindow(Question question) {
	    // Create a new JDialog to display the question window
	    JDialog questionDialog = new JDialog(this, "Question", Dialog.ModalityType.MODELESS);
	    questionDialog.setSize(400, 300);
	    questionDialog.setLocationRelativeTo(this); // Center the window relative to EasyLevel frame

	    // Create a JPanel to hold the question and answers
	    JPanel questionPanel = new JPanel();
	    questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));

	    // Create a JLabel to display the question text
	    JLabel questionLabel = new JLabel(question.getContent());
	    questionPanel.add(questionLabel);

	    // Shuffle the answers randomly
	    List<String> answers = question.getAnswer();
	    Collections.shuffle(answers);

	    // Create JRadioButtons for each answer
	    ButtonGroup buttonGroup = new ButtonGroup();
	    for (String answer : answers) {
	        JRadioButton radioButton = new JRadioButton(answer);
	        radioButton.setActionCommand(answer);
	        buttonGroup.add(radioButton);
	        questionPanel.add(radioButton);
	    }

	    // Create a JButton to submit the answer
	    JButton submitButton = new JButton("Submit");
	    submitButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // Check if any radio button is selected
	            if (buttonGroup.getSelection() == null) {
	                JOptionPane.showMessageDialog(questionDialog, "Please select an answer.");
	                return; // Exit the method without further processing
	            }

	            // Get the selected answer
	            String selectedAnswer = buttonGroup.getSelection().getActionCommand();

	            // Check if the selected answer is correct
	            if (selectedAnswer.equals(question.getTrueAnswer())) {
	                JOptionPane.showMessageDialog(questionDialog, "Correct!");
	            } else {
	                JOptionPane.showMessageDialog(questionDialog, "Incorrect. The correct answer is: " + question.getTrueAnswer());
	            }

	            // Close the question dialog
	            questionDialog.dispose();
	        }
	    });
	    questionPanel.add(submitButton);

	    // Add the question panel to the question dialog
	    questionDialog.add(questionPanel);

	    // Make the question dialog visible
	    questionDialog.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
