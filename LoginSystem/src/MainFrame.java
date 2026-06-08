import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Login System");
        setSize(450, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setContentPane(new Login(this));
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