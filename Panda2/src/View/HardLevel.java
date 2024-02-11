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

	}

}
