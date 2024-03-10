package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.SysData;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Enum.Levels;
import Model.Question;

public class editQ extends JFrame {
	private table2 parentFrame; // Reference to the parent frame (table2)
	private JPanel contentPane;
	private JLabel questionFrame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JButton Submit;

	// frame that edit question deatils for choosen question - ghaidaa
	public editQ(table2 parent, Question q, int modelRow) {
		// the question that the user want to edit - ghaidaa
		Question oldQuestion=new Question(SysData.QuestionId++,q.getQLevel(),q.getContent(), q.getAnswer(), q.getTrueAnswer());

		this.parentFrame = parent;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false); // Hide the addQuestion frame
			}
		});
		setBounds(500, 200, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ArrayList<String> answers=new ArrayList<String>();
		for(String temp: q.getAnswer()) {
			if(!temp.equals(q.getTrueAnswer())) {
				answers.add(temp);
			}
		}

		// present the content of the choosen question - ghaidaa
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

		// present the correct answer of the choosen question - ghaidaa
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

		// present the other answers of the choosen question - ghaidaa 
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
		//  the level of the question is the default value - ghaidaa
		comboBox.setSelectedItem(q.getQLevel()); 

		// close the window and return to table2 frame
		JButton back = new JButton("back button");
		back.setBounds(79, 553, 130, 46);
		ImageIcon backIcon = new ImageIcon(getClass().getResource("/View/img/back.jpg"));
		Image backimg = backIcon.getImage();
		Image resizedImg = backimg.getScaledInstance(145, 46, Image.SCALE_SMOOTH);
		back.setIcon(new ImageIcon(resizedImg));
		contentPane.add(back);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		
		Submit = new JButton("Submit");
		Submit.setBounds(723, 553, 120, 46);
		ImageIcon SubmitIcon = new ImageIcon(getClass().getResource("/View/img/submit.jpg"));
		Image Submitimg = SubmitIcon.getImage();
		Image resizedImg2 = Submitimg.getScaledInstance(140, 46, Image.SCALE_SMOOTH);
		Submit.setIcon(new ImageIcon(resizedImg2));
		contentPane.add(Submit);
		// edit the question  - ghaidaa
		Submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String editedContent = textField.getText();
				String editedTrueAnswer = textField_1.getText();
				String editedAnswer2 = textField_2.getText();
				String editedAnswer3 = textField_3.getText();
				String editedAnswer4 = textField_4.getText();
				Levels editedLevel = (Levels) comboBox.getSelectedItem();

				q.setContent(editedContent);
				q.setTrueAnswer(editedTrueAnswer);
				ArrayList<String> otherAnswers = new ArrayList<>();
				otherAnswers.add(editedAnswer2);
				otherAnswers.add(editedAnswer3);
				otherAnswers.add(editedAnswer4);
				q.setAnswer(otherAnswers);
				q.setQLevel(editedLevel);

				// Update the question in the allQuestions ArrayList - ghaidaa
				int index = parentFrame.getAllQuestions().indexOf(q);
				parentFrame.getAllQuestions().set(index, q);
				Question [] questions= new Question[2];
				questions[0]=oldQuestion;
				questions[1]=q;
				System.out.println("This is old question"+oldQuestion);
				System.out.println("This is new question"+q);
				SysData.editQuestion(questions); // editing the question in json file

				// Update the table directly in the parent frame (table2) - ghaidaa
				parentFrame.updateTable();

				// Dispose of the editQ frame - ghaidaa
				dispose();
			}
		});
		// background - ghaidaa
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
