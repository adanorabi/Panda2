package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Model.Game;
import Model.Player;
import Enum.*;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MediumLevel extends JFrame {
	static int N=50;
	private JPanel contentPane;
	private JLabel mytext;
	private JLabel lblSnake; 
	private JLabel glblSnake;// Label for the snake image
	private JLabel rlblSnake;
	private JLabel ylblSnake;
	private JLabel lblsur;
	private JLabel lblq;
	private JLabel lblLadder; 
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
	/**
	 * Create the frame.
	 */
	public MediumLevel(Player p1,Player p2, Player p3,Player p4,int num) {
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
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MediumLevel.class.getResource("/View/img/mid.jpg")));
		lblNewLabel_1.setBounds(185, 110, 940,585);//94,59
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MediumLevel.class.getResource("/View/img/dice-1.png")));
		lblNewLabel_2.setBounds(0, 532, 175, 230);
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
		int p1Y = 180; // Adjusted y position based on the board offset and grid size
		p1Label.setBounds(p1X, p1Y, 100, 100); // Set bounds for player p1 label

		contentPane.add(p1Label);


		// Add player p1 label to the content pane
		contentPane.add(p1Label);

		// Ensure player p1 label is visible
		p1Label.setVisible(true);

		p1name = new JLabel(p1.getNickName());
		p1name.setFont(new Font("Times New Roman", Font.BOLD, 16));
		p1name.setBounds(73, 171, 200, 13);
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
			imgIcn2=new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
		}
		else {
			p2icon= new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));
			imgIcn2=new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
		}
		Image scaledP2Image = p2icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon scaledP2Icon = new ImageIcon(scaledP2Image);
		// Create a JLabel for player p2
		p2Label = new JLabel(scaledP2Icon);
		p2Label.setBounds(p1X, 280, 100, 100); // Set bounds for player p1 label

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
		p2name.setBounds(73, 270, 200, 13);
		contentPane.add(p2name);

		/******************************p3***************/

		if(num>2) {
			ImageIcon p3icon;
			if(p3.getPlayerColor()==PlayerColor.Red)
				p3icon= new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
			else if(p3.getPlayerColor()==PlayerColor.Green)
				p3icon= new ImageIcon(EasyLevel.class.getResource("/View/img/g.png"));
			else if(p3.getPlayerColor()==PlayerColor.Blue)
				p3icon= new ImageIcon(EasyLevel.class.getResource("/View/img/b.png"));
			else 
				p3icon= new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));
			Image scaledP3Image = p3icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon scaledP3Icon = new ImageIcon(scaledP3Image);
			// Create a JLabel for player p2
			p3Label = new JLabel(scaledP3Icon);
			p3Label.setBounds(p1X, 380, 100, 100); // Set bounds for player p1 label

			// Add player p1 label to the content pane
			contentPane.add(p3Label);

			// Ensure player p1 label is visible
			p3Label.setVisible(true);

			p3name = new JLabel(p3.getNickName());
			p3name.setFont(new Font("Times New Roman", Font.BOLD, 16));
			p3name.setBounds(73, 370, 200, 13);
			contentPane.add(p3name);


			if(num==4) {
				ImageIcon p4icon;
				if(p4.getPlayerColor()==PlayerColor.Red)
					p4icon= new ImageIcon(EasyLevel.class.getResource("/View/img/r.png"));
				else if(p4.getPlayerColor()==PlayerColor.Green)
					p4icon= new ImageIcon(EasyLevel.class.getResource("/View/img/g.png"));
				else if(p4.getPlayerColor()==PlayerColor.Blue)
					p4icon= new ImageIcon(EasyLevel.class.getResource("/View/img/b.png"));
				else 
					p4icon= new ImageIcon(EasyLevel.class.getResource("/View/img/y.png"));
				Image scaledP4Image = p4icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				ImageIcon scaledP4Icon = new ImageIcon(scaledP4Image);
				// Create a JLabel for player p2
				p4Label = new JLabel(scaledP4Icon);
				p4Label.setBounds(p1X, 480, 100, 100); // Set bounds for player p1 label

				// Add player p1 label to the content pane
				contentPane.add(p4Label);

				// Ensure player p1 label is visible
				p4Label.setVisible(true);

				p4name = new JLabel(p4.getNickName());
				p4name.setFont(new Font("Times New Roman", Font.BOLD, 16));
				p4name.setBounds(73, 470, 200, 13);
				contentPane.add(p4name);

			}
		}

		/********************p4***********/



		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MediumLevel.class.getResource("/View/img/game.png")));
		lblNewLabel.setBounds(0, 0, 1200,900);
		contentPane.add(lblNewLabel);

		Game g=new Game(3, Levels.Medium,10, 10);
		g.getPlayers().add(p1);
		g.getPlayers().add(p2);

		if(num>2) {
			JLabel lblNewLabel_5 = new JLabel("p3");
			lblNewLabel_5.setBounds(73, 310, 45, 13);
			contentPane.add(lblNewLabel_5);
			g.getPlayers().add(p3);
			if(num==4) {

				JLabel lblNewLabel_4_1 = new JLabel("p4");
				lblNewLabel_4_1.setBounds(73, 372, 45, 13);
				contentPane.add(lblNewLabel_4_1);
				g.getPlayers().add(p4);
			}
		}
		g.createGame();
		JButton btnNewButton = new JButton("move player");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int next=g.CurrentTurn().getPlayeringame()+1;
				int current=1;
				int beforx=0;
				int befory=0;
				 
				/*beforx=g.getPlayers().get(current).getPlayerRow();	 
				g.getPlayers().get(current).UpdateRow(4);
				movePlayer(g.getPlayers().get(current).UpdateRow(4),beforx,befory);
				*/
				
				beforx=p1.getPlayerRow();	 
				befory=p1.getPlayerCol();	
				p1.UpdateRow(4);//update player func
				
				//call for change cordenation
				movePlayer(p1,beforx,befory);
				
				lineMangment(next,num);
				
				
			}
		});
		/****************************************************************************************************/
		btnNewButton.setBounds(50, 641, 85, 21);
		contentPane.add(btnNewButton);
		
	
		g.PlacespecialSquares(Levels.Medium);
		g.placeNormalSquares();
		g.PlaceSnakes();
		g.placeLadders();
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
		for (i=0 ; i<10; i++)
		{
			for (j=0 ; j<10; j++ )
			{
				if(g.getPlaces()[i][j]==2||g.getPlaces()[i][j]==1) {
					setsurprise(i, j);
					System.out.println("surprise (" + i + "," + j + "):" );
				}
				else if(g.getPlaces()[i][j]==3||g.getPlaces()[i][j]==4||g.getPlaces()[i][j]==5) {
					setq(i, j);
					System.out.println("question (" + i + "," + j + "):" );

				}
			}
		}

	}


	public void setbluesnake(int xhead, int yhead, int xtail, int ytail) {
		// Load the snake image
		ImageIcon snakeIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/bluesnake2.png"));

		// Calculate the position of the snake head and tail
		int snakeHeadX = 185 + xhead * 122; // Adjusted x position based on the board offset and grid size
		int snakeHeadY = 630- yhead * 58; // Adjusted y position based on the board offset and grid size
		int snakeTailX = 185 + xtail * 122; // Adjusted x position based on the board offset and grid size
		int snakeTailY =  630- ytail * 58; // Adjusted y position based on the board offset and grid size

		// Calculate the size of the snake image
		int snakeWidth = Math.abs(snakeHeadX - snakeTailX) + 122; // Adjusted width based on grid size
		int snakeHeight = Math.abs(snakeHeadY - snakeTailY) + 59; // Adjusted height based on grid size

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
	public void setgreensnake(int xhead, int yhead, int xtail, int ytail) {
		// Load the snake image
		ImageIcon snakeIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/greensnake.png"));

		// Calculate the position of the snake head and tail
		int snakeHeadX = 185 + xhead * 94; // Adjusted x position based on the board offset and grid size
		int snakeHeadY =  630  - yhead * 58; // Adjusted y position based on the board offset and grid size
		int snakeTailX = 188 + xtail * 94; // Adjusted x position based on the board offset and grid size
		int snakeTailY =  630  - ytail * 58; // Adjusted y position based on the board offset and grid size

		// Calculate the size of the snake image
		int snakeWidth = Math.abs(snakeHeadX - snakeTailX) + 94; // Adjusted width based on grid size
		int snakeHeight = Math.abs(snakeHeadY - snakeTailY) + 59; // Adjusted height based on grid size

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
	public void setredsnake(int xhead, int yhead) {
		// Load the snake image
		ImageIcon snakeIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/redsnake.png"));

		// Calculate the position of the snake head and tail
		int snakeHeadX = 185 + xhead * 94; // Adjusted x position based on the board offset and grid size//170
		int snakeHeadY =650-yhead*59;

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
	public void  setyellowsnake(int xhead, int yhead, int xtail, int ytail) {
		ImageIcon snakeIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/yellosnake.png"));

		// Calculate the position of the snake head and tail
		int snakeHeadX = 185 + xhead * 94; // Adjusted x position based on the board offset and grid size
		int snakeHeadY = 630 - yhead * 59; // Adjusted y position based on the board offset and grid size
		int snakeTailX = 185 + xtail * 94; // Adjusted x position based on the board offset and grid size
		int snakeTailY = 630 - ytail * 59; // Adjusted y position based on the board offset and grid size
		// Calculate the size of the snake image
		int snakeWidth = Math.abs(snakeHeadX - snakeTailX) + 94; // Adjusted width based on grid size
		int snakeHeight = Math.abs(snakeHeadY - snakeTailY) + 59; // Adjusted height based on grid size

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

	public void setLadders(int typeOfLader, int xhead, int yhead, int xtail, int ytail) {
		int ladderHeadX = 190 + xhead * 94; // Adjusted x position based on the board offset and grid size
		int ladderHeadY = 620 - yhead * 59; // Adjusted y position based on the board offset and grid size
		int ladderTailX = 190 + xtail * 94; // Adjusted x position based on the board offset and grid size
		int ladderTailY = 620 - ytail * 59; // Adjusted y position based on the board offset and grid size
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
		case 5:
			ladderIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/ladder5.png"));
		case 6:
			ladderIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/ladder6.png"));
		default:
			// Default ladder image

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
		int sX = 200 + x * 94; 
		int sY =639-y*58;

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
		int sX = 200 + x * 94; 
		int sY =650-y*58;

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

	public void setPlayer(Player player) {
		int pX,pY;
		switch(player.getPlayeringame()) {
		case 1:
			pX = 185 + player.getPlayerRow() * 94; // Adjusted x position based on the board offset and grid size//170
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
			pX = N+185 + player.getPlayerRow() * 94; // Adjusted x position based on the board offset and grid size//170
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

		}



	}
	public void movePlayer(Player player,int beforx,int befory) {
		int pX=0,pY=0,bx=0,by=0;
		

		switch(player.getPlayeringame()) {
		case 1:
			pX = 185 + player.getPlayerRow() * 94; // Adjusted x position based on the board offset and grid size//170
			//p1OnGame.setLocation(pX, pY);
			break;
		case 2://+N
			pX = N+185 + player.getPlayerRow() * 94; // Adjusted x position based on the board offset and grid size//170
			break;

		}
		pY =630-player.getPlayerCol()*59;
		bx= 185 + beforx * 94;
		by=630-befory*59;
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
	                p1OnGame.setLocation(newX, newY);
	                count[0]++;
	            } else {
	                timer.stop(); // Stop the timer when the movement is complete
	            }
	        });


	}
	public void setPlayerText(Player p,String text) {
		mytext.setText(p.getNickName()+" "+text);
	}
	public void lineMangment(int turn,int num) {
		switch(num) {
		case 2:
			switch(turn) {
			case 1:
				p1Label.setLocation(35, 180);
				p1name.setLocation(73,170);
				p2Label.setLocation(35, 280);
				p1name.setLocation(73,270);
				break;
			case 2:
				p1Label.setLocation(35, 280);
				p1name.setLocation(73,270);
				p2Label.setLocation(35, 180);
				p2name.setLocation(73,170);
				break;	
			}
			break;
		
		
		case 3:
			switch(turn) {
			case 1:
				p1Label.setLocation(35, 180);
				p1name.setLocation(73,170);
				p2Label.setLocation(35, 280);
				p2name.setLocation(73,270);
				p3Label.setLocation(35, 380);
				p3name.setLocation(73,370);
				break;
			case 2:

				p2Label.setLocation(35, 180);
				p2name.setLocation(73,170);
				p3Label.setLocation(35, 280);
				p3name.setLocation(73,270);
				p1Label.setLocation(35, 380);
				p1name.setLocation(73,370);
				break;
			case 3:
				p3Label.setLocation(35, 180);
				p3name.setLocation(73,170);
				p1Label.setLocation(35, 280);
				p1name.setLocation(73,270);
				p2Label.setLocation(35, 380);
				p2name.setLocation(73,370);
				
			}
			break;
		case 4:
			switch(turn) {
			case 1:
				p1Label.setLocation(35, 180);
				p1name.setLocation(73,170);
				p2Label.setLocation(35, 280);
				p2name.setLocation(73,270);
				p3Label.setLocation(35, 380);
				p3name.setLocation(73,370);
				p4Label.setLocation(35, 480);
				p4name.setLocation(73,470);
				break;
			case 2:
				p2Label.setLocation(35, 180);
				p2name.setLocation(73,170);
				p3Label.setLocation(35, 280);
				p3name.setLocation(73,270);
				p4Label.setLocation(35, 380);
				p4name.setLocation(73,370);
				p1Label.setLocation(35, 480);
				p1name.setLocation(73,470);
			
				break;
			case 3:
				p3Label.setLocation(35, 180);
				p3name.setLocation(73,170);
				p4Label.setLocation(35, 280);
				p4name.setLocation(73,270);
				p1Label.setLocation(35, 380);
				p1name.setLocation(73,370);
				p2Label.setLocation(35, 480);
				p2name.setLocation(73,470);
				break;
			case 4:
				p4Label.setLocation(35, 180);
				p4name.setLocation(73,170);
				p1Label.setLocation(35, 280);
				p1name.setLocation(73,270);
				p2Label.setLocation(35, 380);
				p2name.setLocation(73,370);
				p3Label.setLocation(35, 480);
				p3name.setLocation(73,470);
				break;
				
			
				
			}
			break;
		
	}
		
		
	}
}