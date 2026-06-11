package Settings;

import Dbcon.DBConnection;
import LogReg.MainFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Ron
 */

//This class is for deleting the account but since i don't have access to log in page yet it doesnt serve its purpose yet

public class DeleteAccount extends JPanel implements ActionListener {

    private JPanel top;
    private JLabel title;
    private JLabel uname, uname1, name, name1, email, email1;
    private JLabel pnum, pnum1, gen, gen1, birth, birth1;
    private JButton delete;
    private int userId;
    
    DeleteAccount(int userId) {
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
        
        delete = new JButton("Delete Profile");
        delete.setBounds(520,470,220,45);
        delete.setBackground(PALATINATE);
        delete.setForeground(Color.WHITE);
        top.add(delete);
        
        delete.addActionListener(this);
        loadProfile();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == delete){
            deleteAccount(userId);
            Window window = SwingUtilities.getWindowAncestor(this);
            window.dispose();
            MainFrame h = new MainFrame();
            h.setVisible(true);
        }
    }
    
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
    
    public static void deleteAccount(int userId) {

            try {
                Connection conn = DBConnection.getConnection();

                String sql = "DELETE FROM users WHERE user_id=?";

                PreparedStatement pst = conn.prepareStatement(sql);

                pst.setInt(1, userId);

                pst.executeUpdate();

                conn.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    
}