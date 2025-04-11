package com.adm;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve user input
        String username = request.getParameter("username");

        // Store in a cookie with a 1-minute expiration
        Cookie userCookie = new Cookie("username", username);
        userCookie.setMaxAge(60); // Cookie expires in 1 minute
        response.addCookie(userCookie);

        // Display confirmation
        out.println("<html><body>");
        out.println("<h2>Cookie has been set!</h2>");
        out.println("<p>Stored Name: <b>" + username + "</b></p>");
        out.println("<p>Note: This cookie will expire in 1 minute.</p>");
        out.println("<a href='CookieServlet'>Click here to see stored name</a>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve cookie
        Cookie[] cookies = request.getCookies();
        String storedName = "Not Found";

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    storedName = cookie.getValue();
                }
            }
        }

        // Display stored cookie value
        out.println("<html><body>");
        out.println("<h2>Stored Cookie Data</h2>");
        out.println("<p>Your Name: <b>" + storedName + "</b></p>");
        out.println("<p>(If it's 'Not Found', the cookie has expired.)</p>");
        out.println("<a href='Cookie.html'>Go Back</a>");
        out.println("</body></html>");
    }
}
