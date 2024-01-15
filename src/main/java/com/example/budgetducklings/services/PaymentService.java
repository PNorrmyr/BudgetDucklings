package com.example.budgetducklings.services;

import com.example.budgetducklings.model.PaymentEntry;
import com.example.budgetducklings.repository.PaymentRepository;

import java.sql.Date;
import java.util.List;

public class PaymentService {
    private PaymentRepository paymentRepository = new PaymentRepository();


    public List<PaymentEntry> getAll(){
        return paymentRepository.getAll();
    }

    public void create(String title, Date date, String description, String category, int amount) {
        paymentRepository.create(title, date, description, category, amount);
    }
}
