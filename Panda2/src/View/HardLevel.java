package View;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Game;
import Enum.*;


public class HardLevel extends JFrame {

	private JPanel contentPane;
	private JLabel lblHardTable; // Label for the Hardtable image
	private JLabel lblSnake; 
	private JLabel glblSnake;// Label for the snake image
	private JLabel rlblSnake;
	private JLabel ylblSnake;
	private JLabel lblLadder; 
	private JLabel lblsur;
	private JLabel lblq;

	/**
	 * Create the frame.
	 */
	public HardLevel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Label for the Hardtable image
				lblHardTable = new JLabel("");
				lblHardTable.setIcon(new ImageIcon(HardLevel.class.getResource("/View/img/hard.jpg")));
				lblHardTable.setBounds(171,130, 1005, 560);/*43 */
				contentPane.add(lblHardTable);
				
				JLabel lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.setIcon(new ImageIcon(HardLevel.class.getResource("/View/img/dice-1.png")));
				lblNewLabel_2.setBounds(27, 633, 150, 150);
				contentPane.add(lblNewLabel_2);

				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(HardLevel.class.getResource("/View/img/game.png")));
				lblNewLabel.setBounds(0, 0, 1200, 900);//
				contentPane.add(lblNewLabel);
				Game g=new Game(3, Levels.Hard,13, 13);
				g.createGame();
				g.PlacespecialSquares(Levels.Hard);
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
				for (i=0 ; i<13; i++)
				{
					for (j=0 ; j<13; j++ )
					{
						if(g.getPlaces()[i][j]==2) {
							setsurprise(i, j);
							System.out.println("surprise (" + i + "," + j + "):" );
						}
						else if(g.getPlaces()[i][j]==3) {
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
		int snakeHeadX = 171 + xhead * 76; // Adjusted x position based on the board offset and grid size
		int snakeHeadY = 647 - yhead * 43; // Adjusted y position based on the board offset and grid size
		int snakeTailX = 171 + xtail * 76; // Adjusted x position based on the board offset and grid size
		int snakeTailY = 647 - ytail * 43; // Adjusted y position based on the board offset and grid size

		// Calculate the size of the snake image
		int snakeWidth = Math.abs(snakeHeadX - snakeTailX) + 75; // Adjusted width based on grid size
		int snakeHeight = Math.abs(snakeHeadY - snakeTailY) + 35; // Adjusted height based on grid size

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
		// Load the snake image
		ImageIcon snakeIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/greensnake.png"));
		int snakeHeadX = 171 + xhead * 76; // Adjusted x position based on the board offset and grid size
		int snakeHeadY = 647 - yhead * 43; // Adjusted y position based on the board offset and grid size
		int snakeTailX = 171 + xtail * 76; // Adjusted x position based on the board offset and grid size
		int snakeTailY = 647 - ytail * 43; // Adjusted y position based on the board offset and grid size

		// Calculate the size of the snake image
		int snakeWidth = Math.abs(snakeHeadX - snakeTailX) + 75; // Adjusted width based on grid size
		int snakeHeight = Math.abs(snakeHeadY - snakeTailY) + 43; // Adjusted height based on grid size


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
		int snakeHeadX = 178 + xhead * 77; // Adjusted x position based on the board offset and grid size
		int snakeHeadY =660-yhead*43;

		// Calculate the size of the snake image
		int snakeWidth = 40; // Adjusted width based on grid size
		int snakeHeight = 25;//Adjusted height based on grid size

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

		int snakeHeadX = 171 + xhead * 76; // Adjusted x position based on the board offset and grid size
		int snakeHeadY = 647 - yhead * 43; // Adjusted y position based on the board offset and grid size
		int snakeTailX = 171 + xtail * 76; // Adjusted x position based on the board offset and grid size
		int snakeTailY = 647 - ytail * 43; // Adjusted y position based on the board offset and grid size

		// Calculate the size of the snake image
		int snakeWidth = Math.abs(snakeHeadX - snakeTailX) + 75; // Adjusted width based on grid size
		int snakeHeight = Math.abs(snakeHeadY - snakeTailY) + 43; // Adjusted height based on grid size


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
		int ladderHeadX = 171 + xhead * 77; // Adjusted x position based on the board offset and grid size
		int ladderHeadY = 647 - yhead * 43; // Adjusted y position based on the board offset and grid size
		int ladderTailX = 171 + xtail * 77; // Adjusted x position based on the board offset and grid size
		int ladderTailY = 647 - ytail * 43; // Adjusted y position based on the board offset and grid size
		ImageIcon ladderIcon=null;
		// Calculate the size of the ladder image
		int ladderWidth = Math.abs(ladderHeadX - ladderTailX) + 70; // Adjusted width based on grid size
		int ladderHeight = Math.abs(ladderHeadY - ladderTailY) + 37; // Adjusted height based on grid size


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
			break;
		case 6:
			ladderIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/ladder6.png"));
			break;
		case 7: 
			ladderIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/ladder7.png"));
			break;
		case 8: 
			ladderIcon = new ImageIcon(EasyLevel.class.getResource("/View/img/ladder8.png"));
			break;
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


	}


