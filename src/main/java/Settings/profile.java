package Settings;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ron
 */

public class profile extends JPanel implements ActionListener {

    private JPanel top;
    private JLabel title;
    private JLabel uname, uname1, name, name1, email, email1;
    private JLabel pnum, pnum1, gen, gen1, birth, birth1;

    profile() {

        setLayout(null);
        setBackground(new Color(245, 245, 245));
        setBounds(0, 0, 1550, 790);

        Color PALATINATE = new Color(104, 40, 96);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 17);
        Font valueFont = new Font("Segoe UI", Font.PLAIN, 17);
        
        title = new JLabel("My Profile");
        title.setBounds(80, 30, 300, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        add(title);
        
        top = new JPanel(null);
        top.setBounds(80, 90, 1300, 550);
        top.setBackground(Color.WHITE);
        top.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        add(top);

        

        int labelX = 220;
        int valueX = 500;
        int startY = 80;
        int gap = 65;
        uname = new JLabel("Username:");
        uname.setBounds(labelX, startY, 200, 30);
        uname.setFont(labelFont);
        top.add(uname);

        name = new JLabel("Full Name:");
        name.setBounds(labelX, startY + gap, 200, 30);
        name.setFont(labelFont);
        top.add(name);

        email = new JLabel("Email:");
        email.setBounds(labelX, startY + (gap * 2), 200, 30);
        email.setFont(labelFont);
        top.add(email);

        pnum = new JLabel("Phone Number:");
        pnum.setBounds(labelX, startY + (gap * 3), 200, 30);
        pnum.setFont(labelFont);
        top.add(pnum);

        gen = new JLabel("Gender:");
        gen.setBounds(labelX, startY + (gap * 4), 200, 30);
        gen.setFont(labelFont);
        top.add(gen);

        birth = new JLabel("Birth Date:");
        birth.setBounds(labelX, startY + (gap * 5), 200, 30);
        birth.setFont(labelFont);
        top.add(birth);

        // VALUES
        uname1 = new JLabel("ADMIN123");
        uname1.setBounds(valueX, startY, 400, 30);
        uname1.setFont(valueFont);
        top.add(uname1);

        name1 = new JLabel("ADMIN A. ADMIN");
        name1.setBounds(valueX, startY + gap, 400, 30);
        name1.setFont(valueFont);
        top.add(name1);

        email1 = new JLabel("ADMIN@gmail.com");
        email1.setBounds(valueX, startY + (gap * 2), 400, 30);
        email1.setFont(valueFont);
        top.add(email1);

        pnum1 = new JLabel("09912345678");
        pnum1.setBounds(valueX, startY + (gap * 3), 400, 30);
        pnum1.setFont(valueFont);
        top.add(pnum1);

        gen1 = new JLabel("Male");
        gen1.setBounds(valueX, startY + (gap * 4), 400, 30);
        gen1.setFont(valueFont);
        top.add(gen1);

        birth1 = new JLabel("January 1, 2000");
        birth1.setBounds(valueX, startY + (gap * 5), 400, 30);
        birth1.setFont(valueFont);
        top.add(birth1);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}