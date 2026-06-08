import java.sql.*;

public class TestInsert {
    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/login_db",
                "root",
                ""
            );

            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, "testuser");
            pst.setString(2, "12345");

            int result = pst.executeUpdate();

            System.out.println("Rows inserted: " + result);

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}