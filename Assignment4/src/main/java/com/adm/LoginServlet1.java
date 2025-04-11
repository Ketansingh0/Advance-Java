//2.⁠ ⁠Assume four users user1, user2, user3 and user4 having the passwords pwd1, pwd2, pwd3 and pwd4 respectively. Write a servlet for doing the following. Create a Cookie and add these four-user id’s and passwords to this Cookie. 2. Read the user id and passwords entered in the Login form and authenticate with the values available in the cookies.

package com.adm;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet1")
public class LoginServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Hardcoded user credentials
        String[][] users = {
            {"user1", "pwd1"},
            {"user2", "pwd2"},
            {"user3", "pwd3"},
            {"user4", "pwd4"}
        };

        // Creating a cookie to store users and passwords
        for (String[] user : users) {
            Cookie cookie = new Cookie(user[0], user[1]);
            cookie.setMaxAge(60 * 60 * 24); // Cookie valid for 1 day
            response.addCookie(cookie);
        }

        // Get user credentials from request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Get stored cookies
        Cookie[] cookies = request.getCookies();
        boolean isAuthenticated = false;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(username) && cookie.getValue().equals(password)) {
                    isAuthenticated = true;
                    break;
                }
            }
        }

        // Response based on authentication result
        out.println("<html><body>");
        if (isAuthenticated) {
            out.println("<h3 style='color:green;'>Login Successful! Welcome, " + username + ".</h3>");
        } else {
            out.println("<h3 style='color:red;'>Invalid username or password. Try again.</h3>");
        }
        out.println("</body></html>");
    }
}
