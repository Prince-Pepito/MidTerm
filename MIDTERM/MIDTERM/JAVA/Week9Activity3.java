// PRINCE GODFREY S. PEPITO              BSCS 2-Y1-1

import java.text.DecimalFormat;
import java.util.Scanner;

public class Week9Activity3 {
    static Scanner sc = new Scanner(System.in);

    // =====================================================
    // MAIN MENU
    // =====================================================
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== MIDTERM ACTIVITY 3 =====");
            System.out.println(" 1. Vowel / Consonant        17. Sum of squares");
            System.out.println(" 2. Date in words            18. Sum 1 to n");
            System.out.println(" 3. Temperature (ICE/WATER)  19. Reverse a number");
            System.out.println(" 4. Aircraft label           20. Sum of powers");
            System.out.println(" 5. Ship class               21. Right triangle (*)");
            System.out.println(" 6. Earthquake damage        22. Floyd's triangle (0/1)");
            System.out.println(" 7. Number to words          23. Odd pyramid (*)");
            System.out.println(" 8. Roman numerals           24. Pyramid, repeated number");
            System.out.println(" 9. Tuition fee              25. Pyramid (*)");
            System.out.println("10. Percentile to grade      26. Pyramid, counting numbers");
            System.out.println("11. Squares table            27. Right triangle, counting");
            System.out.println("12. Sequence 1,5,2,4...      28. Right triangle, repeated");
            System.out.println("13. Sequence 5,1,4,2...      29. Right triangle, 1..i");
            System.out.println("14. Factorial                30. Diamond");
            System.out.println("15. Fibonacci                31. Number pyramid 1 2 1");
            System.out.println("16. Power");
            System.out.println(" 0. Exit");
            choice = readIntInRange("Enter program number: ", 0, 31);
            System.out.println();
            run(choice);
        } while (choice != 0);
        System.out.println("Goodbye!");
    }

    static void run(int choice) {
        switch (choice) {
            case 1: p1(); break;
            case 2: p2(); break;
            case 3: p3(); break;
            case 4: p4(); break;
            case 5: p5(); break;
            case 6: p6(); break;
            case 7: p7(); break;
            case 8: p8(); break;
            case 9: p9(); break;
            case 10: p10(); break;
            case 11: p11(); break;
            case 12: p12(); break;
            case 13: p13(); break;
            case 14: p14(); break;
            case 15: p15(); break;
            case 16: p16(); break;
            case 17: p17(); break;
            case 18: p18(); break;
            case 19: p19(); break;
            case 20: p20(); break;
            case 21: p21(); break;
            case 22: p22(); break;
            case 23: p23(); break;
            case 24: p24(); break;
            case 25: p25(); break;
            case 26: p26(); break;
            case 27: p27(); break;
            case 28: p28(); break;
            case 29: p29(); break;
            case 30: p30(); break;
            case 31: p31(); break;
            default: break; // 0 = exit
        }
    }

    // =====================================================
    // INPUT / OUTPUT HELPERS
    // =====================================================
    static String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    static int readInt(String prompt) {
        while (true) {
            String s = readLine(prompt).replace(",", "");
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int n = readInt(prompt);
            if (n >= min && n <= max) {
                return n;
            }
            System.out.println("Please enter a number from " + min + " to " + max + ".");
        }
    }

    static double readDouble(String prompt) {
        while (true) {
            String s = readLine(prompt).replace(",", "");
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    static char readLetter(String prompt) {
        while (true) {
            String s = readLine(prompt);
            if (s.length() == 1 && Character.isLetter(s.charAt(0))) {
                return s.charAt(0);
            }
            System.out.println("Please enter a single letter.");
        }
    }

    static int readRows() {
        return readIntInRange("Number of rows: ", 1, 30);
    }

    // Repeats a string (works on any Java version)
    static String rep(String s, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    // =====================================================
    // 1. VOWEL OR CONSONANT
    // =====================================================
    static void p1() {
        char c = Character.toUpperCase(readLetter("Enter a letter: "));
        System.out.println("Solution 1 (if / else if / else): " + vowelIf(c));
        System.out.println("Solution 2 (switch / case):       " + vowelSwitch(c));
    }

    static String vowelIf(char c) {
        if (c == 'A') {
            return "VOWEL";
        } else if (c == 'E') {
            return "VOWEL";
        } else if (c == 'I') {
            return "VOWEL";
        } else if (c == 'O') {
            return "VOWEL";
        } else if (c == 'U') {
            return "VOWEL";
        } else {
            return "CONSONANT";
        }
    }

    static String vowelSwitch(char c) {
        switch (c) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return "VOWEL";
            default:
                return "CONSONANT";
        }
    }

    // =====================================================
    // 2. DATE IN WORDS
    // =====================================================
    static void p2() {
        int month, day, year;
        while (true) {
            String[] parts = readLine("Enter date as month day year (e.g. 2 26 1986): ").split("\\s+");
            try {
                if (parts.length != 3) {
                    throw new NumberFormatException();
                }
                month = Integer.parseInt(parts[0]);
                day = Integer.parseInt(parts[1]);
                year = Integer.parseInt(parts[2]);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid format. Type three whole numbers separated by spaces.");
            }
        }
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            System.out.println("Invalid date.");
            return;
        }
        System.out.println("Solution 1 (if / else if): " + monthIf(month) + " " + day + ", " + year);
        System.out.println("Solution 2 (switch):       " + monthSwitch(month) + " " + day + ", " + year);
    }

    static String monthIf(int m) {
        if (m == 1) {
            return "January";
        } else if (m == 2) {
            return "February";
        } else if (m == 3) {
            return "March";
        } else if (m == 4) {
            return "April";
        } else if (m == 5) {
            return "May";
        } else if (m == 6) {
            return "June";
        } else if (m == 7) {
            return "July";
        } else if (m == 8) {
            return "August";
        } else if (m == 9) {
            return "September";
        } else if (m == 10) {
            return "October";
        } else if (m == 11) {
            return "November";
        } else {
            return "December";
        }
    }

    static String monthSwitch(int m) {
        switch (m) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            default: return "December";
        }
    }

    // =====================================================
    // 3. TEMPERATURE
    // =====================================================
    static void p3() {
        double temp = readDouble("Enter temp: ");
        if (temp < 0) {
            System.out.println("ICE");
        } else if (temp <= 100) {
            System.out.println("WATER");
        } else {
            System.out.println("STEAM");
        }
    }

    // =====================================================
    // 4. AIRCRAFT LABEL
    // =====================================================
    static void p4() {
        double speed = readDouble("Observed speed (km/h): ");
        double length = readDouble("Estimated length (m): ");
        if (speed > 1100 && length > 52) {
            System.out.println("Civilian aircraft");
        } else if (speed >= 500) {
            System.out.println("Military aircraft");
        } else {
            System.out.println("It's a bird");
        }
    }

    // =====================================================
    // 5. SHIP CLASS
    // =====================================================
    static void p5() {
        char id = readLetter("Enter class ID (B, C, D, F): ");
        System.out.println("Solution 1 (if / else if / else): " + shipIf(id));
        System.out.println("Solution 2 (switch / case):       " + shipSwitch(id));
    }

    static String shipIf(char id) {
        if (id == 'B' || id == 'b') {
            return "Battleship";
        } else if (id == 'C' || id == 'c') {
            return "Cruiser";
        } else if (id == 'D' || id == 'd') {
            return "Destroyer";
        } else if (id == 'F' || id == 'f') {
            return "Frigate";
        } else {
            return "Unknown class ID";
        }
    }

    static String shipSwitch(char id) {
        switch (id) {
            case 'B':
            case 'b':
                return "Battleship";
            case 'C':
            case 'c':
                return "Cruiser";
            case 'D':
            case 'd':
                return "Destroyer";
            case 'F':
            case 'f':
                return "Frigate";
            default:
                return "Unknown class ID";
        }
    }

    // =====================================================
    // 6. EARTHQUAKE DAMAGE
    // =====================================================
    static void p6() {
        double n = readDouble("Enter Richter scale value: ");
        if (n < 5.0) {
            System.out.println("Little or no damage");
        } else if (n < 5.5) {
            System.out.println("Some damage");
        } else if (n < 6.5) {
            System.out.println("Serious damage");
        } else if (n < 7.5) {
            System.out.println("Disaster");
        } else {
            System.out.println("Catastrophe");
        }
    }

    // =====================================================
    // 7. NUMBER TO WORDS (max 3000)
    // =====================================================
    static final String[] ONES = {"", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"};
    static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty",
            "seventy", "eighty", "ninety"};

    static void p7() {
        int n = readIntInRange("Enter a number (0-3000): ", 0, 3000);
        System.out.println(numberToWords(n));
    }

    static String numberToWords(int n) {
        if (n == 0) {
            return "zero";
        }
        StringBuilder sb = new StringBuilder();
        int thousands = n / 1000;
        int hundreds = (n % 1000) / 100;
        int rest = n % 100;
        if (thousands > 0) {
            sb.append(ONES[thousands]).append(" thousand ");
        }
        if (hundreds > 0) {
            sb.append(ONES[hundreds]).append(" hundred ");
        }
        if (rest > 0) {
            if (rest < 20) {
                sb.append(ONES[rest]);
            } else {
                sb.append(TENS[rest / 10]);
                if (rest % 10 > 0) {
                    sb.append(" ").append(ONES[rest % 10]);
                }
            }
        }
        return sb.toString().trim();
    }

    // =====================================================
    // 8. ROMAN NUMERALS (max 3000)
    // =====================================================
    static void p8() {
        int n = readIntInRange("Enter a number (1-3000): ", 1, 3000);
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (n >= values[i]) {
                roman.append(symbols[i]);
                n -= values[i];
            }
        }
        System.out.println(roman);
    }

    // =====================================================
    // 9. TUITION FEE
    // =====================================================
    static void p9() {
        double fee = readDouble("Enter tuition fee: ");
        System.out.println("(Press 1 for Cash, 2 for Two-Installment, 3 for Three-Installment)");
        int plan = readIntInRange("Enter mode of payment: ", 1, 3);
        double total;
        switch (plan) {
            case 1:
                total = fee - fee * 0.10;   // 10% discount
                break;
            case 2:
                total = fee - fee * 0.05;   // 5% discount
                break;
            default:
                total = fee + fee * 0.10;   // 10% interest
        }
        DecimalFormat df = new DecimalFormat("#,##0.##");
        System.out.println("Your total tuition fee is: " + df.format(total));
    }

    // =====================================================
    // 10. PERCENTILE TO GRADE
    // =====================================================
    static void p10() {
        double p = readDouble("Enter grade (percentile): ");
        String grade;
        if (p >= 98 && p <= 100) {
            grade = "1.00";
        } else if (p >= 95 && p < 98) {
            grade = "1.25";
        } else if (p >= 92 && p < 95) {
            grade = "1.50";
        } else if (p >= 89 && p < 92) {
            grade = "1.75";
        } else if (p >= 85 && p < 89) {
            grade = "2.00";
        } else if (p >= 82 && p < 85) {
            grade = "2.25";
        } else if (p >= 80 && p < 82) {
            grade = "2.50";
        } else if (p >= 77 && p < 80) {
            grade = "2.75";
        } else if (p >= 75 && p < 77) {
            grade = "3.00";
        } else {
            grade = "Out-of-Range";
        }
        System.out.println("Grade equivalent: " + grade);
    }

    // =====================================================
    // 11. SEQUENCE AND SQUARES (1 to 5)
    // =====================================================
    static void p11() {
        System.out.println("Solution 1 - for loop");
        System.out.println("Sequence nos.\tSquared");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + "\t\t" + (i * i));
        }

        System.out.println("\nSolution 2 - while loop");
        System.out.println("Sequence nos.\tSquared");
        int n = 1;
        while (n <= 5) {
            System.out.println(n + "\t\t" + (n * n));
            n++;
        }

        System.out.println("\nSolution 3 - do while loop");
        System.out.println("Sequence nos.\tSquared");
        int k = 1;
        do {
            System.out.println(k + "\t\t" + (k * k));
            k++;
        } while (k <= 5);
    }

    // =====================================================
    // 12. 1, 5, 2, 4, 3, 3, 4, 2, 5, 1
    // =====================================================
    static void p12() {
        System.out.print("Solution 1 - for:      ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + ", " + (6 - i));
            if (i < 5) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("Solution 2 - while:    ");
        int n = 1;
        while (n <= 5) {
            System.out.print(n + ", " + (6 - n));
            if (n < 5) {
                System.out.print(", ");
            }
            n++;
        }
        System.out.println();

        System.out.print("Solution 3 - do while: ");
        int k = 1;
        do {
            System.out.print(k + ", " + (6 - k));
            if (k < 5) {
                System.out.print(", ");
            }
            k++;
        } while (k <= 5);
        System.out.println();
    }

    // =====================================================
    // 13. 5, 1, 4, 2, 3, 3, 2, 4, 1, 5
    // =====================================================
    static void p13() {
        System.out.print("Solution 1 - for:      ");
        for (int i = 1; i <= 5; i++) {
            System.out.print((6 - i) + ", " + i);
            if (i < 5) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("Solution 2 - while:    ");
        int n = 1;
        while (n <= 5) {
            System.out.print((6 - n) + ", " + n);
            if (n < 5) {
                System.out.print(", ");
            }
            n++;
        }
        System.out.println();

        System.out.print("Solution 3 - do while: ");
        int k = 1;
        do {
            System.out.print((6 - k) + ", " + k);
            if (k < 5) {
                System.out.print(", ");
            }
            k++;
        } while (k <= 5);
        System.out.println();
    }

    // =====================================================
    // 14. FACTORIAL (counting up with i++)
    // =====================================================
    static void p14() {
        int n = readIntInRange("Enter a no.: ", 0, 20);

        long r1 = 1;
        for (int i = 1; i <= n; i++) {
            r1 *= i;
        }

        long r2 = 1;
        int j = 1;
        while (j <= n) {
            r2 *= j;
            j++;
        }

        long r3 = 1;
        int k = 1;
        do {
            r3 *= k;
            k++;
        } while (k <= n);

        System.out.println("Solution 1 - for:      Factorial value: " + r1);
        System.out.println("Solution 2 - while:    Factorial value: " + r2);
        System.out.println("Solution 3 - do while: Factorial value: " + r3);

        StringBuilder expr = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            expr.append("*").append(i);
        }
        System.out.println("(The computation is: " + expr + "=" + r1 + ")");
    }

    // =====================================================
    // 15. FIBONACCI
    // =====================================================
    static void p15() {
        int n = readIntInRange("Enter a no.: ", 1, 90);

        System.out.print("Solution 1 - for:      ");
        long a = 1, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
        }
        System.out.println();

        System.out.print("Solution 2 - while:    ");
        a = 1;
        b = 1;
        int j = 1;
        while (j <= n) {
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
            j++;
        }
        System.out.println();

        System.out.print("Solution 3 - do while: ");
        a = 1;
        b = 1;
        int k = 1;
        do {
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
            k++;
        } while (k <= n);
        System.out.println();
    }

    // =====================================================
    // 16. POWER
    // =====================================================
    static void p16() {
        int base = readInt("Enter base no.: ");
        int exp = readIntInRange("Enter exponent no.: ", 0, 62);
        if (Math.pow(Math.abs((double) base), exp) > 9.0e18) {
            System.out.println("Result is too large to compute.");
            return;
        }

        long r1 = 1;
        for (int i = 1; i <= exp; i++) {
            r1 *= base;
        }

        long r2 = 1;
        int j = 1;
        while (j <= exp) {
            r2 *= base;
            j++;
        }

        long r3 = 1;
        int k = 1;
        if (exp > 0) {
            do {
                r3 *= base;
                k++;
            } while (k <= exp);
        }

        System.out.println("Solution 1 - for:      Power value: " + r1);
        System.out.println("Solution 2 - while:    Power value: " + r2);
        System.out.println("Solution 3 - do while: Power value: " + r3);

        StringBuilder expr = new StringBuilder();
        if (exp == 0) {
            expr.append("1");
        } else {
            for (int i = 1; i <= exp; i++) {
                expr.append(base);
                if (i < exp) {
                    expr.append(" * ");
                }
            }
        }
        System.out.println("(The computation is: " + base + "^" + exp + " = " + expr + " = " + r1 + ")");
    }

    // =====================================================
    // 17. SUM OF SQUARES 1 to n
    // =====================================================
    static void p17() {
        int n = readIntInRange("Enter n: ", 1, 1000000);

        long s1 = 0;
        for (int i = 1; i <= n; i++) {
            s1 += (long) i * i;
        }

        long s2 = 0;
        int j = 1;
        while (j <= n) {
            s2 += (long) j * j;
            j++;
        }

        long s3 = 0;
        int k = 1;
        do {
            s3 += (long) k * k;
            k++;
        } while (k <= n);

        System.out.println("Solution 1 - for:      " + s1);
        System.out.println("Solution 2 - while:    " + s2);
        System.out.println("Solution 3 - do while: " + s3);
    }

    // =====================================================
    // 18. SUM 1 to n
    // =====================================================
    static void p18() {
        int n = readIntInRange("Enter n: ", 1, 1000000);

        long s1 = 0;
        for (int i = 1; i <= n; i++) {
            s1 += i;
        }

        long s2 = 0;
        int j = 1;
        while (j <= n) {
            s2 += j;
            j++;
        }

        long s3 = 0;
        int k = 1;
        do {
            s3 += k;
            k++;
        } while (k <= n);

        System.out.println("Solution 1 - for:      " + s1);
        System.out.println("Solution 2 - while:    " + s2);
        System.out.println("Solution 3 - do while: " + s3);
    }

    // =====================================================
    // 19. REVERSE A NUMBER
    // =====================================================
    static void p19() {
        long original = readIntInRange("Enter a number: ", 0, Integer.MAX_VALUE);

        long n = original;
        long r1 = 0;
        for (; n > 0; n /= 10) {
            r1 = r1 * 10 + n % 10;
        }

        n = original;
        long r2 = 0;
        while (n > 0) {
            r2 = r2 * 10 + n % 10;
            n /= 10;
        }

        n = original;
        long r3 = 0;
        do {
            r3 = r3 * 10 + n % 10;
            n /= 10;
        } while (n > 0);

        System.out.println("Solution 1 - for:      Reverse number: " + r1);
        System.out.println("Solution 2 - while:    Reverse number: " + r2);
        System.out.println("Solution 3 - do while: Reverse number: " + r3);
    }

    // =====================================================
    // 20. SUM OF POWERS 1^1 + 2^2 + ... + n^n
    // =====================================================
    static long pow(int base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    static void p20() {
        int n = readIntInRange("Enter n (1-15): ", 1, 15);

        long s1 = 0;
        for (int i = 1; i <= n; i++) {
            s1 += pow(i, i);
        }

        long s2 = 0;
        int j = 1;
        while (j <= n) {
            s2 += pow(j, j);
            j++;
        }

        long s3 = 0;
        int k = 1;
        do {
            s3 += pow(k, k);
            k++;
        } while (k <= n);

        System.out.println("Solution 1 - for:      " + s1);
        System.out.println("Solution 2 - while:    " + s2);
        System.out.println("Solution 3 - do while: " + s3);
    }

    // =====================================================
    // 21. RIGHT TRIANGLE OF ASTERISKS
    // =====================================================
    static void p21() {
        int n = readRows();
        for (int i = 1; i <= n; i++) {
            System.out.println(rep("* ", i));
        }
    }

    // =====================================================
    // 22. FLOYD'S TRIANGLE (0 and 1)
    // =====================================================
    static void p22() {
        int n = readRows();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(((i + j) % 2 == 0 ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    // =====================================================
    // 23. PYRAMID, ODD NUMBER OF ASTERISKS PER ROW
    // =====================================================
    static void starRow(int n, int i) {
        System.out.println(rep(" ", 2 * (n - i)) + rep("* ", 2 * i - 1));
    }

    static void p23() {
        int n = readRows();
        for (int i = 1; i <= n; i++) {
            starRow(n, i);
        }
    }

    // =====================================================
    // 24. PYRAMID, ROW NUMBER REPEATED
    // =====================================================
    static void p24() {
        int n = readRows();
        for (int i = 1; i <= n; i++) {
            System.out.println(rep(" ", n - i) + rep(i + " ", i));
        }
    }

    // =====================================================
    // 25. PYRAMID OF ASTERISKS
    // =====================================================
    static void p25() {
        int n = readRows();
        for (int i = 1; i <= n; i++) {
            System.out.println(rep(" ", n - i) + rep("* ", i));
        }
    }

    // =====================================================
    // 26. PYRAMID, NUMBERS INCREASING BY 1
    // =====================================================
    static void p26() {
        int n = readRows();
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            StringBuilder line = new StringBuilder(rep(" ", n - i));
            for (int j = 1; j <= i; j++) {
                line.append(counter++).append(" ");
            }
            System.out.println(line);
        }
    }

    // =====================================================
    // 27. RIGHT TRIANGLE, NUMBERS INCREASING BY 1
    // =====================================================
    static void p27() {
        int n = readRows();
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter++ + " ");
            }
            System.out.println();
        }
    }

    // =====================================================
    // 28. RIGHT TRIANGLE, ROW NUMBER REPEATED
    // =====================================================
    static void p28() {
        int n = readRows();
        for (int i = 1; i <= n; i++) {
            System.out.println(rep(i + " ", i));
        }
    }

    // =====================================================
    // 29. RIGHT TRIANGLE, 1 TO i IN EACH ROW
    // =====================================================
    static void p29() {
        int n = readRows();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    // =====================================================
    // 30. DIAMOND
    // =====================================================
    static void p30() {
        int n = readIntInRange("Number of rows (half of the diamond): ", 1, 30);
        for (int i = 1; i <= n; i++) {
            starRow(n, i);
        }
        for (int i = n - 1; i >= 1; i--) {
            starRow(n, i);
        }
    }

    // =====================================================
    // 31. NUMBER PYRAMID 1 / 1 2 1 / 1 2 3 2 1 ...
    // =====================================================
    static void p31() {
        int n = readIntInRange("Number of rows (1-9 looks best): ", 1, 30);
        for (int i = 1; i <= n; i++) {
            StringBuilder line = new StringBuilder(rep(" ", 2 * (n - i)));
            for (int j = 1; j <= i; j++) {
                line.append(j).append(" ");
            }
            for (int j = i - 1; j >= 1; j--) {
                line.append(j).append(" ");
            }
            System.out.println(line);
        }
    }
}