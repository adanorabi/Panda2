package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.Game;
import Enum.*;


public class MediumLevel extends JFrame {
	private JPanel contentPane;

	private JLabel lblSnake; 
	private JLabel glblSnake;// Label for the snake image
	private JLabel rlblSnake;
	private JLabel ylblSnake;
	private JLabel lblsur;
	private JLabel lblq;
	private JLabel lblLadder; 

	/**
	 * Create the frame.
	 */
	public MediumLevel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MediumLevel.class.getResource("/View/img/mid.jpg")));
		lblNewLabel_1.setBounds(185, 110, 940,585);//94,59
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MediumLevel.class.getResource("/View/img/dice-1.png")));
		lblNewLabel_2.setBounds(0, 532, 175, 230);
		contentPane.add(lblNewLabel_2);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MediumLevel.class.getResource("/View/img/game.png")));
		lblNewLabel.setBounds(0, 0, 1200,900);
		contentPane.add(lblNewLabel);
	}

}