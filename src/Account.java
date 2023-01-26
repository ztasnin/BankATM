import java.util.Scanner;
public class Account {
    private double money;

    private static Scanner scan = new Scanner(System.in);
    public Account(){
        money = 0;
    }

    public void addCash(double toAdd){
        money+=toAdd;
    }

    public void withdrawCash(double toRemove){
        money-=toRemove;
    }

    public double getBalance(){
        return money;
    }

    public static void withdrawFrom(Account accountSubstract, double money){ //use scanned info from the ATM to withdraw money
        if(money>accountSubstract.getBalance()){
            System.out.println("Inefficient balance!!! Please try again!");
            Statics.printMenu();
        } else if(money%5!=0){
            System.out.println("Please choose an appropriate amount!!!");
            Statics.printMenu();
        } else {
            if(money<20){
                System.out.println("Please take " + (int)money/5 + " five dollar bills!");
                Statics.transaction++;
                System.out.println("You have successfully withdrawn $"+ Statics.round(money) + " from your account" );
                System.out.println("Transaction ID: " + Statics.getTransaction());
            } else{

                boolean isTrue = true;
                while(isTrue){
                    System.out.print("How many $20 bills would you like?: ");
                    int twenties = scan.nextInt();
                    System.out.print("How many $5 bills would you like?: ");
                    int fives = scan.nextInt();
                    if(fives*5 + twenties*20 == money){
                        Statics.transaction++;
                        isTrue=false;
                        System.out.println("You have successfully withdrawn $"+ Statics.round(money) + " from your account" );
                        System.out.println("Transaction ID: " + Statics.getTransaction());
                        break;
                    }
                    System.out.println("Request rejected!!! Please try again");
                    accountSubstract.withdrawCash(money);
                }
            }
        }

    }
}
