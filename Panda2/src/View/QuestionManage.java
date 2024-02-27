package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import Controller.SysData;
import Model.Question;

public class QuestionManage extends JFrame {

    private JPanel contentPane;
    private JLabel questionFrame;
    private JTable table;
    private JScrollPane scrollPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuestionManage frame = new QuestionManage();
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
    public QuestionManage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1100, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Initialize an empty list to hold all questions
        java.util.List<Question> allQuestions = new java.util.ArrayList<>();
        
        // Add all questions from EasyQues, MidQues, and HardQues to the list
        allQuestions.addAll(SysData.EasyQues);
        allQuestions.addAll(SysData.MidQues);
        allQuestions.addAll(SysData.HardQues);
        
        // Initialize the data array with the size of allQuestions list
        Object[][] data = new Object[allQuestions.size()][3]; // Assuming 3 columns
        
        // Populate the data array with question data
        for (int i = 0; i < allQuestions.size(); i++) {
            Question question = allQuestions.get(i);
            data[i][0] = i + 1; // Num of Row starts from 1
            data[i][1] = question.getContent();
            data[i][2] = question.getQLevel();
        }

        // Column names
        String[] columnNames = {"Num of Row", "Content of Question", "Level"};

        // Create a table
        table = new JTable(data, columnNames);
        table.setModel(new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });        // Set column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(100); // Num of Row
        table.getColumnModel().getColumn(1).setPreferredWidth(300); // Content of Question
        table.getColumnModel().getColumn(2).setPreferredWidth(200); // Level

        // Add the table to a scroll pane
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 100, 800, 500);
        contentPane.add(scrollPane);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, -149, 1148, 959);
        lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/View/img/sky.png")));
        contentPane.add(lblNewLabel);
    }
}
