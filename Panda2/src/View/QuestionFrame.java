package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Enum.Levels;
import Model.Question;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class QuestionFrame extends JFrame {

	private JPanel contentPane;
	private JLabel questionFrame;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QuestionFrame frame = new QuestionFrame(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public QuestionFrame(Question question) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 854, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
        setAlwaysOnTop(true); // Make sure the frame stays on top


		JButton submitButton = new JButton("");
		//submitButton.setIcon(new ImageIcon(QuestionFrame.class.getResource("/View/img/submit.jpg")));
		ImageIcon icon = new ImageIcon(QuestionFrame.class.getResource("/View/img/submit.jpg"));
		Image image = icon.getImage(); // Transform it 
		Image newImage = image.getScaledInstance(120, 100, Image.SCALE_SMOOTH); // Resize it
		icon = new ImageIcon(newImage); // Convert back to ImageIcon
		submitButton.setIcon(icon);

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		submitButton.setBounds(635, 373, 115, 69);
		contentPane.add(submitButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(194, 62, 549, 66);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setText(question.getContent());
		
		if(question.getQLevel().equals(Levels.Easy))
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(627, 10, 203, 106);
			lblNewLabel_1.setIcon(new ImageIcon(QuestionFrame.class.getResource("/View/img/easyq.png")));
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Easy Question!");
			lblNewLabel_2.setForeground(new Color(0, 100, 0));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_2.setBounds(661, 107, 169, 29);
			contentPane.add(lblNewLabel_2);
		}else if(question.getQLevel().equals(Levels.Hard))
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(627, 10, 203, 106);
			lblNewLabel_1.setIcon(new ImageIcon(QuestionFrame.class.getResource("/View/img/hardq.png")));
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Hard Question!!!");
			lblNewLabel_2.setForeground(new Color(255, 0, 0));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_2.setBounds(661, 107, 169, 29);
			contentPane.add(lblNewLabel_2);
		}
		else if(question.getQLevel().equals(Levels.Medium))
		{
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(627, 10, 203, 106);
			lblNewLabel_1.setIcon(new ImageIcon(QuestionFrame.class.getResource("/View/img/medq.png")));
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Medium Question!!");
			lblNewLabel_2.setForeground(new Color(255, 165, 0));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_2.setBounds(661, 107, 169, 29);
			contentPane.add(lblNewLabel_2);
		}

	    ArrayList<String> shuffledAnswers = new ArrayList<>(question.getAnswer());
        Collections.shuffle(shuffledAnswers);
        
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(103, 153, 322, 66);
        rdbtnNewRadioButton.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14)); // Set font size here
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setBounds(491, 153, 311, 66);
		rdbtnNewRadioButton_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14)); // Set font size here

		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBackground(Color.WHITE);
		rdbtnNewRadioButton_2.setBounds(103, 286, 322, 66);
		rdbtnNewRadioButton_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14)); // Set font size here
		contentPane.add(rdbtnNewRadioButton_2);
		
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_3.setBackground(Color.WHITE);
		rdbtnNewRadioButton_3.setBounds(491, 296, 311, 59);
		rdbtnNewRadioButton_3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14)); // Set font size here
		contentPane.add(rdbtnNewRadioButton_3);
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnNewRadioButton);
		G.add(rdbtnNewRadioButton_1);
		G.add(rdbtnNewRadioButton_2);
		G.add(rdbtnNewRadioButton_3);
		for(int i=0 ; i<4; i++)
		{
			if (i==0)
			{
				rdbtnNewRadioButton.setText(shuffledAnswers.get(i));
			}
			if(i==1) {
				rdbtnNewRadioButton_1.setText(shuffledAnswers.get(i));

			}
			if(i==2)
			{
				rdbtnNewRadioButton_2.setText(shuffledAnswers.get(i));
			}
			if(i==3)
			{
				rdbtnNewRadioButton_3.setText(shuffledAnswers.get(i));
			}
		}
		submitButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Find out which radio button is selected
		        JRadioButton selectedRadioButton = null;
		        if (rdbtnNewRadioButton.isSelected()) {
		            selectedRadioButton = rdbtnNewRadioButton;
		        } else if (rdbtnNewRadioButton_1.isSelected()) {
		            selectedRadioButton = rdbtnNewRadioButton_1;
		        } else if (rdbtnNewRadioButton_2.isSelected()) {
		            selectedRadioButton = rdbtnNewRadioButton_2;
		        } else if (rdbtnNewRadioButton_3.isSelected()) {
		            selectedRadioButton = rdbtnNewRadioButton_3;
		        }
		        
		        if (selectedRadioButton != null) {
		            // Get the text of the selected radio button
		            String selectedAnswer = selectedRadioButton.getText();
		            
		            // Compare the selected answer with the correct answer
		            if (selectedAnswer.equals(question.getTrueAnswer())) {
		                // If the selected answer is correct
		                JOptionPane.showMessageDialog(contentPane, "Correct answer!");
		            } else {
		                // If the selected answer is incorrect
		                JOptionPane.showMessageDialog(contentPane, "Incorrect answer. Try again!");
		            }
		        } else {
		            // If no answer is selected
		            JOptionPane.showMessageDialog(contentPane, "Please select an answer.");
		        }
		    }
		});
		questionFrame = new JLabel("");
		questionFrame.setIcon(new ImageIcon(QuestionFrame.class.getResource("/View/img/questionFrame.jpg")));
		questionFrame.setBounds(5, 5, 830, 453);
		contentPane.add(questionFrame);
		

	}
}
