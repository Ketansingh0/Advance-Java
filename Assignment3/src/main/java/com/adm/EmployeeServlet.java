package com.adm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String url = "jdbc:mysql://127.0.0.1:3306/assignments";
        String uname = "root";
        String pass = "adarsh@001";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(url, uname, pass);
            Statement st = con.createStatement();
            String query = "SELECT * FROM employee";
            ResultSet rs = st.executeQuery(query);

            // HTML structure
            out.println("<html><head><title>Employee Details</title>");
            out.println("<style>");
            out.println("body { font-family: Arial, sans-serif; text-align: center; background-color: #f4f4f4; }");
            out.println("table { width: 60%; margin: auto; border-collapse: collapse; background-color: white; }");
            out.println("th, td { padding: 10px; border: 1px solid black; }");
            out.println("th { background-color: #007bff; color: white; }");
            out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
            out.println("</style></head><body>");
            out.println("<h2>Employee Details</h2>");
            out.println("<table>");
            out.println("<tr><th>Employee Name</th><th>Address</th></tr>");

            // Fetching three rows and only two fields (Name & Address)
            int count = 0;
            while (rs.next() && count < 3) {
                out.println("<tr>");
                out.println("<td>" + rs.getString(2) + "</td>");
                out.println("<td>" + rs.getString(3) + "</td>");
                out.println("</tr>");
                count++;
            }

            out.println("</table>");
            out.println("</body></html>");

            // Close resources
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        }
    }
}
