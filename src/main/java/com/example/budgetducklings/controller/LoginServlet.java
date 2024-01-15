package com.example.budgetducklings.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    private Map<String, String> users = new HashMap<>() {{
        put("phil", "123");
        put("nor", "123");
    }};

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getPathInfo()) {
            case"/login": login(req, resp); break;
            case"/logout": logout(req, resp); break;
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (users.get(username) == null) {
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        } else if (users.get(username).equals(password)) {
            HttpSession session = req.getSession(true);
            session.setAttribute("username", username);

            resp.sendRedirect("/invoice");
        } else {
            resp.sendRedirect("/index.jsp?error=invalid%20login");
        }
    }


    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    HttpSession session = req.getSession(true);

    session.setAttribute("username", null);
    session.invalidate();

    resp.sendRedirect("index.jsp");

    }
}
