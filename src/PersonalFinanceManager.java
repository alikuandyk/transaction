import java.util.ArrayList;
import java.util.Scanner;

public class PersonalFinanceManager {
    private static ArrayList<Transaction> transactions = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("Personal Finance Manager");
            System.out.println("1. Add income");
            System.out.println("2. Add expense");
            System.out.println("3. View balance");
            System.out.println("4. View transactions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addIncome();
                    break;
                case 2:
                    addExpense();
                    break;
                case 3:
                    viewBalance();
                    break;
                case 4:
                    viewTransactions();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    private static void addIncome() {
        System.out.print("Enter income description: ");
        String description = scanner.nextLine();
        System.out.print("Enter income amount: ");
        double amount = scanner.nextDouble();
        transactions.add(new Transaction(description, amount));
        System.out.println("Income added successfully.");
    }

    private static void addExpense() {
        System.out.print("Enter expense description: ");
        String description = scanner.nextLine();
        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        transactions.add(new Transaction(description, -amount)); // Expenses represented as negative amounts
        System.out.println("Expense added successfully.");
    }

    private static void viewBalance() {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        System.out.println("Current balance: " + balance);
    }

    private static void viewTransactions() {
        System.out.println("Transactions:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getDescription() + ": " + transaction.getAmount());
        }
    }
}

