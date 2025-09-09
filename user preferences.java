import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserPreferences {
    private String username;
    private List<String> skillsToLearn;
    private List<String> interests;

    public UserPreferences(String username) {
        this.username = username;
        this.skillsToLearn = new ArrayList<>();
        this.interests = new ArrayList<>();
    }

    public void addSkill(String skill) {
        skillsToLearn.add(skill);
    }

    public void addInterest(String interest) {
        interests.add(interest);
    }

    public String getUsername() {
        return username;
    }

    public List<String> getSkillsToLearn() {
        return skillsToLearn;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void displayPreferences() {
        System.out.println("\n=== Preferences for " + username + " ===");
        System.out.println("Skills to Learn: " + (skillsToLearn.isEmpty() ? "None" : skillsToLearn));
        System.out.println("Interests: " + (interests.isEmpty() ? "None" : interests));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Local Skill Exchange - User Preferences ===");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        UserPreferences prefs = new UserPreferences(username);

        System.out.println("Enter skills you would like to learn (type 'done' to finish):");
        while (true) {
            String skill = scanner.nextLine();
            if (skill.equalsIgnoreCase("done")) break;
            prefs.addSkill(skill);
        }

        System.out.println("Enter your interests (type 'done' to finish):");
        while (true) {
            String interest = scanner.nextLine();
            if (interest.equalsIgnoreCase("done")) break;
            prefs.addInterest(interest);
        }

        prefs.displayPreferences();

        scanner.close();
    }
}
