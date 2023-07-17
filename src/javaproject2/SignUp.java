package javaproject2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textuserName;
	private JTextField textEmail;
	private JTextField textPassword;
	String name;String userName;String email;String password;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 516);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 193, 241));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignupForm = new JLabel("SignUp Form");
		lblSignupForm.setBounds(175, 10, 89, 15);
		contentPane.add(lblSignupForm);
		
		JLabel lblUsern = new JLabel("Names");
		lblUsern.setBounds(25, 43, 101, 15);
		contentPane.add(lblUsern);
		
		JLabel lblPassword = new JLabel("UserName");
		lblPassword.setBounds(25, 108, 101, 15);
		contentPane.add(lblPassword);
		
		textName = new JTextField();
		textName.setBounds(157, 34, 175, 28);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textuserName = new JTextField();
		textuserName.setBounds(157, 99, 175, 28);
		contentPane.add(textuserName);
		textuserName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(25, 166, 70, 15);
		contentPane.add(lblEmail);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(25, 222, 70, 15);
		contentPane.add(lblPassword_1);
		
		textEmail = new JTextField();
		textEmail.setBounds(157, 160, 175, 28);
		contentPane.add(textEmail);
		textEmail.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setBounds(157, 216, 175, 28);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JButton btnSignin = new JButton("Sign Up");
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectDB db= new ConnectDB();
				db.dbConnection();
				String name = textName.getText();
				String email = textEmail.getText();
				String userName = textuserName.getText();
				String password = textPassword.getText();
				
				try {
					db.addUser(name,userName, email,  password);
					System.out.println("success");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				Login lg =new Login();
				lg.setVisible(true);
			}
		});
		btnSignin.setBounds(24, 301, 151, 40);
		contentPane.add(btnSignin);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(196, 301, 117, 40);
		contentPane.add(btnNewButton);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login login=new Login();
				login.setVisible(true);
			}
		});
		btnLogin.setBounds(182, 373, 82, 25);
		contentPane.add(btnLogin);
		
		JLabel lblAlreadyExist = new JLabel("Already Exist");
		lblAlreadyExist.setBounds(40, 378, 101, 15);
		contentPane.add(lblAlreadyExist);
	}
}
