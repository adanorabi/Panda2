package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.SysData;
import FlatLafDesign.TableGradientCell;
import Model.Question;
import sun.util.logging.resources.logging;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
public class table2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private List<Question> allQuestions;
	private JButton delete;
	private JButton details;
	private JButton edit;
	private JButton addQ;
	private JButton btnNewButton;
	/**
	 * @wbp.nonvisual location=119,854
	 */

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//	     FlatLaf.registerCustomDefaultsSource("View");
//         FlatLightLaf.setup();
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					table2 frame = new table2();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public table2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 30, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		
		allQuestions = new ArrayList<>();
		allQuestions.addAll(SysData.EasyQues);
		allQuestions.addAll(SysData.MidQues);
		allQuestions.addAll(SysData.HardQues);

		Object[][] data = new Object[allQuestions.size()][3];
		String[] columnNames = {"Num of Row", "Content of Question", "Level"};
		for (int i = 0; i < allQuestions.size(); i++) {
			Question question = allQuestions.get(i);
			data[i][0] = i + 1;
			data[i][1] = question.getContent();
			data[i][2] = question.getQLevel();
		}
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);

		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(200);
		contentPane.setLayout(null);
		table.setRowHeight(40);
		table.setDefaultRenderer(Object.class, new TableGradientCell());
		table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
	                + "hoverBackground:null;"
	                + "pressedBackground:null;"
	                + "separatorColor:$TableHeader.background");
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(240, 170, 1000, 700);
		contentPane.add(scrollPane);

		delete = new JButton("delete");
		delete.setContentAreaFilled(false); // Remove background
		delete.setBorderPainted(false); // Remove border
		delete.setBounds(1098, 116, 95, 44);
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/View/img/delete.jpg"));
		Image img = deleteIcon.getImage();
		Image resizedImg = img.getScaledInstance(95, 44, Image.SCALE_SMOOTH);
		delete.setIcon(new ImageIcon(resizedImg));
		contentPane.add(delete);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) { // If a row is selected
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int modelRow = table.convertRowIndexToModel(selectedRow);
					Question selectedQuestion = allQuestions.get(modelRow);
					model.removeRow(modelRow); // Remove row from table
					SysData.DeleteQuestioFromJson(selectedQuestion.getContent());  // deleting from json

					// Remove corresponding question from the list
					allQuestions.remove(modelRow);
					
				} else {
					JOptionPane.showMessageDialog(contentPane, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
				}
			}
		});


		edit = new JButton("edit");
		edit.setBounds(988, 116, 82, 44);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/View/img/edit.jpg"));
		Image editimg = editIcon.getImage();
		Image resizedImg2 = editimg.getScaledInstance(95, 44, Image.SCALE_SMOOTH);
		edit.setIcon(new ImageIcon(resizedImg2));
		contentPane.add(edit);
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) { // If a row is selected
					int modelRow = table.convertRowIndexToModel(selectedRow);
					Question selectedQuestion = allQuestions.get(modelRow);
					// Open the EditQ frame and pass the selected question and modelRow
					editQ editFrame = new editQ(table2.this, selectedQuestion, modelRow);
					editFrame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(contentPane, "Please select a row to edit.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
				}
			}
		});


		details = new JButton("details");
		details.setBounds(877, 116, 82, 44);
		ImageIcon detailsIcon = new ImageIcon(getClass().getResource("/View/img/details.jpg"));
		Image detailsimg = detailsIcon.getImage();
		Image resizedImg3 = detailsimg.getScaledInstance(95, 44, Image.SCALE_SMOOTH);
		details.setIcon(new ImageIcon(resizedImg3));
		contentPane.add(details);

		details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) { // If a row is selected
					int modelRow = table.convertRowIndexToModel(selectedRow);
					Question selectedQuestion = allQuestions.get(modelRow);
					// Open the QuestionAnswers frame and pass the selected question
					System.out.println(selectedQuestion.toString());
					QuestionAnswes qaFrame = new QuestionAnswes(selectedQuestion);
					qaFrame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(contentPane, "Please select a row to view details.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		addQ = new JButton("add question");
		addQ.setBounds(240, 81, 234, 62);
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/View/img/addq.jpg"));
		Image addimg = addIcon.getImage();
		Image resizedImg4 = addimg.getScaledInstance( 245, 70, Image.SCALE_SMOOTH);
		addQ.setIcon(new ImageIcon(resizedImg4));
		addQ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addQuestion addQuestionFrame = new addQuestion(table2.this);
				addQuestionFrame.setVisible(true);

			}
		});
		contentPane.add(addQ);
		

		JButton back = new JButton("back button");
		back.setBounds(74, 850, 153, 56);
		ImageIcon backIcon = new ImageIcon(getClass().getResource("/View/img/back.jpg"));
		Image backimg = backIcon.getImage();
		Image resizedImg1 = backimg.getScaledInstance(165, 56, Image.SCALE_SMOOTH);
		back.setIcon(new ImageIcon(resizedImg1));
		contentPane.add(back);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame mf=new MainFrame();
				setVisible(false);
				mf.setVisible(true);
			}
		});

		ImageIcon icon = new ImageIcon(Winner.class.getResource("/View/img/sky.png"));
		System.out.println("Image loaded: " + icon.getImageLoadStatus());

		//Verify image dimensions
		int containerWidth = 1500;
		int containerHeight = 1000;
		System.out.println("Container size: " + containerWidth + "x" + containerHeight);
		//Create JLabel with scaled image
		Image scaledImg = icon.getImage().getScaledInstance(containerWidth, containerHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);		
		JLabel lblNewLabel = new JLabel(scaledIcon);
		lblNewLabel.setBounds(0, 0,containerWidth, containerHeight);//
		//Set layout manager to BorderLayout


		//Add JLabel to center of contentPane
		contentPane.add(lblNewLabel);
	}
	public void updateEditedQuestion(int rowIndex, Question editedQuestion) {
		// Update the question in the ArrayList
		allQuestions.set(rowIndex, editedQuestion);

		// Update the table with the edited values
		table.getModel().setValueAt(editedQuestion.getContent(), rowIndex, 1); // Update content column
		table.getModel().setValueAt(editedQuestion.getQLevel(), rowIndex, 2); // Update level column

		// Notify the table UI of changes
		((DefaultTableModel) table.getModel()).fireTableDataChanged();
	}
	public void updateTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Clear existing rows
		for (int i = 0; i < allQuestions.size(); i++) {
			Question question = allQuestions.get(i);
			Object[] rowData = {i + 1, question.getContent(), question.getQLevel()};
			model.addRow(rowData);
		}
	}

	public ArrayList<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return (ArrayList<Question>) this.allQuestions;
	}

}
