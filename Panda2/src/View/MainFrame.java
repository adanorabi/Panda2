package View;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("start");/*adding start button*/
		btnNewButton.addActionListener(this);
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/View/img/start.png")));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(427, 266, 125, 130);
		
		contentPane.add(btnNewButton);

		
		
		
	}//			

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s=e.getActionCommand();
		if(s.equals("start")) {/*start the game and move to levelgame frame*/
			LevelGame lframe=new LevelGame();
			this.setVisible(false);
			lframe.setVisible(true);
			
		}
	}
}
