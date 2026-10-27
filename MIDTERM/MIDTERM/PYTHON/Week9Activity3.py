# PRINCE GODFREY S. PEPITO              BSCS 2-Y1-1
# MIDTERM LAB ACTIVITY - 3 
# PROGRAM 1: Chapter 12: Bytes and Bytearray
# PROGRAM 2: Name Analyzer

def program_1():
    print("------- PROGRAM 1 -------")
    
    message = "Hello Python"
    
    bytes_obj = message.encode('utf-8')
    
    string_obj = bytes_obj.decode('utf-8')
    
    hex_string = bytes_obj.hex()
    
    bytes_from_hex = bytes.fromhex(hex_string)
    
    bytearray_direct = bytearray(message, 'utf-8')
    
    bytearray_from_bytes = bytearray(bytes_obj)
    
    sliced_bytes = bytes_obj[6:]
    
    decoded_modified = bytearray_from_bytes.decode('utf-8')
    
    print(f"1. Bytes to Object: {bytes_obj}")
    print(f"2. Bytes to String: {string_obj}")
    print(f"3. Bytes to hex: {hex_string}")
    print(f"4. Hex to bytes: {bytes_from_hex}")
    print(f"5. New bytearray: {bytearray_direct}")
    print(f"6. Bytes to bytearray: {bytearray_from_bytes}")
    print(f"7. Sliced bytes: {sliced_bytes}")
    print(f"8. Modified Message: {decoded_modified}")


def program_2():
    print("------- PROGRAM 2 -------")
    
    fname = input("First name: ")
    lname = input("Last name: ")
    
    wname = fname + " " + lname
    
    print(f"Full name: {wname}")
    print("First Character: ", fname[0])
    
    try:
        last_char = lname[-1]
        print(f"The last character is: {last_char}")
        
    except Idx_err:
        print("You didn't type anything. There is no last character")
    print('Strings are immutable; individual characters \ncannot be changed directly.')
    
    try:
        fname[0] = "D"
        
    except TypeError as error:
        
        print(f"Caught Error: {error}")
    print("Strings ")
    new_namae = "D" + fname[1:]
    print(f"New name: {new_namae}")
    print(f"Original name: {fname}")
    print("\nCharacters in full name:")
    
    for char in wname:
        print(char)
        
    if " " in wname:
        space_pos = wname.find(" ")
        sliced_first = wname[:space_pos]
        sliced_last = wname[space_pos + 1:]
        print(f"\nSliced first name: {sliced_first}")
        print(f"Sliced last name: {sliced_last}")
        
    while True:
        s_char = input("Enter one character to search: ")
        sfull = wname.casefold()
        
        if len(s_char) != 1:
            print("Validation Error: Please enter exactly ONE character.")
            continue
        
        else:
            if s_char.casefold() in sfull:
                all_indices = []
                for index, char in enumerate(sfull):
                    if char == s_char.casefold():
                        all_indices.append(index)
                print(f"Character '{s_char}' found at indices: {all_indices}")
                break
            
            else:
                print(f"Character '{s_char}' was not found in the full name. Try again.")
    print("The blank line between a and S is the space in Maria Santos")


def main():
    while True:
        
        print("------- MIDTERM LAB ACTIVITY 3 -------")
        
        print("1) Program 1 - Chapter 12: Bytes and Bytearray")
        print("2) Program 2 - Name Analyzer")
        print("3) EXIT PROGRAM")
        
        choice = input("What program do you want to run?: ")
        
        if choice == "1":
            program_1()
        elif choice == "2":
            program_2()
        elif choice == "3":
            print("\nTHANK YOU!")
            break
        else:
            print("\nINVALID!")


if __name__ == "__main__":
    main()