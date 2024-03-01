package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

import Model.Question;

public class QuestionAnswes extends JFrame {

    private JPanel contentPane;

    public QuestionAnswes(Question q) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 30, 1100, 1000);
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
        
        JLabel Qu = new JLabel("");
        Qu.setBounds(329, 51, 544, 175);
        contentPane.add(Qu);
        Qu.setText(q.getContent());
        adjustFontSize(Qu);
        Qu.setForeground(Color.WHITE);

        JLabel TrueAns = new JLabel("");
        TrueAns.setBounds(519, 296, 415, 116);
        contentPane.add(TrueAns);
        TrueAns.setText(q.getTrueAnswer());
        adjustFontSize(TrueAns);
        TrueAns.setForeground(Color.WHITE);

        JLabel falseAns1 = new JLabel("New label");
        falseAns1.setBounds(592, 479, 415, 103);
        contentPane.add(falseAns1);
        falseAns1.setText(answers.get(0));
        adjustFontSize(falseAns1);
        falseAns1.setForeground(Color.WHITE);

        JLabel falseAns2 = new JLabel("New label");
        falseAns2.setBounds(620, 655, 427, 103);
        contentPane.add(falseAns2);
        falseAns2.setText(answers.get(1));
        adjustFontSize(falseAns2);
        falseAns2.setForeground(Color.WHITE);

        JLabel falseAns3 = new JLabel("New label");
        falseAns3.setBounds(541, 822, 427, 103);
        contentPane.add(falseAns3);
        falseAns3.setText(answers.get(2));
        adjustFontSize(falseAns3);
        falseAns3.setForeground(Color.WHITE);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(10, 0, 1106, 1073);
        lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/View/img/adminanswers.jpg")));
        contentPane.add(lblNewLabel);
    }

    private void adjustFontSize(JLabel label) {
        String text = label.getText();
        int length = text.length();
        Font originalFont = label.getFont();
        int fontSize = originalFont.getSize();
        if (length > 20) { // You can adjust this threshold according to your preference
            fontSize += 10; // Decrease font size if text is long
        } else {
            fontSize += 20; // Increase font size if text is short
        }
        label.setFont(new Font(originalFont.getName(), originalFont.getStyle(), fontSize));
    }
}
