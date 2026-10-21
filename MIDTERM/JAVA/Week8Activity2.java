import java.util.Scanner;


    public class Week8Activity2{


        public static void main(String[] args){
            Scanner lagay = new Scanner(System.in);
                // String name. int tpages, pages_read, due;


            System.out.print("Enter your name (E.g. Prince Pepito): ");
            String name = lagay.nextLine();


            while (true){
                System.out.print(name);
            if (name.matches("[a-zA-Z\\s]+")) {
                break;
            } else {
                    System.out.println("Invalid input! Please try again.");
                }
            }
            System.out.print("How many pages does the book have?: ");
            int tpages = lagay.nextInt();


            while (true){
                System.out.println("How many pages have you read?: ");
                int pages_read = lagay.nextInt();


                if (tpages >= pages_read){
                    break;
                } else {
                    System.out.print("Invalid Input! Pages overload, try again.");
                }
            }


            while(true){
                System.out.println("----- ");




            }




            




        }
    }