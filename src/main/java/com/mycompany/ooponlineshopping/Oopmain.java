package com.mycompany.ooponlineshopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class Oopmain {

    public static void main(String[] args) {
        DatabaseManager.initializeDatabase();

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement()) {
            
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM orders");
            if (rs.next() && rs.getInt("total") == 0) {
                String insertSQL = "INSERT INTO orders (product_name, price, quantity, status) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setString(1, "Test Mechanical Keyboard");
                    pstmt.setDouble(2, 49.99);
                    pstmt.setInt(3, 1);
                    pstmt.setString(4, "Pending");
                    pstmt.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            DefaultListModel<String> toShip = new DefaultListModel<>();
            DefaultListModel<String> transit = new DefaultListModel<>();
            DefaultListModel<String> completed = new DefaultListModel<>();

            DatabaseManager.loadOrdersByStatus("Pending", toShip);
            DatabaseManager.loadOrdersByStatus("In Transit", transit);
            DatabaseManager.loadOrdersByStatus("Completed", completed);

            adminDispatch adminWindow = new adminDispatch(toShip, transit, completed);
            customerStatus customerWindow = new customerStatus(toShip, transit, completed);

            adminWindow.setVisible(true);
            customerWindow.setVisible(true);
        }); 
    } 
} 