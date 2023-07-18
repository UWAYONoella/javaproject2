package javaproject2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Dashboard extends JFrame {

	private JPanel mainPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1000);
		mainPane = new JPanel();
		mainPane.setBackground(new Color(153, 193, 241));
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 40, 140, 667);
		panel.setBackground(new Color(255, 190, 111));
		mainPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAboutUs = new JButton("About Us");
		btnAboutUs.setBounds(12, 34, 117, 34);
		btnAboutUs.setBackground(new Color(255, 255, 255));
		panel.add(btnAboutUs);
		
		JButton btnSale = new JButton("Sales");
		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				sales sl =new sales();
				sl.setVisible(true);
				
			}
		});
		btnSale.setBackground(new Color(255, 255, 255));
		btnSale.setBounds(12, 193, 117, 34);
		panel.add(btnSale);
		
		JButton btnBuy = new JButton("Stock");
		btnBuy.setBackground(new Color(255, 255, 255));
		btnBuy.setBounds(12, 320, 117, 34);
		panel.add(btnBuy);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SignUp sn =new SignUp();
				sn.setVisible(true);
			}
		});
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setBounds(12, 477, 117, 34);
		panel.add(btnLogout);
		
		JLabel lblDashboard = new JLabel("Shoes Shopping User Control System");
		lblDashboard.setBounds(250, 0, 472, 43);
		lblDashboard.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		mainPane.add(lblDashboard);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 255, 255));
		label.setIcon(new ImageIcon("/home/noella/Pictures/all photo/sckl/shop.jpg"));
		label.setBounds(186, 40, 740, 418);
		mainPane.add(label);
		
		JLabel lblSsu = new JLabel("SSUC ltd ");
		lblSsu.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblSsu.setBounds(35, 0, 203, 26);
		mainPane.add(lblSsu);
		
		JLabel lblKeep = new JLabel("Keep controlling your shop");
		lblKeep.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 25));
		lblKeep.setBackground(new Color(255, 255, 255));
		lblKeep.setBounds(944, -2, 403, 45);
		mainPane.add(lblKeep);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(257, 609, 70, 15);
		mainPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(691, 609, 70, 15);
		mainPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(652, 582, 70, 15);
		mainPane.add(label_3);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("/home/noella/Pictures/all photo/sckl/fine.jpg"));
		label_5.setBounds(170, 40, 1177, 670);
		mainPane.add(label_5);
	}
}
