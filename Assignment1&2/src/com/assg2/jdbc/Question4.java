package com.assg2.jdbc;
import java.sql.*;
public class Question4 {
	public static void main(String args[]) throws Exception{
		String url = "jdbc:mysql://localhost:3306/assignments", user = "root", pass = "adarsh@001";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		
		String query = "delete from student where grade<= ?";
		String threshold = "D";
		PreparedStatement st = con.prepareStatement(query);
		
		st.setString(1, threshold);
		
		int count = st.executeUpdate();
		System.out.println(count+ " rows deleted");
		
		st.close();
		con.close();
	}
}
