package View;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

import Controller.SysData;
import Enum.Levels;
import Enum.PlayerColor;
import FlatLafDesign.*;
import Model.Game;
import Model.Player;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class History extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel backgroundPanel;
    private ImageIcon backgroundImage;
    private BackButton backButton; // Declare BackButton
    public History() {
    
        initComponents();
        backButton = new BackButton();
        backButton.setText("Back"); // Set button text
        // Add action listener to handle button click event
        backButton.addActionListener(e -> {
            // Handle back button click event here, e.g., navigate to previous screen
            // For example:
            // dispose(); // Close the current window
            // new PreviousScreen().setVisible(true); // Open previous screen
        });
        
        // Add BackButton to the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Set panel to be transparent
        buttonPanel.add(backButton);
        backgroundPanel.add(buttonPanel, BorderLayout.NORTH);
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
                JFrame frame=new JFrame();
                showDialog(frame);
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
        TableActionCellRender cellRender = new TableActionCellRender(event);
        table.getColumnModel().getColumn(4).setCellRenderer(cellRender);
        table.getColumnModel().getColumn(4).setCellEditor(cellRender);
      
        table.repaint();

     // Set the clicked column index
//     renderer.setClickedColumn(4);

       // testData(); 

    }

    @SuppressWarnings("unchecked")

    private void initComponents( ) {
    	Game g=new Game(10,Levels.Easy,7,7);
    	g.setWinnerId(2);
    	Player p1=new Player(PlayerColor.Blue,"panda1",0,0,1);
    	Player p2=new Player(PlayerColor.Red,"panda2",0,0,1);
    	g.getPlayers().add(p2);
    	g.getPlayers().add(p1);
    	g.setEndTime(110099);
    	SysData.gamesList.add(g);
        jPanel1 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());
     // Assuming SysData.gamesList is a list of Game objects
        Object[][] data = new Object[SysData.gamesList.size()][5]; // Assuming there are 5 columns in your table

        for (int i = 0; i < SysData.gamesList.size(); i++) {
            Game game = SysData.gamesList.get(i);
            data[i][0] = game.getGameId();
            data[i][1] = game.getGameLevel();
            data[i][2] = game.getWinnerId();
            data[i][3] = game.getEndTime();
            data[i][4] = null; // Assuming you handle the Game ScreenShoot separately
        }

        String[] columnNames = {"Game ID", "Game Level", "Winner nickName", "Timer", "Game ScreenShoot"};

        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames) {
            boolean[] canEdit = new boolean[]{false, false, false, false, true}; // Assuming the last column is editable

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
            public static void main(String[] args) {
                FlatLaf.registerCustomDefaultsSource("View");
                FlatLightLaf.setup();
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            History frame = new History();
                            frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }