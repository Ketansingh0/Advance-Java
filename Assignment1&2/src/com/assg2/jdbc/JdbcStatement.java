package com.assg2.jdbc;
import java.sql.*;

public class JdbcStatement {
	private static final String URL = "jdbc:mysql://localhost:3306/sys";
	private static final String USER = "root";
	private static final String PASSWORD = "adarsh@001";
	
	public static void main(String args[]) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

        // Creating Statement object
        Statement stmt = con.createStatement();

        // SQL query to create the Students table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS Students ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "name VARCHAR(50) NOT NULL, "
                + "age INT NOT NULL, "
                + "grade CHAR(1) NOT NULL)";

        // Executing the query
        stmt.executeUpdate(createTableSQL);
        System.out.println("Table 'Students' created successfully!");

        // Closing resources
        stmt.close();
        con.close();
	}
}
