// PRINCE GODFREY S. PEPITO              BSCS 2-Y1-1
// WEEK 10 ACTIVITY 4: PROGRAMMING ACTIVITIES 18-27

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Week10Activity4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== PROGRAMMING ACTIVITIES 18-27 =====");
            System.out.println("1. Smart Payslip Generator");
            System.out.println("2. Student Tuition Billing");
            System.out.println("3. Customer Purchase Receipt");
            System.out.println("4. Event Ticketing System");
            System.out.println("5. Reservation and Billing System");
            System.out.println("6. Car Rental System");
            System.out.println("7. Restaurant Ordering System");
            System.out.println("8. Flower Reservation Billing");
            System.out.println("9. KMART Korean Noodles Billing");
            System.out.println("10. Parking Reservation Billing");
            System.out.println("0. Exit");
            System.out.print("Choose an activity: ");
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    activity18(input);
                    break;
                case "2":
                    activity19(input);
                    break;
                case "3":
                    activity20(input);
                    break;
                case "4":
                    activity21(input);
                    break;
                case "5":
                    activity22(input);
                    break;
                case "6":
                    activity23(input);
                    break;
                case "7":
                    activity24(input);
                    break;
                case "8":
                    activity25(input);
                    break;
                case "9":
                    activity26(input);
                    break;
                case "10":
                    activity27(input);
                    break;
                case "0":
                    input.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose 0-10.");
            }
            input.nextLine(); // Clear the leftover newline from numeric input
            System.out.println("\nPress Enter to return to the menu.");
            input.nextLine();
        }
    }

    // Activity 18: Smart Payslip Generator
    public static void activity18(Scanner input) {
        System.out.println("=== SMART PAYSLIP GENERATOR ===");
                System.out.print("Employee name: ");
                String name = input.nextLine();
                System.out.print("Employee ID: ");
                String id = input.nextLine();
                System.out.print("Department: ");
                String department = input.nextLine();
                System.out.print("Basic monthly salary: ");
                double salary = input.nextDouble();
                input.nextLine();
                System.out.print("Payroll start date (YYYY-MM-DD): ");
                String startDate = input.nextLine();
                System.out.print("Payroll end date (YYYY-MM-DD): ");
                String endDate = input.nextLine();
                System.out.print("Payout date (YYYY-MM-DD): ");
                String payoutDate = input.nextLine();
                System.out.print("Regular hours worked: ");
                double regularHours = input.nextDouble();
                System.out.print("Overtime hours worked: ");
                double overtimeHours = input.nextDouble();
                System.out.print("Absent days: ");
                double absentDays = input.nextDouble();
                System.out.print("Rice allowance: ");
                double rice = input.nextDouble();
                System.out.print("Transportation allowance: ");
                double transportation = input.nextDouble();
                System.out.print("Communication allowance: ");
                double communication = input.nextDouble();
                System.out.print("SSS contribution: ");
                double sss = input.nextDouble();
                System.out.print("PhilHealth contribution: ");
                double philHealth = input.nextDouble();
                System.out.print("PAG-IBIG contribution: ");
                double pagIbig = input.nextDouble();
                System.out.print("Withholding tax: ");
                double tax = input.nextDouble();
                System.out.print("Other deductions: ");
                double other = input.nextDouble();
                double hourlyRate = salary / 160;
                double dailyRate = salary / 20;
                double regularPay = regularHours * hourlyRate;
                double overtimePay = overtimeHours * hourlyRate * 1.25;
                double absenceDeduction = absentDays * dailyRate;
                double totalAllowances = rice + transportation + communication;
                double grossPay = regularPay + overtimePay + totalAllowances;
                double totalDeductions = sss + philHealth + pagIbig + tax + other + absenceDeduction;
                double netPay = grossPay - totalDeductions;
                System.out.println("\n============== SMART EMPLOYEE PAYSLIP ==============");
                System.out.println("Name: " + name);
                System.out.println("Employee ID: " + id);
                System.out.println("Department: " + department);
                System.out.println("Pay Period: " + startDate + " to " + endDate);
                System.out.println("Payout Date: " + payoutDate);
                System.out.println("\nEARNINGS");
                System.out.printf("Regular Pay:             %.2f%n", regularPay);
                System.out.printf("Overtime Pay:            %.2f%n", overtimePay);
                System.out.printf("Total Allowances:        %.2f%n", totalAllowances);
                System.out.printf("Gross Pay:               %.2f%n", grossPay);
                System.out.println("\nALLOWANCES");
                System.out.printf("Rice:                    %.2f%n", rice);
                System.out.printf("Transportation:          %.2f%n", transportation);
                System.out.printf("Communication:           %.2f%n", communication);
                System.out.println("\nDEDUCTIONS");
                System.out.printf("SSS:                     %.2f%n", sss);
                System.out.printf("PhilHealth:              %.2f%n", philHealth);
                System.out.printf("PAG-IBIG:                %.2f%n", pagIbig);
                System.out.printf("Withholding Tax:         %.2f%n", tax);
                System.out.printf("Absence Deduction:       %.2f%n", absenceDeduction);
                System.out.printf("Other Deductions:        %.2f%n", other);
                System.out.printf("Total Deductions:        %.2f%n", totalDeductions);
                System.out.printf("NET PAY:                 %.2f%n", netPay);
                System.out.println("====================================================");
    }
    // Activity 19: Student Tuition Billing
    public static void activity19(Scanner input) {
        System.out.println("=== STUDENT TUITION BILLING SYSTEM ===");
                System.out.print("Student name: ");
                String name = input.nextLine();
                System.out.print("Student ID: ");
                String id = input.nextLine();
                System.out.print("Course/program: ");
                String course = input.nextLine();
                System.out.print("Year level: ");
                int year = input.nextInt();
                System.out.print("Units enrolled: ");
                int units = input.nextInt();
                System.out.print("Tuition fee per unit: ");
                double feePerUnit = input.nextDouble();
                System.out.print("Miscellaneous fee: ");
                double misc = input.nextDouble();
                System.out.print("Laboratory fee: ");
                double lab = input.nextDouble();
                System.out.print("Library fee: ");
                double library = input.nextDouble();
                System.out.print("Other fees: ");
                double other = input.nextDouble();
                System.out.print("Down payment: ");
                double downPayment = input.nextDouble();
                System.out.print("Scholarship discount amount: ");
                double scholarship = input.nextDouble();
                double tuitionTotal = units * feePerUnit;
                double grossTotal = tuitionTotal + misc + lab + library + other;
                double netTotal = grossTotal - scholarship;
                double balance = netTotal - downPayment;
                System.out.println("\n============= STUDENT TUITION BILL =============");
                System.out.println("Name: " + name);
                System.out.println("Student ID: " + id);
                System.out.println("Course: " + course);
                System.out.println("Year Level: " + year);
                System.out.println("Units Enrolled: " + units);
                System.out.printf("Tuition per Unit:       %.2f%n", feePerUnit);
                System.out.printf("Tuition Fee Total:      %.2f%n", tuitionTotal);
                System.out.printf("Miscellaneous Fee:      %.2f%n", misc);
                System.out.printf("Laboratory Fee:         %.2f%n", lab);
                System.out.printf("Library Fee:            %.2f%n", library);
                System.out.printf("Other Fees:             %.2f%n", other);
                System.out.printf("Gross Total Fee:        %.2f%n", grossTotal);
                System.out.printf("Scholarship Discount:   %.2f%n", scholarship);
                System.out.printf("Net Total Fee:          %.2f%n", netTotal);
                System.out.printf("Down Payment:           %.2f%n", downPayment);
                System.out.printf("Remaining Balance:      %.2f%n", balance);
                System.out.println("================================================");
    }

    // Activity 20: Customer Purchase Receipt
    public static void activity20(Scanner input) {
        System.out.println("=== CUSTOMER PURCHASE ORDER ===");
                System.out.print("Customer name: ");
                String name = input.nextLine();
                System.out.print("Customer ID: ");
                String id = input.nextLine();
                String[] itemNames = new String[3];
                int[] quantities = new int[3];
                double[] prices = new double[3];
                double subtotal = 0;
        
                for (int i = 0; i < 3; i++) {
                    System.out.println("\nItem " + (i + 1));
                    System.out.print("Item name: ");
                    itemNames[i] = input.nextLine();
                    System.out.print("Quantity: ");
                    quantities[i] = input.nextInt();
                    System.out.print("Price per item: ");
                    prices[i] = input.nextDouble();
                    input.nextLine();
                    subtotal += quantities[i] * prices[i];
                }
                System.out.print("Discount percentage: ");
                double discountPercent = input.nextDouble();
                System.out.print("Amount tendered: ");
                double tendered = input.nextDouble();
                double discountAmount = subtotal * discountPercent / 100;
                double amountDue = subtotal - discountAmount;
                double difference = tendered - amountDue;
                System.out.println("\n================ CUSTOMER RECEIPT ================");
                System.out.println("Customer: " + name + " | ID: " + id);
                System.out.printf("%-20s %8s %12s %12s%n", "Item", "Quantity", "Price", "Total");
                for (int i = 0; i < 3; i++) {
                    System.out.printf("%-20s %8d %12.2f %12.2f%n",
                            itemNames[i], quantities[i], prices[i], quantities[i] * prices[i]);
                }
                System.out.printf("Subtotal:                 %.2f%n", subtotal);
                System.out.printf("Discount (%.2f%%):         %.2f%n", discountPercent, discountAmount);
                System.out.printf("Total Amount Due:          %.2f%n", amountDue);
                System.out.printf("Amount Tendered:           %.2f%n", tendered);
                if (difference >= 0) {
                    System.out.printf("Change:                    %.2f%n", difference);
                } else {
                    System.out.printf("Remaining Balance:         %.2f%n", -difference);
                }
                System.out.println("==================================================");
    }
    // Activity 21: Event Ticketing System
    public static void activity21(Scanner input) {
        System.out.println("=== EVENT TICKETING SYSTEM ===");
                System.out.print("Customer name: ");
                String name = input.nextLine();
                System.out.print("Customer ID: ");
                String id = input.nextLine();
                System.out.print("Event name: ");
                String event = input.nextLine();
                System.out.print("Ticket type (Regular/VIP): ");
                String ticketType = input.nextLine();
                System.out.print("Ticket price: ");
                double price = input.nextDouble();
                System.out.print("Number of tickets: ");
                int quantity = input.nextInt();
                System.out.print("Discount percentage: ");
                double discountPercent = input.nextDouble();
                System.out.print("Amount tendered: ");
                double tendered = input.nextDouble();
                double totalCost = price * quantity;
                double discountAmount = totalCost * discountPercent / 100;
                double amountDue = totalCost - discountAmount;
                double difference = tendered - amountDue;
                System.out.println("\n================ EVENT TICKET ================");
                System.out.println("Customer: " + name);
                System.out.println("Customer ID: " + id);
                System.out.println("Event: " + event);
                System.out.println("Ticket Type: " + ticketType);
                System.out.printf("Ticket Price:           %.2f%n", price);
                System.out.println("Number of Tickets: " + quantity);
                System.out.printf("Total Ticket Cost:      %.2f%n", totalCost);
                System.out.printf("Discount (%.2f%%):       %.2f%n", discountPercent, discountAmount);
                System.out.printf("Final Amount Due:       %.2f%n", amountDue);
                System.out.printf("Amount Tendered:        %.2f%n", tendered);
                if (difference >= 0) {
                    System.out.printf("Change:                 %.2f%n", difference);
                } else {
                    System.out.printf("Remaining Balance:      %.2f%n", -difference);
                }
                System.out.println("==============================================");
    }
    // Activity 22: Reservation and Billing System
    public static void activity22(Scanner input) {
        System.out.println("=== RESERVATION AND BILLING SYSTEM ===");
                System.out.print("Customer name: ");
                String name = input.nextLine();
                System.out.print("Customer ID: ");
                String id = input.nextLine();
                System.out.print("Reservation type (Room/Cottage/Table): ");
                String type = input.nextLine();
                System.out.print("Number of days or hours reserved: ");
                double duration = input.nextDouble();
                System.out.print("Rate per day or hour: ");
                double rate = input.nextDouble();
                System.out.print("Food charges: ");
                double food = input.nextDouble();
                System.out.print("Service charges: ");
                double service = input.nextDouble();
                System.out.print("Other charges: ");
                double other = input.nextDouble();
                System.out.print("Discount percentage: ");
                double discountPercent = input.nextDouble();
                System.out.print("Down payment: ");
                double downPayment = input.nextDouble();
                double reservationCost = duration * rate;
                double subtotal = reservationCost + food + service + other;
                double discountAmount = subtotal * discountPercent / 100;
                double totalBill = subtotal - discountAmount;
                double balance = totalBill - downPayment;
                System.out.println("\n============= RESERVATION BILL =============");
                System.out.println("Customer: " + name);
                System.out.println("Customer ID: " + id);
                System.out.println("Reservation Type: " + type);
                System.out.println("Duration: " + duration);
                System.out.printf("Rate:                    %.2f%n", rate);
                System.out.printf("Reservation Cost:        %.2f%n", reservationCost);
                System.out.printf("Food Charges:            %.2f%n", food);
                System.out.printf("Service Charges:         %.2f%n", service);
                System.out.printf("Other Charges:           %.2f%n", other);
                System.out.printf("Subtotal:                %.2f%n", subtotal);
                System.out.printf("Discount (%.2f%%):        %.2f%n", discountPercent, discountAmount);
                System.out.printf("Total Bill:              %.2f%n", totalBill);
                System.out.printf("Down Payment:            %.2f%n", downPayment);
                if (balance >= 0) {
                    System.out.printf("Remaining Balance:       %.2f%n", balance);
                } else {
                    System.out.printf("Overpayment:             %.2f%n", -balance);
                }
                System.out.println("=============================================");
    }
    // Activity 23: Car Rental System
    public static void activity23(Scanner input) {
        System.out.println("=== CAR RENTAL SYSTEM ===");
                System.out.print("Customer name: ");
                String name = input.nextLine();
                System.out.print("Customer ID: ");
                String id = input.nextLine();
                System.out.print("Driver's license number: ");
                String license = input.nextLine();
                System.out.print("Vehicle type: ");
                String vehicleType = input.nextLine();
                System.out.print("Vehicle model: ");
                String model = input.nextLine();
                System.out.print("Rental rate per day: ");
                double rate = input.nextDouble();
                input.nextLine();
                System.out.print("Pickup date (YYYY-MM-DD): ");
                LocalDate pickupDate = LocalDate.parse(input.nextLine());
                System.out.print("Return date (YYYY-MM-DD): ");
                LocalDate returnDate = LocalDate.parse(input.nextLine());
                long days = ChronoUnit.DAYS.between(pickupDate, returnDate);
                if (days < 1) {
                    days = 1;
                }
                System.out.print("Insurance fee: ");
                double insurance = input.nextDouble();
                System.out.print("Fuel charge: ");
                double fuel = input.nextDouble();
                System.out.print("Other charges: ");
                double other = input.nextDouble();
                System.out.print("Discount percentage: ");
                double discountPercent = input.nextDouble();
                System.out.print("Amount paid: ");
                double amountPaid = input.nextDouble();
                double rentalCost = rate * days;
                double subtotal = rentalCost + insurance + fuel + other;
                double discountAmount = subtotal * discountPercent / 100;
                double totalDue = subtotal - discountAmount;
                double difference = amountPaid - totalDue;
                System.out.println("\n============== CAR RENTAL RECEIPT ==============");
                System.out.println("Customer: " + name);
                System.out.println("Customer ID: " + id);
                System.out.println("Driver's License: " + license);
                System.out.println("Vehicle: " + vehicleType + " - " + model);
                System.out.printf("Rate per Day:            %.2f%n", rate);
                System.out.println("Pickup Date: " + pickupDate);
                System.out.println("Return Date: " + returnDate);
                System.out.println("Rental Days: " + days);
                System.out.printf("Rental Cost:             %.2f%n", rentalCost);
                System.out.printf("Insurance Fee:           %.2f%n", insurance);
                System.out.printf("Fuel Charge:             %.2f%n", fuel);
                System.out.printf("Other Charges:           %.2f%n", other);
                System.out.printf("Subtotal:                %.2f%n", subtotal);
                System.out.printf("Discount (%.2f%%):        %.2f%n", discountPercent, discountAmount);
                System.out.printf("Total Amount Due:        %.2f%n", totalDue);
                System.out.printf("Amount Paid:             %.2f%n", amountPaid);
                if (difference >= 0) {
                    System.out.printf("Change:                  %.2f%n", difference);
                } else {
                    System.out.printf("Remaining Balance:       %.2f%n", -difference);
                }
                System.out.println("================================================");
    }
     public static void activity24(Scanner input) {
        System.out.println("=== RESTAURANT ORDERING SYSTEM ===");
                System.out.print("Customer name: ");
                String name = input.nextLine();
                System.out.print("Order type (Dine-In/Takeout): ");
                String orderType = input.nextLine();
                String[] itemNames = new String[3];
                int[] quantities = new int[3];
                double[] prices = new double[3];
                double subtotal = 0;
        
                for (int i = 0; i < 3; i++) {
                    System.out.println("\nItem " + (i + 1));
                    System.out.print("Item name: ");
                    itemNames[i] = input.nextLine();
                    System.out.print("Quantity: ");
                    quantities[i] = input.nextInt();
                    System.out.print("Price per item: ");
                    prices[i] = input.nextDouble();
                    input.nextLine();
                    subtotal += quantities[i] * prices[i];
                }
                System.out.print("Service charge (enter 0 for Takeout): ");
                double serviceCharge = input.nextDouble();
                System.out.print("Packaging fee (enter 0 for Dine-In): ");
                double packagingFee = input.nextDouble();
                System.out.print("Discount percentage: ");
                double discountPercent = input.nextDouble();
                System.out.print("Amount tendered: ");
                double tendered = input.nextDouble();
                double applicableCharge;
                if (orderType.equalsIgnoreCase("Dine-In")) {
                    applicableCharge = serviceCharge;
                } else {
                    applicableCharge = packagingFee;
                }
                double beforeDiscount = subtotal + applicableCharge;
                double discountAmount = beforeDiscount * discountPercent / 100;
                double amountDue = beforeDiscount - discountAmount;
                double difference = tendered - amountDue;
                System.out.println("\n============= RESTAURANT RECEIPT =============");
                System.out.println("Customer: " + name);
                System.out.println("Order Type: " + orderType);
                System.out.printf("%-20s %8s %12s %12s%n", "Item", "Quantity", "Price", "Total");
                for (int i = 0; i < 3; i++) {
                    System.out.printf("%-20s %8d %12.2f %12.2f%n",
                            itemNames[i], quantities[i], prices[i], quantities[i] * prices[i]);
                }
                System.out.printf("Subtotal:                       %.2f%n", subtotal);
                System.out.printf("Service/Packaging Charge:        %.2f%n", applicableCharge);
                System.out.printf("Total Before Discount:           %.2f%n", beforeDiscount);
                System.out.printf("Discount (%.2f%%):                %.2f%n", discountPercent, discountAmount);
                System.out.printf("Total Amount Due:                %.2f%n", amountDue);
                System.out.printf("Amount Tendered:                 %.2f%n", tendered);
                if (difference >= 0) {
                    System.out.printf("Change:                          %.2f%n", difference);
                } else {
                    System.out.printf("Remaining Balance:               %.2f%n", -difference);
                }
                System.out.println("===============================================");
    }
    // Activity 25: Flower Reservation Billing
    public static void activity25(Scanner input) {
        System.out.println("=== FLOWER RESERVATION SYSTEM ===");
                System.out.print("Customer name: ");
                String name = input.nextLine();
                System.out.print("Customer ID: ");
                String id = input.nextLine();
                System.out.print("Contact number: ");
                String contact = input.nextLine();
                System.out.print("Flower type: ");
                String flowerType = input.nextLine();
                System.out.print("Arrangement type: ");
                String arrangement = input.nextLine();
                System.out.print("Price per arrangement: ");
                double price = input.nextDouble();
                System.out.print("Quantity: ");
                int quantity = input.nextInt();
                input.nextLine();
                System.out.print("Reservation date (YYYY-MM-DD): ");
                String reservationDate = input.nextLine();
                System.out.print("Pickup/delivery date (YYYY-MM-DD): ");
                String pickupDate = input.nextLine();
                System.out.print("Delivery fee: ");
                double delivery = input.nextDouble();
                System.out.print("Customization fee: ");
                double customization = input.nextDouble();
                System.out.print("Other charges: ");
                double other = input.nextDouble();
                System.out.print("Discount percentage: ");
                double discountPercent = input.nextDouble();
                System.out.print("Down payment: ");
                double downPayment = input.nextDouble();
                double reservationCost = price * quantity;
                double subtotal = reservationCost + delivery + customization + other;
                double discountAmount = subtotal * discountPercent / 100;
                double totalBill = subtotal - discountAmount;
                double balance = totalBill - downPayment;
                System.out.println("\n========== FLOWER RESERVATION RECEIPT ==========");
                System.out.println("Customer: " + name);
                System.out.println("Customer ID: " + id);
                System.out.println("Contact Number: " + contact);
                System.out.println("Flower Type: " + flowerType);
                System.out.println("Arrangement Type: " + arrangement);
                System.out.println("Quantity: " + quantity);
                System.out.printf("Price per Arrangement:       %.2f%n", price);
                System.out.printf("Reservation Cost:            %.2f%n", reservationCost);
                System.out.println("Reservation Date: " + reservationDate);
                System.out.println("Pickup/Delivery Date: " + pickupDate);
                System.out.printf("Delivery Fee:                %.2f%n", delivery);
                System.out.printf("Customization Fee:           %.2f%n", customization);
                System.out.printf("Other Charges:               %.2f%n", other);
                System.out.printf("Subtotal:                    %.2f%n", subtotal);
                System.out.printf("Discount (%.2f%%):            %.2f%n", discountPercent, discountAmount);
                System.out.printf("Total Bill:                  %.2f%n", totalBill);
                System.out.printf("Down Payment:                %.2f%n", downPayment);
                if (balance >= 0) {
                    System.out.printf("Remaining Balance:           %.2f%n", balance);
                } else {
                    System.out.printf("Overpayment:                 %.2f%n", -balance);
                }
                System.out.println("================================================");
    }
    // Activity 26: KMART Korean Noodles Billing
    public static void activity26(Scanner input) {
        System.out.println("=== KMART KOREAN NOODLES BILLING ===");
                System.out.print("Customer name: ");
                String name = input.nextLine();
                System.out.print("Customer ID: ");
                String id = input.nextLine();
                System.out.print("Contact number: ");
                String contact = input.nextLine();
                System.out.print("Product name: ");
                String product = input.nextLine();
                System.out.print("Brand: ");
                String brand = input.nextLine();
                System.out.print("Price per pack: ");
                double price = input.nextDouble();
                System.out.print("Quantity: ");
                int quantity = input.nextInt();
                System.out.print("Packaging fee: ");
                double packaging = input.nextDouble();
                System.out.print("Delivery fee: ");
                double delivery = input.nextDouble();
                System.out.print("Discount percentage: ");
                double discountPercent = input.nextDouble();
                System.out.print("Cash payment: ");
                double cash = input.nextDouble();
                double productCost = price * quantity;
                double subtotal = productCost + packaging + delivery;
                double discountAmount = subtotal * discountPercent / 100;
                double totalBill = subtotal - discountAmount;
                double difference = cash - totalBill;
                System.out.println("\n============= KMART PURCHASE RECEIPT =============");
                System.out.println("Customer: " + name);
                System.out.println("Customer ID: " + id);
                System.out.println("Contact Number: " + contact);
                System.out.println("Product: " + product);
                System.out.println("Brand: " + brand);
                System.out.printf("Price per Pack:          %.2f%n", price);
                System.out.println("Quantity: " + quantity);
                System.out.printf("Total Product Cost:      %.2f%n", productCost);
                System.out.printf("Packaging Fee:           %.2f%n", packaging);
                System.out.printf("Delivery Fee:            %.2f%n", delivery);
                System.out.printf("Subtotal:                %.2f%n", subtotal);
                System.out.printf("Discount (%.2f%%):        %.2f%n", discountPercent, discountAmount);
                System.out.printf("Total Bill:              %.2f%n", totalBill);
                System.out.printf("Cash Payment:            %.2f%n", cash);
                if (difference >= 0) {
                    System.out.printf("Change:                  %.2f%n", difference);
                } else {
                    System.out.printf("Remaining Balance:       %.2f%n", -difference);
                }
                System.out.println("===================================================");
    }
    // Activity 27: Parking Reservation Billing
    public static void activity27(Scanner input) {
        System.out.println("=== PARKING RESERVATION AND BILLING ===");
                System.out.print("Customer name: ");
                String name = input.nextLine();
                System.out.print("Customer ID: ");
                String id = input.nextLine();
                System.out.print("Contact number: ");
                String contact = input.nextLine();
                System.out.print("Vehicle type (Car/Motorcycle): ");
                String vehicleType = input.nextLine();
                System.out.print("Plate number: ");
                String plate = input.nextLine();
                System.out.print("Entry time (HH:MM): ");
                LocalTime entryTime = LocalTime.parse(input.nextLine());
                System.out.print("Exit time (HH:MM): ");
                LocalTime exitTime = LocalTime.parse(input.nextLine());
                long minutes = Duration.between(entryTime, exitTime).toMinutes();
                if (minutes < 0) {
                    minutes += 24 * 60;
                }
                long hours = (minutes + 59) / 60;
                System.out.print("Hourly rate: ");
                double hourlyRate = input.nextDouble();
                System.out.print("Reservation fee: ");
                double reservationFee = input.nextDouble();
                System.out.print("Overnight fee: ");
                double overnightFee = input.nextDouble();
                System.out.print("Penalty fee: ");
                double penaltyFee = input.nextDouble();
                System.out.print("Discount percentage: ");
                double discountPercent = input.nextDouble();
                System.out.print("Cash payment: ");
                double cash = input.nextDouble();
                double parkingFee = hours * hourlyRate;
                double subtotal = parkingFee + reservationFee + overnightFee + penaltyFee;
                double discountAmount = subtotal * discountPercent / 100;
                double totalBill = subtotal - discountAmount;
                double difference = cash - totalBill;
                System.out.println("\n================ PARKING RECEIPT ================");
                System.out.println("Customer: " + name);
                System.out.println("Customer ID: " + id);
                System.out.println("Contact Number: " + contact);
                System.out.println("Vehicle Type: " + vehicleType);
                System.out.println("Plate Number: " + plate);
                System.out.println("Entry Time: " + entryTime);
                System.out.println("Exit Time: " + exitTime);
                System.out.println("Total Parking Hours: " + hours);
                System.out.printf("Hourly Rate:            %.2f%n", hourlyRate);
                System.out.printf("Parking Fee:            %.2f%n", parkingFee);
                System.out.printf("Reservation Fee:        %.2f%n", reservationFee);
                System.out.printf("Overnight Fee:          %.2f%n", overnightFee);
                System.out.printf("Penalty Fee:            %.2f%n", penaltyFee);
                System.out.printf("Subtotal:               %.2f%n", subtotal);
                System.out.printf("Discount (%.2f%%):       %.2f%n", discountPercent, discountAmount);
                System.out.printf("Total Bill:             %.2f%n", totalBill);
                System.out.printf("Cash Payment:           %.2f%n", cash);
                if (difference >= 0) {
                    System.out.printf("Change:                 %.2f%n", difference);
                } else {
                    System.out.printf("Remaining Balance:      %.2f%n", -difference);
                }
                System.out.println("==================================================");
    }
} 