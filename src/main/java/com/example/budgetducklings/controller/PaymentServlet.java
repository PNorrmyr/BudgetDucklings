package com.example.budgetducklings.controller;

import com.example.budgetducklings.model.PaymentEntry;
import com.example.budgetducklings.services.PaymentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/payment/*")
public class PaymentServlet extends HttpServlet {

    private final PaymentService paymentService = new PaymentService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (req.getPathInfo()){
            case "/add": createEntry(req,resp); break;
            case "/delete": deleteEntry(req,resp); break;
        }
    }

    private void createEntry(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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

            paymentService.create(title, date, description, category, amount, username);

            resp.sendRedirect("/BudgetDucklings_war/invoice");
        }
    }

    private void deleteEntry(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");

        int id = Integer.parseInt(req.getParameter("id"));


        if (username == null) {
            resp.sendRedirect("/index.jsp");
        } else {
            paymentService.delete(username, id);
        }
        resp.sendRedirect("/BudgetDucklings_war/invoice");
    }

    private void updateEntry(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");


        if (username==null) {
            resp.sendRedirect("/index.jsp");
        } else {
            String title = req.getParameter("title");
            Date date = Date.valueOf(req.getParameter("date"));
            String description = req.getParameter("description");
            String category = req.getParameter("category");
            int amount = Integer.parseInt(req.getParameter("amount"));



        }
    }
}
