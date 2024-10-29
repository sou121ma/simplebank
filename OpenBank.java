package simpleBank;

import java.util.Scanner;

public class OpenBank {
    
    static int count = 0;

    public static void main(String[] args) {
        char op;
        Customer cus;

        System.out.println("************ Welcome to Funny Bank *********");
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("---------------------------------------");
            System.out.println("1.Open new account");
            System.out.println("2.Log in");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {

                System.out.print("Enter your name:");
                String name = sc.nextLine();

                System.out.print("Enter mobile number: ");
                String mob = sc.nextLine();

                System.out.print("Set userID: ");
                String id = sc.nextLine();

                System.out.print("Set password: ");
                String pass = sc.nextLine();

                Customer cust = new Customer(name, mob, id, pass);
                cust.addCustomer(cust);
                count++;

            } else if(choice == 2){
                if(count == 0){
                    System.out.println("Sorry! you are the first customer.Please open new account");
                    continue;
                }
                System.out.print("Enter userId:");
                String id = sc.nextLine();
                
                System.out.print("Enter password: ");
                String pass = sc.nextLine();
                
                Customer.checkValidate(id, pass, count);
                if(Customer.checkValidate(id, pass, count)){
                    System.out.println("Log in success!");
                    Customer.showDetails();
                    int choose;

                    do{
                        System.out.println("\t1.Diposite Money");
                        System.out.println("\t2.Withdraw money");
                        System.out.println("\t3.Log out");
                        System.out.print("choose: ");
                        choose = sc.nextInt();
                        sc.nextLine();
                        if(choose == 1){
                            System.out.print("Enter amount to add your account:");
                            double amount = sc.nextDouble();
                            sc.nextLine();
                            Customer.addBal(amount);
                            Customer.showDetails();
                        } else if(choose == 2){
                            System.out.print("Enter amount to withdraw: ");
                            double amount = sc.nextDouble();
                            sc.nextLine();
                            Customer.withdraw(amount);
                            Customer.showDetails();
                        } 
                        
                    }while(choose !=3);



                } else { System.out.println("Login fail..............");}


                

            }


        } while(true);
    }
}
