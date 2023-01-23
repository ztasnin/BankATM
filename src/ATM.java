import java.util.Scanner;
import java.util.stream.StreamSupport;

public class ATM {

    private static Account savings = new Account();
    private static Account checking = new Account();
    private static int cstPIN = 0;
    private static Scanner scan = new Scanner(System.in);

    private static int transaction = 1000;

    private static Customer customer1 = new Customer("", 0);


    public static void start() {
        clear();
        System.out.println("Welcome to the ATM");
        System.out.print("Please type your name: ");
        String cstName = scan.nextLine();
        customer1.setName(cstName);
        System.out.print("Please create and type your PIN number: ");
        cstPIN = scan.nextInt();
        scan.nextLine();
        customer1.setPIN(cstPIN);
        clear();

        checkPIN();

        Statics.printMenu();
        int choice = 0;
        System.out.print("What do you need help with today? (Please type the appropriate number) ");
        choice = scan.nextInt();
        scan.nextLine();
        while (choice!=6){
            if(choice == 1){
                choice1();
            } else if(choice == 2){
                choice2();
            } else if(choice == 3){
                choice3();
            } else if(choice == 4){
                    System.out.println("Your savings balance is $" + Statics.round(savings.getBalance()));
                    System.out.println("Your checking balance is $" + Statics.round(checking.getBalance()));
            } else if (choice == 5){
                System.out.print("Please type out your new PIN number: ");
                int newPin = scan.nextInt();
                customer1.setPIN(newPin);
                System.out.println("Your PIN number has been changed successfully!!!");
            }
            System.out.print("What do you need help with today? (Please type the appropriate number) ");
            choice = scan.nextInt();
        }
        if(choice == 6){
            clear();
            System.out.println("Thank you for using our ATM. Have a great day!!!");
        }

    }




    private static void choice3(){
        System.out.print("Which account do you want to transfer money from? (S)avings/(C)hecking: ");
        String from = scan.nextLine().toLowerCase();
        scan.nextLine();
        System.out.print("How much money do you want to transfer?: ");
        double transfer = scan.nextDouble();
        scan.nextLine();
        if(from.equals("s")){
            if(savings.getBalance()<transfer){
                System.out.println("Insufficient balance!!! Please try again!!!");
                Statics.printMenu();
            } else{
                transfer(savings,checking,transfer);
                System.out.println("$" + transfer + " has been successfully transferred!!");
                transaction++;
                System.out.println("Transaction ID: " + transaction);
            }
        } else if(from.equals("c")){
            if(checking.getBalance()<transfer){
                System.out.println("Insufficient balance!!! Please try again!!!");
                Statics.printMenu();
            } else{
                transfer(checking,savings,transfer);
                System.out.println("$" + transfer + " has been successfully transferred!!");
                transaction++;
                System.out.println("Transaction ID: " + transaction);
            }
        }
    }
    private static void transfer(Account from, Account to, double money){
        from.withdrawCash(money);
        to.addCash(money);
    }

    private static void choice1(){
        System.out.print("How much money do you want to withdraw?: ");
        double withdrawMoney = scan.nextDouble();
        scan.nextLine();
        System.out.print("Which account do you want to withdraw from? (S)avings/(C)hecking: ");
        String withdrawAcc = scan.nextLine().toLowerCase();
        if(withdrawAcc.equals("s")){
            Statics.withdrawFrom(savings, withdrawMoney);
            System.out.println("Transaction ID: " + Statics.getTransaction());
            transaction++;
            Statics.setTransaction();
            Statics.printMenu();
        } else if (withdrawAcc.equals("c")){
            Statics.withdrawFrom(checking, withdrawMoney);
            System.out.println("Transaction ID: " + Statics.getTransaction());
            transaction++;
            Statics.setTransaction();
            Statics.printMenu();
        } else{
            System.out.println("Your response is invalid");
            Statics.printMenu();
        }
    }

    private static void choice2(){
        System.out.print("How much do you want to deposit? ");
        double add = scan.nextDouble();
        scan.nextLine();
        System.out.print("Which account do you want to use to deposit? (S)avings/(C)hecking: ");
        String accName = scan.nextLine().toLowerCase();

        if(accName.equals("s")){
            savings.addCash(add);
            System.out.println("You have successfully deposited $" + add + " to your savings account. ");
            transaction++;
            Statics.setTransaction();
            System.out.println("Transaction ID: " + transaction);
            Statics.printMenu();
        } else if (accName.equals("c")){
            checking.addCash(add);
            System.out.println("You have successfully deposited $" + add + " to your checking account. ");
            transaction++;
            Statics.setTransaction();
            System.out.println("Transaction ID: " + transaction);
            Statics.printMenu();
        } else {
            System.out.println("Your response is invalid");
            Statics.printMenu();
        }

    }

    public static void checkPIN(){
        boolean correct = false;
        while(!correct) {
            System.out.print("Please enter your PIN number?: ");
            int trialPIN = scan.nextInt();
            if (trialPIN != cstPIN) {
                clear();
                System.out.println("WRONG PIN number!!!");
            } else {
                clear();
                System.out.println("You have logged in successfully!!!");
                correct = true;
            }
        }
    }

    private static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
