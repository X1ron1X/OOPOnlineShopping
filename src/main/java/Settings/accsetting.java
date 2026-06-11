package Settings;

import LogReg.MainFrame;
import com.mycompany.ooponlineshopping.Settings;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Ron
 */

//This class is the navigation for the other class

public class accsetting extends JPanel implements ActionListener {

    private JButton btnprof, btnacc, btnadd, btnpay, btnlog;
    private JPanel pnlside, pnlwin;
    private int userId;
    
    public accsetting(int userId) {
    this.userId = userId;
        setBounds(0, 50, 1300, 850);
        setLayout(null);
        
        Color PALATINATE = Color.decode("#FFBF00");
        Font navFont = new Font("Segoe UI", Font.BOLD, 18);
        
        pnlside = new JPanel();
        pnlside.setLayout(null);
        pnlside.setBounds(0, 0, 1400, 60);
        pnlside.setBackground(PALATINATE);
        add(pnlside);
        
        btnprof = new JButton("Profile");
        btnprof.setFont(navFont);
        btnprof.setBackground(PALATINATE);
        btnprof.setForeground(Color.WHITE);
        btnprof.setBounds(120, 15, 140, 30);
        btnprof.setFocusPainted(false);
        btnprof.setBorderPainted(false);
        btnprof.setContentAreaFilled(false);
        btnprof.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlside.add(btnprof);
        
        btnacc = new JButton("Account Settings");
        btnacc.setFont(navFont);
        btnacc.setBackground(PALATINATE);
        btnacc.setForeground(Color.WHITE);
        btnacc.setBounds(320, 15, 220, 30);
        btnacc.setFocusPainted(false);
        btnacc.setBorderPainted(false);
        btnacc.setContentAreaFilled(false);
        btnacc.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlside.add(btnacc);
        
        btnadd = new JButton("Address");
        btnadd.setFont(navFont);
        btnadd.setBackground(PALATINATE);
        btnadd.setForeground(Color.WHITE);
        btnadd.setBounds(610, 15, 140, 30);
        btnadd.setFocusPainted(false);
        btnadd.setBorderPainted(false);
        btnadd.setContentAreaFilled(false);
        btnadd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlside.add(btnadd);
        
        btnpay = new JButton("Cashless Payments");
        btnpay.setFont(navFont);
        btnpay.setBackground(PALATINATE);
        btnpay.setForeground(Color.WHITE);
        btnpay.setBounds(820, 15, 200, 30);
        btnpay.setFocusPainted(false);
        btnpay.setBorderPainted(false);
        btnpay.setContentAreaFilled(false);
        btnpay.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlside.add(btnpay);
        
        btnlog = new JButton("Log out");
        btnlog.setFont(navFont);
        btnlog.setBackground(PALATINATE);
        btnlog.setForeground(Color.WHITE);
        btnlog.setBounds(1250, 15, 140, 30);
        btnlog.setFocusPainted(false);
        btnlog.setBorderPainted(false);
        btnlog.setContentAreaFilled(false);
        btnlog.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnlside.add(btnlog);
        
        pnlwin = new JPanel();
        pnlwin.setLayout(null);
        pnlwin.setBounds(0, 60, 1550, 790);
        pnlwin.setBackground(new Color(235, 235, 235));
        add(pnlwin);
        
        turnPage(new profile(userId));
        
        btnprof.addActionListener(this);
        btnacc.addActionListener(this);
        btnadd.addActionListener(this);
        btnpay.addActionListener(this);
        btnlog.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnprof) {
            turnPage(new profile(userId));
        }else if (e.getSource() == btnacc) {
            turnPage(new account(userId));
        }else if (e.getSource() == btnadd) {
            turnPage(new Address(userId));
        }else if (e.getSource() == btnpay) {
            turnPage(new Payments(userId));
        }else if (e.getSource() == btnlog) {
            Window window = SwingUtilities.getWindowAncestor(this);
            window.dispose();
            MainFrame h = new MainFrame();
            h.setVisible(true);
        }

    }

    public void turnPage(JPanel newPage) {

        pnlwin.removeAll();
        newPage.setBounds(0, 0, 1400, 800);
        pnlwin.add(newPage);
        pnlwin.revalidate();
        pnlwin.repaint();
    }
}