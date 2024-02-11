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



	}

}
