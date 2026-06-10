package com.mycompany.ooponlineshopping;

import java.sql.*;
import javax.swing.DefaultListModel;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlserver://localhost;"
            + "instanceName=MSSQLLocalDB;"
            + "databaseName=master;" 
            + "integratedSecurity=true;"
            + "encrypt=true;"
            + "trustServerCertificate=true;";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initializeDatabase() {
        String createTableSQL = "IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[orders]') AND type in (N'U')) "
                + "BEGIN "
                + "CREATE TABLE orders ("
                + "id INT IDENTITY(1,1) PRIMARY KEY, "
                + "product_name VARCHAR(255) NOT NULL, "
                + "price DECIMAL(10,2) NOT NULL, "
                + "quantity INT NOT NULL, "
                + "status VARCHAR(50) NOT NULL"
                + ");"
                + "END";
        
        try (Connection conn = getConnection(); 
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadOrdersByStatus(String status, DefaultListModel<String> model) {
        model.clear();
        String query = "SELECT id, product_name, price, quantity FROM orders WHERE status = ?;";
        
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, status);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("product_name");
                double price = rs.getDouble("price");
                int qty = rs.getInt("quantity");
                
                model.addElement("ID: " + id + " | " + name + " | Price: $" + price + " | Qty: " + qty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateOrderStatus(String orderText, String newStatus) {
        if (orderText == null || !orderText.contains("|")) return;
        
        try {
            String idPart = orderText.split("\\|")[0].replace("ID:", "").trim();
            int orderId = Integer.parseInt(idPart);

            String query = "UPDATE orders SET status = ? WHERE id = ?;";
            try (Connection conn = getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                
                pstmt.setString(1, newStatus);
                pstmt.setInt(2, orderId);
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}