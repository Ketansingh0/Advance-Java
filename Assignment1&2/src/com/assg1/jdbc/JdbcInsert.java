//⁠Write program to create a demo table emp having fields is, name, city and insert two rows by using JDBC.

package com.assg1.jdbc;
import java.sql.*;
public class JdbcInsert {
	public static void main(String args[]) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.3:3306/assignments", "root", "adarsh@001");
		Statement st = con.createStatement();
		
		String query = "CREATE TABLE emp (id INT PRIMARY KEY, name VARCHAR(50), city VARCHAR(50))";
		
		st.executeUpdate(query);
		System.out.println("Table 'emp' created successfully");
		
		// Inserting data
		String data1 = "INSERT INTO emp VALUES(1, 'Ketan', 'Greater Noida'),(2, 'Adarsh', 'Delhi')";
		int count = st.executeUpdate(data1);
		System.out.println(count+" rows affected");
		
		st.close();
		con.close();
	}
}
