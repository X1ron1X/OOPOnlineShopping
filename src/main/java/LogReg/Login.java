import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {

    private MainFrame frame;

    public Login(MainFrame frame) {
        this.frame = frame;

        setLayout(null);
        setBackground(Color.WHITE);
        
        JLabel users = new JLabel("Username");
        users.setBounds(25, 150, 250, 35);
        
        JLabel passw = new JLabel("Password");
        passw.setBounds(25, 200, 250, 35);
        
        JLabel title = new JLabel("LOGIN");
        title.setBounds(180, 80, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JTextField username = new JTextField();
        username.setBounds(100, 150, 250, 35);

        JPasswordField password = new JPasswordField();
        password.setBounds(100, 210, 250, 35);

        JButton loginBtn = new JButton("LOGIN");
        loginBtn.setBounds(150, 270, 150, 35);

        JButton createBtn = new JButton("CREATE ACCOUNT");
        createBtn.setBounds(120, 330, 200, 35);

        loginBtn.addActionListener(e -> {
            String user = username.getText();
            String pass = new String(password.getPassword());

            if (Account.login(user, pass)) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Login!");
            }
        });

        createBtn.addActionListener(e -> frame.showRegister());

        add(title);
        add(username);
        add(password);
        add(loginBtn);
        add(createBtn);
        add(users);
        add(passw);
    }
}