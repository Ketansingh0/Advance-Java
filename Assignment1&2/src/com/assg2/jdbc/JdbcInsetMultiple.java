// Write a Java program using Statement to insert multiple records into the Students table.
package com.assg2.jdbc;
import java.sql.*;
public class JdbcInsetMultiple {
	public static void main(String []args) throws Exception {
		// Database connection details
        String url = "jdbc:mysql://127.0.0.1:3306/sys";
        String user = "root";
        String pass = "adarsh@001";

        // Step 1: Establish connection
        Connection con = DriverManager.getConnection(url, user, pass);

        // Step 2: Create Statement object
        Statement stmt = con.createStatement();

        // Step 3: Define multiple INSERT queries
        String insert1 = "INSERT INTO Students (name, age, grade) VALUES ('Amit', 20, 'A')";
        String insert2 = "INSERT INTO Students (name, age, grade) VALUES ('Priya', 19, 'B')";
        String insert3 = "INSERT INTO Students (name, age, grade) VALUES ('Rahul', 21, 'A')";
        String insert4 = "INSERT INTO Students (name, age, grade) VALUES ('Sneha', 20, 'C')";
        String insert5 = "INSERT INTO Students (name, age, grade) VALUES ('Rohan', 22, 'B')";

        // Step 4: Execute the queries
        stmt.executeUpdate(insert1);
        stmt.executeUpdate(insert2);
        stmt.executeUpdate(insert3);
        stmt.executeUpdate(insert4);
        stmt.executeUpdate(insert5);

        System.out.println("Records inserted successfully!");

        // Step 5: Close resources
        stmt.close();
        con.close();
    }
}