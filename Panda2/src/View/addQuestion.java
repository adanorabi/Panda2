package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Controller.SysData;
import Enum.Levels;
import Model.Question;

import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class addQuestion extends JFrame {

    private JPanel contentPane;
	private table2 parentFrame; // Reference to the parent frame (table2)
    private JLabel questionFrame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JLabel lblNewLabel_3;

    /**
     * Launch the application.
//     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    addQuestion frame = new addQuestion();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the frame.
     */
    public addQuestion(table2 parentFrame) {
        this.parentFrame = parentFrame;
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
        
        JLabel lblNewLabel = new JLabel("the content of the new question:");
        lblNewLabel.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
        lblNewLabel.setBounds(258, 72, 300, 38);
        contentPane.add(lblNewLabel);
        
        textField = new JTextField("Question");
        textField.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
        textField.setBounds(257, 114, 404, 36);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("The right answer :");
        lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
        lblNewLabel_1.setBounds(258, 161, 203, 25);
        contentPane.add(lblNewLabel_1);
        
        textField_1 = new JTextField("answer 1");
        textField_1.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
        textField_1.setBounds(257, 196, 404, 38);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Other answers : ");
        lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
        lblNewLabel_2.setBounds(257, 242, 250, 25);
        contentPane.add(lblNewLabel_2);
        
        textField_2 = new JTextField("answer 2");
        textField_2.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
        textField_2.setBounds(255, 281, 404, 38);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField("answer 3");
        textField_3.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
        textField_3.setBounds(256, 345, 404, 38);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField("answer 4");
        textField_4.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
        textField_4.setColumns(10);
        textField_4.setBounds(256, 412, 404, 38);
        contentPane.add(textField_4);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(318, 471, 119, 25);
        contentPane.add(comboBox);
        comboBox.addItem(Levels.Easy);
        comboBox.addItem(Levels.Medium);
        comboBox.addItem(Levels.Hard);

        btnNewButton = new JButton("Next");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals("Question")) {
                    JOptionPane.showMessageDialog(getContentPane(),"Enter content of Question!");
                } else if(textField_1.getText().equals("answer 1") || textField_2.getText().equals("answer 2") || 
                        textField_3.getText().equals("answer 3") || textField_4.getText().equals("answer 4")) {
                    JOptionPane.showMessageDialog(getContentPane(),"Enter all the answers!");
                } else {
                    // Create a new Question object
                    String content = textField.getText();
                    String trueAnswer = textField_1.getText();
                    String answer2 = textField_2.getText();
                    String answer3 = textField_3.getText();
                    String answer4 = textField_4.getText();
                    Levels level = (Levels) comboBox.getSelectedItem();
                    ArrayList<String> answers =new ArrayList<String>();
                    answers.add(trueAnswer);
                    answers.add(answer2);
                    answers.add(answer3);
                    answers.add(answer4);

                    Question newQuestion =new Question(SysData.QuestionId++, level, content, answers, trueAnswer);
                    SysData.AddQuestioToJson(newQuestion); // Adding question to json 

                    // Add the new question to the allQuestions ArrayList
                    parentFrame.getAllQuestions().add(newQuestion);

                    // Update the table directly in the parent frame (table2)
                    parentFrame.updateTable();

                    // Dispose of the addQuestion frame
                    dispose();
                }
            }
        });
        btnNewButton.setBounds(783, 567, 135, 46);
        contentPane.add(btnNewButton);
        btnNewButton.setIcon(new ImageIcon(getClass().getResource("/View/img/submit.jpg")));

        btnNewButton_1 = new JButton("Back");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		setVisible(false);
            }
        });
        btnNewButton_1.setBounds(52, 567, 158, 46);
        contentPane.add(btnNewButton_1);
        btnNewButton_1.setIcon(new ImageIcon(LevelGame.class.getResource("/View/img/back.jpg")));
        
        lblNewLabel_3 = new JLabel("Level:");
        lblNewLabel_3.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
        lblNewLabel_3.setBounds(258, 470, 71, 26);
        contentPane.add(lblNewLabel_3);

        questionFrame = new JLabel("");
        questionFrame.setIcon(new ImageIcon(QuestionFrame.class.getResource("/View/img/sky.png")));
        questionFrame.setBounds(0, -70, 1005, 805);
        contentPane.add(questionFrame);
        // Set border color dynamically
        textField_1.setBorder(new LineBorder(Color.GREEN)); // Set the correct answer border color to green
        textField_2.setBorder(new LineBorder(Color.RED));   // Set other answer border color to red
        textField_3.setBorder(new LineBorder(Color.RED));   // Set other answer border color to red
        textField_4.setBorder(new LineBorder(Color.RED));   // Set other answer border color to red
        
        // Add focus listeners to clear default text
        textField_1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField_1.getText().equals("answer 1")) {
                    textField_1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField_1.getText().isEmpty()) {
                    textField_1.setText("answer 1");
                }
            }
        });
        
        textField_2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField_2.getText().equals("answer 2")) {
                    textField_2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField_2.getText().isEmpty()) {
                    textField_2.setText("answer 2");
                }
            }
        });

        textField_3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField_3.getText().equals("answer 3")) {
                    textField_3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField_3.getText().isEmpty()) {
                    textField_3.setText("answer 3");
                }
            }
        });

        textField_4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField_4.getText().equals("answer 4")) {
                    textField_4.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField_4.getText().isEmpty()) {
                    textField_4.setText("answer 4");
                }
            }
        });
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("Question")) {
                	textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                	textField.setText("Question");
                }
            }
        });
    }
}
