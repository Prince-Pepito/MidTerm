tickets = []
next_ticket_id = 1
priority_streak = 0
counters = {1: None, 2: None} 

def issue_ticket(purpose, service_type="regular"):
    global next_ticket_id

    purpose = purpose.strip().title()
    service_type = service_type.strip().lower()

    if purpose not in ["Enrollment", "Records", "Payment"]:
        print("Invalid purpose. Choose Enrollment, Records, or Payment.")
        return None
    if service_type not in ["regular", "priority"]:
        print("Invalid service type. Choose regular or priority.")
        return None

    ticket = {
        "id": next_ticket_id,
        "purpose": purpose,
        "type": service_type,
        "status": "waiting",
        "counter": None
    }
    tickets.append(ticket)
    next_ticket_id += 1
    return ticket["id"]

def issue_many(*requests):
    issued_ids = []
    for purpose, service_type in requests:
        tid = issue_ticket(purpose, service_type)
        if tid:
            issued_ids.append(tid)
    return issued_ids

def next_ticket(waiting_list, streak):
    if not waiting_list:
        return None, streak

    priorities = [t for t in waiting_list if t["type"] == "priority"]
    regulars = [t for t in waiting_list if t["type"] == "regular"]

    if priorities and regulars:
        if streak >= 2:
            return regulars[0], 0
        else:
            return priorities[0], streak + 1
            
    if priorities:
        return priorities[0], streak + 1
    if regulars:
        return regulars[0], 0

    return None, streak

def report(**kwargs):
    print("\n===== QUEUE SYSTEM REPORT =====")
    for key, value in kwargs.items():
        print(f"• {key.replace('_', ' ').title()}: {value}")
    print("===============================")

class WaitingTicketIterator:
    def __init__(self, tickets_list):
        self.tickets = tickets_list
        self.index = 0

    def __iter__(self):
        return self

    def __next__(self):
        while self.index < len(self.tickets):
            t = self.tickets[self.index]
            self.index += 1
            if t["status"] == "waiting":
                return t
        raise StopIteration

def main():
    global priority_streak
    
    while True:
        print("\n--- CAMPUS QUEUE MANAGER ---")
        print("1. Issue a ticket")
        print("2. Call the next ticket")
        print("3. Complete a service")
        print("4. Cancel a waiting ticket")
        print("5. Show waiting tickets (Using Iterator)")
        print("6. Show counter status and history")
        print("7. Show a summary report")
        print("8. Exit")
        
        choice = input("Select an option (1-8): ").strip()
        
        if choice == "1":
            purpose = input("Enter purpose (Enrollment/Records/Payment): ").strip()
            stype = input("Enter type (regular/priority) [Press Enter for regular]: ").strip()
            if not stype: 
                stype = "regular"
                
            tid = issue_ticket(purpose, stype)
            if tid:
                waiting = [t for t in tickets if t["status"] == "waiting"]
                print(f"Ticket #{tid} issued! Estimated wait position: {len(waiting)}")

        elif choice == "2":
            free_counter = None
            for num in range(1, 3):
                if counters[num] is None:
                    free_counter = num
                    break
                    
            if free_counter is None:
                print("All counters are busy right now.")
                continue
                
            waiting = [t for t in tickets if t["status"] == "waiting"]
            ticket_to_call, priority_streak = next_ticket(waiting, priority_streak)
            
            if ticket_to_call:
                ticket_to_call["status"] = "served"
                ticket_to_call["counter"] = free_counter
                counters[free_counter] = ticket_to_call
                print(f"Ticket #{ticket_to_call['id']} sent to Counter {free_counter}!")
            else:
                print("The waiting queue is empty.")

        elif choice == "3":
            cnum = input("Enter counter number to clear (1 or 2): ").strip()
            if cnum not in ["1", "2"]:
                print("Invalid counter number.")
                continue
                
            cnum = int(cnum)
            if counters[cnum] is None:
                print("That counter is already empty.")
            else:
                done = counters[cnum]
                counters[cnum] = None
                print(f"Completed service for Ticket #{done['id']}!")

        elif choice == "4":
            tid_str = input("Enter ticket ID to cancel: ").strip()
            if not tid_str.isdigit():
                print("Ticket ID must be a number.")
                continue
                
            target_id = int(tid_str)
            found = False
            for t in tickets:
                if t["id"] == target_id:
                    found = True
                    if t["status"] == "waiting":
                        t["status"] = "cancelled"
                        print(f"Ticket #{target_id} has been cancelled.")
                    else:
                        print("This ticket is not in waiting status.")
            if not found:
                print("Ticket not found.")

        elif choice == "5":
            print("\n--- Current Waiting Line ---")
            iterator = WaitingTicketIterator(tickets)
            count = 0
            while True:
                try:
                    t = next(iterator)
                    count += 1
                    print(f"Position {count} -> Ticket #{t['id']} [{t['type'].upper()}] for {t['purpose']}")
                except StopIteration:
                    break
            if count == 0:
                print("No students are waiting.")

        elif choice == "6":
            print("\n--- Counter Status ---")
            for num in range(1, 3):
                status = f"BUSY with Ticket #{counters[num]['id']}" if counters[num] else "FREE"
                print(f"Counter {num}: {status}")
                
            print("\n--- Completed History ---")
            history = [t for t in tickets if t["status"] == "served" and t not in counters.values()]
            for t in history:
                print(f"• Ticket #{t['id']} completed at Counter {t['counter']}")

        elif choice == "7":
            report(
                waiting_count=len([t for t in tickets if t["status"] == "waiting"]),
                served_count=len([t for t in tickets if t["status"] == "served"]),
                cancelled_count=len([t for t in tickets if t["status"] == "cancelled"])
            )

        elif choice == "8":
            print("Exiting. Goodbye!")
            break
        else:
            print("Invalid menu choice.")

print("--- RUNNING LOGIC TESTS ---")
issue_ticket("Enrollment", "priority")
issue_ticket("Records", "priority")   
issue_ticket("Payment", "regular")     
test_waiting = [t for t in tickets if t["status"] == "waiting"]

pick1, _ = next_ticket(test_waiting, 0)
pick2, _ = next_ticket(test_waiting, 1)
pick3, _ = next_ticket(test_waiting, 2)
assert pick3["id"] == 3
print("Core Fairness Logic Test Passed!")

tickets.clear()
if __name__ == "__main__":
    main()