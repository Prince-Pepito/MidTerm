// PRINCE GODFREY S. PEPITO              BSCS 2-Y1-1

import java.util.Scanner;

public class Week9assignment1 {
    public static void main(String[] args) {
        Scanner lagay = new Scanner(System.in);

            System.out.print("Enter your name: ");
            String pangalan = lagay.nextLine();
            
            for (int i = 0; i < 5; i++){
                System.out.println(pangalan);
            }
        lagay.close();
    }
}