package javaproject2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Adminform extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminform frame = new Adminform();
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
	public Adminform() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(800, 800, 1500, 1000);
	    contentPane = new JPanel();
	    contentPane.setBackground(new Color(153, 193, 241));
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	    setContentPane(contentPane);
	    contentPane.setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("      Welcome Admin");
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
	    lblNewLabel.setBounds(12, 0, 380, 36);
	    contentPane.add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("");
	    lblNewLabel_1.setIcon(new ImageIcon("/home/noella/Pictures/all photo/sckl/WEB.jpg"));
	    lblNewLabel_1.setBounds(12, 41, 298, 558);
	    contentPane.add(lblNewLabel_1);
	    
	    JButton btnNewButton = new JButton("Display");
	    btnNewButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Clear existing table data
	            DefaultTableModel model = (DefaultTableModel) table.getModel();
	            model.setRowCount(0);

	            // Retrieve data from the database and populate the table
	            ConnectDB db = new ConnectDB();
	            db.dbConnection();
	            db.displayData(model);
	        }
	    });
	    btnNewButton.setBounds(22, 630, 116, 36);
	    contentPane.add(btnNewButton);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(153, 193, 241));
	    panel.setBounds(315, 41, 1037, 663);
	    contentPane.add(panel);
	    panel.setLayout(null);
	    
	    
	    // Assign the JTable instance to the existing table
	    table = new JTable();
	    table.setModel(new DefaultTableModel(
	        new Object[][] {
	        },
	        new String[] {
	            "ID", "Names","UserName", "Email", "Password"
	        }
	    ));
	    table.setBounds(12, 27, 1013, 636);
	    panel.add(table);
	    
	    JButton btnLogout = new JButton("LogOut");
	    btnLogout.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		dispose();
	    		Dashboard dash = new Dashboard();
	    		dash.setVisible(true);
	    	}
	    });
	    btnLogout.setBounds(178, 630, 117, 36);
	    contentPane.add(btnLogout);
	}

}
