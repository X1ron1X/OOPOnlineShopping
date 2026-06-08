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

//This class let's the user update or edit their profile

public class profset extends JPanel implements ActionListener {

    private JPanel top, uptpnl;
    private JLabel title, uptitle;
    private JLabel uname, uname1, name, name1, email, email1;
    private JLabel pnum, pnum1, gen, gen1, birth, birth1;
    private JLabel upuname, upname, upemail, uppnum, upgen, upbirth;
    private JTextField txtuser, txtname, txtemail, txtpnum;
    private JButton save, edit, exit;

    JComboBox<Integer> cmbday, cmbyear;
    JComboBox<String> cmbgen, cmbmonth;

    private final String[] months;
    private final String[] gender;

    private final Integer[] years = new Integer[97];
    private final Integer[] days = new Integer[31];

    public profset() {

        this.months = new String[]{
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        this.gender = new String[]{"Male", "Female", "Other"};

        for (int i = 1911; i <= 2007; i++) {
            this.years[i - 1911] = i;
        }

        for (int i = 1; i <= 31; i++) {
            this.days[i - 1] = i;
        }

        setLayout(null);
        setBackground(new Color(245, 245, 245));
        setBounds(0, 0, 1550, 790);

        Color PALATINATE = new Color(104, 40, 96);
        Font labelFont = new Font("Segoe UI", Font.BOLD, 17);
        Font valueFont = new Font("Segoe UI", Font.PLAIN, 17);
        
        title = new JLabel("Profile");
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

        // LABELS
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

        // UPDATE BUTTON
        edit = new JButton("Update Profile");
        edit.setBounds(520, 470, 220, 45);
        edit.setBackground(PALATINATE);
        edit.setForeground(Color.WHITE);
        edit.setFont(new Font("Segoe UI", Font.BOLD, 16));
        edit.setFocusPainted(false);
        top.add(edit);

        // UPDATE PANEL
        uptpnl = new JPanel(null);
        uptpnl.setBounds(420, 100, 700, 560);
        uptpnl.setBackground(Color.WHITE);
        uptpnl.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        uptpnl.setVisible(false);
        add(uptpnl);

        uptitle = new JLabel("Update Profile");
        uptitle.setBounds(220, 25, 300, 40);
        uptitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        uptpnl.add(uptitle);
        
        upuname = new JLabel("Username:");
        upuname.setBounds(70, 100, 150, 30);
        upuname.setFont(labelFont);
        uptpnl.add(upuname);
        
        upname = new JLabel("Full Name:");
        upname.setBounds(70, 200, 150, 30);
        upname.setFont(labelFont);
        uptpnl.add(upname);
        
        upemail = new JLabel("Email:");
        upemail.setBounds(70, 300, 150, 30);
        upemail.setFont(labelFont);
        uptpnl.add(upemail);
        
        uppnum = new JLabel("Phone Number:");
        uppnum.setBounds(70, 400, 150, 30);
        uppnum.setFont(labelFont);
        uptpnl.add(uppnum);
        
        upgen = new JLabel("Gender:");
        upgen.setBounds(70, 500, 150, 30);
        upgen.setFont(labelFont);
        uptpnl.add(upgen);
        
        upbirth = new JLabel("Birth Date:");
        upbirth.setBounds(70, 600, 150, 30);
        upbirth.setFont(labelFont);
        uptpnl.add(upbirth);

        txtuser = new JTextField();
        txtuser.setBounds(240, 100, 350, 35);
        uptpnl.add(txtuser);

        txtname = new JTextField();
        txtname.setBounds(240, 160, 350, 35);
        uptpnl.add(txtname);

        txtemail = new JTextField();
        txtemail.setBounds(240, 220, 350, 35);
        uptpnl.add(txtemail);

        txtpnum = new JTextField();
        txtpnum.setBounds(240, 280, 350, 35);
        uptpnl.add(txtpnum);

        cmbgen = new JComboBox<>(gender);
        cmbgen.setBounds(240, 340, 180, 35);
        uptpnl.add(cmbgen);

        cmbmonth = new JComboBox<>(months);
        cmbmonth.setBounds(240, 400, 130, 35);
        uptpnl.add(cmbmonth);

        cmbday = new JComboBox<>(days);
        cmbday.setBounds(380, 400, 80, 35);
        uptpnl.add(cmbday);

        cmbyear = new JComboBox<>(years);
        cmbyear.setBounds(470, 400, 120, 35);
        uptpnl.add(cmbyear);
        
        save = new JButton("Save");
        save.setBounds(180, 470, 140, 45);
        save.setBackground(PALATINATE);
        save.setForeground(Color.WHITE);
        save.setFont(new Font("Segoe UI", Font.BOLD, 15));
        save.setFocusPainted(false);
        uptpnl.add(save);
        
        exit = new JButton("Close");
        exit.setBounds(380, 470, 140, 45);
        exit.setBackground(Color.DARK_GRAY);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Segoe UI", Font.BOLD, 15));
        exit.setFocusPainted(false);
        uptpnl.add(exit);
        
        edit.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == edit) {

            txtuser.setText(uname1.getText());
            txtname.setText(name1.getText());
            txtemail.setText(email1.getText());
            txtpnum.setText(pnum1.getText());

            uptpnl.setVisible(true);
            top.setVisible(false);

        } else if (e.getSource() == exit) {

            uptpnl.setVisible(false);
            top.setVisible(true);

        } else if (e.getSource() == save) {

            String bday = cmbmonth.getSelectedItem()+" "+cmbday.getSelectedItem()+", "+ cmbyear.getSelectedItem();
            
            uname1.setText(txtuser.getText());
            name1.setText(txtname.getText());
            email1.setText(txtemail.getText());
            pnum1.setText(txtpnum.getText());
            gen1.setText((String) cmbgen.getSelectedItem());
            birth1.setText(bday);
            uptpnl.setVisible(false);
            top.setVisible(true);
        }
    }
}