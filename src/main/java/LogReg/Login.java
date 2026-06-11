package LogReg;

import Dbcon.DBConnection;
import com.mycompany.ooponlineshopping.Header;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JPanel {

    private MainFrame frame;
    private int loggedInUserId;

    public Login(MainFrame frame) {
        this.frame = frame;

        setLayout(null);
        setBackground(new Color(245, 245, 245));

        
        JPanel cardPanel = new JPanel(null);
        cardPanel.setBounds(225, 195, 600, 400);
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        add(cardPanel);

      
        JLabel title = new JLabel("LOGIN");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setBounds(260, 30, 200, 40);
        cardPanel.add(title);

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);

      
        JLabel users = new JLabel("Username");
        users.setFont(labelFont);
        users.setBounds(80, 100, 200, 20);

        JTextField username = new JTextField();
        username.setBounds(80, 120, 440, 35);

   
        JLabel passw = new JLabel("Password");
        passw.setFont(labelFont);
        passw.setBounds(80, 170, 200, 20);

        JPasswordField password = new JPasswordField();
        password.setBounds(80, 190, 440, 35);

   
        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(170, 270, 120, 40);
        loginBtn.setBackground(new Color(255, 191, 0));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);

        JButton createBtn = new JButton("CREATE");
        createBtn.setBounds(310, 270, 140, 40);
        createBtn.setBackground(Color.GRAY);
        createBtn.setForeground(Color.WHITE);
        createBtn.setFocusPainted(false);

  
        cardPanel.add(title);

        cardPanel.add(users);
        cardPanel.add(username);

        cardPanel.add(passw);
        cardPanel.add(password);

        cardPanel.add(loginBtn);
        cardPanel.add(createBtn);

       
        loginBtn.addActionListener(e -> {

            String user = username.getText().trim();
            String pass = new String(password.getPassword());

            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter username and password.");
                return;
            }

            try (
                Connection conn = DBConnection.getConnection();
                PreparedStatement pst = conn.prepareStatement(
                        "SELECT user_id FROM users WHERE username=? AND password=?")
            ) {

                pst.setString(1, user);
                pst.setString(2, pass);

                try (ResultSet rs = pst.executeQuery()) {

                    if (rs.next()) {

                        loggedInUserId = rs.getInt("user_id");

                        JOptionPane.showMessageDialog(this,
                                "Login Successful!");

                        Header h = new Header(loggedInUserId);
                        h.setVisible(true);

                        Window window = SwingUtilities.getWindowAncestor(this);
                        if (window != null) {
                            window.dispose();
                        }

                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Invalid Login!");
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Database Error: " + ex.getMessage());
            }
        });

       
        createBtn.addActionListener(e -> frame.showRegister());
    }
}