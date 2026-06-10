package com.mycompany.ooponlineshopping;

import Settings.Address;
import Dbcon.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Test extends JFrame implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginBtn;

    public static int loggedInUserId; // IMPORTANT for your Address module
    

    public Test() {

        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 100, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 50, 180, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 100, 100, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 180, 25);
        add(passwordField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(150, 160, 100, 30);
        loginBtn.addActionListener(this);
        add(loginBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginBtn) {

            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            try {
                Connection conn = DBConnection.getConnection();

                String sql = "SELECT user_id FROM users WHERE username=? AND password=?";

                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, password);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    loggedInUserId = rs.getInt("user_id");

                    JOptionPane.showMessageDialog(this, "Login Successful!");

                    // OPEN YOUR MAIN SYSTEM OR ADDRESS PANEL
                    // Example:
                    // new MainFrame(loggedInUserId).setVisible(true);
                    Header h = new Header(loggedInUserId);
                    h.setVisible(true);

                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Login!");
                }

                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    
}