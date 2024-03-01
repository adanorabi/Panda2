package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Enum.Levels;
import Model.Question;

public class editQ extends JFrame {
	  private JPanel contentPane;
	    private JLabel questionFrame;
	    private JTextField textField;
	    private JTextField textField_1;
	    private JTextField textField_2;
	    private JTextField textField_3;
	    private JTextField textField_4;
	    private JLabel lblNewLabel_3;

//	 * /Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					editQ frame = new editQ();
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
	public editQ(Question q) {
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(500, 200, 1000, 700);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        ArrayList<String> answers=new ArrayList<String>();
	        for(String temp: q.getAnswer())
	        {
	        	if(!temp.equals(q.getTrueAnswer()))
	        	{
	        		answers.add(temp);
	        	}
	        }
	        
	        JLabel lblNewLabel = new JLabel("the content of the new question:");
	        lblNewLabel.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
	        lblNewLabel.setBounds(258, 72, 300, 38);
	        contentPane.add(lblNewLabel);
	        
	        textField = new JTextField("");
	        textField.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
	        textField.setBounds(257, 114, 404, 36);
	        contentPane.add(textField);
	        textField.setColumns(10);
	        textField.setText(q.getContent());
	        
	        JLabel lblNewLabel_1 = new JLabel("The right answer :");
	        lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
	        lblNewLabel_1.setBounds(258, 161, 203, 25);
	        contentPane.add(lblNewLabel_1);
	        
	        textField_1 = new JTextField("");
	        textField_1.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
	        textField_1.setBounds(257, 196, 404, 38);
	        contentPane.add(textField_1);
	        textField_1.setColumns(10);
	        textField_1.setText(q.getTrueAnswer());
	        
	        JLabel lblNewLabel_2 = new JLabel("Other answers : ");
	        lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
	        lblNewLabel_2.setBounds(257, 242, 250, 25);
	        contentPane.add(lblNewLabel_2);
	        
	        textField_2 = new JTextField("");
	        textField_2.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
	        textField_2.setBounds(255, 281, 404, 38);
	        contentPane.add(textField_2);
	        textField_2.setColumns(10);
	        textField_2.setText(answers.get(0));

	        
	        textField_3 = new JTextField("");
	        textField_3.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
	        textField_3.setBounds(256, 345, 404, 38);
	        contentPane.add(textField_3);
	        textField_3.setColumns(10);
	        textField_3.setText(answers.get(1));

	        textField_4 = new JTextField("");
	        textField_4.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
	        textField_4.setColumns(10);
	        textField_4.setBounds(256, 412, 404, 38);
	        contentPane.add(textField_4);
	        textField_4.setText(answers.get(2));

	        lblNewLabel_3 = new JLabel("Level:");
	        lblNewLabel_3.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
	        lblNewLabel_3.setBounds(258, 470, 71, 26);
	        contentPane.add(lblNewLabel_3);
	        
	        JComboBox comboBox = new JComboBox();
	        comboBox.setBounds(318, 471, 119, 25);
	        contentPane.add(comboBox);
	        comboBox.addItem(Levels.Easy);
	        comboBox.addItem(Levels.Medium);
	        comboBox.addItem(Levels.Hard);

	        questionFrame = new JLabel("");
	        questionFrame.setIcon(new ImageIcon(QuestionFrame.class.getResource("/View/img/sky.png")));
	        questionFrame.setBounds(0, -70, 1005, 805);
	        contentPane.add(questionFrame);
	        // Set border color dynamically
	        textField_1.setBorder(new LineBorder(Color.GREEN)); // Set the correct answer border color to green
	        textField_2.setBorder(new LineBorder(Color.RED));   // Set other answer border color to red
	        textField_3.setBorder(new LineBorder(Color.RED));   // Set other answer border color to red
	        textField_4.setBorder(new LineBorder(Color.RED));   // Set other answer border color to red
	}

}
