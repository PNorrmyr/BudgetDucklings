package com.example.budgetducklings.repository;

import com.example.budgetducklings.model.PaymentEntry;
import jakarta.servlet.annotation.WebServlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {

    private final Connection connection;


    public PaymentRepository(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/budgetducklings", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PaymentEntry> getAll(){
        List<PaymentEntry> entries = new ArrayList<>();

        String sql = "SELECT * FROM payments";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                PaymentEntry entry = new PaymentEntry();

                entry.setTitle(rs.getString("title"));
                entry.setDate(rs.getString("date"));
                entry.setDescription(rs.getString("description"));
                entry.setCategory(rs.getString("category"));
                entry.setAmount(rs.getString("amount"));

                entries.add(entry);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return entries;
    }


    public void create(String title, Date date, String description, String category, int amount) {


        String sql = "INSERT INTO payments (title, date, description, category, amount)" +
                    "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setDate(2, date);
            pstmt.setString(3, description);
            pstmt.setString(4, category);
            pstmt.setInt(5, amount);

            pstmt.execute();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
