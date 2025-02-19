import java.io.*;
import java.util.List;

public class FileHandler {
    public static void saveTransactions(List<Transaction> transactions) {
        try (FileWriter writer = new FileWriter("transactions.txt", true)) {
            for (Transaction t : transactions) {
                writer.write(t.getType() + "," + t.getAmount() + "," + t.getDescription() + "\n");
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving transactions.");
        }
    }

    public static void loadTransactions(List<Transaction> transactions) {
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                transactions.add(new Transaction(parts[0], Double.parseDouble(parts[1]), parts[2]));
            }
        } catch (IOException e) {
            System.out.println("❌ Error loading transactions.");
        }
    }
}
