package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Model.Admin;
import Model.PlayAudio;

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField passwordField_1;
    private ArrayList<Admin> admins;


    // log in frame for admins - panda group members
    public LogIn() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 70,1200, 900);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        // the information of the admins for the log in 
        admins=new ArrayList<>();
        admins.add(new Admin("Ghaidaaazzam", "Ghaidaa123"));
        admins.add(new Admin("YaraGh", "Yara123"));
        admins.add(new Admin("YomnaZoabi", "Yomna123"));
        admins.add(new Admin("AdanOrabi", "Adan123"));

        // Username text field
        txtUsername = new JTextField();
        txtUsername.setBackground(new Color(176, 224, 230));
        txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Set font size to 20
        txtUsername.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Empty implementation
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Empty implementation
            }
        });
        txtUsername.setBounds(386, 487, 415, 86);
        contentPane.add(txtUsername);

        // Password field
        passwordField_1 = new JPasswordField();
        passwordField_1.setBackground(new Color(176, 224, 230));
        passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 20)); // Set font size to 20
        passwordField_1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                // Empty implementation
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Empty implementation
            }
        });
        passwordField_1.setBounds(386, 641, 415, 86);
        contentPane.add(passwordField_1);
        
        // home page button , return to the main frame
        JButton btnNewButton = new JButton("<<home page");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainFrame mf=new MainFrame();
        		PlayAudio.PlayBackSound(); // Calling  the function that play back buttons audio -Yara
        		setVisible(false);
        		mf.setVisible(true);
        
        	}
        });
        
        btnNewButton.setIcon(new ImageIcon(getClass().getResource("/View/img/homepage.jpg")));
        btnNewButton.setBounds(67, 772, 219, 37);
        contentPane.add(btnNewButton);
        
		ImageIcon icon1 = new ImageIcon(getClass().getResource("/View/img/title.jpg"));
        Image scaledImg1 = icon1.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon1 = new ImageIcon(scaledImg1);		
		JLabel lblNewLabel_1 = new JLabel(scaledIcon1);
        lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/View/img/title.jpg")));
        lblNewLabel_1.setBounds(359, 180, 539, 271);
        contentPane.add(lblNewLabel_1);
        

        // log in button
        JButton btnNewButton_1 = new JButton("Log in");
        btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("/View/img/logInbut.jpg")));
        btnNewButton_1.setBounds(935, 772, 156, 37);
        contentPane.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username=txtUsername.getText();
				String password=passwordField_1.getText();
				// cheeck if the user fill all the fields
				if(username.isEmpty()|| password.isEmpty()) {
					JOptionPane.showMessageDialog(getContentPane(),"You need to fill both username and password");

				}
				else 
				{
					boolean check= false;
					for(Admin a:admins)
					{
						if(username.equals(a.getUsername())&&password.equals(a.getPassword()))
						{
							check=true;
						}
					}
					if(!check) {
						// when the user enter false informations
						JOptionPane.showMessageDialog(getContentPane(),"We didn't recognize you!");
					}else
					{
						// when the user enter correct informations
						table2 QM=new table2();
						setVisible(false);
						QM.setVisible(true);
					}

				}
			}
		});
        // Background photo
		ImageIcon icon = new ImageIcon(Winner.class.getResource("/View/img/logIn.jpg"));
		System.out.println("Image loaded: " + icon.getImageLoadStatus());

		//Verify image dimensions
		int containerWidth = 1200;
		int containerHeight = 900;
		System.out.println("Container size: " + containerWidth + "x" + containerHeight);
		//Create JLabel with scaled image
		Image scaledImg = icon.getImage().getScaledInstance(containerWidth, containerHeight, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);		
		JLabel lblNewLabel = new JLabel(scaledIcon);
		lblNewLabel.setBounds(0, 10,1200, 871);
		contentPane.add(lblNewLabel);
    }
}
