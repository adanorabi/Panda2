package View;

import com.formdev.flatlaf.FlatClientProperties;
import FlatLafDesign.BackButton;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

import Controller.SysData;
import Enum.Levels;
import Enum.PlayerColor;
import FlatLafDesign.*;
import Model.Game;
import Model.Player;
import FlatLafDesign.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import Controller.*; 
public class History extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel backgroundPanel;
	private ImageIcon backgroundImage;
	private JButton backButton;

	public History() {

		initComponents();
		
		TableActionEvent event = new TableActionEvent() {
			@Override
			public void onEdit(int row) {
				System.out.println("Edit row : " + row);
			}

			@Override
			public void onDelete(int row) {
				if (table.isEditing()) {
					table.getCellEditor().stopCellEditing();
				}
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(row);
			}

			@Override
			public void onView(int row) {
				System.out.println("View row : " + row);
				int gameId = (int) table.getValueAt(row, 0);
				System.out.println(gameId );
                // Call the showScreenshot method with the game ID
				Screenshot.showScreenshot(gameId-1);
               
			}
		};
		//1d
		// Load the background image
		backgroundImage = new ImageIcon(getClass().getResource("/View/img/game.png"));

		backgroundPanel = new JPanel(new BorderLayout()) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Draw the image as the background
				g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
			}
		};

		jPanel1.setPreferredSize(new Dimension(1200, 500));
		JPanel panelWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelWrapper.setOpaque(false); // Set panelWrapper to be transparent
		panelWrapper.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		panelWrapper.add(jPanel1);

		backgroundPanel.add(panelWrapper, BorderLayout.CENTER);

		jPanel1.setAlignmentX(LEFT_ALIGNMENT);
		scroll.setAlignmentX(LEFT_ALIGNMENT);
		table.setDefaultRenderer(Object.class, new TableGradientCell());
		jPanel1.putClientProperty(FlatClientProperties.STYLE, ""
				+ "border:1,1,1,1,$TableHeader.bottomSeparatorColor,,10");
		table.getTableHeader().putClientProperty(FlatClientProperties.STYLE, ""
				+ "hoverBackground:null;"
				+ "pressedBackground:null;"
				+ "separatorColor:$TableHeader.background");
		scroll.putClientProperty(FlatClientProperties.STYLE, ""
				+ "border:3,0,3,0,$Table.background,10,10");
		scroll.getVerticalScrollBar().putClientProperty(FlatClientProperties.STYLE, ""
				+ "hoverTrackColor:null");

		setSize(1300, 1000);
		setLocationRelativeTo(null);
		setContentPane(backgroundPanel);

		//        table.getColumnModel().getColumn(4).setCellRenderer(renderer);
		//        table.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
		// 
		//        // Set the cell renderer and cell editor for the "Game ScreenShoot" columnint columnIndex = 4; // Adjust this to the index of the column you want to apply the renderer to
		//        table.getColumnModel().getColumn(4).setCellRenderer(renderer);
//		TableActionCellRender cellRender = new TableActionCellRender(event);
//		table.getColumnModel().getColumn(4).setCellRenderer(cellRender);
//		table.getColumnModel().getColumn(4).setCellEditor(cellRender);

//        table.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
//        table.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
//		table.repaint();

		backButton = new BackButton();
		backButton.setText("Back"); // Set button text
		backButton.addActionListener(e -> onBackButtonClick()); // Set the action listener

		// Add BackButton to the frame
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false); // Set panel to be transparent
		buttonPanel.add(backButton); // Add the backButton to the buttonPanel

		// Add the buttonPanel to the backgroundPanel
		backgroundPanel.add(buttonPanel, BorderLayout.SOUTH); // Add buttonPanel to the SOUTH of backgroundPanel

		// Adjust the bounds of the buttonPanel instead of the backButton
		buttonPanel.setBounds(10, 700, 30, 20); // Adjust x, y, width, and height as needed for the buttonPanel

		// Repaint the frame
		revalidate();
		repaint();



	}

	@SuppressWarnings("unchecked")

	private void initComponents( ) {
		Screenshot.loadExistingScreenshots();;
		String filePath = "AllGames.csv";
	SysData.readCsv(filePath);
		jPanel1 = new javax.swing.JPanel();
		scroll = new javax.swing.JScrollPane();
		table = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setLayout(new java.awt.BorderLayout());
		// Assuming SysData.gamesList is a list of Game objects
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0); // Removes all rows from the table
		Object[][] data = new Object[SysData.gamesList.size()][4]; // Assuming there are 5 columns in your table
        System.out.println("game list in history"+SysData.gamesList.size());
		for (int i = 0; i < SysData.gamesList.size(); i++) {
			System.out.println("im in history");
			Game game = SysData.gamesList.get(i);
			System.out.println(game.getGameLevel());
			System.out.println(game.getGameId());
			Player p=SysData.winnerPlayer.get(i);
			data[i][0] = game.getGameId();
			data[i][1] = game.getGameLevel();
			data[i][2] = p.getNickName();
			data[i][3] = game.getEndTime();
			//data[i][4] = null; // Assuming you handle the Game ScreenShoot separately
		}

		String[] columnNames = {"Game ID", "Game Level", "Winner nickName", "Timer"};

		table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames) {
			boolean[] canEdit = new boolean[]{false, false, false, false}; // Assuming the last column is editable

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		scroll.setViewportView(table);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));

		jPanel1.add(scroll, java.awt.BorderLayout.CENTER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(38, 38, 38)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
						.addGap(36, 36, 36))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(50, 50, 50)
						.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
						.addGap(38, 38, 38))
				);

		pack();
		setLocationRelativeTo(null);
	}


	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane scroll;
	private javax.swing.JTable table;
	private static void showDialog(JFrame parent) {
		// Create a JDialog with the specified parent frame
		JDialog dialog = new JDialog(parent, "Game View", true);
		dialog.setSize(700, 500);
		dialog.setLocationRelativeTo(parent);

		// Load an image from file or resource
		ImageIcon icon = new ImageIcon(History.class.getResource("/View/img/winnerbg.png"));
		Image scaledImg = icon.getImage().getScaledInstance(700, 500, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);	
		// Create a JLabel to display the image
		JLabel label = new JLabel(scaledIcon);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);

		// Add the label to the dialog's content pane
		dialog.getContentPane().add(label, BorderLayout.CENTER);

		// Show the dialog
		dialog.setVisible(true);
	}
	private void onBackButtonClick() {
		// Handle back button click event here, navigate to MainFrame
		dispose(); // Close the current window
		MainFrame mainFrame = new MainFrame(); // Create an instance of MainFrame
		mainFrame.setVisible(true); // Make the MainFrame visible
	}
}