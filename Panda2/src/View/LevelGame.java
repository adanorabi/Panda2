package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LevelGame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LevelGame frame = new LevelGame();
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
	public LevelGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 1106, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel_1 = new JLabel("Choose players numbers :");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		lblNewLabel_1.setBounds(261, 223, 294, 27);
		contentPane.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel("Choose game level :");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.ITALIC, 24));
		lblNewLabel_2.setBounds(261, 339, 300, 41);
		contentPane.add(lblNewLabel_2);
	}

}
