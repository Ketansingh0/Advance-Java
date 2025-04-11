package com.assg2.jdbc;
import java.sql.*;
public class Question5 {
	public static void main(String args[]) throws Exception{
		String url = "jdbc:mysql://localhost:3306/player", user = "root", pass = "adarsh@001";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pass);
		
		String query = "insert into playerdetails values(?,?,?)";
		PreparedStatement st = con.prepareStatement(query);
		
		long start = System.currentTimeMillis();
		
		for (int i = 1; i<=1000; i++) {
			st.setInt(1, i);
			st.setString(2, "Player_"+i);
			st.setInt(3,  (int)(Math.random() *100));
			st.addBatch();
			
			if(i%100==0) {
				st.executeBatch();
			}
		}st.executeBatch();
		
		long end = System.currentTimeMillis();
		System.out.println("Inserted 1000 rows in "+(end-start)+"ms");
		
		st.close();
		con.close();
	}
}
