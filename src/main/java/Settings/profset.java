package Settings;

import Dbcon.DBConnection;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class profset extends JPanel implements ActionListener {

    private JPanel top, uptpnl;
    private JLabel title;

    private JLabel uname1, name1, email1, pnum1, gen1, birth1;

    private JTextField txtuser, txtname, txtemail, txtpnum;
    private JButton save, edit, exit;

    private JComboBox<Integer> cmbday, cmbyear;
    private JComboBox<String> cmbgen, cmbmonth;

    private final String[] months = {
        "January","February","March","April","May","June",
        "July","August","September","October","November","December"
    };

    private final String[] gender = {"Male","Female","Other"};

    private final Integer[] years = new Integer[97];
    private final Integer[] days = new Integer[31];

    private int userId;

    public profset(int userId) {
        Font labelFont = new Font("Segoe UI", Font.BOLD, 17);
        this.userId = userId;

        for (int i = 0; i < 97; i++) years[i] = 1911 + i;
        for (int i = 0; i < 31; i++) days[i] = i + 1;

        setLayout(null);
        setBackground(new Color(245,245,245));
        setBounds(0,0,1550,790);

        Color PALATINATE = Color.decode("#FFBF00");

        title = new JLabel("Profile");
        title.setBounds(80,30,300,40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        add(title);

        top = new JPanel(null);
        top.setBounds(80,90,1300,550);
        top.setBackground(Color.WHITE);
        top.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        add(top);

        int labelX = 220, valueX = 500, startY = 80, gap = 65;

        JLabel uname = new JLabel("Username:");
        uname.setBounds(labelX,startY,200,30);
        uname.setFont(labelFont);
        top.add(uname);

        JLabel name = new JLabel("Full Name:");
        name.setBounds(labelX,startY+gap,200,30);
        name.setFont(labelFont);
        top.add(name);

        JLabel email = new JLabel("Email:");
        email.setBounds(labelX,startY+gap*2,200,30);
        email.setFont(labelFont);
        top.add(email);

        JLabel pnum = new JLabel("Phone:");
        pnum.setBounds(labelX,startY+gap*3,200,30);
        pnum.setFont(labelFont);
        top.add(pnum);

        JLabel gen = new JLabel("Gender:");
        gen.setBounds(labelX,startY+gap*4,200,30);
        gen.setFont(labelFont);
        top.add(gen);

        JLabel birth = new JLabel("Birth Date:");
        birth.setBounds(labelX,startY+gap*5,200,30);
        birth.setFont(labelFont);
        top.add(birth);

        uname1 = new JLabel();
        name1 = new JLabel();
        email1 = new JLabel();
        pnum1 = new JLabel();
        gen1 = new JLabel();
        birth1 = new JLabel();

        uname1.setBounds(valueX,startY,400,30);
        name1.setBounds(valueX,startY+gap,400,30);
        email1.setBounds(valueX,startY+gap*2,400,30);
        pnum1.setBounds(valueX,startY+gap*3,400,30);
        gen1.setBounds(valueX,startY+gap*4,400,30);
        birth1.setBounds(valueX,startY+gap*5,400,30);

        top.add(uname1);
        top.add(name1);
        top.add(email1);
        top.add(pnum1);
        top.add(gen1);
        top.add(birth1);

        edit = new JButton("Update Profile");
        edit.setBounds(520,470,220,45);
        edit.setBackground(PALATINATE);
        edit.setForeground(Color.WHITE);
        top.add(edit);

        // EDIT PANEL
        uptpnl = new JPanel(null);
        uptpnl.setBounds(420,100,700,560);
        uptpnl.setBackground(Color.WHITE);
        uptpnl.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        uptpnl.setVisible(false);
        add(uptpnl);

        JLabel uptitle = new JLabel("Update Profile");
        uptitle.setBounds(220,25,300,40);
        uptitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        uptpnl.add(uptitle);

        txtuser = new JTextField();
        txtname = new JTextField();
        txtemail = new JTextField();
        txtpnum = new JTextField();

        txtuser.setBounds(240,100,350,35);
        txtname.setBounds(240,160,350,35);
        txtemail.setBounds(240,220,350,35);
        txtpnum.setBounds(240,280,350,35);

        uptpnl.add(txtuser);
        uptpnl.add(txtname);
        uptpnl.add(txtemail);
        uptpnl.add(txtpnum);

        cmbgen = new JComboBox<>(gender);
        cmbgen.setBounds(240,340,180,35);
        uptpnl.add(cmbgen);

        cmbmonth = new JComboBox<>(months);
        cmbmonth.setBounds(240,400,130,35);
        uptpnl.add(cmbmonth);

        cmbday = new JComboBox<>(days);
        cmbday.setBounds(380,400,80,35);
        uptpnl.add(cmbday);

        cmbyear = new JComboBox<>(years);
        cmbyear.setBounds(470,400,120,35);
        uptpnl.add(cmbyear);

        save = new JButton("Save");
        exit = new JButton("Close");

        save.setBounds(180,470,140,45);
        exit.setBounds(380,470,140,45);

        save.setBackground(PALATINATE);
        save.setForeground(Color.WHITE);
        exit.setBackground(Color.DARK_GRAY);
        exit.setForeground(Color.WHITE);

        uptpnl.add(save);
        uptpnl.add(exit);

        edit.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);

        loadProfile(); // 🔥 IMPORTANT
    }

    // ================= LOAD PROFILE =================
    private void loadProfile() {
        try (Connection con = DBConnection.getConnection()) {
            Font valueFont = new Font("Segoe UI", Font.PLAIN, 17);

            String sql = "SELECT * FROM users WHERE user_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                uname1.setText(rs.getString("username"));
                name1.setText(rs.getString("fname"));
                email1.setText(rs.getString("email"));
                pnum1.setText(rs.getString("pnum"));
                gen1.setText(rs.getString("gender"));
                birth1.setText(rs.getString("bdates"));
                
                uname1.setFont(valueFont);
                name1.setFont(valueFont);
                email1.setFont(valueFont);
                pnum1.setFont(valueFont);
                gen1.setFont(valueFont);
                birth1.setFont(valueFont);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // ================= UPDATE PROFILE =================
    private void updateProfile() {

        String birth = cmbmonth.getSelectedItem() + " "
                + cmbday.getSelectedItem() + ", "
                + cmbyear.getSelectedItem();

        try (Connection con = DBConnection.getConnection()) {

            String sql =
                "UPDATE users SET username=?, fname=?, email=?, pnum=?, gender=?, bdates=? WHERE user_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, txtuser.getText());
            ps.setString(2, txtname.getText());
            ps.setString(3, txtemail.getText());
            ps.setString(4, txtpnum.getText());
            ps.setString(5, (String) cmbgen.getSelectedItem());
            ps.setString(6, birth);
            ps.setInt(7, userId);

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        loadProfile();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == edit) {

            txtuser.setText(uname1.getText());
            txtname.setText(name1.getText());
            txtemail.setText(email1.getText());
            txtpnum.setText(pnum1.getText());

            top.setVisible(false);
            uptpnl.setVisible(true);

        } else if (e.getSource() == exit) {

            uptpnl.setVisible(false);
            top.setVisible(true);

        } else if (e.getSource() == save) {

            updateProfile();

            uptpnl.setVisible(false);
            top.setVisible(true);
        }
    }
}