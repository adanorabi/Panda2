package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableCellRenderer;

import Controller.SysData;
import Model.Question;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class QuestionManage extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JScrollPane scrollPane;

    // Store all questions in a list
    private List<Question> allQuestions;

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

        // Initialize the list to hold all questions
        allQuestions = new ArrayList<>();
        // Add all questions from EasyQues, MidQues, and HardQues to the list
        allQuestions.addAll(SysData.EasyQues);
        allQuestions.addAll(SysData.MidQues);
        allQuestions.addAll(SysData.HardQues);

        // Initialize the data array with the size of allQuestions list
        Object[][] data = new Object[allQuestions.size()][4]; // Assuming 4 columns (including delete icon)

        // Populate the data array with question data
        for (int i = 0; i < allQuestions.size(); i++) {
            Question question = allQuestions.get(i);
            data[i][0] = i + 1; // Num of Row starts from 1
            data[i][1] = question.getContent();
            data[i][2] = question.getQLevel();
            data[i][3] = ""; // Delete icon placeholder
        }

        // Column names
        String[] columnNames = {"Num of Row", "Content of Question", "Level", "Delete"};

        // Create a custom table model
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // No cell should be editable directly
            }
        };

        // Create the table with the custom model
        table = new JTable(model) {
            @Override
            public Class getColumnClass(int column) {
                return column == 3 ? JButton.class : Object.class;
            }
        };

        // Set column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(100); // Num of Row
        table.getColumnModel().getColumn(1).setPreferredWidth(300); // Content of Question
        table.getColumnModel().getColumn(2).setPreferredWidth(200); // Level
        table.getColumnModel().getColumn(3).setPreferredWidth(50); // Delete icon column

        // Set row height
        table.setRowHeight(40); // Adjust row height as needed

        // Render the delete button in each row
        table.getColumnModel().getColumn(3).setCellRenderer(new DeleteButtonRenderer());

        // Add the table to a scroll pane
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 100, 800, 500);
        contentPane.add(scrollPane);

        // Set up the list selection listener to handle row selection
        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                JOptionPane.showMessageDialog(null, "Row " + (selectedRow + 1) + " deleted successfully!");
                // Remove the corresponding question from the list
                allQuestions.remove(selectedRow);
                // Update the table model
                model.removeRow(selectedRow);
            }
        });

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, -149, 1148, 959);
        lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/View/img/sky.png")));
        contentPane.add(lblNewLabel);
    }

    private class DeleteButtonRenderer extends JButton implements TableCellRenderer {

        public DeleteButtonRenderer() {
            setOpaque(false); // Set the button to be transparent
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Set the size of the button based on the cell size
            int buttonSize = table.getRowHeight();
            setPreferredSize(new Dimension(buttonSize, buttonSize));

            // Load and resize the delete icon
            ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/View/img/delete.png"));
            Image img = deleteIcon.getImage();
            Image resizedImg = img.getScaledInstance(buttonSize, buttonSize, Image.SCALE_SMOOTH);
            setIcon(new ImageIcon(resizedImg));

            return this;
        }
    }

}
