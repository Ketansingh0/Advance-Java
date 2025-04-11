package com.adm;

import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;

@WebServlet("/AttendanceServlet")
public class AttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve employee details from form
        String empId = request.getParameter("empId");
        String empName = request.getParameter("empName");

        // Get the session
        HttpSession session = request.getSession();

        // Retrieve or create attendance list
        @SuppressWarnings("unchecked")
		ArrayList<String> attendanceList = (ArrayList<String>) session.getAttribute("attendance");

        if (attendanceList == null) {
            attendanceList = new ArrayList<>();
        }

        // Add employee to the attendance list
        attendanceList.add("ID: " + empId + ", Name: " + empName);

        // Save the list back to the session
        session.setAttribute("attendance", attendanceList);

        // Confirmation message
        out.println("<html><body>");
        out.println("<h2>Attendance Marked Successfully!</h2>");
        out.println("<a href='index.html'>Go Back</a> | ");
        out.println("<a href='AttendanceServlet'>View Attendance</a>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve session
        HttpSession session = request.getSession();

        // Retrieve attendance list
        @SuppressWarnings("unchecked")
		ArrayList<String> attendanceList = (ArrayList<String>) session.getAttribute("attendance");

        out.println("<html><body>");
        out.println("<h2>Employee Attendance Records</h2>");

        if (attendanceList == null || attendanceList.isEmpty()) {
            out.println("<p>No attendance records found.</p>");
        } else {
            out.println("<table border='1' cellpadding='10'>");
            out.println("<tr><th>Employee ID</th><th>Employee Name</th></tr>");

            for (String record : attendanceList) {
                String[] data = record.split(", ");
                out.println("<tr>");
                out.println("<td>" + data[0].split(": ")[1] + "</td>");
                out.println("<td>" + data[1].split(": ")[1] + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }

        out.println("<br><a href='EmployeeAttendForm.html'>Go Back</a>");
        out.println("</body></html>");
    }
}
