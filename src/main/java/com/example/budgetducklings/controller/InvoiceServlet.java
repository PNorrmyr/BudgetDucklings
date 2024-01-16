package com.example.budgetducklings.controller;

import com.example.budgetducklings.model.PaymentEntry;
import com.example.budgetducklings.services.PaymentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/invoice")
public class InvoiceServlet extends HttpServlet {


    PaymentService paymentService = new PaymentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        List<PaymentEntry> paymentEntries = paymentService.getAll();

        for (PaymentEntry entry : paymentEntries) {
            out.println("<br>Title:" + entry.getTitle() + "<br> Date: " + entry.getDate() + "<br>Description: " + entry.getDescription() + "<br>Category: " + entry.getCategory() + "<br>Amount: " + entry.getAmount());
        }
    }
}
