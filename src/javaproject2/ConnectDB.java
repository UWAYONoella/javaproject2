package javaproject2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
		   String encryptedPassword = encryptPassword(password);
	       
		String sql="INSERT INTO Inform(Names,UserName,Email,Password) VALUES(?,?,?,?)";
		try {
			PreparedStatement  stm=con.prepareStatement(sql);
			stm.setString(1,name);
			stm.setString(2,userName);
			stm.setString(3,email);
			
			stm.setString(4,encryptedPassword);
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
	        String encryptedPassword = encryptPassword(Password);
	       
	        String sql = "SELECT * FROM Inform WHERE UserName=? AND Password=?";
	        try {
	            PreparedStatement st = con.prepareStatement(sql);
	            st.setString(1, Username);
	            st.setString(2, encryptedPassword);
	            row = st.executeQuery();
	            if (row.next()) {
	                Dashboard dash=new Dashboard();
	                dash.setVisible(true);          
	                }
	            else {
	            	JOptionPane.showMessageDialog(null, "Incorrect UserName or Password");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            
	        }
	        return row;
	    }
	 
	 private String encryptPassword(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] digest = md.digest(password.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (byte b : digest) {
	                sb.append(String.format("%02x", b & 0xff));
	            }
	            return sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	 
	 public void addSales(String date,String shoetype,String shoeid,String color,String size,String pairs,String priceunit) {
		 String sql ="INSERT INTO Sales(Date,ShoeType,ShoeId,Color,Size,Pairs,PairUnitPrice) VALUE(?,?,?,?,?,?,?)";
		 try {
			 PreparedStatement st=con.prepareStatement(sql);
			 st.setString(1,date);
			 st.setString(2,shoetype);
			 st.setString(3,shoeid);
			 st.setString(4,color);
			 st.setString(5,size);
			 st.setString(6,pairs);
			 st.setString(7,priceunit);
			 
			 int row =st.executeUpdate();
			 if(row>0) {
				 JOptionPane.showMessageDialog(null, "Well Inserted!");
			 }
		 } catch(SQLException e) {
			 e.printStackTrace();
		 }
	 }
	 public ResultSet getSales() {
		 ResultSet rs = null;
		 try {
			 if(con!=null) {
				String query="SELECT * FROM Sales";
				Statement stmt =con.createStatement();
				rs =stmt.executeQuery(query);
						 }
		 } catch(SQLException e) {
			 e.printStackTrace();
		 }
		 return rs;
	 }

	 
	 public ResultSet getSaleById( String date) {
		 ResultSet row=null;
		 String sql="SELECT * FROM Sales WHERE Date=?";
		 try {
			 if(con!=null) {
			PreparedStatement pre=con.prepareStatement(sql);
			pre.setString(1,date);
			row=pre.executeQuery();
		
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return row;
		 
	 }
	 
	 
	 public void updateSale(String date, String shoetype, String shoeid, String color, String size, String pairs, String priceunit) {
		    String sql = "UPDATE Sales SET ShoeType=?, ShoeId=?, Color=?, Size=?, Pairs=?, PairUnitPrice=? WHERE Date=?";
		    try {
		        if (con != null) {
		            PreparedStatement st = con.prepareStatement(sql);
		            st.setString(1, shoetype);
		            st.setString(2, shoeid);
		            st.setString(3, color);
		            st.setString(4, size);
		            st.setString(5, pairs);
		            st.setString(6, priceunit);
		            st.setString(7, date);

		            int row = st.executeUpdate();
		            if (row > 0) {
		                JOptionPane.showMessageDialog(null, "Entry updated successfully");
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Database connection not established.");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	// Delete methode

	 public void deleteSale(String date) {
	     String sql = "DELETE FROM Sales WHERE Date = ?";
	     try {
	         if (con != null) {
	             PreparedStatement st = con.prepareStatement(sql);
	             st.setString(1, date);
	             int row = st.executeUpdate();
	             if (row > 0) {
	                 JOptionPane.showMessageDialog(null, "Entry deleted successfully");
	             }
	         } else {
	             JOptionPane.showMessageDialog(null, "Database connection not established.");
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	 }
	 
	 
	 public void displayData(DefaultTableModel model) {
		    String sql = "SELECT * FROM Inform";
		    try {
		        Statement stmt = con.createStatement();
		        ResultSet rs = stmt.executeQuery(sql);

		        while (rs.next()) {
		            String id = rs.getString("ID");
		            String name = rs.getString("Names");
		            String userName = rs.getString("UserName");
		            String email = rs.getString("Email");
		            String password = rs.getString("Password");

		            // Add the retrieved data to the table model
		            model.addRow(new Object[] { id, name, userName, email, password });
		        }

		        rs.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}


	

}

