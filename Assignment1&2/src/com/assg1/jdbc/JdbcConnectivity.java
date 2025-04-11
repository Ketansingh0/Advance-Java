// ⁠Install a database (MySQL or Oracle).  
//Program to illustrate JDBC connectivity.  Program for maintaining database by sending queries.

package com.assg1.jdbc;
import java.sql.*;
public class JdbcConnectivity {
	public static void main(String []args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.3:3306/assignments", "root", "adarsh@001");
		Statement st = con.createStatement();
		
		String query = "select * from emp";
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			String empdata = rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3);
			System.out.println(empdata);
		}
	}
}
