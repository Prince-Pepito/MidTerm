import java.util.ArrayList;
import java.util.Scanner;

public class Week10Activity6 {
        static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int mainMenuChoice;
        do {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Banking Program (Program 1)");
            System.out.println("2. Hospital Database Program (Program 2)");
            System.out.println("3. University Hierarchy Program (Program 3)");
            System.out.println("4. Exit Application");
            System.out.print("Select which program to run: ");
            mainMenuChoice = sc.nextInt();
            switch (mainMenuChoice) {
                case 1:
                    System.out.print("Enter your initial balance: ");
                    double balance = sc.nextDouble();
                    bankingProgram(balance);
                    break;
                case 2:
                    hospitalDatabaseProgram();
                    break;
                case 3:
                    UnivRankingProgram();
                    break;
                case 4:
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        } while (mainMenuChoice != 4);
    }





    // ==========================
    // PROGRAM 1: BANKING SYSTEM
    // ==========================

    public static void bankingProgram(double balance) {
        int choices;
        do {
            System.out.println("\n--- Banking Menu ---");
            System.out.println("1. Withdraw Amount ");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choices = sc.nextInt();
            
            switch (choices) {
                case 1:
                    balance = withdraw(balance);
                    break;
                case 2:
                    balance = deposit(balance);
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Error: Invalid Choice");
            }
        } while (choices != 3);
    }
    public static double withdraw(double balance) {
        System.out.print("How much do you want to withdraw?\nAmount: ");
        double withdrawAmount = sc.nextDouble();
        if (withdrawAmount > balance) {
            System.out.println("Error: Insufficient funds.");
        } else {
            balance -= withdrawAmount;
            System.out.println("Your new balance is: " + balance);
        }
        return balance;
    }
    public static double deposit(double balance) {
        System.out.print("How much do you want to deposit?\nAmount: ");
        double depositAmount = sc.nextDouble();
        balance += depositAmount;
        System.out.println("Your new balance is: " + balance);
        return balance;
    }





    // ================================================
    // PROGRAM 2 CLASSES: HOSPITAL DATABASE STRUCTURES
    // ================================================
    
    // Structure to store the date (year, month, date)
    static class DateStructure {
        int year;
        int month;
        int day;
        public DateStructure(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
        @Override
        public String toString() {
            return day + "/" + month + "/" + year;
        }
    }
    // Base Class: Stores general patient details
    static class Patient {
        String name;
        DateStructure dateOfAdmission;
        String disease;
        DateStructure dateOfDischarge;
        // Member function to enter general patient info
        public void enterInformation() {
            System.out.print("Enter Patient Name: ");
            sc.nextLine(); // Clear scanner buffer
            this.name = sc.nextLine();
            System.out.println("Enter Date of Admission:");
            System.out.print("  Day (DD): "); int addDay = sc.nextInt();
            System.out.print("  Month (MM): "); int addMonth = sc.nextInt();
            System.out.print("  Year (YYYY): "); int addYear = sc.nextInt();
            this.dateOfAdmission = new DateStructure(addDay, addMonth, addYear);
            System.out.print("Enter Disease/Diagnosis: ");
            sc.nextLine(); // Clear buffer
            this.disease = sc.nextLine();
            System.out.println("Enter Date of Discharge:");
            System.out.print("  Day (DD): "); int disDay = sc.nextInt();
            System.out.print("  Month (MM): "); int disMonth = sc.nextInt();
            System.out.print("  Year (YYYY): "); int disYear = sc.nextInt();
            this.dateOfDischarge = new DateStructure(disDay, disMonth, disYear);
        }
        // Member function to display general patient details
        public void displayInformation() {
            System.out.println("Name: " + name);
            System.out.println("Admitted On: " + dateOfAdmission);
            System.out.println("Disease: " + disease);
            System.out.println("Discharged On: " + dateOfDischarge);
        }
    }
    // Derived Class: Extends patient to add and manage age records
    static class DetailedPatient extends Patient {
        int age;
        @Override
        public void enterInformation() {
            super.enterInformation(); // Call parent input logic
            System.out.print("Enter Patient Age: ");
            this.age = sc.nextInt();
        }
        @Override
        public void displayInformation() {
            super.displayInformation(); // Call parent display logic
            System.out.println("Age: " + age + " years old");
            System.out.println("---------------------------------------");
        }
    }

    // ======================================
    // PROGRAM 2 EXECUTION: HOSPITAL PROGRAM
    // ======================================
    public static void hospitalDatabaseProgram() {
        ArrayList<DetailedPatient> database = new ArrayList<>();
        int menuChoice;
        do {
            System.out.println("\n===== HOSPITAL INDOOR PATIENT DATABASE =====");
            System.out.println("1. Add New Patient Records");
            System.out.println("2. Display All Patients");
            System.out.println("3. List Pediatric Patients (Age < 12)");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");
            menuChoice = sc.nextInt();
            switch (menuChoice) {
                case 1:
                    System.out.print("How many patient records do you want to add? ");
                    int count = sc.nextInt();
                    for (int i = 0; i < count; i++) {
                        System.out.println("\n--- Entering Details for Patient #" + (i + 1) + " ---");
                        DetailedPatient p = new DetailedPatient();
                        p.enterInformation();
                        database.add(p);
                    }
                    break;
                case 2:
                    if (database.isEmpty()) {
                        System.out.println("The database is currently empty.");
                    } else {
                        System.out.println("\n===== ALL PATIENT RECORDS =====");
                        System.out.println("---------------------------------------");
                        for (DetailedPatient p : database) {
                            p.displayInformation();
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n===== PEDIATRIC PATIENTS LIST (< 12 Years Old) =====");
                    System.out.println("---------------------------------------");
                    boolean foundPediatric = false;
                    
                    for (DetailedPatient p : database) {
                        if (p.age < 12) {
                            p.displayInformation();
                            foundPediatric = true;
                        }
                    }
                    
                    if (!foundPediatric) {
                        System.out.println("No pediatric patients found matching this criteria.");
                    }
                    break;
                case 4:
                    System.out.println("Returning to main application selector...");
                    break;
                default:
                    System.out.println("Invalid input. Please choose a valid option.");
            }
        } while (menuChoice != 4);
    }




    // ================================================
    // PROGRAM 3 CLASSES: UNIVERSITY RANKING PROGRAM
    // ================================================

    public static void UnivRankingProgram() {
        class Professor {
            private String name;
            private double salary;

            public Professor(String name, double salary) {
                this.name = name;
                this.salary = salary;
            }

            public String getName() {
                return name;
            }

            public double getSalary() {
                return salary;
            }
        }

        class Dean extends Professor {
            private String department;

            public Dean(String name, double salary, String department) {
                super(name, salary);
                this.department = department;
            }

            public String getDepartment() {
                return department;
            }

            protected String details() {
                return "Name: " + getName() + "\n"
                    + "Department: " + department + "\n"
                    + "Salary: " + (int) getSalary();
            }

            @Override
            public String toString() {
                return "Status\n"
                    + "Rank: Dean\n"
                    + details();
            }
        }

        class Executive extends Dean {
            public Executive(String name, double salary, String department) {
                super(name, salary, department);
            }

            @Override
            public String toString() {
                return "Status\n"
                    + "Rank: Executive\n"
                    + details();
            }
        }

        // Menu + user input
        int choices;
        do {
            System.out.println("\n--- University Ranking Menu ---");
            System.out.println("1. Enter and Display Dean and Executive Details");
            System.out.println("2. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choices = sc.nextInt();
            sc.nextLine();

            switch (choices) {
                case 1: {
                    System.out.println("\n--- Enter Dean Details ---");
                    System.out.print("Name: ");
                    String deanName = sc.nextLine();
                    System.out.print("Department: ");
                    String deanDept = sc.nextLine();
                    System.out.print("Salary: ");
                    double deanSalary = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("\n--- Enter Executive Details ---");
                    System.out.print("Name: ");
                    String execName = sc.nextLine();
                    System.out.print("Department: ");
                    String execDept = sc.nextLine();
                    System.out.print("Salary: ");
                    double execSalary = sc.nextDouble();
                    sc.nextLine();

                    Dean dean = new Dean(deanName, deanSalary, deanDept);
                    Executive exec = new Executive(execName, execSalary, execDept);

                    System.out.println();
                    System.out.println(dean);
                    System.out.println("----------------------------------------");
                    System.out.println(exec);
                    break;
                }
                case 2:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Error: Invalid Choice");
            }
        } while (choices != 2);
    }
}