// PRINCE GODFREY S. PEPITO              BSCS 2-Y1-1

import java.util.Scanner;

public class Week7assignment2 {
    
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a letter: ");
        char single = input.next().charAt(0);
        char lower = Character.toLowerCase(single);
        
        if (Character.isLetter(single)){
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u'){
                System.out.print("It's a vowel!");
            } else {
                System.out.print("It's a consonant!");
            }
        } else {
            System.out.println("This is not a letter.");
        }
        input.close();
    }
}
