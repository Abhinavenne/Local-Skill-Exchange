import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SkillsBrowser {
    private List<String> skills;
    private int pageSize;   // number of skills per page


    public SkillsBrowser(List<String> skills, int pageSize) {
        this.skills = skills;
        this.pageSize = pageSize;
    }


    public void showPage(int pageNumber) {
        int start = pageNumber * pageSize;
        int end = Math.min(start + pageSize, skills.size());

        if (start >= skills.size()) {
            System.out.println("⚠ No more skills to display.");
            return;
        }

        System.out.println("\n=== Skills List (Page " + (pageNumber + 1) + ") ===");
        for (int i = start; i < end; i++) {
            System.out.println((i + 1) + ". " + skills.get(i));
        }
    }

   
    public void browse() {
        Scanner scanner = new Scanner(System.in);
        int page = 0;
        boolean running = true;

        while (running) {
            showPage(page);
            System.out.println("\nOptions: [n] Next | [p] Previous | [s <number>] Select | [q] Quit");
            System.out.print("Enter choice: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("n")) {
                page++;
            } else if (input.equalsIgnoreCase("p")) {
                if (page > 0) page--;
                else System.out.println("⚠ Already at the first page.");
            } else if (input.startsWith("s")) {
                try {
                    int choice = Integer.parseInt(input.split(" ")[1]);
                    if (choice >= 1 && choice <= skills.size()) {
                        System.out.println("✅ You selected: " + skills.get(choice - 1));
                    } else {
                        System.out.println("⚠ Invalid skill number.");
                    }
                } catch (Exception e) {
                    System.out.println("⚠ Invalid input. Use: s <number>");
                }
            } else if (input.equalsIgnoreCase("q")) {
                running = false;
            } else {
                System.out.println("⚠ Unknown command.");
            }
        }

        scanner.close();
        System.out.println("Exiting Skills Browser...");
    }

    public static void main(String[] args) {
        List<String> sampleSkills = new ArrayList<>();
        sampleSkills.add("Java Programming");
        sampleSkills.add("Python Development");
        sampleSkills.add("Cooking");
        sampleSkills.add("Graphic Design");
        sampleSkills.add("Public Speaking");
        sampleSkills.add("Digital Marketing");
        sampleSkills.add("Photography");
        sampleSkills.add("Music Production");
        sampleSkills.add("Gardening");
        sampleSkills.add("Web Development");

        SkillsBrowser browser = new SkillsBrowser(sampleSkills, 3);
        browser.browse();
    }
}
