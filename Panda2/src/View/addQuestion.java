package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Model.Question;

import javax.swing.border.EmptyBorder;

public class addQuestion extends JFrame {

    private JPanel contentPane;
    private JLabel questionFrame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JButton btnNewButton;
    private JButton btnNewButton_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    addQuestion frame = new addQuestion();
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
    public addQuestion() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 854, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("the content of the new question:");
        lblNewLabel.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
        lblNewLabel.setBounds(195, 43, 300, 38);
        contentPane.add(lblNewLabel);
        
        textField = new JTextField("Question");
        textField.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
        textField.setBounds(195, 73, 404, 36);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("The right answer :");
        lblNewLabel_1.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
        lblNewLabel_1.setBounds(195, 119, 203, 25);
        contentPane.add(lblNewLabel_1);
        
        textField_1 = new JTextField("answer 1");
        textField_1.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
        textField_1.setBounds(195, 154, 404, 38);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Other answers : ");
        lblNewLabel_2.setFont(new Font("Traditional Arabic", Font.BOLD, 18));
        lblNewLabel_2.setBounds(195, 219, 250, 25);
        contentPane.add(lblNewLabel_2);
        
        textField_2 = new JTextField("answer 2");
        textField_2.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
        textField_2.setBounds(195, 250, 404, 38);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        textField_3 = new JTextField("answer 3");
        textField_3.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
        textField_3.setBounds(195, 310, 404, 38);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField("answer 4");
        textField_4.setFont(new Font("Traditional Arabic", Font.PLAIN, 18));
        textField_4.setColumns(10);
        textField_4.setBounds(195, 368, 404, 38);
        contentPane.add(textField_4);
        
        btnNewButton = new JButton("Next");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (textField.getText().equals("Question"))
            	{
				JOptionPane.showMessageDialog(getContentPane(),"Enter content of Question!");
            	}else if(textField_1.getText().equals("answer 1")||textField_2.getText().equals("answer 2")||textField_3.getText().equals("answer 3")||textField_4.getText().equals("answer 4") )
            	{
				JOptionPane.showMessageDialog(getContentPane(),"Enter all the answers!");
            	}else
            	{
            		// add question to json and arraylist
            	}
            	System.out.println(textField.getText());
            	System.out.println(textField_1.getText());
            }
            	
        });
        btnNewButton.setBounds(661, 410, 99, 38);
        contentPane.add(btnNewButton);
        btnNewButton.setIcon(new ImageIcon(getClass().getResource("/View/img/next.png")));

        btnNewButton_1 = new JButton("Back");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		MainFrame mf=new MainFrame();
        		setVisible(false);
        		mf.setVisible(true);
            }
        });
        btnNewButton_1.setBounds(22, 416, 174, 26);
        contentPane.add(btnNewButton_1);
        btnNewButton_1.setIcon(new ImageIcon(LevelGame.class.getResource("/View/img/hp.png")));

        questionFrame = new JLabel("");
        questionFrame.setIcon(new ImageIcon(QuestionFrame.class.getResource("/View/img/sky.png")));
        questionFrame.setBounds(0, -17, 859, 624);
        contentPane.add(questionFrame);

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
