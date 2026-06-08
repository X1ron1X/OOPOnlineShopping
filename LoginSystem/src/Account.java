import java.sql.*;

public class Account {

    public static void addAccount(String username, String password) {

        String sql = "INSERT INTO users(username, password) VALUES(?, ?)";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();

            System.out.println("Saved to MySQL!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean login(String username, String password) {

        String sql = "SELECT * FROM users WHERE username=? AND password=?";

        try (Connection conn = DBConnection.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            return ps.executeQuery().next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}