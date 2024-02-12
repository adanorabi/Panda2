package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuestionFrame extends JFrame {

	private JPanel contentPane;
	private JLabel questionFrame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionFrame frame = new QuestionFrame();
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
	public QuestionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 854, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		submitButton.setBounds(646, 385, 141, 53);
		contentPane.add(submitButton);
		
		
		questionFrame = new JLabel("");
		questionFrame.setIcon(new ImageIcon(QuestionFrame.class.getResource("/View/img/questionFrame.jpg")));
		questionFrame.setBounds(5, 5, 830, 453);
		contentPane.add(questionFrame);

	}
}
//package View;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//
//import Model.Question;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class QuestionFrame extends JFrame {
//    private JLabel questionLabel;
//    private JButton[] answerButtons;
//	private JPanel contentPane;
//
//    private Question currentQuestion;
//    private String userAnswer;
//
//    public QuestionFrame(Question question) {
//        currentQuestion = question;
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(400, 100, 1200, 900);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//        setTitle("Question");
//        setSize(842, 425);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        
//    	JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon(EasyLevel.class.getResource("/View/img/EasyLevel.png")));
//		lblNewLabel.setBounds(0, 0, 824, 425);
//		getContentPane().add(lblNewLabel);
////        getContentPane().setLayout(new BorderLayout());
////
////        questionLabel = new JLabel(currentQuestion.getContent());
////        getContentPane().add(questionLabel, BorderLayout.NORTH);
////
////        JPanel answersPanel = new JPanel();
////        getContentPane().add(answersPanel, BorderLayout.CENTER);
////        answersPanel.setLayout(null);
//
//        answerButtons = new JButton[4];
//
//        ArrayList<String> shuffledAnswers = new ArrayList<>(currentQuestion.getAnswer());
//        Collections.shuffle(shuffledAnswers);
//
//
//        for (int i = 0; i < 4; i++) {
//            JButton button = new JButton(shuffledAnswers.get(i));
//            button.setPreferredSize(new Dimension(120, 40)); // Reduced button size
//            button.addActionListener(new AnswerButtonListener());
//            answerButtons[i] = button;
////            answersPanel.add(button);
//        }
//    }
//
//    private class AnswerButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            JButton button = (JButton) e.getSource();
//            userAnswer = button.getText();
//
//            if (userAnswer.equals(currentQuestion.getTrueAnswer())) {
//                JOptionPane.showMessageDialog(null, "Correct!");
//            } else {
//                JOptionPane.showMessageDialog(null, "Incorrect!");
//            }
//        }
//    }
//
//}
