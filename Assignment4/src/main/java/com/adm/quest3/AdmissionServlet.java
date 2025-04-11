package com.adm.quest3;

import java.sql.*;
import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/AdmissionServlet")
public class AdmissionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/CollegeDB";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "adarsh@001";
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String phone = request.getParameter("phone");

        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            String query = "INSERT INTO admission (name, email, course, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, course);
            pst.setString(4, phone);
            pst.executeUpdate();
            
            out.println("<h3>Admission Form Submitted Successfully!</h3>");
            con.close();
        } catch (Exception e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
}

