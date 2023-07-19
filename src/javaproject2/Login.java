package javaproject2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField textpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 193, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginForm = new JLabel("LOGIN FORM");
		lblLoginForm.setBounds(250, 12, 125, 15);
		contentPane.add(lblLoginForm);
		
		JLabel lblEmail = new JLabel("Username");
		lblEmail.setBounds(38, 95, 97, 15);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(38, 158, 97, 15);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(205, 85, 209, 27);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		textpassword = new JTextField();
		textpassword.setBounds(205, 152, 209, 27);
		contentPane.add(textpassword);
		textpassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String Username = txtUsername.getText();
	                String Password = textpassword.getText();
	                ConnectDB db = new ConnectDB();
	                     db.dbConnection();  
	                     
	                     
	                     db.getUser(Username, Password);
				
			}
		});
		btnLogin.setBounds(201, 232, 109, 40);
		contentPane.add(btnLogin);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textpassword.setText("");
				txtUsername.setText("");
			}
		});
		btnCancel.setBounds(314, 232, 97, 40);
		contentPane.add(btnCancel);
		
		JButton btnCreate = new JButton("Create Account");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				SignUp sn=new SignUp();
				sn.setVisible(true);
				
			}
		});
		btnCreate.setBounds(205, 341, 150, 25);
		contentPane.add(btnCreate);
		
		JLabel lblNewUser = new JLabel("New User");
		lblNewUser.setBounds(205, 308, 70, 15);
		contentPane.add(lblNewUser);
		
		JButton btnLoginAsAdmin = new JButton("login as admin");
		btnLoginAsAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Adminform df = new Adminform();
				df.setVisible(true);
			}
		});
		btnLoginAsAdmin.setBounds(367, 341, 150, 25);
		contentPane.add(btnLoginAsAdmin);
	}
}
