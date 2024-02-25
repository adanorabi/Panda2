package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame {

    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField passwordField_1;
    private ArrayList<Admin> admins;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LogIn frame = new LogIn();
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
    public LogIn() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 10, 1106, 720);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
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
        txtUsername.setBounds(359, 360, 404, 68);
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
        passwordField_1.setBounds(359, 480, 404, 68);
        contentPane.add(passwordField_1);
        
        JButton btnNewButton = new JButton("<<home page");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainFrame mf=new MainFrame();
        		setVisible(false);
        		mf.setVisible(true);
        
        	}
        });
        
        btnNewButton.setIcon(new ImageIcon(getClass().getResource("/View/img/homepage.jpg")));
        btnNewButton.setBounds(108, 623, 219, 37);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/View/img/title.jpg")));
        lblNewLabel_1.setBounds(377, 108, 501, 203);
        contentPane.add(lblNewLabel_1);
        
//        JLabel lblNewLabel_2 = new JLabel("");
//        lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/View/img/message.jpg")));
//        lblNewLabel_2.setBounds(423, 265, 398, 37);
//        contentPane.add(lblNewLabel_2);
        
        JButton btnNewButton_1 = new JButton("Log in");
        btnNewButton_1.setIcon(new ImageIcon(getClass().getResource("/View/img/logInbut.jpg")));
        btnNewButton_1.setBounds(825, 623, 156, 37);
        contentPane.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username=txtUsername.getText();
				String password=passwordField_1.getText();
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
						JOptionPane.showMessageDialog(getContentPane(),"We didn't recognize you!");
					}else
					{
						QuestionManage QM=new QuestionManage();
						setVisible(false);
						QM.setVisible(true);
					}

				}
			}
		});
        // Background photo
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/View/img/logIn.jpg")));
        lblNewLabel.setBounds(-21, -36, 1162, 734);
        contentPane.add(lblNewLabel);
    }
}
