// PRINCE GODFREY S. PEPITO              BSCS 2-Y1-1

import java.util.Scanner;

public class Week8Activity2 {
    public static void main(String[] args) {
        Scanner lagay = new Scanner(System.in);
        
        String name = "";
        int tpages = 0;
        int pages_read = 0;
        int days_remaining = 0;
        int step = 1; // 1 = Name, 2 = Pages, 3 = Days Remaining

        while (step <= 3) {
            try {
                switch (step) {
                    case 1: // --- STEP 1: NAME ---
                        System.out.print("Enter your name (E.g. Prince Pepito): ");
                        name = lagay.nextLine();
                        
                        if (name.matches("[a-zA-Z\\s]+")) {
                            System.out.println("Welcome, " + name + "!\n");
                            step = 2;
                        } else {
                            System.out.println("Invalid input! Name must contain letters only.\n");
                        }
                        break;

                    case 2: // --- STEP 2: BOOK PAGES ---
                        System.out.print("How many pages does the book have?: ");
                        tpages = lagay.nextInt();

                        System.out.print("How many pages have you read?: ");
                        pages_read = lagay.nextInt();

                        if (tpages >= pages_read && tpages > 0 && pages_read >= 0) {
                            step = 3; // Move to entering days
                        } else {
                            System.out.println("Invalid Input! Pages read cannot exceed total pages or be negative.\n");
                        }
                        break;

                    case 3: // --- STEP 3: DAYS REMAINING ---
                        System.out.print("How many days remaining to return the book?: ");
                        days_remaining = lagay.nextInt();

                        if (days_remaining > 0) {
                            step = 4; // Safely exits the while loop
                        } else {
                            System.out.println("Invalid Input! Days remaining must be greater than 0.\n");
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input type! Please enter valid data.\n");
                lagay.nextLine(); // Flushes the scanner buffer to prevent infinite loops
            }
        }

        // --- MATH CALCULATIONS ---
        int percentageRead = (int) (((double) pages_read / tpages) * 100);
        int pages_left = tpages - pages_read;
        
        // Integer division automatically handles truncating to match the image sample behavior (50 / 4 = 12)
        int pages_per_day = pages_left / days_remaining; 

        // --- DYNAMIC OUTPUT ---
        System.out.println("\n------------------------------------------------");
        System.out.println("You have read " + percentageRead + "% of the book.");
        System.out.println("You have " + days_remaining + " day(s) remaining to return the book.");
        System.out.println("You still have " + pages_left + " page(s) left and you should read " + pages_per_day + " pages a day.");
        System.out.println("------------------------------------------------");
    }
}
