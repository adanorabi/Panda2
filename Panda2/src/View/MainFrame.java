package View;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	private JButton btnNewButton;
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("start");/*adding start button*/
		btnNewButton.addActionListener(this);
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/View/img/start.png")));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(427, 266, 125, 130);
		 /*btnNewButton.addMouseListener(new MouseListener() {
	            @Override
	            public void mouseClicked(MouseEvent e) {}

	            @Override
	            public void mousePressed(MouseEvent e) {}

	            @Override
	            public void mouseReleased(MouseEvent e) {}

	            @Override
	            public void mouseEntered(MouseEvent e) {
	                // Scale up the button when mouse enters
	                btnNewButton.setBounds(417, 256, 145, 150);
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                // Scale back to original size when mouse exits
	                btnNewButton.setBounds(427, 266, 125, 130);
	            }
	        });*/

		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("inst");/*adding instructions button*/
		
		btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("/View/img/instructions.png")));
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setBounds(584, 266, 125, 130);
		contentPane.add(btnNewButton_1);


		JButton btnNewButton_2 = new JButton("hist");/*adding history button*/
		btnNewButton_2.setIcon(new ImageIcon(getClass().getResource("/View/img/history.png")));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setBounds(584, 418, 125, 130);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");/*adding q button*/
		
		btnNewButton_3.setIcon(new ImageIcon(getClass().getResource("/View/img/question.png")));
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.setBounds(427, 418, 125, 130);
		contentPane.add(btnNewButton_3);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 10, 1106, 645);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/View/img/MainBG.png")));
		contentPane.add(lblNewLabel);
		
		
		
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
