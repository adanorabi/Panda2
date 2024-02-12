package View;

import javax.swing.*;

import Model.Question;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class QuestionFrame extends JFrame {
    private JLabel questionLabel;
    private JButton[] answerButtons;

    private Question currentQuestion;
    private String userAnswer;

    public QuestionFrame(Question question) {
        currentQuestion = question;

        setTitle("Question");
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setLayout(new BorderLayout());

        questionLabel = new JLabel("<html><span style='font-size:16px; font-weight:bold;'>" + currentQuestion.getContent() + "</span></html>");
        getContentPane().add(questionLabel, BorderLayout.NORTH);

        JPanel answersPanel = new JPanel(new GridLayout(2, 2));
        getContentPane().add(answersPanel, BorderLayout.CENTER);

        answerButtons = new JButton[4];

        ArrayList<String> shuffledAnswers = new ArrayList<>(currentQuestion.getAnswer());
        Collections.shuffle(shuffledAnswers);

        Color[] buttonColors = {Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE};

        for (int i = 0; i < 4; i++) {
            JButton button = new JButton(shuffledAnswers.get(i));
            button.setPreferredSize(new Dimension(120, 40)); // Reduced button size
            button.addActionListener(new AnswerButtonListener());
            answerButtons[i] = button;
            button.setBackground(buttonColors[i]); // Set button background color
            answersPanel.add(button);
        }
    }

    private class AnswerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            userAnswer = button.getText();

            if (userAnswer.equals(currentQuestion.getTrueAnswer())) {
                JOptionPane.showMessageDialog(null, "Correct!");
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect!");
            }
        }
    }

}
