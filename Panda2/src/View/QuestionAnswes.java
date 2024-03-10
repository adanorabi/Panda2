package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import Model.Question;

// frame that present details for choosen question with 4 answers - ghaidaa
public class QuestionAnswes extends JFrame {

    private JPanel contentPane;

    public QuestionAnswes(Question q) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false); // Hide the addQuestion frame
            }
        });
        setBounds(400, 30, 1100, 1000);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // arraylist that contain the false answers - ghaidaa
        ArrayList<String> answers=new ArrayList<String>();
        for(String temp: q.getAnswer())
        {
        	if(!temp.equals(q.getTrueAnswer()))
        	{
        		answers.add(temp);
        	}
        }
        
        // set the contant of the question - ghaidaa
        JLabel Qu = new JLabel("");
        Qu.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Qu.setBounds(329, 51, 544, 175);
        contentPane.add(Qu);
        String questionText = q.getContent();
        String formattedQuestionText = insertLineBreaks(questionText);
        Qu.setText("<html>" + formattedQuestionText + "</html>");
        Qu.setForeground(Color.WHITE);
        
        // set the true answer - ghaidaa
        JLabel TrueAns = new JLabel("");
        TrueAns.setFont(new Font("Tahoma", Font.PLAIN, 15));
        TrueAns.setBounds(519, 296, 415, 116);
        contentPane.add(TrueAns);
        questionText = q.getTrueAnswer();
        formattedQuestionText = insertLineBreaks(questionText);
        TrueAns.setText("<html>" + formattedQuestionText + "</html>");
        TrueAns.setForeground(Color.WHITE);

        // present the false answers - ghaidaa
        JLabel falseAns1 = new JLabel("New label");
        falseAns1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        falseAns1.setBounds(592, 479, 415, 103);
        contentPane.add(falseAns1);
        questionText = answers.get(0);
        formattedQuestionText = insertLineBreaks(questionText);
        falseAns1.setText("<html>" + formattedQuestionText + "</html>");
        falseAns1.setForeground(Color.WHITE);

        JLabel falseAns2 = new JLabel("New label");
        falseAns2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        falseAns2.setBounds(620, 655, 427, 103);
        contentPane.add(falseAns2);
        questionText = answers.get(1);
        formattedQuestionText = insertLineBreaks(questionText);
        falseAns2.setText("<html>" + formattedQuestionText + "</html>");
        falseAns2.setForeground(Color.WHITE);

        JLabel falseAns3 = new JLabel("New label");
        falseAns3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        falseAns3.setBounds(541, 822, 427, 103);
        contentPane.add(falseAns3);
        questionText = answers.get(2);
        formattedQuestionText = insertLineBreaks(questionText);
        falseAns3.setText("<html>" + formattedQuestionText + "</html>");
        falseAns3.setForeground(Color.WHITE);
        
        // back button that return the user to question management - ghaidaa
        JButton back = new JButton("back button");
        back.setBounds(79, 793, 170, 69);
        ImageIcon backIcon = new ImageIcon(getClass().getResource("/View/img/back.jpg"));
		Image backimg = backIcon.getImage();
		Image resizedImg = backimg.getScaledInstance(200, 69, Image.SCALE_SMOOTH);
		back.setIcon(new ImageIcon(resizedImg));
        contentPane.add(back);
        back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(10, 0, 1106, 1073);
        lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/View/img/adminanswers.jpg")));
        contentPane.add(lblNewLabel);

    }

    private String insertLineBreaks(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        int wordCount = 0;
        for (String word : words) {
            result.append(word).append(" ");
            wordCount++;
            if (wordCount == 10) {
                result.append("<br>");
                wordCount = 0;
            }
        }
        return result.toString().trim();
    }

}
