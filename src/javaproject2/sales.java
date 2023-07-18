package javaproject2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class sales extends JFrame {

	private JPanel mainPane;
	private JTable table;
	private JTextField textFielddate;
	private JTextField textFieldshoetype;
	private JTextField textFieldshoeid;
	private JTextField textFieldcolor;
	private JTextField textFieldsize;
	private JTextField textFieldpair;
	private JTextField textFieldprice;
	DefaultTableModel model;
	String date;String shoetype;String shoeid;String color;String size;String pairs;String priceunit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sales frame = new sales();
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
	public sales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 1000);
		mainPane = new JPanel();
		mainPane.setBackground(new Color(153, 193, 241));
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPane);
		mainPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(562, 50, 800, 650);
		mainPane.add(scrollPane);
		
		table = new JTable();
		
		table.setBorder(new LineBorder(new Color(255, 190, 111), 3));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Date", "ShoeType", "ShoeId", "color","Size","Pairs","PairUnitPrice"
			}
			
		));
		scrollPane.setViewportView(table);
			Object[]row=new Object[7];
	   
		 DefaultTableModel model = (DefaultTableModel) table.getModel();
	        try {
	            ConnectDB db = new ConnectDB();
	            db.dbConnection(); 
	   
	            ResultSet rs = db.getSales();
	            while (rs.next()) {
	                String date = rs.getString("Date");
	                String shoetype = rs.getString("ShoeType");
	                String shoeid= rs.getString("ShoeId");
	                String color = rs.getString("Color");
	                String sidateze = rs.getString("Size");
	                String pairs = rs.getString("Pairs");
	                String priceunit = rs.getString("PairUnitPrice");
	                model.addRow(new Object[]{date , shoetype, shoeid, color, sidateze, pairs, priceunit});
	         
	              
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	       
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 50, 523, 650);
		mainPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(12, 25, 101, 15);
		panel.add(lblDate);
		
		JLabel lblShoetype = new JLabel("ShoeType");
		lblShoetype.setBounds(12, 82, 126, 15);
		panel.add(lblShoetype);
		
		JLabel lblShoeid = new JLabel("ShoeId");
		lblShoeid.setBounds(15, 141, 113, 15);
		panel.add(lblShoeid);
		
		JLabel lblColor = new JLabel("color");
		lblColor.setBounds(12, 197, 113, 15);
		panel.add(lblColor);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(12, 251, 113, 15);
		panel.add(lblSize);
		
		JLabel lblPairs = new JLabel("Pairs");
		lblPairs.setBounds(15, 307, 113, 15);
		panel.add(lblPairs);
		
		JLabel lblPairsunitprice = new JLabel("PairsUnitPrice");
		lblPairsunitprice.setBounds(15, 371, 113, 15);
		panel.add(lblPairsunitprice);
//		Object[] row=new Object[8];
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectDB db = new ConnectDB();
				db.dbConnection();
				

				String date =textFielddate.getText();
				String shoetype=textFieldshoetype.getText();
				String shoeid =textFieldshoeid.getText();
				String color =textFieldcolor.getText();
				String size =textFieldsize.getText();
				String pairs=textFieldpair.getText();
				String priceunit =textFieldprice.getText();
				
				try {
					db.addSales( date,shoetype,shoeid,color,size,pairs, priceunit);
					
//					JOptionPane.showMessageDialog(null, "Well connected!");
				} catch(Exception en) {
					en.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(22, 511, 117, 38);
		panel.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectDB db = new ConnectDB();
				db.dbConnection();
				String date = textFielddate().getText();
				String shoetype = textFieldshoetype().getText();
				String shoeid = textFieldshoeid().getText();
				String color = textFieldcolor().getText();
				String size = textFieldsize().getText();
				String pairs = textFieldpair().getText();
				String priceunit = textFieldprice().getText();

				try {
					db.addSales( date,shoetype,shoeid,color,size,pairs, priceunit);
					
//					JOptionPane.showMessageDialog(null, "Well connected!");
				} catch(Exception en) {
					en.printStackTrace();
				}
			}

			private JTextField textFieldprice() {
				// TODO Auto-generated method stub
				return textFieldprice;
			}

			private JTextField textFieldsize() {
				// TODO Auto-generated method stub
				return textFieldprice;
			}

			private JTextField textFieldpair() {
				// TODO Auto-generated method stub
				return textFieldpair;
			}

			private JTextField textFieldcolor() {
				// TODO Auto-generated method stub
				return textFieldcolor;
			}

			private JTextField textFieldshoeid() {
				// TODO Auto-generated method stub
				return textFieldshoeid;
			}

			private JTextField textFieldshoetype() {
				// TODO Auto-generated method stub
				return textFieldshoetype;
			}

			private JTextField textFielddate() {
				// TODO Auto-generated method stub
				return textFielddate;
			}
		});
		btnUpdate.setBounds(188, 511, 117, 38);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 textFielddate.setText("");
				 textFieldshoetype.setText("");
				textFieldshoeid.setText("");
				textFieldcolor.setText("");
				 textFieldsize.setText("");
				 textFieldpair.setText("");
				 textFieldprice.setText("");


			}
		});
		btnDelete.setBounds(370, 511, 117, 38);
		panel.add(btnDelete);
		
		textFielddate = new JTextField();
		textFielddate.setBounds(191, 12, 230, 30);
		panel.add(textFielddate);
		textFielddate.setColumns(10);
		
		textFieldshoetype = new JTextField();
		textFieldshoetype.setBounds(191, 69, 230, 30);
		panel.add(textFieldshoetype);
		textFieldshoetype.setColumns(10);
		
		textFieldshoeid = new JTextField();
		textFieldshoeid.setText("");
		textFieldshoeid.setBounds(191, 128, 230, 30);
		panel.add(textFieldshoeid);
		textFieldshoeid.setColumns(10);
		
		textFieldcolor = new JTextField();
		textFieldcolor.setText("");
		textFieldcolor.setBounds(191, 184, 230, 30);
		panel.add(textFieldcolor);
		textFieldcolor.setColumns(10);
		
		textFieldsize = new JTextField();
		textFieldsize.setText("");
		textFieldsize.setBounds(191, 238, 230, 30);
		panel.add(textFieldsize);
		textFieldsize.setColumns(10);
		
		textFieldpair = new JTextField();
		textFieldpair.setText("");
		textFieldpair.setBounds(191, 294, 230, 30);
		panel.add(textFieldpair);
		textFieldpair.setColumns(10);
		
		textFieldprice = new JTextField();
		textFieldprice.setText("");
		textFieldprice.setBounds(191, 358, 230, 30);
		panel.add(textFieldprice);
		textFieldprice.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Dashboard dash =new Dashboard();
				dash.setVisible(true);
			}
		});
		btnBack.setBackground(new Color(143, 240, 164));
		btnBack.setBounds(104, 572, 117, 25);
		panel.add(btnBack);
		
		JLabel lblSales = new JLabel("Sales Control");
		lblSales.setHorizontalAlignment(SwingConstants.CENTER);
		lblSales.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		lblSales.setBounds(207, 0, 462, 46);
		mainPane.add(lblSales);
	}
}
