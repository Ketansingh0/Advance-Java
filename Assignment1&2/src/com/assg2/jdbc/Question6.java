package com.assg2.jdbc;
import java.sql.*;
public class Question6 {
	public static void main(String args[]) throws Exception{
		String url = "jdbc:mysql://localhost:3306/assignments", user = "root", pass = "adarsh@001";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		
		CallableStatement cstmt = con.prepareCall("{CALL GetTotalSalary(?)}");
		
		String department = "HR";

        cstmt.setString(1, department);

        ResultSet rs = cstmt.executeQuery();
        
        double totalSalary = 0.0;
        while(rs.next()) {
        	totalSalary+=rs.getInt(1);
        }

      
        System.out.println("Total Salary for " + department + " Department: ₹" + totalSalary);

        cstmt.close();
        con.close();
	}
}
