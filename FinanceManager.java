import java.util.*;

public class FinanceManager {
    private Map<String, User> users = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();
    private User currentUser;

    public void registerUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        users.put(username, new User(username, password));
        System.out.println("✅ Registration Successful! You can now log in.");
    }

    public void loginUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            currentUser = users.get(username);
            System.out.println("✅ Login Successful! Welcome " + username);
            manageFinance();
        } else {
            System.out.println("❌ Invalid credentials!");
        }
    }

    private void manageFinance() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Income\n2. Add Expense\n3. View Transactions\n4. Logout");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addTransaction("Income");
                    break;
                case 2:
                    addTransaction("Expense");
                    break;
                case 3:
                    viewTransactions();
                    break;
                case 4:
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option. Try again!");
            }
        }
    }

    private void addTransaction(String type) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount: ₹");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter description: ");
        String description = sc.nextLine();

        transactions.add(new Transaction(type, amount, description));
        System.out.println("✅ Transaction Added!");
    }

    private void viewTransactions() {
        System.out.println("\n🔹 Transaction History 🔹");
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
