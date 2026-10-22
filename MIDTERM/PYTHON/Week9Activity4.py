# PRINCE GODFREY S. PEPITO              BSCS 2-Y1-1
# ACTIVITY 4: MIDTERM LAB ACTIVITY - 4

import random
import time


# ==========================
# INPUT HELPERS
# ==========================
def read_int(prompt):
    return int(input(prompt))


def read_float(prompt):
    return float(input(prompt))


# ==========================
# PROGRAM 1: BANKING SYSTEM
# ==========================
def banking_program():
    choices = 0
    balance = 0.0
    balance_initialized = False

    while True:
        try:
            if not balance_initialized:
                balance = read_float("Enter your initial balance: ")
                balance_initialized = True

            print("\n--- Banking Menu ---")
            print("1. Withdraw Amount ")
            print("2. Deposit Amount")
            print("3. Back to Main Menu")
            print("4. Re-enter Initial Balance")
            choices = read_int("Enter your choice: ")

            if choices == 1:
                balance = withdraw(balance)
            elif choices == 2:
                balance = deposit(balance)
            elif choices == 3:
                print("Returning to main menu...")
                return
            elif choices == 4:
                print("Reseting balance... Please wait a moment.")

                random_delay = random.randint(2, 6)
                print("Processing request...")

                for i in range(random_delay, 0, -1):
                    print(f"Please wait {i} seconds...")
                    time.sleep(1)  # Sleep for 1 second

                print("Balance reset successful. Please re-enter your initial balance.")
                balance_initialized = False  # Ask for the balance again
            else:
                print("Error: Invalid Choice. Please select a valid option.")
        except ValueError:
            print("Error: Invalid input. Numeric values only.")


def withdraw(balance):
    print("How much do you want to withdraw?")
    withdraw_amount = read_float("Amount: ")
    if withdraw_amount > balance:
        print("Error: Insufficient funds.")
    else:
        balance -= withdraw_amount
        print(f"Your new balance is: {balance}")
    return balance


def deposit(balance):
    print("How much do you want to deposit?")
    deposit_amount = read_float("Amount: ")
    balance += deposit_amount
    print(f"Your new balance is: {balance}")
    return balance


# ================================================
# PROGRAM 2 CLASSES: HOSPITAL DATABASE STRUCTURES
# ================================================

# Structure to store the date (day, month, year)
class DateStructure:
    def __init__(self, day, month, year):
        self.day = day
        self.month = month
        self.year = year

    def __str__(self):
        return f"{self.day}/{self.month}/{self.year}"


# Base Class: Stores general patient details
class Patient:
    def __init__(self):
        self.name = ""
        self.date_of_admission = None
        self.disease = ""
        self.date_of_discharge = None

    # Member function to enter general patient info
    def enter_information(self):
        self.name = input("Enter Patient Name: ")

        print("Enter Date of Admission:")
        add_day = read_int("  Day (DD): ")
        add_month = read_int("  Month (MM): ")
        add_year = read_int("  Year (YYYY): ")
        self.date_of_admission = DateStructure(add_day, add_month, add_year)

        self.disease = input("Enter Disease/Diagnosis: ")

        print("Enter Date of Discharge:")
        dis_day = read_int("  Day (DD): ")
        dis_month = read_int("  Month (MM): ")
        dis_year = read_int("  Year (YYYY): ")
        self.date_of_discharge = DateStructure(dis_day, dis_month, dis_year)

    # Member function to display general patient details
    def display_information(self):
        print(f"Name: {self.name}")
        print(f"Admitted On: {self.date_of_admission}")
        print(f"Disease: {self.disease}")
        print(f"Discharged On: {self.date_of_discharge}")


# Derived Class: Extends Patient to add and manage age records
class DetailedPatient(Patient):
    def __init__(self):
        super().__init__()
        self.age = 0

    def enter_information(self):
        super().enter_information()  # Call parent input logic
        self.age = read_int("Enter Patient Age: ")

    def display_information(self):
        super().display_information()  # Call parent display logic
        print(f"Age: {self.age} years old")
        print("---------------------------------------")


# ======================================
# PROGRAM 2 EXECUTION: HOSPITAL PROGRAM
# ======================================
def hospital_database_program():
    database = []
    menu_choice = 0

    while menu_choice != 4:
        try:
            print("\n===== HOSPITAL INDOOR PATIENT DATABASE =====")
            print("1. Add New Patient Records")
            print("2. Display All Patients")
            print("3. List Pediatric Patients (Age < 12)")
            print("4. Back to Main Menu")
            menu_choice = read_int("Choose an option: ")

            if menu_choice == 1:
                count = read_int("How many patient records do you want to add? ")
                for i in range(count):
                    print(f"\n--- Entering Details for Patient #{i + 1} ---")
                    p = DetailedPatient()
                    p.enter_information()
                    database.append(p)
            elif menu_choice == 2:
                if not database:
                    print("The database is currently empty.")
                else:
                    print("\n===== ALL PATIENT RECORDS =====")
                    print("---------------------------------------")
                    for p in database:
                        p.display_information()
            elif menu_choice == 3:
                print("\n===== PEDIATRIC PATIENTS LIST (< 12 Years Old) =====")
                print("---------------------------------------")
                found_pediatric = False

                for p in database:
                    if p.age < 12:
                        p.display_information()
                        found_pediatric = True

                if not found_pediatric:
                    print("No pediatric patients found matching this criteria.")
            elif menu_choice == 4:
                print("Returning to main application selector...")
            else:
                print("Invalid input. Please choose a valid option.")
        except ValueError:
            print("Error: Invalid input. Numeric values only.")
            menu_choice = 0


# ================================================
# PROGRAM 3 CLASSES: UNIVERSITY RANKING PROGRAM
# ================================================
class Professor:
    def __init__(self, name, salary):
        self.__name = name
        self.__salary = salary

    def get_name(self):
        return self.__name

    def get_salary(self):
        return self.__salary


class Dean(Professor):
    def __init__(self, name, salary, department):
        super().__init__(name, salary)
        self.__department = department

    def get_department(self):
        return self.__department

    def _details(self):
        return (f"Name: {self.get_name()}\n"
                f"Department: {self.__department}\n"
                f"Salary: {int(self.get_salary())}")

    def __str__(self):
        return "Status\nRank: Dean\n" + self._details()


class Executive(Dean):
    def __init__(self, name, salary, department):
        super().__init__(name, salary, department)

    def __str__(self):
        return "Status\nRank: Executive\n" + self._details()


def univ_ranking_program():
    choices = 0

    while choices != 2:
        try:
            print("\n--- University Ranking Menu ---")
            print("1. Enter and Display Dean and Executive Details")
            print("2. Back to Main Menu")
            choices = read_int("Enter your choice: ")

            if choices == 1:
                print("\n--- Enter Dean Details ---")
                dean_name = input("Name: ")
                dean_dept = input("Department: ")
                dean_salary = read_float("Salary: ")

                print("\n--- Enter Executive Details ---")
                exec_name = input("Name: ")
                exec_dept = input("Department: ")
                exec_salary = read_float("Salary: ")

                dean = Dean(dean_name, dean_salary, dean_dept)
                executive = Executive(exec_name, exec_salary, exec_dept)

                print()
                print(dean)
                print("----------------------------------------")
                print(executive)
            elif choices == 2:
                print("Returning to main menu...")
            else:
                print("Error: Invalid Choice")
        except ValueError:
            print("Error: Invalid input. Numeric values only.")
            choices = 0


# ==========
# MAIN MENU
# ==========
def main():
    main_menu_choice = 0

    while main_menu_choice != 4:
        try:
            print("\n===== MAIN MENU =====")
            print("1. Banking Program (Program 1)")
            print("2. Hospital Database Program (Program 2)")
            print("3. University Hierarchy Program (Program 3)")
            print("4. Exit Application")
            main_menu_choice = read_int("Select which program to run: ")

            if main_menu_choice == 1:
                banking_program()
            elif main_menu_choice == 2:
                hospital_database_program()
            elif main_menu_choice == 3:
                univ_ranking_program()
            elif main_menu_choice == 4:
                print("Exiting application. Goodbye!")
            else:
                print("Invalid selection. Try again.")
        except ValueError:
            print("Error: Invalid input. Please enter a number.")
            main_menu_choice = 0


if __name__ == "__main__":
    main()