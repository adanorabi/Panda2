package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Enum.Levels;
import Model.Game;

public class EasyLevel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
		Game g=new Game(3, Levels.Easy, 7, 7);
		g.createGame();
		g.PlacespecialSquares(Levels.Easy);
		g.placeNormalSquares();
		g.PlaceSnakes();
		g.placeLadders();
		int i, j;
	}

}
