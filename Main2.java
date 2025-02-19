import java.util.Scanner;

public class Main2 {
    private static FinanceManager financeManager = new FinanceManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🔹 Welcome to Personal Finance Tracker 🔹");

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    financeManager.registerUser();
                    break;
                case 2:
                    financeManager.loginUser();
                    break;
                case 3:
                    System.out.println("Exiting... Thank you! 🏦");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
