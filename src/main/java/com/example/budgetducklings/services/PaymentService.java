package com.example.budgetducklings.services;

import com.example.budgetducklings.model.PaymentEntry;
import com.example.budgetducklings.repository.PaymentRepository;

import java.sql.Date;
import java.util.List;

public class PaymentService {
    private PaymentRepository paymentRepository = new PaymentRepository();


    public List<PaymentEntry> getAll(String owner){
        return paymentRepository.getAll(owner);
    }

    public void create(String title, Date date, String description, String category, int amount, String owner) {
        paymentRepository.create(title, date, description, category, amount, owner);
    }

    public boolean delete(String owner, int id){
        return paymentRepository.delete(owner, id);
    }

    //public PaymentEntry update(PaymentEntry entry){
    //}
}
