
    import java.util.InputMismatchException;
import java.util.Scanner;
public class Week9assignment2 {
    public static void main(String[] args) {
        Scanner lagay = new Scanner(System.in);
            
            while(true){
                try{
                    System.out.print("Enter a number from 1-10: ");
                    int num = lagay.nextInt();

                        if (num < 1 || num > 10) {
                        System.out.println("Invalid Number");
                        }

                    while(true) {

                            System.out.print("Again? Y/N: ");
                            char y_n = lagay.next().charAt(0);

                                if (y_n == 'n' || y_n == 'N') {
                                System.out.println("Exiting...");
                                lagay.close();
                                return;

                        } else if (y_n == 'Y' || y_n == 'y'){
                            break;
                        } else {
                            System.out.println("Invalid input! Please enter Y or N only.");
                        }
                    }
                } catch (InputMismatchException Number) {
                    System.out.println("Error: That is not a valid integer!");
                    lagay.next();
                }
            }
    }
}
