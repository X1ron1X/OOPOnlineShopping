package LogReg;

import Dbcon.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register extends JPanel {


private JTextField txtFirstName, txtMiddleName, txtLastName;
private JTextField txtUsername, txtEmail, txtMobile;
private JPasswordField txtPassword, txtConfirmPassword;

public Register(MainFrame frame) {

    setLayout(null);
    setSize(450,750);
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
    JButton btnBack = new JButton("<-");

    btnBack.setBounds(10,15,50,35);
    btnBack.setBackground(new Color(255,193,7));
    btnBack.setForeground(Color.BLACK);
    btnBack.setFont(new Font("Arial",Font.BOLD,18));
    btnBack.setFocusPainted(false);
    btnBack.addActionListener(e -> frame.showLogin());
    
    header.add(btnBack);
    add(header);

    JLabel title = new JLabel("CREATE ACCOUNT");
    title.setBounds(90,90,300,35);
    title.setFont(new Font("Arial",Font.BOLD,24));
    title.setForeground(Color.BLACK);


    Font lblFont = new Font("Arial",Font.BOLD,13);

    JLabel lblFirst = new JLabel("First Name");
    lblFirst.setBounds(50,140,100,20);
    lblFirst.setFont(lblFont);
    lblFirst.setForeground(Color.BLACK);

    txtFirstName = new JTextField();
    txtFirstName.setBounds(50,160,90,30);
    txtFirstName.setBackground(new Color(255,248,220));
    txtFirstName.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

    JLabel lblMiddle = new JLabel("Middle Name");
    lblMiddle.setBounds(150,140,100,20);
    lblMiddle.setFont(lblFont);
    lblMiddle.setForeground(Color.BLACK);

    txtMiddleName = new JTextField();
    txtMiddleName.setBounds(150,160,90,30);
    txtMiddleName.setBackground(new Color(255,248,220));
    txtMiddleName.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

    JLabel lblLast = new JLabel("Last Name");
    lblLast.setBounds(250,140,100,20);
    lblLast.setFont(lblFont);
    lblLast.setForeground(Color.BLACK);

    txtLastName = new JTextField();
    txtLastName.setBounds(250,160,100,30);
    txtLastName.setBackground(new Color(255,248,220));
    txtLastName.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

    JLabel lblUsername = new JLabel("Username");
    lblUsername.setBounds(50,205,150,20);
    lblUsername.setFont(lblFont);
    lblUsername.setForeground(Color.BLACK);

    txtUsername = new JTextField();
    txtUsername.setBounds(50,225,300,30);
    txtUsername.setBackground(new Color(255,248,220));
    txtUsername.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

    JLabel lblEmail = new JLabel("Email Address");
    lblEmail.setBounds(50,270,150,20);
    lblEmail.setFont(lblFont);
    lblEmail.setForeground(Color.BLACK);

    txtEmail = new JTextField();
    txtEmail.setBounds(50,290,300,30);
    txtEmail.setBackground(new Color(255,248,220));
    txtEmail.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

    JLabel lblMobile = new JLabel("Mobile Number");
    lblMobile.setBounds(50,335,150,20);
    lblMobile.setFont(lblFont);
    lblMobile.setForeground(Color.BLACK);

    txtMobile = new JTextField();
    txtMobile.setBounds(50,355,300,30);
    txtMobile.setBackground(new Color(255,248,220));
    txtMobile.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

    add(lblFirst);
    add(txtFirstName);
    add(title);
    add(lblMiddle);
    add(txtMiddleName);
    add(lblLast);
    add(txtLastName);
    add(lblUsername);
    add(txtUsername);
    add(lblEmail);
    add(txtEmail);
    add(lblMobile);
    add(txtMobile);

    JLabel lblBirthdate = new JLabel("Birthdate");
    lblBirthdate.setBounds(50,400,150,20);
    lblBirthdate.setFont(lblFont);
    lblBirthdate.setForeground(Color.BLACK);

    String[] months = {
        "Jan","Feb","Mar","Apr","May","Jun",
        "Jul","Aug","Sep","Oct","Nov","Dec"
    };

    String[] days = new String[31];
    for(int i=0;i<31;i++){
        days[i]=String.valueOf(i+1);
    }

    String[] years = new String[50];
    int y = 2025;

    for(int i=0;i<50;i++){
        years[i]=String.valueOf(y-i);
    }

    JComboBox<String> cmbMonth = new JComboBox<>(months);
    JComboBox<String> cmbDay = new JComboBox<>(days);
    JComboBox<String> cmbYear = new JComboBox<>(years);

    cmbMonth.setBounds(50,420,100,30);
    cmbDay.setBounds(160,420,60,30);
    cmbYear.setBounds(230,420,120,30);

    cmbMonth.setBackground(new Color(255,248,220));
    cmbDay.setBackground(new Color(255,248,220));
    cmbYear.setBackground(new Color(255,248,220));

    JLabel lblGender = new JLabel("Gender");
    lblGender.setBounds(50,460,150,20);
    lblGender.setFont(lblFont);
    lblGender.setForeground(Color.BLACK);

    String[] gender = {"Male","Female","Other"};

    JComboBox<String> cmbGender =
            new JComboBox<>(gender);

    cmbGender.setBounds(50,480,300,30);
    cmbGender.setBackground(new Color(255,248,220));

    JLabel lblPass = new JLabel("Password");
    lblPass.setBounds(50,520,150,20);
    lblPass.setFont(lblFont);
    lblPass.setForeground(Color.BLACK);

    txtPassword = new JPasswordField();
    txtPassword.setBounds(50,540,300,30);
    txtPassword.setBackground(new Color(255,248,220));
    txtPassword.setBorder(
            BorderFactory.createLineBorder(Color.BLACK,2));

    JLabel lblConfirm = new JLabel("Confirm Password");
    lblConfirm.setBounds(50,580,150,20);
    lblConfirm.setFont(lblFont);
    lblConfirm.setForeground(Color.BLACK);

    txtConfirmPassword = new JPasswordField();
    txtConfirmPassword.setBounds(50,600,300,30);
    txtConfirmPassword.setBackground(new Color(255,248,220));
    txtConfirmPassword.setBorder(
            BorderFactory.createLineBorder(Color.BLACK,2));

    JCheckBox showPass = new JCheckBox("Show Password");
    showPass.setBounds(50,635,150,20);
    showPass.setBackground(new Color(255,193,7));

    showPass.addActionListener(e->{

        if(showPass.isSelected()){

            txtPassword.setEchoChar((char)0);
            txtConfirmPassword.setEchoChar((char)0);

        }else{

            txtPassword.setEchoChar('*');
            txtConfirmPassword.setEchoChar('*');

        }

    });

    JButton btnCreate = new JButton("CREATE ACCOUNT");
    btnCreate.setBounds(100,670,220,40);
    btnCreate.setBackground(Color.BLACK);
    btnCreate.setForeground(new Color(255,193,7));
    btnCreate.setFont(new Font("Arial",Font.BOLD,15));
    btnCreate.setFocusPainted(false);

    btnCreate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = txtFirstName.getText().trim();
            String middleName = txtMiddleName.getText().trim();
            String lastName = txtLastName.getText().trim();
            String username = txtUsername.getText().trim();
            String email = txtEmail.getText().trim();
            String mobile = txtMobile.getText().trim();
            String gender = cmbGender.getSelectedItem().toString();
            String password = new String(txtPassword.getPassword());
            String confirmPassword = new String(txtConfirmPassword.getPassword());
            if (firstName.isEmpty() ||
                    lastName.isEmpty() ||
                    username.isEmpty() ||
                    email.isEmpty() ||
                    mobile.isEmpty() ||
                    password.isEmpty() ||
                    confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(Register.this, "Please fill in all required fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(Register.this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String birthdate =
                    cmbMonth.getSelectedItem()+" "+
                    cmbDay.getSelectedItem()+", "+
                    cmbYear.getSelectedItem();
            String fullname =
                    firstName+" "+
                    middleName+" "+
                    lastName;
            try {
                Connection conn = DBConnection.getConnection();
                PreparedStatement check =
                        conn.prepareStatement(
                                "SELECT * FROM users WHERE username=?");
                check.setString(1, username);
                ResultSet rs = check.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(Register.this, "Username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                PreparedStatement pst =
                        conn.prepareStatement(
                                "INSERT INTO users(username,fname,email,password,pnum,gender,bdates) VALUES(?,?,?,?,?,?,?)");
                pst.setString(1, username);
                pst.setString(2, fullname);
                pst.setString(3, email);
                pst.setString(4, password);
                pst.setString(5, mobile);
                pst.setString(6, gender);
                pst.setString(7, birthdate);
                int row = pst.executeUpdate();
                if (row > 0) {
                    JOptionPane.showMessageDialog(Register.this, "Account Created Successfully!");
                    txtFirstName.setText("");
                    txtMiddleName.setText("");
                    txtLastName.setText("");
                    txtUsername.setText("");
                    txtEmail.setText("");
                    txtMobile.setText("");
                    txtPassword.setText("");
                    txtConfirmPassword.setText("");
                    cmbGender.setSelectedIndex(0);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(Register.this, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
    JButton btnLogin = new JButton("LOGIN");
    btnLogin.setBounds(100,725,220,40);
    btnLogin.setBackground(new Color(255,193,7));
    btnLogin.setForeground(Color.BLACK);
    btnLogin.setBorder(
            BorderFactory.createLineBorder(Color.BLACK,2));
    btnLogin.setFont(new Font("Arial",Font.BOLD,15));

    btnLogin.addActionListener(e->frame.showLogin());

    JPanel footer = new JPanel();
    footer.setBackground(Color.BLACK);
    footer.setBounds(0,790,450,35);

    JLabel foot =
            new JLabel("© BumbleBee Online Shopping");

    foot.setForeground(new Color(255,193,7));
    foot.setFont(new Font("Arial",Font.BOLD,12));

    footer.add(foot);

    add(lblBirthdate);
    add(cmbMonth);
    add(cmbDay);
    add(cmbYear);
    add(header);
    add(lblGender);
    add(cmbGender);
    add(lblPass);
    add(txtPassword);
    add(lblConfirm);
    add(txtConfirmPassword);
    add(showPass);
    add(btnCreate);
    add(btnLogin);

    add(footer);

}

}

