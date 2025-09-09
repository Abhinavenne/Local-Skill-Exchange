import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserLogin {
    private String username;
    private String password;

    private static Map<String, String> users = new HashMap<>();
    static {
        users.put("alice", "password123");
        users.put("bob", "secure456");
        users.put("charlie", "mypassword");
    }
    public UserLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate() {
        if (users.containsKey(username)) {
            String storedPassword = users.get(username);
            return storedPassword.equals(password);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Local Skill Exchange - User Login ===");
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        UserLogin login = new UserLogin(username, password);

        if (login.authenticate()) {
            System.out.println("✅ Login successful! Welcome, " + username + "!");
        } else {
            System.out.println("❌ Invalid username or password. Please try again.");
        }

        scanner.close();
    }
}
