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


    private final Map<String, String> users = new HashMap<>() {{
        put("Bob", "123");
        put("Yves", "abc");
        put("Dan", "xyz");
        put("Ann", "789");
    }};

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            login(req, resp);

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (users.get(username) == null || !users.get(username).equals(password)) {
            resp.sendRedirect("index.jsp?error=invalid%20login");
        } else {
            HttpSession session = req.getSession(true);
            session.setAttribute("username", username);

            resp.sendRedirect("/BudgetDucklings_war/invoice");
        }
    }


    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    HttpSession session = req.getSession(true);

    session.setAttribute("username", null);
    session.invalidate();

    resp.sendRedirect("index.jsp");

    }
}
