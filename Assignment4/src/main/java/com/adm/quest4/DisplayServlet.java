package com.adm.quest4;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieving stored attributes from FormServlet
        String name = (String) request.getAttribute("name");
        String email = (String) request.getAttribute("email");
        String phone = (String) request.getAttribute("phone");
        String course = (String) request.getAttribute("course");

        // Displaying the entered data
        out.println("<html><head><title>Registration Details</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; text-align: center; margin: 40px; background-color: #f4f4f4; }");
        out.println("table { width: 50%; margin: auto; border-collapse: collapse; background-color: white; }");
        out.println("th, td { padding: 10px; border: 1px solid black; }");
        out.println("th { background-color: #007bff; color: white; }");
        out.println("</style></head><body>");
        out.println("<h2>Registration Successful!</h2>");
        out.println("<table>");
        out.println("<tr><th>Field</th><th>Value</th></tr>");
        out.println("<tr><td>Name</td><td>" + name + "</td></tr>");
        out.println("<tr><td>Email</td><td>" + email + "</td></tr>");
        out.println("<tr><td>Phone</td><td>" + phone + "</td></tr>");
        out.println("<tr><td>Course</td><td>" + course + "</td></tr>");
        out.println("</table>");
        out.println("</body></html>");
    }
}
