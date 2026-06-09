package Settings;

import Dbcon.DBConnection;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ChangePassword extends JPanel implements ActionListener {

    private JLabel title, oldpass, newpass, conpass;
    private JPasswordField oldpassword, newpassword, conpassword;
    private JButton save;

    private int userId;

    public ChangePassword(int userId) {

        this.userId = userId;

        setLayout(null);
        setBackground(new Color(245, 245, 245));
        setBounds(0, 0, 1270, 790);

        Color PALATINATE = new Color(104, 40, 96);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 16);

        title = new JLabel("Change Password");
        title.setBounds(60, 40, 400, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        add(title);

        JPanel card = new JPanel(null);
        card.setBounds(60, 110, 600, 400);
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        add(card);

        oldpass = new JLabel("Old Password");
        oldpass.setBounds(50, 60, 200, 30);
        oldpass.setFont(labelFont);
        card.add(oldpass);

        oldpassword = new JPasswordField();
        oldpassword.setBounds(220, 60, 300, 35);
        card.add(oldpassword);

        newpass = new JLabel("New Password");
        newpass.setBounds(50, 130, 200, 30);
        newpass.setFont(labelFont);
        card.add(newpass);

        newpassword = new JPasswordField();
        newpassword.setBounds(220, 130, 300, 35);
        card.add(newpassword);

        conpass = new JLabel("Confirm Password");
        conpass.setBounds(50, 200, 200, 30);
        conpass.setFont(labelFont);
        card.add(conpass);

        conpassword = new JPasswordField();
        conpassword.setBounds(220, 200, 300, 35);
        card.add(conpassword);

        save = new JButton("Update Password");
        save.setBounds(220, 290, 200, 45);
        save.setBackground(PALATINATE);
        save.setForeground(Color.WHITE);
        save.setFont(new Font("Segoe UI", Font.BOLD, 16));
        save.setFocusPainted(false);
        card.add(save);

        save.addActionListener(this);
    }

    // ================= GET CURRENT PASSWORD =================
    private String getCurrentPassword() {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT password FROM users WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("password");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    // ================= UPDATE PASSWORD =================
    private void updatePassword(String newPass) {

        try (Connection con = DBConnection.getConnection()) {

            String sql = "UPDATE users SET password=? WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, newPass);
            ps.setInt(2, userId);

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == save) {

            String old = new String(oldpassword.getPassword());
            String newp = new String(newpassword.getPassword());
            String conf = new String(conpassword.getPassword());

            String current = getCurrentPassword();

            if (current == null) {
                JOptionPane.showMessageDialog(this,
                        "User not found.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!old.equals(current)) {
                JOptionPane.showMessageDialog(this,
                        "Old password is incorrect.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!newp.equals(conf)) {
                JOptionPane.showMessageDialog(this,
                        "Passwords do not match.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (newp.length() < 6) {
                JOptionPane.showMessageDialog(this,
                        "Password too short (min 6 characters).",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            updatePassword(newp);

            JOptionPane.showMessageDialog(this,
                    "Password updated successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            oldpassword.setText("");
            newpassword.setText("");
            conpassword.setText("");
        }
    }
}