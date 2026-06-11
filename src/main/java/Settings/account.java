package Settings;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ron
 */

public class account extends JPanel implements ActionListener {

    private JLabel title;
    private JPanel sidebar, content;

    private JButton prof, pass, acc;
    private int userId;

    account(int userId) {
        this.userId = userId;
        setLayout(null);
        setBackground(new Color(245, 245, 245));
        setBounds(0, 0, 1400, 800);

        Color PALATINATE = Color.decode("#FFBF00");
        
        sidebar = new JPanel();
        sidebar.setLayout(null);
        sidebar.setBounds(0, 0, 180, 790);
        sidebar.setBackground(PALATINATE);
        add(sidebar);

        Font navFont = new Font("Segoe UI", Font.BOLD, 18);

        prof = new JButton("Profile");
        prof.setBounds(20, 80, 140, 45);
        prof.setFont(navFont);
        prof.setForeground(Color.WHITE);
        prof.setBackground(new Color(0,0,0,0));
        prof.setFocusPainted(false);
        prof.setBorderPainted(false);
        prof.setContentAreaFilled(false);
        sidebar.add(prof);
        
        pass = new JButton("Password");
        pass.setBounds(20, 150, 140, 45);
        pass.setFont(navFont);
        pass.setForeground(Color.WHITE);
        pass.setBackground(new Color(0,0,0,0));
        pass.setFocusPainted(false);
        pass.setBorderPainted(false);
        pass.setContentAreaFilled(false);
        sidebar.add(pass);
        
        acc  = new JButton("Account");
        acc.setBounds(20, 220, 140, 45);
        acc.setFont(navFont);
        acc.setForeground(Color.WHITE);
        acc.setBackground(new Color(0,0,0,0));
        acc.setFocusPainted(false);
        acc.setBorderPainted(false);
        acc.setContentAreaFilled(false);
        sidebar.add(acc);
        
        content = new JPanel();
        content.setLayout(null);
        content.setBounds(180, 0, 1200, 790);
        content.setBackground(Color.WHITE);
        add(content);

        title = new JLabel("Account Settings");
        title.setBounds(40, 30, 400, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        content.add(title);
        
        turnPage(new profset(userId));
        
        prof.addActionListener(this);
        pass.addActionListener(this);
        acc.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == prof) {
            turnPage(new profset(userId));
        }else if (e.getSource() == pass) {
            turnPage(new ChangePassword(userId));
        }else if (e.getSource() == acc) {
            turnPage(new DeleteAccount(userId));
        }
    }
    
    public void turnPage(JPanel newPage) {

        content.removeAll();
        newPage.setBounds(0, 0, 1400, 800);
        content.add(newPage);
        content.revalidate();
        content.repaint();
    }
}