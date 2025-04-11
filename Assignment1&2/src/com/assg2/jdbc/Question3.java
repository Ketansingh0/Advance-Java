package com.assg2.jdbc;
import java.sql.*;
public class Question3 {
	public static void main(String args[]) throws Exception{
		String url = "jdbc:mysql://127.0.0.3:3306/assignments";
		String uname = "root", pass = "adarsh@001";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, uname, pass);
		
		con.setAutoCommit(false);
		
		int senderId = 1;   
	    int receiverId = 2; 
	    double amount = 8000;

	    String debitQuery = "UPDATE bankdb SET balance = balance - ? WHERE id = ?";
	    PreparedStatement debitStmt = con.prepareStatement(debitQuery);
	    debitStmt.setDouble(1, amount);
	    debitStmt.setInt(2, senderId);
	    int debitResult = debitStmt.executeUpdate();
		    
	    String creditQuery = "UPDATE bankdb SET balance = balance + ? WHERE id = ?";
	    PreparedStatement creditStmt = con.prepareStatement(creditQuery);
	    creditStmt.setDouble(1, amount);
	    creditStmt.setInt(2, receiverId);	    
	    int creditResult = creditStmt.executeUpdate();
	    
	    if (debitResult > 0 && creditResult > 0) {
	        con.commit();  
	        System.out.println("Transaction Successful! " + amount+" transferred");
	    } else {
	        con.rollback();
	        System.out.println("Transaction Failed! Rolled Back.");
	    }
	    
	    debitStmt.close();
	    creditStmt.close();
	    con.close();
	}
}
