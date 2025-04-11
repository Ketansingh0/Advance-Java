package com.adm;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;

public class EmployeeRegistrationServlet extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String url = "jdbc:mysql://127.0.0.1:3306/assignments";
        String uname = "root";
        String pass = "adarsh@001";
        
     // Get form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");
        String salary = request.getParameter("salary");

        // Validate inputs
        if (name == null || email == null || designation == null || salary == null || name.isEmpty() || email.isEmpty() || designation.isEmpty() || salary.isEmpty()) {
            out.println("<h3 style='color:red;'>All fields are required!</h3>");
            return;
        }

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, uname, pass);

            // Prepare SQL query
            String sql = "INSERT INTO employee1 (name, email, designation, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, designation);
            pstmt.setDouble(4, Double.parseDouble(salary));

            // Execute query
            int rowsInserted = pstmt.executeUpdate();

            // Close resources
            pstmt.close();
            conn.close();

            if (rowsInserted > 0) {
                out.println("<h3 style='color:green;'>Employee registered successfully!</h3>");
            } else {
                out.println("<h3 style='color:red;'>Failed to register employee.</h3>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
        }
    }
}