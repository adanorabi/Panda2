package View;
import Enum.Levels;
import Enum.PlayerColor;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**/
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
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


import Enum.Levels;
import Enum.SnakeColor;
import Model.*;

public class EasyLevel extends JFrame implements QuestionFrame.QuestionAnsweredListener {
	static int N=60;
	private JPanel contentPane;
	private JLabel lblEasyTable; // Label for the easytable image
	private JLabel lblSnake; 
	private JLabel glblSnake;// Label for the snake image
	private JLabel rlblSnake;
	private JLabel ylblSnake;
	private JLabel lblsur;
	private JLabel lblq;
	private JLabel lblLadder; 
	private JButton diceButton;
	private ImageIcon[] diceIcons;
	private JLabel diceLabel ;
	/***/
	private JLabel p1Label;
	private JLabel p2Label;
	private JLabel p3Label;
	private JLabel p4Label;
	private JLabel p1OnGame=null;
	private JLabel p2OnGame=null;
	private JLabel p3OnGame=null;
	private JLabel p4OnGame=null;
	private Image img1;
	private ImageIcon imgIcn1;
	private ImageIcon finalIcon1;
	private Image img2;
	private ImageIcon imgIcn2;
	private ImageIcon finalIcon2;
	private Image img3;
	private ImageIcon imgIcn3;
	private ImageIcon finalIcon3;
	private Image img4;
	private ImageIcon imgIcn4;
	private ImageIcon finalIcon4;
	private JLabel p1name;
	private JLabel p2name;
	private JLabel p3name;
	private JLabel p4name;
	private JLabel mytext;
	private QuestionFrame questionFrame;


	/**
	 * Create the frame.
	 */
	public EasyLevel(Player p1,Player p2, Player p3,Player p4,int num) {


		Game g=new Game(3, Levels.Easy, 7, 7);
		g.createGame();
		g.getPlayers().add(p1);
		g.getPlayers().add(p2);

		/**************************************************************************************************/
		g.PlacespecialSquares(Levels.Easy);
		g.placeNormalSquares();
		g.PlaceSnakes();
		g.placeLadders();
		//	Player turn=g.CurrentTurn();//call the turn
		//	System.out.println("the player is "+turn.getNickName());
		//	setPlayerText(turn,"it is you turn to roll a dice");/**********************turn***********************/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		mytext = new JLabel("");
		mytext.setFont(new Font("Tahoma", Font.ITALIC, 20));
		mytext.setBounds(200, 29, 900, 50);
		contentPane.add( mytext);

		// Label for the easytable image
		lblEasyTable = new JLabel("");
		lblEasyTable.setIcon(new ImageIcon(EasyLevel.class.getResource("/View/img/easytable.png")));
		lblEasyTable.setBounds(214, 125, 861, 602);
		contentPane.add(lblEasyTable);


		diceButton = new JButton("Roll Dice");
		diceButton.setIcon(new ImageIcon(getClass().getResource("/View/img/roll.png")));
		diceButton.setBounds(43, 702, 134, 49);
		diceButton.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("in dice btn");
				rollDiceAnimation(g,num);


			}});
		contentPane.add(diceButton); 

		diceLabel = new JLabel("");
		diceLabel.setIcon(new ImageIcon(EasyLevel.class.getResource("/View/img/1.png")));
		diceLabel.setBounds(40, 520, 150, 150);

		contentPane.add(diceLabel); // Add the dice label to lblEasyTable panel
		diceLabel.setVisible(true);

		diceIcons = new ImageIcon[8];
		for (int i = 0; i < 5; i++) {
			ImageIcon originalIcon = new ImageIcon(getClass().getResource("/View/img/" + i  + ".png"));
			Image resizedImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			diceIcons[i] = new ImageIcon(resizedImage);
		}
		ImageIcon originalIcon1 = new ImageIcon(getClass().getResource("/View/img/EasyD.png"));
		Image resizedImage1 = originalIcon1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		diceIcons[5] = new ImageIcon(resizedImage1);
		ImageIcon originalIcon2 = new ImageIcon(getClass().getResource("/View/img/HardD.png"));
		Image resizedImage2 = originalIcon2.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		diceIcons[6] = new ImageIcon(resizedImage2);
		ImageIcon originalIcon3 = new ImageIcon(getClass().getResource("/View/img/MedD.png"));
		Image resizedImage3 = originalIcon3.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		diceIcons[7] = new ImageIcon(resizedImage3);


		// question example
		//		ArrayList<String> answers= new ArrayList<String>();
		//		answers.add("No one");
		//		answers.add("the manager of the project");
		//		answers.add("who leads the team using agile");
		//		answers.add("QA ");
		//		Question q= new Question(1, Levels.Hard,"what is scrum master?", answers,"who leads the team using agile");
		//		q.setAnswer(answers);
		//		System.out.println(q.getAnswer());
		//		QuestionFrame fQ=new QuestionFrame(q);
		//		fQ.setVisible(true);
		// Button for rolling the dice

		//        JButton btnNewButton = new JButton("New button");
		//        btnNewButton.setBounds(54, 712, 125, 56);
		//        contentPane.add(btnNewButton);
		/*********************************************************************************************************************************/
		ImageIcon p1icon;
		if(p1.getPlayerColor()==PlayerColor.Red)
		{
			p1icon= new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
			imgIcn1=new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
		}
		else if(p1.getPlayerColor()==PlayerColor.Green)
		{
			p1icon= new ImageIcon(EasyLevel.class.getResource("/View/img/g.png"));
			imgIcn1=new ImageIcon(EasyLevel.class.getResource("/View/img/g.png"));
		}
		else if(p1.getPlayerColor()==PlayerColor.Blue)
		{
			p1icon= new ImageIcon(EasyLevel.class.getResource("/View/img/b.png"));
			imgIcn1=new ImageIcon(EasyLevel.class.getResource("/View/img/b.png"));
		}
		else {
			p1icon= new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));
			imgIcn1=new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));
		}
		Image scaledP1Image = p1icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledP1Icon = new ImageIcon(scaledP1Image);
		//setting icon on game
		img1=imgIcn1.getImage().getScaledInstance(N, N, Image.SCALE_SMOOTH);
		finalIcon1= new ImageIcon(img1);

		p1OnGame=new JLabel(finalIcon1);//finish putting the icon only setbound and set visible left


		// Create a JLabel for player p1
		p1Label = new JLabel(scaledP1Icon);


		int p1X = 35; // Adjusted x position based on the board offset and grid size
		int p1Y = 80; // Adjusted y position based on the board offset and grid size
		p1Label.setBounds(p1X, p1Y, 100, 100); // Set bounds for player p1 label


		// Add player p1 label to the content pane
		contentPane.add(p1Label);

		// Ensure player p1 label is visible
		p1Label.setVisible(true);

		p1name = new JLabel(p1.getNickName());
		p1name.setFont(new Font("Times New Roman", Font.BOLD, 16));
		p1name.setBounds(73, 70, 200, 13);
		contentPane.add(p1name);

		/******************************p2**********************/
		ImageIcon p2icon;
		if(p2.getPlayerColor()==PlayerColor.Red) {
			p2icon= new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
			imgIcn2=new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
		}
		else if(p2.getPlayerColor()==PlayerColor.Green) {
			p2icon= new ImageIcon(EasyLevel.class.getResource("/View/img/g.png"));
			imgIcn2=new ImageIcon(EasyLevel.class.getResource("/View/img/g.png"));
		}
		else if(p2.getPlayerColor()==PlayerColor.Blue) {
			p2icon= new ImageIcon(EasyLevel.class.getResource("/View/img/b.png"));
			imgIcn2=new ImageIcon(EasyLevel.class.getResource("/View/img/b.png"));
		}
		else {
			p2icon= new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));
			imgIcn2=new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));
		}
		Image scaledP2Image = p2icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledP2Icon = new ImageIcon(scaledP2Image);
		// Create a JLabel for player p2
		p2Label = new JLabel(scaledP2Icon);
		p2Label.setBounds(p1X, 180, 100, 100); // Set bounds for player p1 label

		// Add player p1 label to the content pane
		contentPane.add(p2Label);

		// Ensure player p1 label is visible
		p2Label.setVisible(true);

		img2=imgIcn2.getImage().getScaledInstance(N, N, Image.SCALE_SMOOTH);
		finalIcon2= new ImageIcon(img2);

		p2OnGame=new JLabel(finalIcon2);//finish putting the icon only setbound and set visible left

		setPlayer(p1);//
		setPlayer(p2);//		



		p2name = new JLabel(p2.getNickName());
		p2name.setFont(new Font("Times New Roman", Font.BOLD, 16));
		p2name.setBounds(73, 170, 200, 13);
		contentPane.add(p2name);

		/******************************p3***************/

		if(num>2) {
			ImageIcon p3icon;
			if(p3.getPlayerColor()==PlayerColor.Red) {
				p3icon= new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
				imgIcn3=new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
			}
			else if(p3.getPlayerColor()==PlayerColor.Green) {
				p3icon= new ImageIcon(EasyLevel.class.getResource("/View/img/g.png"));
				imgIcn3=new ImageIcon(EasyLevel.class.getResource("/View/img/g.png"));
			}
			else if(p3.getPlayerColor()==PlayerColor.Blue) {
				p3icon= new ImageIcon(EasyLevel.class.getResource("/View/img/b.png"));
				imgIcn3=new ImageIcon(EasyLevel.class.getResource("/View/img/b.png"));
			}
			else {
				p3icon= new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));
				imgIcn3=new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));
			}
			Image scaledP3Image = p3icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon scaledP3Icon = new ImageIcon(scaledP3Image);
			// Create a JLabel for player p2
			p3Label = new JLabel(scaledP3Icon);
			p3Label.setBounds(p1X, 280, 100, 100); // Set bounds for player p1 label

			// Add player p1 label to the content pane
			contentPane.add(p3Label);

			// Ensure player p1 label is visible
			p3Label.setVisible(true);

			img3=imgIcn3.getImage().getScaledInstance(N, N, Image.SCALE_SMOOTH);
			finalIcon3= new ImageIcon(img3);

			p3OnGame=new JLabel(finalIcon3);//finish putting the icon only setbound and set visible left

			setPlayer(p3);//
			p3name = new JLabel(p3.getNickName());
			p3name.setFont(new Font("Times New Roman", Font.BOLD, 16));
			p3name.setBounds(73, 270, 200, 13);
			contentPane.add(p3name);


			if(num==4) {
				ImageIcon p4icon;
				if(p4.getPlayerColor()==PlayerColor.Red) {
					p4icon= new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
					imgIcn4=new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
				}
				else if(p4.getPlayerColor()==PlayerColor.Green) {
					p4icon= new ImageIcon(EasyLevel.class.getResource("/View/img/g.png"));
					imgIcn4=new ImageIcon(EasyLevel.class.getResource("/View/img/g.png"));
				}
				else if(p4.getPlayerColor()==PlayerColor.Blue) {
					p4icon= new ImageIcon(EasyLevel.class.getResource("/View/img/b.png"));
					imgIcn4=new ImageIcon(EasyLevel.class.getResource("/View/img/b.png"));
				}
				else {
					p4icon= new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));
					imgIcn4=new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));
				}
				Image scaledP4Image = p4icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				ImageIcon scaledP4Icon = new ImageIcon(scaledP4Image);
				// Create a JLabel for player p2
				p4Label = new JLabel(scaledP4Icon);
				p4Label.setBounds(p1X, 380, 100, 100); // Set bounds for player p1 label

				// Add player p1 label to the content pane
				contentPane.add(p4Label);

				// Ensure player p1 label is visible
				p4Label.setVisible(true);
				img4=imgIcn4.getImage().getScaledInstance(N, N, Image.SCALE_SMOOTH);
				finalIcon4= new ImageIcon(img4);

				p4OnGame=new JLabel(finalIcon4);//finish putting the icon only setbound and set visible left

				setPlayer(p4);//
				p4name = new JLabel(p4.getNickName());
				p4name.setFont(new Font("Times New Roman", Font.BOLD, 16));
				p4name.setBounds(73, 370, 200, 13);
				contentPane.add(p4name);

			}
		}

		/********************p4*******************************************************************88*/


		if(num>2) {
			g.getPlayers().add(p3);
			if(num==4) {


				g.getPlayers().add(p4);
			}
		}


		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EasyLevel.class.getResource("/View/img/game.png")));
		lblNewLabel.setBounds(0, 0, 1200, 900);
		contentPane.add(lblNewLabel);

		int i, j;
		for(i=0; i<g.getSnakes().size();i++)
		{
			SnakeColor color= g.getSnakes().get(i).getColor();
			int xHead=g.getSnakes().get(i).getXHeadNum();
			int xTail=g.getSnakes().get(i).getXTailNum();
			int yHead=g.getSnakes().get(i).getYHeadNum();
			int yTail=g.getSnakes().get(i).getYTailNum();
			if(color==SnakeColor.Blue)
			{
				setbluesnake(xHead,yHead,xTail,yTail);
				System.out.println("bluessnake (" +xHead  + "," + yHead+ "," + xTail+ "," + yTail+ "):" );

			}
			else if(color==SnakeColor.Green)
			{
				setgreensnake(xHead,yHead,xTail,yTail);
				System.out.println("greensnake (" + xHead + "," + yHead +"," +  xTail+ "," + yTail+ "):" );

			}
			else if(color==SnakeColor.Red)
			{
				setredsnake(xHead,yHead);
				System.out.println("redsnake (" + xHead + "," + yHead+"," +  xTail+ "," + yTail+ "):" );

			}
			else if (color==SnakeColor.Yellow)
			{
				setyellowsnake(xHead, yHead, xTail, yTail);
				System.out.println("yellow (" + xHead + "," + yHead +"," +  xTail+ "," + yTail+ "):" );

			}
		}
		for(i=0; i<g.getLadders().size();i++)
		{
			int length= g.getLadders().get(i).getLength();
			int xHead=g.getLadders().get(i).getXEnd();
			int xTail=g.getLadders().get(i).getXStart();
			int yHead=g.getLadders().get(i).getYEnd();
			int yTail=g.getLadders().get(i).getYStart();
			System.out.println("lader ("+ length + "," + xHead + "," + yHead +"," +  xTail+ "," + yTail+"):" );
			setLadders(length,xHead,yHead,xTail,yTail);
		}
		for (i=0 ; i<7; i++)
		{
			for (j=0 ; j<7; j++ )
			{
				if(g.getPlaces()[i][j]==3||g.getPlaces()[i][j]==4||g.getPlaces()[i][j]==5) {
					setq(i, j);
					System.out.println("question (" + i + "," + j + "):" );

				}
			}
		}

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

		int width = 50; // Adjusted width based on grid size
		int height = 50;//Adjusted height based on grid size

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
	private void rollDiceAnimation(Game g,int num) {
		System.out.println("im in the roll dice func");
		final int NUM_FRAMES = 15; // Number of frames for the dice animation
		final int DELAY = 50; // Delay between each frame in milliseconds
		Random random = new Random();

		Timer timer = new Timer(DELAY, new ActionListener() {
			int frameCount = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				// Change dice image randomly for animation


				// Create a new JLabel with the dice image and add it to the lblEasyTable panel
				// Change dice image randomly for animation
				int randomIndex = random.nextInt(diceIcons.length);

				// Create a new JLabel with the dice image and add it to the lblEasyTable panel
				diceLabel.setIcon(diceIcons[randomIndex]);
				diceLabel.setBounds(40, 520, 150, 150);
				frameCount++;
				if (frameCount >= NUM_FRAMES) {
					Player p=g.CurrentTurn();

					int bx=p.getPlayerRow();
					int by=p.getPlayerCol();


					int squareResult;
					Object  CHECK = g.Roll();
					System.out.println("the dice rolled"+CHECK);
					Question q;
					String answer="";

					if(CHECK instanceof Integer) {
						diceLabel.setIcon(diceIcons[(Integer)CHECK]);
						answer=Integer.toString((Integer)CHECK);
						int ax=p.getPlayerRow();
						int ay=p.getPlayerCol();
						System.out.println("the current player is:"+p.getPlayerColor());
						movePlayer(p, bx, by,ax, ay);//moved player once


						while( g.UpdatePlayerPlace()!=0) {//

							if (g.checkQuestionSquare2() == true) {
								Question myQ = g.checkQuestionSquare();
								System.out.println("questionnnnnnn type from question square!!");

								if (myQ.getQLevel().equals(Levels.Easy)) {
									answer = "easy question";
								} else if (myQ.getQLevel().equals(Levels.Medium)) {
									answer = "medium question";
								} else {
									answer = "hard question";
								}
								System.out.println("questionnnn frame");

								// Create the QuestionFrame
								QuestionFrame qu = new QuestionFrame(myQ, new QuestionFrame.QuestionAnsweredListener() {
									@Override
									public void onQuestionAnswered(boolean isCorrect) {
										// This method will be called when the player answers the question
										g.updateByQuestion(myQ, isCorrect);
										System.out.println("Answered: " + isCorrect);
										// Continue with your logic here
									}
								});
								qu.setVisible(true);

								int awx=p.getPlayerRow();//new x
								int awy=p.getPlayerCol();// new y

								movePlayer(p, ax, ay,awx, awy);

							}if( g.UpdatePlayerPlace()!=0)
								break;

							int awx=p.getPlayerRow();//new x
							int awy=p.getPlayerCol();// new y

							movePlayer(p, ax, ay,awx, awy);

						}
						g.NextPlayer();
						lineMangment(g.CurrentTurn().getPlayeringame(), num);
					}/**************************question dice*************************8*/
					else {

						System.out.println("the current player is:" + p.getPlayerColor());
						System.out.println("questionnnnnnn type!!");
						q = (Question) CHECK;
						if (q.getQLevel().equals(Levels.Easy)) {
							diceLabel.setIcon(diceIcons[5]);
							answer = "easy question";
						} else if (q.getQLevel().equals(Levels.Medium)) {
							diceLabel.setIcon(diceIcons[7]);
							answer = "medium question";
						} else {
							diceLabel.setIcon(diceIcons[6]);
							answer = "hard question";
						}
						System.out.println("questionnnn frame");
						QuestionFrame qu = new QuestionFrame(q, new QuestionFrame.QuestionAnsweredListener() {
							@Override
							public void onQuestionAnswered(boolean isCorrect) {
								// This method will be called when the player answers the question
								g.updateByQuestion(q, isCorrect);
								System.out.println("Answered: " + isCorrect);
								// Continue with your logic here
								int ax = p.getPlayerRow();
								int ay = p.getPlayerCol();

								movePlayer(p, bx, by, ax, ay);    //move player by answer

								while (g.UpdatePlayerPlace() != 0) {//
									String answer="";
									if (g.checkQuestionSquare2() == true) {
										Question myQ = g.checkQuestionSquare();
										System.out.println("questionnnnnnn type from question square!!");

										if (myQ.getQLevel().equals(Levels.Easy)) {//check

											answer = "easy question";
										} else if (myQ.getQLevel().equals(Levels.Medium)) {

											answer = "medium question";
										} else {

											answer = "hard question";
										}
										System.out.println("questionnnn frame");
										QuestionFrame c = new QuestionFrame(myQ, new QuestionFrame.QuestionAnsweredListener() {
											@Override
											public void onQuestionAnswered(boolean isCorrect) {
												// This method will be called when the player answers the question
												g.updateByQuestion(myQ, isCorrect);
												System.out.println("Answered: " + isCorrect);
												// Continue with your logic here
											}
										});
										c.setVisible(true);
		

										int awx=p.getPlayerRow();//new x
										int awy=p.getPlayerCol();// new y

										movePlayer(p, ax, ay,awx, awy);

									}if( g.UpdatePlayerPlace()!=0)
										break;

									int awx = p.getPlayerRow();
									int awy = p.getPlayerCol();

									movePlayer(p, ax, ay, awx, awy);

								}
								g.NextPlayer();
								lineMangment(g.CurrentTurn().getPlayeringame(), num);
							}
						});
						qu.setVisible(true);
					}


					((Timer) e.getSource()).stop();
					// Simulate rolling and display the final result
					//JOptionPane.showMessageDialog(null, "You rolled: " + answer, "Dice Roll Result", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});



		timer.start();
	}


	public void movePlayer(Player player,int beforx,int befory,int afterx,int aftery) {//check
		System.out.println("The player is *******"+player.getPlayerColor()+" "+player.getPlayeringame());
		int pX=0,pY=0,bx=0,by=0;
		System.out.println("("+beforx+","+befory+")"+" to ("+afterx+","+aftery+")");


		switch(player.getPlayeringame()) {//check
		case 1:
			pX = 214 + afterx * 122; // Adjusted x position based on the board offset and grid size//170
			bx= 214 + beforx * 122;
			pY =641-aftery*86;
			by=641-befory*86;
			//p1OnGame.setLocation(pX, pY);
			break;
		case 2://+N
			pX = N+214 +afterx * 122; // Adjusted x position based on the board offset and grid size//170
			bx= 214 +N+ beforx * 122;
			pY =641-aftery*86;

			by=641-befory*86;
			break;
		case 3:
			pX = 214 + afterx * 122; // Adjusted x position based on the board offset and grid size//170
			bx= 214 + beforx * 122;
			pY =641-aftery*86+N;

			by=641-befory*86+N;
			//p1OnGame.setLocation(pX, pY);
			break;
		case 4://+N
			pX = N+214 +afterx * 122; // Adjusted x position based on the board offset and grid size//170
			bx= 214 +N+ beforx * 122;
			pY =641-aftery*86+N;

			by=641-befory*86+N;
			break;

		}

	
		final int finalBx = bx; // Declare effectively final variables
		final int finalBy = by;

		int steps = 50; // Number of steps for the movement
		double deltaX = (pX-bx) / (double) steps;
		double deltaY = (pY-by) / (double) steps;
		Timer timer = new Timer(20, null); // Create a timer without ActionListener
		timer.start(); // Start the timer
		final int[] count = {0};
		timer.addActionListener(e -> {
			if (count[0] < steps) {
				int newX = (int) (finalBx + deltaX * count[0]);
				int newY = (int) (finalBy+ deltaY * count[0]);
				if(player.getPlayeringame()==1)
					p1OnGame.setLocation(newX, newY);
				else if(player.getPlayeringame()==2)
					p2OnGame.setLocation(newX, newY);
				count[0]++;

			} else {
				timer.stop(); // Stop the timer when the movement is complete
			}
		});

	}
	public void setPlayerText(Player p,String text) {
		System.out.println(p.getNickName());
		System.out.println(text);
		mytext.setText(p+" "+text);
	}
	public void lineMangment(int turn,int num) {
		switch(num) {
		case 2:
			switch(turn) {
			case 1:
				p1Label.setLocation(35, 80);
				p1name.setLocation(73,70);
				p2Label.setLocation(35, 180);
				p1name.setLocation(73,170);
				break;
			case 2:
				p1Label.setLocation(35, 180);
				p1name.setLocation(73,170);
				p2Label.setLocation(35, 80);
				p2name.setLocation(73,70);
				break;	
			}
			break;


		case 3:
			switch(turn) {
			case 1:
				p1Label.setLocation(35, 80);
				p1name.setLocation(73,70);
				p2Label.setLocation(35, 180);
				p2name.setLocation(73,170);
				p3Label.setLocation(35, 280);
				p3name.setLocation(73,270);
				break;
			case 2:

				p2Label.setLocation(35, 80);
				p2name.setLocation(73,70);
				p3Label.setLocation(35, 180);
				p3name.setLocation(73,170);
				p1Label.setLocation(35, 280);
				p1name.setLocation(73,270);
				break;
			case 3:
				p3Label.setLocation(35, 80);
				p3name.setLocation(73,70);
				p1Label.setLocation(35, 180);
				p1name.setLocation(73,170);
				p2Label.setLocation(35, 280);
				p2name.setLocation(73,270);

			}
			break;
		case 4:
			switch(turn) {
			case 1:
				p1Label.setLocation(35, 80);
				p1name.setLocation(73,70);
				p2Label.setLocation(35, 180);
				p2name.setLocation(73,170);
				p3Label.setLocation(35, 280);
				p3name.setLocation(73,270);
				p4Label.setLocation(35, 380);
				p4name.setLocation(73,370);
				break;
			case 2:
				p2Label.setLocation(35, 80);
				p2name.setLocation(73,70);
				p3Label.setLocation(35, 180);
				p3name.setLocation(73,170);
				p4Label.setLocation(35, 280);
				p4name.setLocation(73,270);
				p1Label.setLocation(35, 380);
				p1name.setLocation(73,370);

				break;
			case 3:
				p3Label.setLocation(35, 80);
				p3name.setLocation(73,70);
				p4Label.setLocation(35, 180);
				p4name.setLocation(73,170);
				p1Label.setLocation(35, 280);
				p1name.setLocation(73,270);
				p2Label.setLocation(35, 380);
				p2name.setLocation(73,370);
				break;
			case 4:
				p4Label.setLocation(35, 80);
				p4name.setLocation(73,70);
				p1Label.setLocation(35, 180);
				p1name.setLocation(73,170);
				p2Label.setLocation(35, 280);
				p2name.setLocation(73,270);
				p3Label.setLocation(35, 380);
				p3name.setLocation(73,370);
				break;



			}
			break;

		}


	}
	public void setPlayer(Player player) {
		int pX,pY;
		switch(player.getPlayeringame()) {
		case 1:

			pX = 214 + player.getPlayerRow() * 122; // Adjusted x position based on the board offset and grid size//170
			pY =630-player.getPlayerCol()*59;
			System.out.println("setting player 1");
			p1OnGame.setBounds(pX, pY, N, N); // Set bounds for player p1 label

			// Add player p1 label to the content pane
			contentPane.add(p1OnGame);
			p1OnGame.setVisible(true);
			contentPane.setComponentZOrder(p1OnGame, 0);
			contentPane.revalidate();
			contentPane.repaint();

			break;
		case 2://+N
			pX = N+214+ player.getPlayerRow() * 122; // Adjusted x position based on the board offset and grid size//170
			pY =630-player.getPlayerCol()*59;
			System.out.println("setting player 2");
			p2OnGame.setBounds(pX, pY, N, N); // Set bounds for player p2 label

			// Add player p1 label to the content pane
			contentPane.add(p2OnGame);
			p2OnGame.setVisible(true);
			contentPane.setComponentZOrder(p2OnGame, 0);
			contentPane.revalidate();
			contentPane.repaint();
			break;
		case 3://+N
			pX = 214+ player.getPlayerRow() * 122; // Adjusted x position based on the board offset and grid size//170
			pY =N-15+630-player.getPlayerCol()*59;
			System.out.println("setting player 3");
			p3OnGame.setBounds(pX, pY, N, N); // Set bounds for player p2 label

			// Add player p1 label to the content pane
			contentPane.add(p3OnGame);
			p3OnGame.setVisible(true);
			contentPane.setComponentZOrder(p3OnGame, 0);
			contentPane.revalidate();
			contentPane.repaint();
			break;
		case 4://+N
			pX = N+214+ player.getPlayerRow() * 122; // Adjusted x position based on the board offset and grid size//170
			pY =N-15+630-player.getPlayerCol()*59;
			System.out.println("setting player 4");
			p4OnGame.setBounds(pX, pY, N, N); // Set bounds for player p2 label

			// Add player p1 label to the content pane
			contentPane.add(p4OnGame);
			p4OnGame.setVisible(true);
			contentPane.setComponentZOrder(p4OnGame, 0);
			contentPane.revalidate();
			contentPane.repaint();
			break;

		}



	}
	/*private void completeTask() {
		Timer timer = new Timer(20, null); // Create a timer without ActionListener
		int steps=3000;
		timer.start(); // Start the timer
		final int[] count = {0};
		timer.addActionListener(e -> {
			if (count[0] < steps) {

				count[0]++;

			} else {
				timer.stop(); // Stop the timer when the movement is complete
			}
		});

    }*/
	@Override
	public void onQuestionAnswered(boolean isCorrect) {
		// TODO Auto-generated method stub

	}
}
