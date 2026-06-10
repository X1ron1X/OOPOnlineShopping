/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ron
 */
public class DBConnection {

    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/onlineshopoop",
                "root",
                ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}