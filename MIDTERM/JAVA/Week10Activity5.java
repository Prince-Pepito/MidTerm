import java.util.Scanner;

// ==========================================
// 1. BASE ACCOUNT CLASS
// ==========================================
abstract class Account {
    private String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Deposited ₱%.2f successfully.%n", amount);
        }
    }

    // Abstract methods to enforce specific behaviors in child classes
    public abstract void withdraw(double amount);
    public abstract String getAccountType();
}

// ==========================================
// 2. SAVINGS ACCOUNT CLASS
// ==========================================
class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Transaction declined: Insufficient savings balance.");
        } else {
            balance -= amount;
            System.out.printf("Withdrew ₱%.2f successfully from Savings.%n", amount);
        }
    }

    @Override
    public String getAccountType() {
        return "Savings (" + getAccountNumber() + ")";
    }
}

// ==========================================
// 3. CHECKING ACCOUNT CLASS
// ==========================================
class CheckingAccount extends Account {
    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Transaction declined: Insufficient checking balance.");
        } else {
            balance -= amount;
            System.out.printf("Withdrew ₱%.2f successfully from Checking.%n", amount);
        }
    }

    @Override
    public String getAccountType() {
        return "Checking (" + getAccountNumber() + ")";
    }
}

// ==========================================
// 4. MAIN DRIVER PROGRAM
// ==========================================
public class Week10Activity5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the OOP Banking System");
        double openingBalance = readNonNegativeBalance(scanner);

        // Separate objects, each with its own balance
        SavingsAccount savingsAccount = new SavingsAccount("SAV-1001", openingBalance);
        CheckingAccount checkingAccount = new CheckingAccount("CHK-2001", openingBalance);

        // POLYMORPHISM: one Account reference, two possible object types
        Account selectedAccount = savingsAccount;
        printAccountSummary(selectedAccount);

        boolean running = true;
        while (running) {
            showMenu();
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": {
                    double amount = readPositiveAmount(scanner, "Amount to withdraw: ");
                    if (amount > 0) {
                        selectedAccount.withdraw(amount);
                    }
                    break;
                }
                case "2": {
                    double amount = readPositiveAmount(scanner, "Amount to deposit: ");
                    if (amount > 0) {
                        selectedAccount.deposit(amount);
                    }
                    break;
                }
                case "3":
                    printAccountSummary(selectedAccount);
                    break;
                case "4":
                    // Only the reference changes; no balance is touched
                    selectedAccount = (selectedAccount == savingsAccount)
                            ? checkingAccount : savingsAccount;
                    printAccountSummary(selectedAccount);
                    break;
                case "5":
                    running = false;
                    System.out.println("Thank you for using the system!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 5.");
            }
        }
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("\n1 Withdraw | 2 Deposit | 3 Show balance | 4 Switch account | 5 Exit");
    }

    // Keeps asking until the opening balance is a number >= 0
    public static double readNonNegativeBalance(Scanner scanner) {
        while (true) {
            System.out.print("Opening balance: ");
            String input = scanner.nextLine().trim().replace(",", "");
            try {
                double value = Double.parseDouble(input);
                if (value >= 0) {
                    return value;
                }
                System.out.println("Opening balance cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Returns the amount if it is a positive number, otherwise prints a
    // message and returns -1 so the caller goes back to the menu
    public static double readPositiveAmount(Scanner scanner, String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim().replace(",", "");
        try {
            double value = Double.parseDouble(input);
            if (value > 0) {
                return value;
            }
            System.out.println("Invalid amount. It must be greater than zero.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        return -1;
    }

    // Uses only Account's methods: no balance arithmetic here
    public static void printAccountSummary(Account account) {
        System.out.printf("Current account: %s | Balance: \u20B1%.2f%n",
                account.getAccountType(), account.getBalance());
    }
}
