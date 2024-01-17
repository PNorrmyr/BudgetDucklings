package com.example.budgetducklings.controller;

import com.example.budgetducklings.model.PaymentEntry;
import com.example.budgetducklings.services.PaymentService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/invoice")
public class InvoiceServlet extends HttpServlet {


    PaymentService paymentService = new PaymentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String username = (String) session.getAttribute("username");

        List<PaymentEntry> paymentEntries = paymentService.getAll(username);

        // Skicka listan med betalningsposter till JSP-sidan
        req.setAttribute("paymentEntries", paymentEntries);

        if (paymentEntries.isEmpty()) {
            System.out.println("The list of payment entries is empty.");
        } else {
            System.out.println("The list of payment entries is not empty.");
        }

        System.out.println("Sending paymentEntries to invoice.jsp: " + paymentEntries);

        // Skicka begäran till JSP-sidan
        RequestDispatcher dispatcher = req.getRequestDispatcher("/invoice.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/invoice.jsp");
    }
}
