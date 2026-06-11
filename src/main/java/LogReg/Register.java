package LogReg;

import Dbcon.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register extends JPanel {

    private JTextField txtFirstName, txtMiddleName, txtLastName;
    private JTextField txtUsername, txtEmail, txtMobile;
    private JPasswordField txtPassword, txtConfirmPassword;

    public Register(MainFrame frame) {

        setLayout(null);
        setBackground(new Color(245, 245, 245));

        // ================= CARD PANEL =================
        JPanel cardPanel = new JPanel(null);
        cardPanel.setBounds(225, 40, 650, 725);
        cardPanel.setBackground(Color.WHITE);
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        add(cardPanel);

        // ================= TITLE =================
        JLabel title = new JLabel("CREATE ACCOUNT");
        title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        title.setBounds(220, 20, 300, 40);
        cardPanel.add(title);

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);

        // ================= NAME =================
        JLabel lblFirst = new JLabel("First Name");
        lblFirst.setFont(labelFont);
        lblFirst.setBounds(80, 80, 150, 20);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(80, 100, 150, 35);

        JLabel lblMiddle = new JLabel("Middle Name");
        lblMiddle.setFont(labelFont);
        lblMiddle.setBounds(260, 80, 150, 20);

        txtMiddleName = new JTextField();
        txtMiddleName.setBounds(260, 100, 150, 35);

        JLabel lblLast = new JLabel("Last Name");
        lblLast.setFont(labelFont);
        lblLast.setBounds(440, 80, 150, 20);

        txtLastName = new JTextField();
        txtLastName.setBounds(440, 100, 150, 35);

        // ================= USERNAME =================
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(labelFont);
        lblUsername.setBounds(80, 150, 200, 20);

        txtUsername = new JTextField();
        txtUsername.setBounds(80, 170, 510, 35);

        // ================= EMAIL =================
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(labelFont);
        lblEmail.setBounds(80, 220, 200, 20);

        txtEmail = new JTextField();
        txtEmail.setBounds(80, 240, 510, 35);

        // ================= MOBILE =================
        JLabel lblMobile = new JLabel("Mobile Number");
        lblMobile.setFont(labelFont);
        lblMobile.setBounds(80, 290, 200, 20);

        txtMobile = new JTextField();
        txtMobile.setBounds(80, 310, 510, 35);

        // ================= BIRTHDATE =================
        JLabel lblBirth = new JLabel("Birthdate");
        lblBirth.setFont(labelFont);
        lblBirth.setBounds(80, 360, 200, 20);

        String[] months = {
                "Jan","Feb","Mar","Apr","May","Jun",
                "Jul","Aug","Sep","Oct","Nov","Dec"
        };

        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }

        String[] years = new String[50];
        int y = 2025;
        for (int i = 0; i < 50; i++) {
            years[i] = String.valueOf(y - i);
        }

        JComboBox<String> cmbMonth = new JComboBox<>(months);
        JComboBox<String> cmbDay = new JComboBox<>(days);
        JComboBox<String> cmbYear = new JComboBox<>(years);

        cmbMonth.setBounds(80, 380, 120, 35);
        cmbDay.setBounds(210, 380, 80, 35);
        cmbYear.setBounds(300, 380, 120, 35);

        // ================= GENDER =================
        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(labelFont);
        lblGender.setBounds(80, 430, 200, 20);

        String[] genderList = {"Male", "Female", "Other"};
        JComboBox<String> cmbGender = new JComboBox<>(genderList);
        cmbGender.setBounds(80, 450, 510, 35);

        // ================= PASSWORD =================
        JLabel lblPass = new JLabel("Password");
        lblPass.setFont(labelFont);
        lblPass.setBounds(80, 500, 200, 20);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(80, 520, 510, 35);

        JLabel lblConfirm = new JLabel("Confirm Password");
        lblConfirm.setFont(labelFont);
        lblConfirm.setBounds(80, 570, 200, 20);

        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setBounds(80, 590, 510, 35);

        // ================= BUTTONS =================
        JButton btnCreate = new JButton("CREATE ACCOUNT");
        btnCreate.setBounds(180, 650, 160, 40);
        btnCreate.setBackground(new Color(255, 191, 0));
        btnCreate.setForeground(Color.WHITE);
        btnCreate.setFocusPainted(false);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(360, 650, 160, 40);
        btnLogin.setBackground(Color.GRAY);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);

        // ================= ADD COMPONENTS =================
        cardPanel.add(lblFirst);
        cardPanel.add(txtFirstName);

        cardPanel.add(lblMiddle);
        cardPanel.add(txtMiddleName);

        cardPanel.add(lblLast);
        cardPanel.add(txtLastName);

        cardPanel.add(lblUsername);
        cardPanel.add(txtUsername);

        cardPanel.add(lblEmail);
        cardPanel.add(txtEmail);

        cardPanel.add(lblMobile);
        cardPanel.add(txtMobile);

        cardPanel.add(lblBirth);
        cardPanel.add(cmbMonth);
        cardPanel.add(cmbDay);
        cardPanel.add(cmbYear);

        cardPanel.add(lblGender);
        cardPanel.add(cmbGender);

        cardPanel.add(lblPass);
        cardPanel.add(txtPassword);

        cardPanel.add(lblConfirm);
        cardPanel.add(txtConfirmPassword);

        cardPanel.add(btnCreate);
        cardPanel.add(btnLogin);

        // ================= LOGIN ACTION =================
        btnLogin.addActionListener(e -> frame.showLogin());

        // NOTE: your DB logic stays the same
        btnCreate.addActionListener(e -> {
            String firstName = txtFirstName.getText().trim();



            String middleName = txtMiddleName.getText().trim();



            String lastName = txtLastName.getText().trim();



            String username = txtUsername.getText().trim();



            String email = txtEmail.getText().trim();



            String mobile = txtMobile.getText().trim();



            String gender = cmbGender.getSelectedItem().toString();







            String password = new String(txtPassword.getPassword());



            String confirmPassword =



                    new String(txtConfirmPassword.getPassword());







            if (firstName.isEmpty() ||



                lastName.isEmpty() ||



                username.isEmpty() ||



                email.isEmpty() ||



                mobile.isEmpty() ||



                password.isEmpty() ||



                confirmPassword.isEmpty()) {







                JOptionPane.showMessageDialog(



                        this,



                        "Please fill in all required fields.",



                        "Error!!!",



                        JOptionPane.ERROR_MESSAGE);



                return;



            }







            if (!password.equals(confirmPassword)) {



                JOptionPane.showMessageDialog(



                        this,



                        "Passwords do not match!",



                        "Error!!!",



                        JOptionPane.ERROR_MESSAGE);



                return;



            }







            String birthdate =



                    cmbMonth.getSelectedItem() + " " +



                    cmbDay.getSelectedItem() + ", " +



                    cmbYear.getSelectedItem();







            String fullName =



                    firstName + " " +



                    middleName + " " +



                    lastName;







            try (



                Connection conn = DBConnection.getConnection();



                PreparedStatement checkUser =



                        conn.prepareStatement(



                                "SELECT username FROM users WHERE username=?")



            ) {







                checkUser.setString(1, username);







                ResultSet rs = checkUser.executeQuery();







                if (rs.next()) {



                    JOptionPane.showMessageDialog(



                            this,



                            "Username already exists!",



                            "Error!!!",



                            JOptionPane.ERROR_MESSAGE



                    );



                    return;



                }







            } catch (Exception ex) {



                ex.printStackTrace();



                JOptionPane.showMessageDialog(



                        this,



                        "Database Error: " + ex.getMessage()



                );



                return;



            }







            try (



                Connection conn = DBConnection.getConnection();



                PreparedStatement pst = conn.prepareStatement(



                        "INSERT INTO users " +



                        "(username, fname, email, password, pnum, gender, bdates) " +



                        "VALUES (?, ?, ?, ?, ?, ?, ?)")



            ) {







                pst.setString(1, username);



                pst.setString(2, fullName);



                pst.setString(3, email);



                pst.setString(4, password);



                pst.setString(5, mobile);



                pst.setString(6, gender);



                pst.setString(7, birthdate);







                int rows = pst.executeUpdate();







                if (rows > 0) {







                    JOptionPane.showMessageDialog(



                            this,



                            "Account created successfully!"



                    );







                    System.out.println("===== NEW ACCOUNT =====");



                    System.out.println("Name: " + fullName);



                    System.out.println("Username: " + username);



                    System.out.println("Email: " + email);



                    System.out.println("Mobile: " + mobile);



                    System.out.println("Birthdate: " + birthdate);



                    System.out.println("=======================");







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







                ex.printStackTrace();







                JOptionPane.showMessageDialog(



                        this,



                        "Database Error: " + ex.getMessage()



                );



            }
        });
    }
}