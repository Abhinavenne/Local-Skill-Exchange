import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminLogin {
    private String adminName;
    private String password;

    private static Map<String, String> admins = new HashMap<>();

    static {
        admins.put("admin1", "adminpass");
        admins.put("superuser", "super123");
    }

    public AdminLogin(String adminName, String password) {
        this.adminName = adminName;
        this.password = password;
    }

    public boolean authenticate() {
        if (admins.containsKey(adminName)) {
            String storedPassword = admins.get(adminName);
            return storedPassword.equals(password);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Local Skill Exchange - Admin Login ===");

        System.out.print("Enter admin username: ");
        String adminName = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        AdminLogin login = new AdminLogin(adminName, password);

        if (login.authenticate()) {
            System.out.println("✅ Admin login successful! Welcome, " + adminName + "!");
        } else {
            System.out.println("❌ Invalid admin credentials. Access denied.");
        }

        scanner.close();
    }
}
