package com.example.budgetducklings.controller;

import com.example.budgetducklings.services.PaymentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {

    private final PaymentService paymentService = new PaymentService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");


        if (username == null) {
            resp.sendRedirect("/index.jsp");
        } else {
            String title = req.getParameter("title");
            Date date = Date.valueOf(req.getParameter("date"));
            String description = req.getParameter("description");
            String category = req.getParameter("category");
            int amount = Integer.parseInt(req.getParameter("amount"));

            paymentService.create(title, date, description, category, amount);

            resp.sendRedirect("/invoice");
        }
    }
}
