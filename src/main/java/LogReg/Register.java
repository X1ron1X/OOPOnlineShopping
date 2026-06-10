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
        setBackground(Color.WHITE);

        JLabel title = new JLabel("CREATE ACCOUNT");
        title.setBounds(130, 20, 250, 30);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel lblFirst = new JLabel("First Name");
        lblFirst.setBounds(50, 60, 100, 20);

        txtFirstName = new JTextField();
        txtFirstName.setBounds(50, 80, 90, 30);

        JLabel lblMiddle = new JLabel("Middle Name");
        lblMiddle.setBounds(150, 60, 100, 20);

        txtMiddleName = new JTextField();
        txtMiddleName.setBounds(150, 80, 90, 30);

        JLabel lblLast = new JLabel("Last Name");
        lblLast.setBounds(250, 60, 100, 20);

        txtLastName = new JTextField();
        txtLastName.setBounds(250, 80, 100, 30);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(50, 120, 200, 20);

        txtUsername = new JTextField();
        txtUsername.setBounds(50, 140, 300, 30);

        JLabel lblEmail = new JLabel("Email / Gmail");
        lblEmail.setBounds(50, 180, 200, 20);

        txtEmail = new JTextField();
        txtEmail.setBounds(50, 200, 300, 30);

        JLabel lblMobile = new JLabel("Mobile Number");
        lblMobile.setBounds(50, 240, 200, 20);

        txtMobile = new JTextField();
        txtMobile.setBounds(50, 260, 300, 30);

        JLabel lblBirthdate = new JLabel("Birthdate");
        lblBirthdate.setBounds(50, 300, 200, 20);

        String[] months = {
            "Jan","Feb","Mar","Apr","May","Jun",
            "Jul","Aug","Sep","Oct","Nov","Dec"
        };
        
        String[] gen = {
            "Male", "Female", "Other"
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
        JComboBox<String> cmbgen = new JComboBox<>(gen);

        cmbMonth.setBounds(50, 320, 100, 30);
        cmbDay.setBounds(160, 320, 60, 30);
        cmbYear.setBounds(230, 320, 120, 30);
        
        JLabel lblgen = new JLabel("Gender");
        lblgen.setBounds(50, 360, 200, 20);
        cmbgen.setBounds(50, 380, 300, 30);

        JLabel lblPass = new JLabel("Password");
        lblPass.setBounds(50, 420, 200, 20);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(50, 440, 300, 30);

        JLabel lblConfirm = new JLabel("Confirm Password");
        lblConfirm.setBounds(50, 480, 200, 20);

        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setBounds(50, 500, 300, 30);

        JButton btnCreate = new JButton("CREATE ACCOUNT");
        btnCreate.setBounds(100, 550, 200, 35);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(100, 600, 200, 35);  

        btnCreate.addActionListener(e -> {

            String firstName = txtFirstName.getText().trim();
            String middleName = txtMiddleName.getText().trim();
            String lastName = txtLastName.getText().trim();
            String username = txtUsername.getText().trim();
            String email = txtEmail.getText().trim();
            String mobile = txtMobile.getText().trim();
            String gender = cmbgen.getSelectedItem().toString();

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
                    cmbgen.setSelectedIndex(0);
                }

            } catch (Exception ex) {

                ex.printStackTrace();

                JOptionPane.showMessageDialog(
                        this,
                        "Database Error: " + ex.getMessage()
                );
            }
        });

        btnLogin.addActionListener(e -> frame.showLogin());

        add(title);

        add(lblFirst);
        add(txtFirstName);

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

        add(lblBirthdate);
        add(cmbMonth);
        add(cmbDay);
        add(cmbYear);
        
        add(lblgen);
        add(cmbgen);

        add(lblPass);
        add(txtPassword);

        add(lblConfirm);
        add(txtConfirmPassword);

        add(btnCreate);
        add(btnLogin);
    }
}