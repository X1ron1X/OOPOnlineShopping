package Settings;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ron
 */

//This Class lets the user to change their Password

public class ChangePassword extends JPanel implements ActionListener {

    private JLabel title, oldpass, newpass, conpass;
    private JPasswordField oldpassword, newpassword, conpassword;
    private JButton save;

    private String Password = "admin123!";

    ChangePassword() {

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

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == save) {
            String old = oldpassword.getText();
            String newp = newpassword.getText();
            String conf = conpassword.getText();
            if (old.equals(Password) && newp.equals(conf)) {
                Password = newp;
                JOptionPane.showMessageDialog(this,"Password changed successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this,"Invalid input. Please check your passwords.","Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}