package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class QuestionManage extends JFrame {

    private JPanel contentPane;
    private JLabel questionFrame;

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
        
        // Sample data for the table
        Object[][] data = {
                {1, "What is Java?", "Intermediate"},
                {2, "What is Swing?", "Advanced"},
                {3, "How to create a table?", "Beginner"}
        };

        // Column names
        String[] columnNames = {"Num of Row", "Content of Question", "Level"};

        // Create a table
        JTable table = new JTable(data, columnNames);

        // Set column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(100); // Num of Row
        table.getColumnModel().getColumn(1).setPreferredWidth(300); // Content of Question
        table.getColumnModel().getColumn(2).setPreferredWidth(200); // Level

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 100, 800, 500);
        contentPane.add(scrollPane);
        

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, -149, 1148, 959);
        lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/View/img/sky.png")));
        contentPane.add(lblNewLabel);

    }
}
