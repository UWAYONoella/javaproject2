package javaproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectDB {

	String dburl="jdbc:mysql://localhost:3307/ShopUser";
	String dbuser="root";
	String dbpwd="";
	Connection con;
	
	public Connection dbConnection() {
		
		try {
			con=DriverManager.getConnection(dburl,dbuser, dbpwd );
			JOptionPane.showMessageDialog(null, "db connected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;	
	}
	
	public void addUser(String name,String userName,String email,String password) {
		String sql="INSERT INTO Inform(Names,UserName,Email,Password) VALUES(?,?,?,?)";
		try {
			PreparedStatement  stm=con.prepareStatement(sql);
			stm.setString(1,name);
			stm.setString(2,userName);
			stm.setString(3,email);
			
			stm.setString(4,password);
			int row=stm.executeUpdate();
			if(row>0) {
				JOptionPane.showMessageDialog(null, "Inserted ");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public ResultSet getUser(String Username, String Password) {
	        ResultSet row = null;
	       
	        String sql = "SELECT * FROM Inform WHERE UserName=? AND Password=?";
	        try {
	            PreparedStatement st = con.prepareStatement(sql);
	            st.setString(1, Username);
	            st.setString(2, Password);
	            row = st.executeQuery();
	            if (row.next()) {
	                Dashboard dash=new Dashboard();
	                dash.setVisible(true);          
	                }
	            else {
	            	JOptionPane.showMessageDialog(null, "Incorrect Email or Password");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        }
	        return row;
	    }
	
}

