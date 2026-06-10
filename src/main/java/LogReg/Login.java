package LogReg;

import Dbcon.DBConnection;
//import com.mycompany.ooponlineshopping.Header;
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
        setBackground(new Color(255,193,7));

        JPanel header = new JPanel();
        header.setLayout(null);
        header.setBackground(Color.BLACK);
        header.setBounds(0,0,450,70);

        JLabel logo = new JLabel("🐝 BumbleBee Shop");
        logo.setForeground(new Color(255,193,7));
        logo.setFont(new Font("Arial",Font.BOLD,24));
        logo.setBounds(75,18,300,30);

        header.add(logo);

        add(header);

        JLabel title = new JLabel("LOGIN");

        title.setBounds(170,90,200,35);
        title.setFont(new Font("Arial",Font.BOLD,28));
        title.setForeground(Color.BLACK);

        add(title);

        Font lblFont = new Font("Arial",Font.BOLD,14);

        JLabel users = new JLabel("Username");

        users.setBounds(50,170,150,20);
        users.setFont(lblFont);
        users.setForeground(Color.BLACK);

        JTextField username = new JTextField();

        username.setBounds(50,195,300,35);
        username.setBackground(new Color(255,248,220));
        username.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        JLabel passw = new JLabel("Password");

        passw.setBounds(50,250,150,20);
        passw.setFont(lblFont);
        passw.setForeground(Color.BLACK);

        JPasswordField password = new JPasswordField();

        password.setBounds(50,275,300,35);
        password.setBackground(new Color(255,248,220));
        password.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        JCheckBox showPass = new JCheckBox("Show Password");

        showPass.setBounds(50,320,150,20);
        showPass.setBackground(new Color(255,193,7));

        showPass.addActionListener(e -> {

            if(showPass.isSelected()){

                password.setEchoChar((char)0);

            }else{

                password.setEchoChar('*');

            }

        });

        
                JButton loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(100,370,220,40);
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setForeground(new Color(255,193,7));
        loginBtn.setFont(new Font("Arial",Font.BOLD,15));
        loginBtn.setFocusPainted(false);

        JButton forgotBtn = new JButton("Forgot Password?");
        forgotBtn.setBounds(115,420,190,25);
        forgotBtn.setForeground(Color.BLACK);
        forgotBtn.setFont(new Font("Arial",Font.BOLD,12));
        forgotBtn.setBorderPainted(false);
        forgotBtn.setContentAreaFilled(false);
        forgotBtn.setFocusPainted(false);

        JButton createBtn = new JButton("CREATE ACCOUNT");
        createBtn.setBounds(100,470,220,40);
        createBtn.setBackground(new Color(255,193,7));
        createBtn.setForeground(Color.BLACK);
        createBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        createBtn.setFont(new Font("Arial",Font.BOLD,15));
        createBtn.setFocusPainted(false);

        loginBtn.addActionListener(e -> {

            String user = username.getText().trim();
            String pass = new String(password.getPassword());

            if(user.isEmpty() || pass.isEmpty()){

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter username and password."
                );

                return;

            }

            try(

                Connection conn = DBConnection.getConnection();

                PreparedStatement pst = conn.prepareStatement(
                        "SELECT user_id FROM users WHERE username=? AND password=?"
                );

            ){

                pst.setString(1,user);
                pst.setString(2,pass);

                ResultSet rs = pst.executeQuery();

                if(rs.next()){

                    loggedInUserId = rs.getInt("user_id");

                    JOptionPane.showMessageDialog(
                            this,
                            "Login Successful!"
                    );

                    Header h = new Header(loggedInUserId);
                    h.setVisible(true);

                    Window window = SwingUtilities.getWindowAncestor(this);

                    if(window!=null){

                        window.dispose();

                    }

                }

                else{

                    JOptionPane.showMessageDialog(
                            this,
                            "Invalid Username or Password!"
                    );

                }

            }

            catch(Exception ex){

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Database Error : "+ex.getMessage()
                );

            }

        });

        forgotBtn.addActionListener(e -> {

            String uname = JOptionPane.showInputDialog(
                    this,
                    "Enter Username"
            );

            if(uname==null || uname.trim().isEmpty()) return;

            String email = JOptionPane.showInputDialog(
                    this,
                    "Enter Email"
            );

            if(email==null || email.trim().isEmpty()) return;

            JPasswordField pf = new JPasswordField();

            int option = JOptionPane.showConfirmDialog(
                    this,
                    pf,
                    "New Password",
                    JOptionPane.OK_CANCEL_OPTION
            );

            if(option!=JOptionPane.OK_OPTION) return;

            String newPass = new String(pf.getPassword());

            try(

                Connection conn = DBConnection.getConnection();

                PreparedStatement pst = conn.prepareStatement(
                        "UPDATE users SET password=? WHERE username=? AND email=?"
                );

            ){

                pst.setString(1,newPass);
                pst.setString(2,uname);
                pst.setString(3,email);

                int rows = pst.executeUpdate();

                if(rows>0){

                    JOptionPane.showMessageDialog(
                            this,
                            "Password Updated Successfully!"
                    );

                }

                else{

                    JOptionPane.showMessageDialog(
                            this,
                            "Username or Email not found!"
                    );

                }

            }

            catch(Exception ex){

                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage()
                );

            }

        });

        createBtn.addActionListener(e -> frame.showRegister());

        JPanel footer = new JPanel();
        footer.setBackground(Color.BLACK);
        footer.setBounds(0,560,450,35);

        JLabel foot = new JLabel("© BumbleBee Online Shopping");
        foot.setForeground(new Color(255,193,7));
        foot.setFont(new Font("Arial",Font.BOLD,12));

        footer.add(foot);
        
        add(users);
        add(username);
        add(passw);
        add(password);
        add(showPass);
        add(loginBtn);
        add(forgotBtn);
        add(createBtn);
        add(footer);

    }

}