# PRINCE GODFREY S. PEPITO BSCS 2-Y1-1 
# PROGRAM 1: MIDTERM LAB EXAM 

class Book():
    def __init__(self, title, author, price):
        self.title = title
        self.author = author
        self.price = price

    def __str__(self):
        return f"Book: {self.title} | Author: {self.author} \nPrice: PHP {self.price:.2f}"


class EBook(Book):
    def __init__(self, title, author, price, file_size_mb):
        super().__init__(title, author, price)
        self.file_size_mb = file_size_mb

    def __str__(self):
        return f"Book: {self.title} | Author: {self.author} \nPrice: PHP {self.price:.2f} | File size: {self.file_size_mb}MB"


# PRINCE GODFREY S. PEPITO BSCS 2-Y1-1 
# PROGRAM 2: MIDTERM LAB EXAM 

class Student():
    def __init__(self, name, student_id, tuition_fee):
        self.name = name
        self.student_id = student_id
        self.tuition_fee = tuition_fee

    def __str__(self):
        return (
            f"Name: {self.name} | Student ID: {self.student_id} \n"
            f"Tuition fee: PHP {self.tuition_fee:.2f}"
        )


class ScholarStudent(Student):
    def __init__(self, name, student_id, tuition_fee, scholarship_percentage):
        super().__init__(name, student_id, tuition_fee)
        
        if not (0 <= scholarship_percentage <= 100):
            raise ValueError("Value error! Only accepts percentage 0 - 100")
            
        self.scholarship_percentage = scholarship_percentage

    def calculate_payable_fee(self):
        return self.tuition_fee - (self.tuition_fee * self.scholarship_percentage / 100)

    def __str__(self):
        return (
            f"Name: {self.name} | Student ID: {self.student_id} \n"
            f"Tuition fee: PHP {self.tuition_fee:.2f} \n"
            f"Scholarship: {self.scholarship_percentage}% \n"
            f"Payable fee: PHP {self.calculate_payable_fee():.2f}"
        )


def main():
    books = [
        Book("Python Basics", "Maria Santos", 450),
        EBook("Learning OOP", "Ana Cruz", 300, 5),
        EBook("Learning PLNG", "Juan Dela Cruz", 450, 25)
    ]

    try:
        students = [
            Student("Carlo Reyes", "2026-001", 40000),
            ScholarStudent("Prince Pepito", "2026-002", 48000, 67)
        ]

        print("=======BOOK LIST=======")
        for book in books:
            print(book)
            print()

        print("=======STUDENTS LIST=======")
        for student in students:
            print(student)
            print()

    except ValueError as e:
        print(f"Initialization Failed: {e}")


if __name__ == "__main__":
    main()
