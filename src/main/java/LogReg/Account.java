import java.util.HashMap;

public class Account {

    private static HashMap<String, String> users = new HashMap<>();

    public static void addAccount(String username, String password) {
        users.put(username, password);
    }

    public static boolean login(String username, String password) {
        return users.containsKey(username) &&
               users.get(username).equals(password);
    }
}