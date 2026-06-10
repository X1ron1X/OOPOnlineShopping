import LogReg.MainFrame;
import LogReg.Account;
import javax.swing.SwingUtilities;

public class Menu {

    public static void main(String[] args) {

        
        Account.addAccount("user", "1234");

        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
           frame.setVisible(true);
        });
    }
}