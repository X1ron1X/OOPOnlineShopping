package Settings;

import Dbcon.DBConnection;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class profile extends JPanel implements ActionListener {

    private JPanel top;
    private JLabel title;

    private JLabel uname1, name1, email1, pnum1, gen1, birth1;

    private final Integer[] years = new Integer[97];
    private final Integer[] days = new Integer[31];

    private int userId;

    public profile(int userId) {
        Font labelFont = new Font("Segoe UI", Font.BOLD, 17);
        this.userId = userId;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
    
}