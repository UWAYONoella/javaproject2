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
		setBounds(100, 100, 758, 420);
		mainPane = new JPanel();
		mainPane.setBackground(new Color(153, 193, 241));
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 38, 140, 348);
		panel.setBackground(new Color(255, 190, 111));
		mainPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAboutUs = new JButton("About Us");
		btnAboutUs.setBounds(12, 34, 117, 34);
		btnAboutUs.setBackground(new Color(255, 255, 255));
		panel.add(btnAboutUs);
		
		JButton btnProducts = new JButton("Products");
		btnProducts.setBackground(new Color(255, 255, 255));
		btnProducts.setBounds(12, 111, 117, 34);
		panel.add(btnProducts);
		
		JButton btnBuy = new JButton("Stock");
		btnBuy.setBackground(new Color(255, 255, 255));
		btnBuy.setBounds(12, 189, 117, 34);
		panel.add(btnBuy);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(255, 255, 255));
		btnLogout.setBounds(12, 274, 117, 34);
		panel.add(btnLogout);
		
		JLabel lblDashboard = new JLabel("Shoes Shopping User Control");
		lblDashboard.setBounds(279, 0, 338, 43);
		lblDashboard.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		mainPane.add(lblDashboard);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/home/noella/Pictures/all photo/sckl/shop.jpg"));
		label.setBounds(175, 38, 573, 348);
		mainPane.add(label);
		
		JLabel lblSsu = new JLabel("SSUC ltd");
		lblSsu.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		lblSsu.setBounds(35, 0, 129, 26);
		mainPane.add(lblSsu);
	}
}
