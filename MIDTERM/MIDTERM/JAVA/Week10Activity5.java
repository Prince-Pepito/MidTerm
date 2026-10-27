//PRINCE GODFREY S. PEPITO              BSCS 2-Y1-1

import java.util.Scanner;

public class Week10Activity5 {
    static Scanner sc = new Scanner(System.in);

    // ==========================================
    // 1. BASE ACCOUNT CLASS
    // ==========================================
    static abstract class Account {
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
            balance += amount;
            System.out.printf("Deposited \u20B1%.2f successfully.%n", amount);
        }

        // Abstract methods to enforce specific behaviors in child classes
        public abstract void withdraw(double amount);
        public abstract String getAccountType();
    }

    // ==========================================
    // 2. SAVINGS ACCOUNT CLASS
    // ==========================================
    static class SavingsAccount extends Account {
        public SavingsAccount(String accountNumber, double balance) {
            super(accountNumber, balance);
        }

        @Override
        public void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Error: Insufficient savings balance.");
            } else {
                balance -= amount;
                System.out.printf("Withdrew \u20B1%.2f successfully from Savings.%n", amount);
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
    static class CheckingAccount extends Account {
        public CheckingAccount(String accountNumber, double balance) {
            super(accountNumber, balance);
        }

        @Override
        public void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Error: Insufficient checking balance.");
            } else {
                balance -= amount;
                System.out.printf("Withdrew \u20B1%.2f successfully from Checking.%n", amount);
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
    public static void main(String[] args) {
        System.out.println("Welcome to the OOP Banking System");

        // Ask for the opening balance until a valid number (0 or more) is entered
        double openingBalance = 0;
        boolean balanceInitialized = false;
        do {
            try {
                System.out.print("Opening balance: ");
                openingBalance = sc.nextDouble();
                if (openingBalance >= 0) {
                    balanceInitialized = true;
                } else {
                    System.out.println("Error: Opening balance cannot be negative.");
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Numeric values only.");
                sc.nextLine();
            }
        } while (!balanceInitialized);

        // Separate objects, each with its own balance
        SavingsAccount savingsAccount = new SavingsAccount("SAV-1001", openingBalance);
        CheckingAccount checkingAccount = new CheckingAccount("CHK-2001", openingBalance);

        // POLYMORPHISM: one Account reference, two possible object types
        Account selectedAccount = savingsAccount;
        printAccountSummary(selectedAccount);

        int choices;
        do {
            try {
                System.out.println("\n--- Banking Menu ---");
                System.out.println("1. Withdraw Amount");
                System.out.println("2. Deposit Amount");
                System.out.println("3. Show Balance");
                System.out.println("4. Switch Account");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choices = sc.nextInt();

                switch (choices) {
                    case 1:
                        withdrawAmount(selectedAccount);
                        break;
                    case 2:
                        depositAmount(selectedAccount);
                        break;
                    case 3:
                        printAccountSummary(selectedAccount);
                        break;
                    case 4:
                        // Only the reference changes; no balance is touched
                        selectedAccount = (selectedAccount == savingsAccount)
                                ? checkingAccount : savingsAccount;
                        printAccountSummary(selectedAccount);
                        break;
                    case 5:
                        System.out.println("Thank you for using the system!");
                        break;
                    default:
                        System.out.println("Error: Invalid Choice. Please select a valid option.");
                }
            } catch (Exception bank) {
                System.out.println("Error: Invalid input. Numeric values only.");
                sc.nextLine();
                choices = 0;
            }
        } while (choices != 5);
    }

    public static void withdrawAmount(Account account) {
        System.out.print("How much do you want to withdraw?\nAmount: ");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Error: Amount must be greater than zero.");
        } else {
            account.withdraw(amount);
        }
    }

    public static void depositAmount(Account account) {
        System.out.print("How much do you want to deposit?\nAmount: ");
        double amount = sc.nextDouble();
        if (amount <= 0) {
            System.out.println("Error: Amount must be greater than zero.");
        } else {
            account.deposit(amount);
        }
    }

    // Uses only Account's methods: no balance arithmetic here
    public static void printAccountSummary(Account account) {
        System.out.printf("Current account: %s | Balance: \u20B1%.2f%n",
                account.getAccountType(), account.getBalance());
    }
}