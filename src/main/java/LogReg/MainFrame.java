package LogReg;

import LogReg.Login;
import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Login System");
        setSize(1050, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        showLogin();
    }

    public void showLogin() {
        setContentPane(new Login(this));
        revalidate();
        repaint();
    }

    public void showRegister() {
        setContentPane(new Register(this));
        revalidate();
        repaint();
    }
}