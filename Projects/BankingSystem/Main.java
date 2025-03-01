package Projects.BankingSystem;
import java.util.Scanner;

public class Main { 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("--------------------------------------------");
        System.out.println("          Welcome to Bank Account.          ");
        System.out.print("Enter your name : ");
        String name = scan.nextLine();
        System.out.print("Enter your age : ");
        int age = scan.nextInt();
        System.out.print("Enter your Gender : ");
        String gender = scan.next();
        scan.nextLine();
        System.out.print("Enter your Address : ");
        String Add = scan.nextLine();

        Customer customer = new Customer(name, age, gender);
        customer.setAddress(Add);
        int num = 0;

        while(num != 6) {
            System.out.println();
            System.out.println("Chose option from Menu(1-6) : ");
            System.out.println();
            System.out.println("------------------Menu-----------------");
            System.out.println();
            System.out.println("1. Customer Details\n2. Deposit\n3. Withdraw\n4. Balance Check\n5. PassBook\n6. Exit\n");
            System.out.println();
            System.out.print("Enter Number : ");
            num = scan.nextInt();
            System.out.println();
            double Amo;
            switch (num) {
                case 1:
                    customer.getCustomerInfo();
                    break;
                case 2:
                    System.out.print("Enter Amount to Deposit : ");
                    Amo = scan.nextDouble();
                    customer.Deposit(Amo);
                    break;
                case 3:
                    System.out.print("Enter Amount to Withdraw : ");
                    Amo = scan.nextDouble();
                    customer.Withdraw(Amo);
                    break;
                case 4:
                    customer.BalanceCheck();
                    break;
                case 5:
                    customer.getPassBook();
                    break;
                case 6:
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid Number!... Enter Valid Number from Menu");
                    System.out.println();
            }
        }
        scan.close();
        System.out.println("                    Exit                     ");
        System.out.println("                  Thank You.                 ");
        System.out.println("---------------------------------------------");
    }
}
