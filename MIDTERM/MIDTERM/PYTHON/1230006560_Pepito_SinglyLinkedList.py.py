
# PRINCE GODFREY S. PEPITO              BSCS 2-Y1-1
# ACTIVITY 5: MIDTERM LAB ACTIVITY - 5
# PART A: SINGLY LINKED LIST

class CustomerNode:
    def __init__(self, name):
        self.name = name
        self.next = None


class WaitingList:
    def __init__(self):
        self.head = None
        self.tail = None

    # Add customer at the end
    def add_customer(self, name):
        new_customer = CustomerNode(name)

        if self.head is None:
            self.head = new_customer
            self.tail = new_customer
        else:
            self.tail.next = new_customer
            self.tail = new_customer

        print("Customer added:", name)

    # Remove and return the first customer
    def serve_customer(self):
        if self.head is None:
            print("The waiting list is empty.")
            return None

        served = self.head.name
        self.head = self.head.next

        if self.head is None:
            self.tail = None

        print("Served:", served)
        return served

    # Remove the first matching customer
    def cancel_customer(self, name):
        if self.head is None:
            print("The waiting list is empty.")
            return False

        if self.head.name == name:
            self.head = self.head.next

            if self.head is None:
                self.tail = None

            print("Cancelled:", name)
            return True

        previous = self.head
        current = self.head.next

        while current is not None:
            if current.name == name:
                previous.next = current.next

                if current == self.tail:
                    self.tail = previous

                print("Cancelled:", name)
                return True

            previous = current
            current = current.next

        print("Customer not found:", name)
        return False

    # Display customers from head to tail
    def display_waiting(self):
        if self.head is None:
            print("Waiting list is empty.")
            return

        current = self.head
        print("Waiting:", end=" ")

        while current is not None:
            print(current.name, end=" -> ")
            current = current.next

        print("None")

    # Count customers by traversing the nodes
    def count_customers(self):
        count = 0
        current = self.head

        while current is not None:
            count += 1
            current = current.next

        print("Customers waiting:", count)
        return count


def main():
    waiting_list = WaitingList()

    while True:
        print("\n======= CAMPUS SERVICE WAITING LIST =======")
        print("1. Add customer")
        print("2. Serve customer")
        print("3. Cancel customer")
        print("4. Display waiting list")
        print("5. Count customers")
        print("0. Exit")

        choice = input("Enter your choice: ").strip()

        match choice:
            case "1":
                name = input("Enter customer name: ").strip()

                if name:
                    waiting_list.add_customer(name)
                else:
                    print("Customer name cannot be empty.")

            case "2":
                waiting_list.serve_customer()

            case "3":
                name = input("Enter customer name to cancel: ").strip()

                if name:
                    waiting_list.cancel_customer(name)
                else:
                    print("Customer name cannot be empty.")

            case "4":
                waiting_list.display_waiting()

            case "5":
                waiting_list.count_customers()

            case "0":
                print("Exiting waiting list program. Goodbye!")
                break

            case _:
                print("Invalid option. Please try again.")


if __name__ == "__main__":
    main()
