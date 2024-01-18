package com.example.budgetducklings.repository;

import com.example.budgetducklings.model.PaymentEntry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {

    private final Connection connection;


    public PaymentRepository(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/budgetducklings?createDatabaseIfNotExist=true", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PaymentEntry> getAll(String owner){
        List<PaymentEntry> entries = new ArrayList<>();


        String sql = "SELECT id, title, date, description, category, amount FROM payments WHERE owner = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,owner);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                PaymentEntry entry = new PaymentEntry();

                entry.setId(rs.getInt("id"));
                entry.setTitle(rs.getString("title"));
                entry.setDate(rs.getString("date"));
                entry.setDescription(rs.getString("description"));
                entry.setCategory(rs.getString("category"));
                entry.setAmount(rs.getString("amount"));
                entry.setOwner(owner);

                entries.add(entry);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return entries;
    }


    public void create(String title, Date date, String description, String category, int amount, String owner) {


        String sql = "INSERT INTO payments (title, date, description, category, amount, owner)" +
                    "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setDate(2, date);
            pstmt.setString(3, description);
            pstmt.setString(4, category);
            pstmt.setInt(5, amount);
            pstmt.setString(6, owner);

            pstmt.execute();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean delete(String owner, int id) {
        String sql = "DELETE FROM payments WHERE id = ? AND owner = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, owner);

            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

   public void update(PaymentEntry entry) {
        String sql = "UPDATE payments SET title = ?, date = ?, description = ?, category = ?, amount = ? WHERE owner = ? and id = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, entry.getTitle() );
            pstmt.setDate(2, entry.getDate());
            pstmt.setString(3, entry.getDescription());
            pstmt.setString(4, entry.getCategory());
            pstmt.setString(5, entry.getAmount());
            pstmt.setString(6, entry.getOwner());
            pstmt.setInt(7, entry.getId());

            pstmt.execute();
            System.out.println("running sql");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
