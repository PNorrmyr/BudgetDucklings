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


        if (username == null) {
            resp.sendRedirect("/index.jsp");
        } else {
            List<PaymentEntry> paymentEntries = paymentService.getAll(username);

            PrintWriter out = resp.getWriter();
            out.println("<h1>" + username + "'s Invoices</h2>");

            out.println("<form action=\"addPayment.jsp\">");
            out.println("<button >Add payment</button>");
            out.println("</form>");

            out.println("<form action=\"editPayment.jsp\">");
            out.println("<button>Edit expense</button>");
            out.print("<input type=\"number\" name=\"id\" placeholder=\"Expense number\">");
            out.println("</form>");

            out.println("<form method= \"POST\" action=\"/BudgetDucklings_war/payment/delete\">");
            out.println("<button>Delete expense</button>");
            out.print("<input type=\"number\" name=\"id\" placeholder=\"Expense Number\">");
            out.println("</form>");


            for (PaymentEntry entry : paymentEntries) {
                out.println("Expense number, " + entry.getId() + "<br>Title: " + entry.getTitle() + "<br>Date: " + entry.getDate() + "<br>Description: " + entry.getDescription() + "<br>Category: " + entry.getCategory() + "<br>Amount: " + entry.getAmount() + "<br>--------------<br>");
            }
        }
}}
