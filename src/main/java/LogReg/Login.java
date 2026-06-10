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
        setBackground(Color.WHITE);

        JLabel users = new JLabel("Username");
        users.setBounds(25, 150, 250, 35);

        JLabel passw = new JLabel("Password");
        passw.setBounds(25, 210, 250, 35);

        JLabel title = new JLabel("LOGIN");
        title.setBounds(180, 80, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JTextField username = new JTextField();
        username.setBounds(100, 150, 250, 35);

        JPasswordField password = new JPasswordField();
        password.setBounds(100, 210, 250, 35);

        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(150, 270, 150, 35);

        JButton createBtn = new JButton("CREATE ACCOUNT");
        createBtn.setBounds(120, 330, 200, 35);

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

        add(title);
        add(username);
        add(password);
        add(loginBtn);
        add(createBtn);
        add(users);
        add(passw);
    }
}