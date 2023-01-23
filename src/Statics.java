import java.util.Scanner;

public class Statics {
    private static int transaction = 1000;
    private static Scanner scan = new Scanner(System.in);
    public static void printMenu(){
        System.out.println("You need to enter your PIN to access the main menu!!!");
        ATM.checkPIN();
        System.out.println("----------> MAIN MENU: <---------- ");
        System.out.println("1. Withdraw money\n" +
                "2. Deposit money\n" +
                "3. Transfer money between accounts\n" +
                "4. Get account balances\n" +
                "5. Change PIN\n" +
                "6. Exit\n");

    }

    public static void withdrawFrom(Account accountSubstract, double money){
        if(money>accountSubstract.getBalance()){
            System.out.println("Inefficient balance!!! Please try again!");
            printMenu();
        } else if(money%5!=0){
            System.out.println("Please choose an appropriate amount!!!");
            printMenu();
        } else {
            if(money<20){
                System.out.println("Please take " + (int)money/5 + " five dollar bills!");
                transaction++;
            } else{

                boolean isTrue = true;
                while(isTrue){
                    System.out.print("How many $20 bills would you like?: ");
                    int twenties = scan.nextInt();
                    System.out.print("How many $5 bills would you like?: ");
                    int fives = scan.nextInt();
                    if(fives*5 + twenties*20 == money){
                        isTrue=false;
                        System.out.println("You have successfully withdrawn $"+ round(money) + " from your account" );
                        transaction++;
                        break;
                    }
                    System.out.println("Request rejected!!! Please try again");
                    accountSubstract.withdrawCash(money);
                }
            }
        }

    }



    public static double round(double num){
        return ((double)Math.round(num*100))/100;
    }

    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int getTransaction(){
        return transaction;
    }

    public static void setTransaction(){
        transaction++;
    }

}
